import java.util.Objects;

public class Barman extends User{

    @Override
    public void changeStatus(Order order) {
        if (Objects.equals(order.getStatus(), "Em Preparo")) {
            order.setStatus("Pronto");
        }
    }
}
