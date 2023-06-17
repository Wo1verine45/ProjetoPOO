import java.util.Objects;

public class Cook extends User{

    @Override
    public void changeStatus(Order order) {
        if (Objects.equals(order.getStatus(), "Em Preparo")) {
            order.setStatus("Pronto");
        }
    }
}
