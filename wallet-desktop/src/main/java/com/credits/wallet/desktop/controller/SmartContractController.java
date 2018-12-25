package com.credits.wallet.desktop.controller;

import com.credits.client.node.pojo.SmartContractData;
import com.credits.client.node.pojo.TransactionFlowResultData;
import com.credits.general.exception.CreditsException;
import com.credits.general.pojo.VariantData;
import com.credits.general.thrift.generated.Variant;
import com.credits.general.util.Callback;
import com.credits.general.util.variant.VariantUtils;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.VistaNavigator;
import com.credits.wallet.desktop.struct.SmartContractTabRow;
import com.credits.wallet.desktop.utils.ApiUtils;
import com.credits.wallet.desktop.utils.FormUtils;
import com.credits.wallet.desktop.utils.sourcecode.ParseCodeUtils;
import com.credits.wallet.desktop.utils.sourcecode.SourceCodeUtils;
import com.credits.wallet.desktop.utils.sourcecode.codeArea.CodeAreaUtils;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.fxmisc.richtext.CodeArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

import static com.credits.client.node.service.NodeApiServiceImpl.async;
import static com.credits.client.node.service.NodeApiServiceImpl.handleCallback;
import static com.credits.client.node.util.TransactionIdCalculateUtils.calcTransactionIdSourceTarget;
import static com.credits.general.util.Utils.threadPool;
import static com.credits.wallet.desktop.AppState.*;
import static com.credits.wallet.desktop.utils.ApiUtils.createSmartContractTransaction;

/**
 * Created by goncharov-eg on 30.01.2018.
 */
public class SmartContractController implements Initializable {

    private static Logger LOGGER = LoggerFactory.getLogger(SmartContractController.class);

    private CodeArea codeArea;
    private SmartContractData currentSmartContract;
    private MethodDeclaration currentMethod;
    private HashMap<String, SmartContractData> favoriteContracts;

    @FXML
    public Tab myContractsTab;
    @FXML
    public Tab favoriteContractsTab;
    @FXML
    public ToggleButton tbFavorite;
    @FXML
    BorderPane bp;
    @FXML
    private Pane pControls;
    @FXML
    private TextField tfAddress;
    @FXML
    private ComboBox<MethodDeclaration> cbMethods;
    @FXML
    TableView<SmartContractTabRow> smartContractTableView;
    @FXML
    TableView<SmartContractTabRow> favoriteContractTableView;
    @FXML
    private TextField tfSearchAddress;
    @FXML
    private StackPane pCodePanel;
    @FXML
    private AnchorPane pParams;
    @FXML
    private AnchorPane pParamsContainer;

    @FXML
    private void handleBack() {
        VistaNavigator.loadVista(VistaNavigator.WALLET, this);
    }

    @FXML
    private void handleCreate() {
        VistaNavigator.loadVista(VistaNavigator.SMART_CONTRACT_DEPLOY, this);
    }

    @FXML
    private void handleSearch() {
        String address = tfSearchAddress.getText();
        async(() -> nodeApiService.getSmartContract(address), handleGetSmartContractResult());

    }

    private Callback<SmartContractData> handleGetSmartContractResult() {
        return new Callback<SmartContractData>() {
            @Override
            public void onSuccess(SmartContractData contractData) throws CreditsException {
                refreshFormState(contractData);
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("failed!", e);
                FormUtils.showError("Can't get smart-contract from the node. Reason: " + e.getMessage());
            }
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FormUtils.resizeForm(bp);
        tbFavorite.setVisible(false);
        pControls.setVisible(false);
        pCodePanel.setVisible(false);
        codeArea = CodeAreaUtils.initCodeArea(this.pCodePanel, true);
        codeArea.setEditable(false);
        codeArea.copy();
        favoriteContracts = favoriteContractsKeeper.getKeptObject().orElseGet(HashMap::new);
        initializeTable(smartContractTableView);
        initializeTable(favoriteContractTableView);
        refreshFavoriteContractsTab();
    }

    @FXML
    private void updateSelectedTab() {
        if (myContractsTab != null && myContractsTab.isSelected()) {
            refreshContractsTab();
        } else if (favoriteContractsTab != null && favoriteContractsTab.isSelected()) {
            refreshFavoriteContractsTab();
        }
    }

    private void initializeTable(TableView<SmartContractTabRow> tableView) {
        initializeRowFactory(tableView);
        initializeColumns(tableView);
    }

    private void initializeColumns(TableView<SmartContractTabRow> tableView) {
        TableColumn<SmartContractTabRow, String> idColumn = new TableColumn<>();
        idColumn.setPrefWidth(tableView.getPrefWidth() * 0.85);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        FormUtils.addTooltipToColumnCells(idColumn);

        TableColumn<SmartContractTabRow, String> favColumn = new TableColumn<>();
        favColumn.setPrefWidth(tableView.getPrefWidth() * 0.1);
        favColumn.setCellValueFactory(new PropertyValueFactory<>("fav"));

        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(favColumn);
    }

    private void initializeRowFactory(TableView<SmartContractTabRow> tableView) {
        tableView.setRowFactory(tv -> {
            TableRow<SmartContractTabRow> row = new TableRow<>();
            row.setOnMouseClicked(getMouseEventRowHandler(row));
            return row;
        });
    }

    private EventHandler<MouseEvent> getMouseEventRowHandler(TableRow<SmartContractTabRow> row) {
        return event -> {
            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                refreshFormState(row.getItem().getSmartContractData());
            }
        };
    }

