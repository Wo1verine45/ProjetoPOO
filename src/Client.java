public class Client {
    private byte tableNumber;

    public Client(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Option placeOrder(Option option) {
        return option;
    }

    public byte getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(byte tableNumber) {
        this.tableNumber = tableNumber;
    }
}
