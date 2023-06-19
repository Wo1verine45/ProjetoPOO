import java.util.Objects;

public class Waiter extends User{

    @Override
    public void changeStatus(Order order) {
        if (Objects.equals(order.getStatus(), "Mesa Disponível") && ((order.getOrderNumber() >= 1 && order.getOrderNumber() <= 7) || order.getOrderNumber() >= 11 && order.getOrderNumber() <= 12)) {
            order.setStatus("Em Preparo");
        } else if (Objects.equals(order.getStatus(), "Mesa Disponível") && order.getOrderNumber() >= 8 && order.getOrderNumber() <= 10) {
            order.setStatus("Pendente");
        } else if (Objects.equals(order.getStatus(), "Pronto")) {
            order.setStatus("Entregue");
        } else if (Objects.equals(order.getStatus(), "Pendente")) {
            order.setStatus("Entregue");
        } else if (Objects.equals(order.getStatus(), "Pago")){
            order.setStatus("Mesa Disponível");
        }
    }
}