    private EventHandler<ActionEvent> handleFavoriteButtonEvent(ToggleButton pressedButton,
        SmartContractData smartContractData) {
        return event -> switchFavoriteState(pressedButton, smartContractData);
    }

    private void switchFavoriteState(ToggleButton favoriteButton, SmartContractData smartContractData) {
        if (favoriteContracts.containsKey(smartContractData.getBase58Address())) {
            favoriteContracts.remove(smartContractData.getBase58Address());
            favoriteButton.setSelected(false);
            setFavoriteCurrentContract(smartContractData, false);
            changeFavoriteStateIntoTab(smartContractTableView, smartContractData, false);
        } else {
            favoriteContracts.put(smartContractData.getBase58Address(), smartContractData);
            favoriteButton.setSelected(true);
            tbFavorite.setSelected(true);
            setFavoriteCurrentContract(smartContractData, true);
            changeFavoriteStateIntoTab(smartContractTableView, smartContractData, true);
        }
        refreshFavoriteContractsTab();
    }

    private void changeFavoriteStateIntoTab(TableView<SmartContractTabRow> table, SmartContractData smartContractData,
        boolean isSelected) {
        table.getItems()
            .stream()
            .filter(row -> row.getSmartContractData().equals(smartContractData))
            .findFirst()
            .ifPresent(row -> row.getFav().setSelected(isSelected));
        table.refresh();
    }

    private void setFavoriteCurrentContract(SmartContractData smartContractData, boolean isSelected) {
        if (currentSmartContract != null &&
            smartContractData.getBase58Address().equals(currentSmartContract.getBase58Address())) {
            tbFavorite.setSelected(isSelected);
        } else {
            tbFavorite.setSelected(false);
        }
    }

    private void refreshFormState(SmartContractData smartContractData) {
        if (smartContractData == null || smartContractData.getSmartContractDeployData().getByteCode().length == 0 ||
            smartContractData.getAddress().length == 0) {
            tbFavorite.setVisible(false);
            pControls.setVisible(false);
            pCodePanel.setVisible(false);
        } else {
            pControls.setVisible(true);
            pCodePanel.setVisible(true);
            currentSmartContract = smartContractData;

            tbFavorite.setOnAction(handleFavoriteButtonEvent(tbFavorite, currentSmartContract));
            tbFavorite.setVisible(true);
            findInFavoriteThenSelect(smartContractData, tbFavorite);

            String sourceCode = smartContractData.getSmartContractDeployData().getSourceCode();
            tfAddress.setText(smartContractData.getBase58Address());
            List<MethodDeclaration> methods = ParseCodeUtils.parseMethods(sourceCode);
            cbMethods.getItems().clear();
            methods.forEach(method -> {
                method.setBody(null);
                cbMethods.getItems().add(method);
            });
            codeArea.clear();
            codeArea.replaceText(0, 0, SourceCodeUtils.formatSourceCode(sourceCode));
        }
    }

    private void findInFavoriteThenSelect(SmartContractData smartContractData, ToggleButton tbFavorite) {
        if (favoriteContracts.containsKey(smartContractData.getBase58Address())) {
            tbFavorite.setSelected(true);
        } else {
            tbFavorite.setSelected(false);
        }
    }

    private void refreshContractsTab() {
        async(() -> nodeApiService.getSmartContracts(account), handleGetSmartContractsResult());
    }

    private void refreshFavoriteContractsTab() {
        if (favoriteContractTableView != null && favoriteContracts != null) {
            favoriteContractTableView.getItems().clear();
            favoriteContracts.forEach(
                (contractName, contractData) -> addContractToTable(favoriteContractTableView, contractData));
        }
        favoriteContractsKeeper.keepObject(favoriteContracts);
    }

