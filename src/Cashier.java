import java.util.Objects;

public class Cashier extends User{

    @Override
    public void changeStatus(Order order) {
        if (Objects.equals(order.getStatus(), "Entregue")) {
            order.setStatus("Pago");
        }
    }
}
