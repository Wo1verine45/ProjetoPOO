import java.util.Scanner;

public class Client{
    private byte tableNumber;
    private int[] orders = new int[100];
    private int[] personalization = new int[100];

    public Client(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int[] placeOrder() {
        Scanner scanner = new Scanner(System.in);
        int orderNumber = 0;
        int p;
        int option;
        int i = 0;
        while (true) {
            if (i == 0) {
                System.out.println("Para fazer pedidos, digite 1:");
            } else {
                System.out.println("Para continuar fazendo pedidos, digite 1");
                System.out.println("Para finalizar seu pedido, digite 0:");
            }
            option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Selecione o número do seu pedido: ");
                orderNumber = scanner.nextInt();
                while (orderNumber < 1 || orderNumber > 12 || orderNumber == 3 || orderNumber == 7 || orderNumber == 10) {
                    if (orderNumber == 3 || orderNumber == 7 || orderNumber == 10) {
                        System.out.println("Número de pedido não disponível!");
                        System.out.println("Selecione o número do seu pedido: ");
                        orderNumber = scanner.nextInt();
                    } else {
                        System.out.println("Número de pedido não existe!");
                        System.out.println("Selecione o número do seu pedido: ");
                        orderNumber = scanner.nextInt();
                    }
                }
                if (orderNumber >= 1 && orderNumber <= 4) {
                    System.out.println("Escolha o ponto da carne: ");
                    System.out.println("Mal passado, digite 1 ");
                    System.out.println("Ao ponto, digite 2 ");
                    System.out.println("Bem passado, digite 3: ");
                    p = scanner.nextInt();
                    while (p < 1 || p > 3) {
                        System.out.println("Número inválido!");
                        System.out.println("Escolha o ponto da carne: ");
                        System.out.println("Mal passado, digite 1 ");
                        System.out.println("Ao ponto, digite 2 ");
                        System.out.println("Bem passado, digite 3: ");
                        p = scanner.nextInt();
                    }
                    personalization[i] = p;
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

    public void setPersonalization(int[] personalization) {
        this.personalization = personalization;
    }

    public int[] getPersonalization() {
        return personalization;
    }
}
