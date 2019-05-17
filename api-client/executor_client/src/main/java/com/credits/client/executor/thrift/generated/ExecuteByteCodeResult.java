/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.executor.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-05-17")
public class ExecuteByteCodeResult implements org.apache.thrift.TBase<ExecuteByteCodeResult, ExecuteByteCodeResult._Fields>, java.io.Serializable, Cloneable, Comparable<ExecuteByteCodeResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExecuteByteCodeResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField RESULTS_FIELD_DESC = new org.apache.thrift.protocol.TField("results", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField EXTERNAL_CONTRACTS_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("externalContractsState", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ExecuteByteCodeResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ExecuteByteCodeResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable com.credits.general.thrift.generated.APIResponse status; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<SetterMethodResult> results; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> externalContractsState; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    RESULTS((short)2, "results"),
    EXTERNAL_CONTRACTS_STATE((short)3, "externalContractsState");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS
          return STATUS;
        case 2: // RESULTS
          return RESULTS;
        case 3: // EXTERNAL_CONTRACTS_STATE
          return EXTERNAL_CONTRACTS_STATE;
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
    @org.apache.thrift.annotation.Nullable
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.APIResponse.class)));
    tmpMap.put(_Fields.RESULTS, new org.apache.thrift.meta_data.FieldMetaData("results", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "SetterMethodResult"))));
    tmpMap.put(_Fields.EXTERNAL_CONTRACTS_STATE, new org.apache.thrift.meta_data.FieldMetaData("externalContractsState", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , "Address"), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExecuteByteCodeResult.class, metaDataMap);
  }

  public ExecuteByteCodeResult() {
  }

  public ExecuteByteCodeResult(
    com.credits.general.thrift.generated.APIResponse status,
    java.util.List<SetterMethodResult> results,
    java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> externalContractsState)
  {
    this();
    this.status = status;
    this.results = results;
    this.externalContractsState = externalContractsState;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecuteByteCodeResult(ExecuteByteCodeResult other) {
    if (other.isSetStatus()) {
      this.status = new com.credits.general.thrift.generated.APIResponse(other.status);
    }
    if (other.isSetResults()) {
      java.util.List<SetterMethodResult> __this__results = new java.util.ArrayList<SetterMethodResult>(other.results.size());
      for (SetterMethodResult other_element : other.results) {
        __this__results.add(new SetterMethodResult(other_element));
      }
      this.results = __this__results;
    }
    if (other.isSetExternalContractsState()) {
      java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> __this__externalContractsState = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(other.externalContractsState.size());
      for (java.util.Map.Entry<java.nio.ByteBuffer, java.nio.ByteBuffer> other_element : other.externalContractsState.entrySet()) {

        java.nio.ByteBuffer other_element_key = other_element.getKey();
        java.nio.ByteBuffer other_element_value = other_element.getValue();

        java.nio.ByteBuffer __this__externalContractsState_copy_key = org.apache.thrift.TBaseHelper.copyBinary(other_element_key);

        java.nio.ByteBuffer __this__externalContractsState_copy_value = org.apache.thrift.TBaseHelper.copyBinary(other_element_value);

        __this__externalContractsState.put(__this__externalContractsState_copy_key, __this__externalContractsState_copy_value);
      }
      this.externalContractsState = __this__externalContractsState;
    }
  }

  public ExecuteByteCodeResult deepCopy() {
    return new ExecuteByteCodeResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.results = null;
    this.externalContractsState = null;
  }

  @org.apache.thrift.annotation.Nullable
  public com.credits.general.thrift.generated.APIResponse getStatus() {
    return this.status;
  }

  public ExecuteByteCodeResult setStatus(@org.apache.thrift.annotation.Nullable com.credits.general.thrift.generated.APIResponse status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getResultsSize() {
    return (this.results == null) ? 0 : this.results.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SetterMethodResult> getResultsIterator() {
    return (this.results == null) ? null : this.results.iterator();
  }

  public void addToResults(SetterMethodResult elem) {
    if (this.results == null) {
      this.results = new java.util.ArrayList<SetterMethodResult>();
    }
    this.results.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SetterMethodResult> getResults() {
    return this.results;
  }

  public ExecuteByteCodeResult setResults(@org.apache.thrift.annotation.Nullable java.util.List<SetterMethodResult> results) {
    this.results = results;
    return this;
  }

  public void unsetResults() {
    this.results = null;
  }

  /** Returns true if field results is set (has been assigned a value) and false otherwise */
  public boolean isSetResults() {
    return this.results != null;
  }

  public void setResultsIsSet(boolean value) {
    if (!value) {
      this.results = null;
    }
  }

  public int getExternalContractsStateSize() {
    return (this.externalContractsState == null) ? 0 : this.externalContractsState.size();
  }

  public void putToExternalContractsState(java.nio.ByteBuffer key, java.nio.ByteBuffer val) {
    if (this.externalContractsState == null) {
      this.externalContractsState = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>();
    }
    this.externalContractsState.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> getExternalContractsState() {
    return this.externalContractsState;
  }

  public ExecuteByteCodeResult setExternalContractsState(@org.apache.thrift.annotation.Nullable java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> externalContractsState) {
    this.externalContractsState = externalContractsState;
    return this;
  }

  public void unsetExternalContractsState() {
    this.externalContractsState = null;
  }

  /** Returns true if field externalContractsState is set (has been assigned a value) and false otherwise */
  public boolean isSetExternalContractsState() {
    return this.externalContractsState != null;
  }

  public void setExternalContractsStateIsSet(boolean value) {
    if (!value) {
      this.externalContractsState = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((com.credits.general.thrift.generated.APIResponse)value);
      }
      break;

    case RESULTS:
      if (value == null) {
        unsetResults();
      } else {
        setResults((java.util.List<SetterMethodResult>)value);
      }
      break;

    case EXTERNAL_CONTRACTS_STATE:
      if (value == null) {
        unsetExternalContractsState();
      } else {
        setExternalContractsState((java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case RESULTS:
      return getResults();

    case EXTERNAL_CONTRACTS_STATE:
      return getExternalContractsState();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case RESULTS:
      return isSetResults();
    case EXTERNAL_CONTRACTS_STATE:
      return isSetExternalContractsState();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecuteByteCodeResult)
      return this.equals((ExecuteByteCodeResult)that);
    return false;
  }

  public boolean equals(ExecuteByteCodeResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_results = true && this.isSetResults();
    boolean that_present_results = true && that.isSetResults();
    if (this_present_results || that_present_results) {
      if (!(this_present_results && that_present_results))
        return false;
      if (!this.results.equals(that.results))
        return false;
    }

    boolean this_present_externalContractsState = true && this.isSetExternalContractsState();
    boolean that_present_externalContractsState = true && that.isSetExternalContractsState();
    if (this_present_externalContractsState || that_present_externalContractsState) {
      if (!(this_present_externalContractsState && that_present_externalContractsState))
        return false;
      if (!this.externalContractsState.equals(that.externalContractsState))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.hashCode();

    hashCode = hashCode * 8191 + ((isSetResults()) ? 131071 : 524287);
    if (isSetResults())
      hashCode = hashCode * 8191 + results.hashCode();

    hashCode = hashCode * 8191 + ((isSetExternalContractsState()) ? 131071 : 524287);
    if (isSetExternalContractsState())
      hashCode = hashCode * 8191 + externalContractsState.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ExecuteByteCodeResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetResults()).compareTo(other.isSetResults());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResults()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.results, other.results);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExternalContractsState()).compareTo(other.isSetExternalContractsState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExternalContractsState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.externalContractsState, other.externalContractsState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ExecuteByteCodeResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("results:");
    if (this.results == null) {
      sb.append("null");
    } else {
      sb.append(this.results);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("externalContractsState:");
    if (this.externalContractsState == null) {
      sb.append("null");
    } else {
      sb.append(this.externalContractsState);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (status != null) {
      status.validate();
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ExecuteByteCodeResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteByteCodeResultStandardScheme getScheme() {
      return new ExecuteByteCodeResultStandardScheme();
    }
  }

  private static class ExecuteByteCodeResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<ExecuteByteCodeResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ExecuteByteCodeResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new com.credits.general.thrift.generated.APIResponse();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RESULTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.results = new java.util.ArrayList<SetterMethodResult>(_list0.size);
                @org.apache.thrift.annotation.Nullable SetterMethodResult _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new SetterMethodResult();
                  _elem1.read(iprot);
                  struct.results.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setResultsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EXTERNAL_CONTRACTS_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map3 = iprot.readMapBegin();
                struct.externalContractsState = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(2*_map3.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _key4;
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _val5;
                for (int _i6 = 0; _i6 < _map3.size; ++_i6)
                {
                  _key4 = iprot.readBinary();
                  _val5 = iprot.readBinary();
                  struct.externalContractsState.put(_key4, _val5);
                }
                iprot.readMapEnd();
              }
              struct.setExternalContractsStateIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ExecuteByteCodeResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.results != null) {
        oprot.writeFieldBegin(RESULTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.results.size()));
          for (SetterMethodResult _iter7 : struct.results)
          {
            _iter7.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.externalContractsState != null) {
        oprot.writeFieldBegin(EXTERNAL_CONTRACTS_STATE_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.externalContractsState.size()));
          for (java.util.Map.Entry<java.nio.ByteBuffer, java.nio.ByteBuffer> _iter8 : struct.externalContractsState.entrySet())
          {
            oprot.writeBinary(_iter8.getKey());
            oprot.writeBinary(_iter8.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ExecuteByteCodeResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ExecuteByteCodeResultTupleScheme getScheme() {
      return new ExecuteByteCodeResultTupleScheme();
    }
  }

  private static class ExecuteByteCodeResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<ExecuteByteCodeResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ExecuteByteCodeResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetResults()) {
        optionals.set(1);
      }
      if (struct.isSetExternalContractsState()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatus()) {
        struct.status.write(oprot);
      }
      if (struct.isSetResults()) {
        {
          oprot.writeI32(struct.results.size());
          for (SetterMethodResult _iter9 : struct.results)
          {
            _iter9.write(oprot);
          }
        }
      }
      if (struct.isSetExternalContractsState()) {
        {
          oprot.writeI32(struct.externalContractsState.size());
          for (java.util.Map.Entry<java.nio.ByteBuffer, java.nio.ByteBuffer> _iter10 : struct.externalContractsState.entrySet())
          {
            oprot.writeBinary(_iter10.getKey());
            oprot.writeBinary(_iter10.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ExecuteByteCodeResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.status = new com.credits.general.thrift.generated.APIResponse();
        struct.status.read(iprot);
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list11 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.results = new java.util.ArrayList<SetterMethodResult>(_list11.size);
          @org.apache.thrift.annotation.Nullable SetterMethodResult _elem12;
          for (int _i13 = 0; _i13 < _list11.size; ++_i13)
          {
            _elem12 = new SetterMethodResult();
            _elem12.read(iprot);
            struct.results.add(_elem12);
          }
        }
        struct.setResultsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map14 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.externalContractsState = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(2*_map14.size);
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _key15;
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _val16;
          for (int _i17 = 0; _i17 < _map14.size; ++_i17)
          {
            _key15 = iprot.readBinary();
            _val16 = iprot.readBinary();
            struct.externalContractsState.put(_key15, _val16);
          }
        }
        struct.setExternalContractsStateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

