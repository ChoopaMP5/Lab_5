package pack;

/**
 * A concrete implementation of the TableMediator interface.
 * Manages interactions between tables and handles foreign key validation.
 */
public class ConcreteMediator implements TableMediator {
    private ConcreteTable[] tables;
    private int tableCount;

    /**
     * Constructs a ConcreteMediator with a fixed initial size for tables.
     */
    public ConcreteMediator() {
        this.tables = new ConcreteTable[10]; // Initial fixed size
        this.tableCount = 0;
    }

    @Override
    public void registerTable(Table table) {
        if (table instanceof ConcreteTable) {
            if (tableCount == tables.length) {
                expandTablesArray();
            }
            tables[tableCount++] = (ConcreteTable) table;
            System.out.println("Table registered: " + ((ConcreteTable) table).getName());
        } else {
            System.out.println("Unsupported table type");
        }
    }

    @Override
    public boolean validateForeignKey(String tableName, Object record) {
        System.out.println("Validating foreign key for table: " + tableName + ", Record: " + record);
        // Stub: Assume all validations pass
        return true;
    }

    /**
     * Expands the internal tables array when it reaches its capacity.
     */
    private void expandTablesArray() {
        System.out.println("Expanding tables array.");
        ConcreteTable[] newTables = new ConcreteTable[tables.length * 2];
        for (int i = 0; i < tables.length; i++) {
            newTables[i] = tables[i];
        }
        tables = newTables;
    }
}

