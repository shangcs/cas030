

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.facebook.infrastructure.loader package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SuperColumn_QNAME = new QName("", "SuperColumn");
    private final static QName _Table_QNAME = new QName("", "Table");
    private final static QName _Column_QNAME = new QName("", "Column");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.facebook.infrastructure.loader
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeyType }
     * 
     */
    public KeyType createKeyType() {
        return new KeyType();
    }

    /**
     * Create an instance of {@link SuperColumnType }
     * 
     */
    public SuperColumnType createSuperColumnType() {
        return new SuperColumnType();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link Importer }
     * 
     */
    public Importer createImporter() {
        return new Importer();
    }

    /**
     * Create an instance of {@link ColumnFamilyType }
     * 
     */
    public ColumnFamilyType createColumnFamilyType() {
        return new ColumnFamilyType();
    }

    /**
     * Create an instance of {@link TimestampType }
     * 
     */
    public TimestampType createTimestampType() {
        return new TimestampType();
    }

    /**
     * Create an instance of {@link FieldCollection }
     * 
     */
    public FieldCollection createFieldCollection() {
        return new FieldCollection();
    }

    /**
     * Create an instance of {@link ValueType }
     * 
     */
    public ValueType createValueType() {
        return new ValueType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuperColumnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SuperColumn")
    public JAXBElement<SuperColumnType> createSuperColumn(SuperColumnType value) {
        return new JAXBElement<SuperColumnType>(_SuperColumn_QNAME, SuperColumnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Table")
    public JAXBElement<String> createTable(String value) {
        return new JAXBElement<String>(_Table_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Column")
    public JAXBElement<ColumnType> createColumn(ColumnType value) {
        return new JAXBElement<ColumnType>(_Column_QNAME, ColumnType.class, null, value);
    }

}
