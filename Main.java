import pack.*;

/**
 * Demonstrates the usage of the Mediator pattern with tables and foreign key validation.
 */
public class Main {
    public static void main(String[] args) {
        TableMediator mediator = new ConcreteMediator();

        Table usersTable = new ConcreteTable("Users", mediator);
        Table ordersTable = new ConcreteTable("Orders", mediator);

        mediator.registerTable(usersTable);
        mediator.registerTable(ordersTable);

        usersTable.addRecord("User1");
        ordersTable.addRecord("Order1 for User1");

        usersTable.addRecord("User2");
        usersTable.deleteRecord(0);
        usersTable.updateRecord(0, "Updated User2");
    }
}

