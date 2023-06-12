import java.util.Scanner;

public class Client{
    private byte tableNumber;
    private int[] orders = new int[100];

    public Client(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int[] placeOrder() {
        Scanner scanner = new Scanner(System.in);
        int orderNumber = 0;
        int option;
        int i = 0;
        while (true) {
            if (i == 0) {
                System.out.println("Para fazer pedidos, digite 1:");
                option = scanner.nextInt();
            } else {
                System.out.println("Para continuar fazendo pedidos, digite 1");
                System.out.println("Para finalizar seu pedido, digite 0:");
                option = scanner.nextInt();
            }
            if (option == 1) {
                System.out.println("Selecione o número do seu pedido: ");
                orderNumber = scanner.nextInt();
                while (orderNumber < 1 || orderNumber > 12) {
                    System.out.println("Número de pedido não existe!");
                    System.out.println("Selecione o número do seu pedido: ");
                    orderNumber = scanner.nextInt();
                }
                orders[i] = orderNumber;
                i++;
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }

        }
        return orders;
    }

    public byte getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int[] getOrders() {
        return orders;
    }

    public void setOrders(int[] orders) {
        this.orders = orders;
    }
}
