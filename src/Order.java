public class Order {
    private final byte orderNumber = 1;
    private Option[] options;

    public Order(Option[] options) {
        this.options = options;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }
}
