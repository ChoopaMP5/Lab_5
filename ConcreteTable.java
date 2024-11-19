package pack;

/**
 * A concrete implementation of the Table interface.
 * Represents a specific table in the database.
 */
public class ConcreteTable implements Table {
    private String name;
    private Object[] records;
    private int recordCount;
    private TableMediator mediator;

    /**
     * Constructs a ConcreteTable with a given name and mediator.
     *
     * @param name     the name of the table.
     * @param mediator the mediator managing interactions with other tables.
     */
    public ConcreteTable(String name, TableMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.records = new Object[10]; // Initial fixed size
        this.recordCount = 0;
    }

    /**
     * Gets the name of the table.
     *
     * @return the name of the table.
     */
    public String getName() {
        return name;
    }

    @Override
    public void addRecord(Object record) {
        System.out.println("Attempting to add record to table: " + name + ", Record: " + record);
        if (mediator.validateForeignKey(name, record)) {
            if (recordCount == records.length) {
                expandRecordsArray();
            }
            records[recordCount++] = record;
            System.out.println("Record added to " + name + ": " + record);
        } else {
            System.out.println("Foreign key validation failed for record: " + record);
        }
    }

    @Override
    public void updateRecord(int id, Object newRecord) {
        System.out.println("Updating record in table: " + name + ", ID: " + id + ", New Record: " + newRecord);
        if (id >= 0 && id < recordCount) {
            records[id] = newRecord;
        } else {
            System.out.println("Invalid ID: " + id);
        }
    }

    @Override
    public void deleteRecord(int id) {
        System.out.println("Deleting record in table: " + name + ", ID: " + id);
        if (id >= 0 && id < recordCount) {
            // Shift elements to fill the gap
            for (int i = id; i < recordCount - 1; i++) {
                records[i] = records[i + 1];
            }
            records[--recordCount] = null; // Nullify the last element
        } else {
            System.out.println("Invalid ID: " + id);
        }
    }

    /**
     * Expands the internal records array when it reaches its capacity.
     */
    private void expandRecordsArray() {
        System.out.println("Expanding records array for table: " + name);
        Object[] newRecords = new Object[records.length * 2];
        for (int i = 0; i < records.length; i++) {
            newRecords[i] = records[i];
        }
        records = newRecords;
    }
}


