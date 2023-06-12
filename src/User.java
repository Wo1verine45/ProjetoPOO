public class User {

    private int id;
    private Order order;

    public User(int id) {
        this.id = id;
    }
    public User(Order order, int id) {
        this.order = order;
        this.id = id;
    }
    public void changeStatus(String status) {
        order.setStatus(status);
    }

    public void sendToCook() {
        changeStatus("Em Preparo");
    }

    public void cook() {
        changeStatus("Pronto");
    }

    public void deliver() {
        changeStatus("Entregue");
    }

    public void pay(Order order) {
        order.setStatus("Mesa Disponível");
    }
}
