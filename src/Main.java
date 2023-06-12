public class Main {
    public static void main(String[] args) {

        Option[] options = new Option[12];
        Menu menu = new Menu(options);
        options[0] = new Option((byte)1, "X-Burguer", 19.99, true, new String[]{"Pão", "Carne", "Queijo"});
        options[1] = new Option((byte)2, "X-Salada", 24.99, true, new String[]{"Pão", "Carne", "Queijo", "Alface"});
        options[2] = new Option((byte)3, "X-Chicken", 17.99, false, new String[]{"Pão", "Frango", "Queijo"});
        options[3] = new Option((byte)4, "X-TUDO", 34.99, true, new String[]{"Pão", "Carne", "Ovo", "Queijo", "Salada"});
        options[4] = new Option((byte)5, "Batata Frita", 9.99, true, new String[]{});
        options[5] = new Option((byte)6, "Nuggets(x10)", 14.99, true, new String[]{});
        options[6] = new Option((byte)7, "Batata Chips", 12.99, false, new String[]{});
        options[7] = new Option((byte)8, "Refrigerante Lata", 7.99, true, new String[]{});
        options[8] = new Option((byte)9, "Suco Caixinha", 4.99, true, new String[]{});
        options[9] = new Option((byte)10, "Cerveja Lata", 9.99, false, new String[]{});
        options[10] = new Option((byte)11, "Suco Natural", 8.99, true, new String[]{});
        options[11] = new Option((byte)12, "Drink", 14.99, true, new String[]{});
        menu.showMenu();
        Client client1 = new Client((byte)1, 0);
        int[] temporaryOrders = client1.placeOrder();
        int i = 0;
        // conta quantos pedidos tem
        for (; i < temporaryOrders.length && temporaryOrders[i] != 0; i++);
        int needPrepareNumber = 0;
        int needPrepareBarmanNumber = 0;
        int noPrepareNumber = 0;
        Order[] orders = new Order[i];
        // passa o número dos pedidos pra classe orders e ve quantos precisam de preparo ou n
        for (int k = 0; k < i; k++) {
            orders[k] = new Order(temporaryOrders[k]);
            if (temporaryOrders[k] >= 1 && temporaryOrders[k] <= 7) {
                needPrepareNumber++;
            } else if (temporaryOrders[k] >= 11 && temporaryOrders[k] <= 12) {
                needPrepareBarmanNumber++;
            } else {
                noPrepareNumber++;
            }
        }
        Waiter[] waiters = new Waiter[i];
        Cook[] cooks = new Cook[needPrepareNumber];
        // vai mudar os status
        for (int a = 0; a < i;) {
            for (int cookNumber = 0; temporaryOrders[a] >= 1 && temporaryOrders[a] <= 7; cookNumber++, a++) {
                cooks[cookNumber] = new Cook(orders[a], 2);
                waiters[a] = new Waiter(orders[a], 2);
                System.out.println("Status Atual: " + orders[a].getStatus());
                waiters[a].sendToCook();
                System.out.println("Status Atual: " + orders[a].getStatus());
                cooks[cookNumber].cook();
                System.out.println("Status Atual: " + orders[a].getStatus());
                waiters[a].deliver();
                System.out.println("Status Atual: " + orders[a].getStatus());
                client1.pay(orders[a]);
                System.out.println("Status Atual: " + orders[a].getStatus());
            }
            a++;
            /*
            for (temporaryOrders[a] >= 11 && temporaryOrders[a] <= 12) {
                needPrepareBarmanNumber++;
            } else {
                noPrepareNumber++;
            }
             */

        }
    }
}