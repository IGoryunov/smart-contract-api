/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-03-25")
public class WalletInfo implements org.apache.thrift.TBase<WalletInfo, WalletInfo._Fields>, java.io.Serializable, Cloneable, Comparable<WalletInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WalletInfo");

  private static final org.apache.thrift.protocol.TField ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("address", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField BALANCE_FIELD_DESC = new org.apache.thrift.protocol.TField("balance", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField TRANSACTIONS_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("transactionsNumber", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField FIRST_TRANSACTION_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("firstTransactionTime", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new WalletInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new WalletInfoTupleSchemeFactory();

  public java.nio.ByteBuffer address; // required
  public Amount balance; // required
  public long transactionsNumber; // required
  public long firstTransactionTime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ADDRESS((short)1, "address"),
    BALANCE((short)2, "balance"),
    TRANSACTIONS_NUMBER((short)3, "transactionsNumber"),
    FIRST_TRANSACTION_TIME((short)4, "firstTransactionTime");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ADDRESS
          return ADDRESS;
        case 2: // BALANCE
          return BALANCE;
        case 3: // TRANSACTIONS_NUMBER
          return TRANSACTIONS_NUMBER;
        case 4: // FIRST_TRANSACTION_TIME
          return FIRST_TRANSACTION_TIME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TRANSACTIONSNUMBER_ISSET_ID = 0;
  private static final int __FIRSTTRANSACTIONTIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("address", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Address")));
    tmpMap.put(_Fields.BALANCE, new org.apache.thrift.meta_data.FieldMetaData("balance", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Amount.class)));
    tmpMap.put(_Fields.TRANSACTIONS_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("transactionsNumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FIRST_TRANSACTION_TIME, new org.apache.thrift.meta_data.FieldMetaData("firstTransactionTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Time")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WalletInfo.class, metaDataMap);
  }

  public WalletInfo() {
  }

  public WalletInfo(
    java.nio.ByteBuffer address,
    Amount balance,
    long transactionsNumber,
    long firstTransactionTime)
  {
    this();
    this.address = org.apache.thrift.TBaseHelper.copyBinary(address);
    this.balance = balance;
    this.transactionsNumber = transactionsNumber;
    setTransactionsNumberIsSet(true);
    this.firstTransactionTime = firstTransactionTime;
    setFirstTransactionTimeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WalletInfo(WalletInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetAddress()) {
      this.address = org.apache.thrift.TBaseHelper.copyBinary(other.address);
    }
    if (other.isSetBalance()) {
      this.balance = new Amount(other.balance);
    }
    this.transactionsNumber = other.transactionsNumber;
    this.firstTransactionTime = other.firstTransactionTime;
  }

  public WalletInfo deepCopy() {
    return new WalletInfo(this);
  }

  @Override
  public void clear() {
    this.address = null;
    this.balance = null;
    setTransactionsNumberIsSet(false);
    this.transactionsNumber = 0;
    setFirstTransactionTimeIsSet(false);
    this.firstTransactionTime = 0;
  }

  public byte[] getAddress() {
    setAddress(org.apache.thrift.TBaseHelper.rightSize(address));
    return address == null ? null : address.array();
  }

  public java.nio.ByteBuffer bufferForAddress() {
    return org.apache.thrift.TBaseHelper.copyBinary(address);
  }

  public WalletInfo setAddress(byte[] address) {
    this.address = address == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(address.clone());
    return this;
  }

  public WalletInfo setAddress(java.nio.ByteBuffer address) {
    this.address = org.apache.thrift.TBaseHelper.copyBinary(address);
    return this;
  }

  public void unsetAddress() {
    this.address = null;
  }

  /** Returns true if field address is set (has been assigned a value) and false otherwise */
  public boolean isSetAddress() {
    return this.address != null;
  }

  public void setAddressIsSet(boolean value) {
    if (!value) {
      this.address = null;
    }
  }

  public Amount getBalance() {
    return this.balance;
  }

  public WalletInfo setBalance(Amount balance) {
    this.balance = balance;
    return this;
  }

  public void unsetBalance() {
    this.balance = null;
  }

  /** Returns true if field balance is set (has been assigned a value) and false otherwise */
  public boolean isSetBalance() {
    return this.balance != null;
  }

  public void setBalanceIsSet(boolean value) {
    if (!value) {
      this.balance = null;
    }
  }

  public long getTransactionsNumber() {
    return this.transactionsNumber;
  }

  public WalletInfo setTransactionsNumber(long transactionsNumber) {
    this.transactionsNumber = transactionsNumber;
    setTransactionsNumberIsSet(true);
    return this;
  }

  public void unsetTransactionsNumber() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TRANSACTIONSNUMBER_ISSET_ID);
  }

  /** Returns true if field transactionsNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetTransactionsNumber() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TRANSACTIONSNUMBER_ISSET_ID);
  }

  public void setTransactionsNumberIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TRANSACTIONSNUMBER_ISSET_ID, value);
  }

  public long getFirstTransactionTime() {
    return this.firstTransactionTime;
  }

  public WalletInfo setFirstTransactionTime(long firstTransactionTime) {
    this.firstTransactionTime = firstTransactionTime;
    setFirstTransactionTimeIsSet(true);
    return this;
  }

  public void unsetFirstTransactionTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FIRSTTRANSACTIONTIME_ISSET_ID);
  }

  /** Returns true if field firstTransactionTime is set (has been assigned a value) and false otherwise */
  public boolean isSetFirstTransactionTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FIRSTTRANSACTIONTIME_ISSET_ID);
  }

  public void setFirstTransactionTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FIRSTTRANSACTIONTIME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ADDRESS:
      if (value == null) {
        unsetAddress();
      } else {
        if (value instanceof byte[]) {
          setAddress((byte[])value);
        } else {
          setAddress((java.nio.ByteBuffer)value);
        }
      }
      break;

    case BALANCE:
      if (value == null) {
        unsetBalance();
      } else {
        setBalance((Amount)value);
      }
      break;

    case TRANSACTIONS_NUMBER:
      if (value == null) {
        unsetTransactionsNumber();
      } else {
        setTransactionsNumber((java.lang.Long)value);
      }
      break;

    case FIRST_TRANSACTION_TIME:
      if (value == null) {
        unsetFirstTransactionTime();
      } else {
        setFirstTransactionTime((java.lang.Long)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ADDRESS:
      return getAddress();

    case BALANCE:
      return getBalance();

    case TRANSACTIONS_NUMBER:
      return getTransactionsNumber();

    case FIRST_TRANSACTION_TIME:
      return getFirstTransactionTime();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ADDRESS:
      return isSetAddress();
    case BALANCE:
      return isSetBalance();
    case TRANSACTIONS_NUMBER:
      return isSetTransactionsNumber();
    case FIRST_TRANSACTION_TIME:
      return isSetFirstTransactionTime();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof WalletInfo)
      return this.equals((WalletInfo)that);
    return false;
  }

  public boolean equals(WalletInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_address = true && this.isSetAddress();
    boolean that_present_address = true && that.isSetAddress();
    if (this_present_address || that_present_address) {
      if (!(this_present_address && that_present_address))
        return false;
      if (!this.address.equals(that.address))
        return false;
    }

    boolean this_present_balance = true && this.isSetBalance();
    boolean that_present_balance = true && that.isSetBalance();
    if (this_present_balance || that_present_balance) {
      if (!(this_present_balance && that_present_balance))
        return false;
      if (!this.balance.equals(that.balance))
        return false;
    }

    boolean this_present_transactionsNumber = true;
    boolean that_present_transactionsNumber = true;
    if (this_present_transactionsNumber || that_present_transactionsNumber) {
      if (!(this_present_transactionsNumber && that_present_transactionsNumber))
        return false;
      if (this.transactionsNumber != that.transactionsNumber)
        return false;
    }

    boolean this_present_firstTransactionTime = true;
    boolean that_present_firstTransactionTime = true;
    if (this_present_firstTransactionTime || that_present_firstTransactionTime) {
      if (!(this_present_firstTransactionTime && that_present_firstTransactionTime))
        return false;
      if (this.firstTransactionTime != that.firstTransactionTime)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAddress()) ? 131071 : 524287);
    if (isSetAddress())
      hashCode = hashCode * 8191 + address.hashCode();

    hashCode = hashCode * 8191 + ((isSetBalance()) ? 131071 : 524287);
    if (isSetBalance())
      hashCode = hashCode * 8191 + balance.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(transactionsNumber);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(firstTransactionTime);

    return hashCode;
  }

  @Override
  public int compareTo(WalletInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetAddress()).compareTo(other.isSetAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.address, other.address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBalance()).compareTo(other.isSetBalance());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBalance()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.balance, other.balance);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTransactionsNumber()).compareTo(other.isSetTransactionsNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransactionsNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transactionsNumber, other.transactionsNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFirstTransactionTime()).compareTo(other.isSetFirstTransactionTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFirstTransactionTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.firstTransactionTime, other.firstTransactionTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("WalletInfo(");
    boolean first = true;

    sb.append("address:");
    if (this.address == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.address, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("balance:");
    if (this.balance == null) {
      sb.append("null");
    } else {
      sb.append(this.balance);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("transactionsNumber:");
    sb.append(this.transactionsNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("firstTransactionTime:");
    sb.append(this.firstTransactionTime);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (balance != null) {
      balance.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WalletInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WalletInfoStandardScheme getScheme() {
      return new WalletInfoStandardScheme();
    }
  }

  private static class WalletInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<WalletInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WalletInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.address = iprot.readBinary();
              struct.setAddressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BALANCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.balance = new Amount();
              struct.balance.read(iprot);
              struct.setBalanceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TRANSACTIONS_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.transactionsNumber = iprot.readI64();
              struct.setTransactionsNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FIRST_TRANSACTION_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.firstTransactionTime = iprot.readI64();
              struct.setFirstTransactionTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WalletInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.address != null) {
        oprot.writeFieldBegin(ADDRESS_FIELD_DESC);
        oprot.writeBinary(struct.address);
        oprot.writeFieldEnd();
      }
      if (struct.balance != null) {
        oprot.writeFieldBegin(BALANCE_FIELD_DESC);
        struct.balance.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TRANSACTIONS_NUMBER_FIELD_DESC);
      oprot.writeI64(struct.transactionsNumber);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FIRST_TRANSACTION_TIME_FIELD_DESC);
      oprot.writeI64(struct.firstTransactionTime);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WalletInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WalletInfoTupleScheme getScheme() {
      return new WalletInfoTupleScheme();
    }
  }

  private static class WalletInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<WalletInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WalletInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAddress()) {
        optionals.set(0);
      }
      if (struct.isSetBalance()) {
        optionals.set(1);
      }
      if (struct.isSetTransactionsNumber()) {
        optionals.set(2);
      }
      if (struct.isSetFirstTransactionTime()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAddress()) {
        oprot.writeBinary(struct.address);
      }
      if (struct.isSetBalance()) {
        struct.balance.write(oprot);
      }
      if (struct.isSetTransactionsNumber()) {
        oprot.writeI64(struct.transactionsNumber);
      }
      if (struct.isSetFirstTransactionTime()) {
        oprot.writeI64(struct.firstTransactionTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WalletInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.address = iprot.readBinary();
        struct.setAddressIsSet(true);
      }
      if (incoming.get(1)) {
        struct.balance = new Amount();
        struct.balance.read(iprot);
        struct.setBalanceIsSet(true);
      }
      if (incoming.get(2)) {
        struct.transactionsNumber = iprot.readI64();
        struct.setTransactionsNumberIsSet(true);
      }
      if (incoming.get(3)) {
        struct.firstTransactionTime = iprot.readI64();
        struct.setFirstTransactionTimeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

