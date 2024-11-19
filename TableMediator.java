package pack;

/**
 * Defines the mediator responsible for managing interactions between tables.
 */
public interface TableMediator {
    /**
     * Registers a table with the mediator.
     *
     * @param table the table to register.
     */
    void registerTable(Table table);

    /**
     * Validates a foreign key for a specific table.
     *
     * @param tableName the name of the table containing the foreign key.
     * @param record    the record to validate.
     * @return true if the foreign key is valid, false otherwise.
     */
    boolean validateForeignKey(String tableName, Object record);
}