    private Callback<List<SmartContractData>> handleGetSmartContractsResult() {
        return new Callback<List<SmartContractData>>() {
            @Override
            public void onSuccess(List<SmartContractData> smartContracts) throws CreditsException {
                Platform.runLater(() -> {
                    smartContractTableView.getItems().clear();
                    smartContracts.forEach(smartContract -> addContractToTable(smartContractTableView, smartContract));
                });
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("Can't get smart-contracts from the node. Reason: {}", e.getMessage());
                FormUtils.showError("Can't get smart-contracts from the node. Reason: " + e.getMessage());
            }
        };
    }

    @FXML
    private void cbMethodsOnAction() {
        this.pParams.setVisible(false);
        this.currentMethod = this.cbMethods.getSelectionModel().getSelectedItem();
        if (this.currentMethod == null) {
            return;
        }
        List<SingleVariableDeclaration> params = this.currentMethod.parameters();
        this.pParamsContainer.getChildren().clear();
        if (params.size() > 0) {
            this.pParams.setVisible(true);
            double layoutY = 10;
            for (SingleVariableDeclaration param : params) {
                TextField paramValueTextField = new TextField();
                paramValueTextField.setLayoutX(150);
                paramValueTextField.setLayoutY(layoutY);
                paramValueTextField.setStyle(
                    "-fx-background-color:  #fff; -fx-border-radius:15; -fx-border-width: 1; -fx-border-color:  #000; -fx-font-size: 16px");
                paramValueTextField.setPrefSize(500, 30);
                Label paramNameLabel = new Label(param.toString());
                paramNameLabel.setLayoutX(10);
                paramNameLabel.setLayoutY(layoutY + 5);
                paramNameLabel.setStyle("-fx-font-size: 18px");
                paramNameLabel.setLabelFor(paramValueTextField);
                this.pParamsContainer.getChildren().addAll(paramNameLabel, paramValueTextField);
                layoutY += 40;
            }
            this.pParamsContainer.setPrefHeight(layoutY);
        }
    }

    @FXML
    private void handleExecute() {
        try {
            String method = cbMethods.getSelectionModel().getSelectedItem().getName().getIdentifier();
            List<VariantData> params = new ArrayList<>();
            List<SingleVariableDeclaration> currentMethodParams = this.currentMethod.parameters();
            ObservableList<Node> paramsContainerChildren = this.pParamsContainer.getChildren();
            int i = 0;
            for (Node node : paramsContainerChildren) {
                if (node instanceof TextField) {
                    String paramValue = ((TextField) node).getText();
                    SingleVariableDeclaration variableDeclaration = currentMethodParams.get(i);
                    String className = ParseCodeUtils.parseClassName(variableDeclaration);
                    params.add(VariantUtils.createVariantData(className, paramValue));
                    ++i;
                }
            }
            SmartContractData smartContractData = this.currentSmartContract;
            smartContractData.setMethod(method);
            smartContractData.setParams(params);

            CompletableFuture.supplyAsync(() -> calcTransactionIdSourceTarget(AppState.nodeApiService, account,
                smartContractData.getBase58Address(), true), threadPool)
                .thenApply((transactionData) -> createSmartContractTransaction(transactionData, smartContractData))
                .whenComplete(handleCallback(handleExecuteResult()));


        } catch (CreditsException e) {
            LOGGER.error("failed!", e);
            FormUtils.showError(e.toString());
        }
    }

    private Callback<Pair<Long, TransactionFlowResultData>> handleExecuteResult() {
        return new Callback<Pair<Long, TransactionFlowResultData>>() {
            @Override
            public void onSuccess(Pair<Long, TransactionFlowResultData> resultData) {
                ApiUtils.saveTransactionRoundNumberIntoMap(resultData.getRight().getRoundNumber(),
                    resultData.getLeft());
                Variant result =
                    resultData.getRight().getContractResult().orElse(new Variant(Variant._Fields.V_STRING, "void"));
                LOGGER.info("Return value is {}", result);
                FormUtils.showPlatformInfo("Execute smart contract was success: return value is: " + result);
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("failed!", e);
                FormUtils.showPlatformError(e.getMessage());
            }
        };
    }

    private void addContractToTable(TableView<SmartContractTabRow> table, SmartContractData smartContractData) {
        ToggleButton favoriteButton = new ToggleButton();
        favoriteButton.setOnAction(handleFavoriteButtonEvent(favoriteButton, smartContractData));
        SmartContractTabRow row =
            new SmartContractTabRow(smartContractData.getBase58Address(), favoriteButton, smartContractData);
        row.setFav(favoriteButton);
        findInFavoriteThenSelect(smartContractData, favoriteButton);
        table.getItems().add(row);
    }

    public void handleRefreshSmarts() {
        updateSelectedTab();
    }
}