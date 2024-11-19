package pack;

/**
 * Represents a table in a relational database.
 * Defines methods for managing records in the table.
 */
public interface Table {
    /**
     * Adds a new record to the table.
     *
     * @param record the record to be added.
     */
    void addRecord(Object record);

    /**
     * Updates an existing record in the table.
     *
     * @param id        the ID of the record to update.
     * @param newRecord the updated record.
     */
    void updateRecord(int id, Object newRecord);

    /**
     * Deletes a record from the table by ID.
     *
     * @param id the ID of the record to delete.
     */
    void deleteRecord(int id);
}


