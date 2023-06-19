public class Main {
    public static void main(String[] args) {

        // Cria o menu:
        Option[] options = new Option[12];
        Menu menu = new Menu(options);
        options[0] = new Option((byte)1, "X-Burguer", 19.99, true, new String[]{"Pão", "Carne", "Queijo"});
        options[1] = new Option((byte)2, "X-Salada", 24.99, true, new String[]{"Pão", "Carne", "Queijo", "Alface"});
        options[2] = new Option((byte)3, "X-Chicken", 17.99, false, new String[]{"Pão", "Frango", "Queijo"});
        options[3] = new Option((byte)4, "X-TUDO", 34.99, true, new String[]{"Pão", "Carne", "Ovo", "Queijo", "Salada"});
        options[4] = new Option((byte)5, "Batata Frita", 9.99, true, new String[]{});
        options[5] = new Option((byte)6, "Nuggets(x10)", 14.99, true, new String[]{});
        options[6] = new Option((byte)7, "Batata Chips", 12.99, false, new String[]{});
        options[7] = new Option((byte)8, "Coca-Cola", 7.99, true, new String[]{});
        options[8] = new Option((byte)9, "Suco Caixinha", 4.99, true, new String[]{});
        options[9] = new Option((byte)10, "Cerveja Lata", 9.99, false, new String[]{});
        options[10] = new Option((byte)11, "Suco Natural", 8.99, true, new String[]{});
        options[11] = new Option((byte)12, "Drink", 14.99, true, new String[]{});
        menu.showMenu();

        // Faz o pedido:
        Client client1 = new Client((byte)1);
        int[] temporaryOrders = client1.placeOrder();

        // Conta quantos pedidos têm
        int i = 0;
        for (; i < temporaryOrders.length && temporaryOrders[i] != 0; i++);

        // Passa o número dos pedidos para classe orders
        Order[] orders = new Order[i];
        for (int k = 0; k < i; k++) {
            orders[k] = new Order(temporaryOrders[k]);
        }

        // Cria os funcionários:
        Waiter waiter = new Waiter();
        Cook cook = new Cook();
        Barman barman = new Barman();
        Cashier cashier = new Cashier();

        // Vai mudar os status para os primeiros (Em preparo ou pendente), com o garçom mandando os pedidos pra o cozinheiro,
        // para o barman ou indo buscar a bebida na geladeira
        for (int a = 0; a < i; a++) {
            if (orders[a].getOrderNumber() >= 1 && orders[a].getOrderNumber() <= 7) {
                waiter.changeStatus(orders[a]);
            } else if (orders[a].getOrderNumber() >= 8 && orders[a].getOrderNumber() <= 10) {
                waiter.changeStatus(orders[a]);
            } else {
                waiter.changeStatus(orders[a]);
            }
            System.out.print("Status do(a) " + options[(orders[a].getOrderNumber()) - 1].getOptionName());
            if (client1.getPersonalization()[a] == 1) {
                System.out.print(" (Mal Passada)");
            } else if (client1.getPersonalization()[a] == 2) {
                System.out.print(" (Ao Ponto)");
            } else if (client1.getPersonalization()[a] == 3) {
                System.out.print(" (Bem Passado)");
            }
            System.out.println(" da mesa " + client1.getTableNumber() +": " + orders[a].getStatus());
        }
        System.out.println();

        // Vai mudar os status para os próximos (pronto), com o cozinheiro e o barman preparando os pedidos
        for (int b = 0; b < i; b++) {
            if (orders[b].getOrderNumber() >= 1 && orders[b].getOrderNumber() <= 7) {
                cook.changeStatus(orders[b]);
            } else if (orders[b].getOrderNumber() >= 11 && orders[b].getOrderNumber() <= 12) {
                barman.changeStatus(orders[b]);
            }
            System.out.print("Status do(a) " + options[(orders[b].getOrderNumber()) - 1].getOptionName());
            if (client1.getPersonalization()[b] == 1) {
                System.out.print(" (Mal Passada)");
            } else if (client1.getPersonalization()[b] == 2) {
                System.out.print(" (Ao Ponto)");
            } else if (client1.getPersonalization()[b] == 3) {
                System.out.print(" (Bem Passado)");
            }
            System.out.println(" da mesa " + client1.getTableNumber() +": " + orders[b].getStatus());
        }
        System.out.println();

        // Muda os status para entregue, com o garçom entregando o pedido inteiro junto
        for (int c = 0; c < i; c++) {
            waiter.changeStatus(orders[c]);
            System.out.print("Status do(a) " + options[(orders[c].getOrderNumber()) - 1].getOptionName());
            if (client1.getPersonalization()[c] == 1) {
                System.out.print(" (Mal Passada)");
            } else if (client1.getPersonalization()[c] == 2) {
                System.out.print(" (Ao Ponto)");
            } else if (client1.getPersonalization()[c] == 3) {
                System.out.print(" (Bem Passado)");
            }
            System.out.println(" da mesa " + client1.getTableNumber() +": " + orders[c].getStatus());
        }
        System.out.println();

        // Muda os status para Pago, pois o cliente já pagou
        for (int d = 0; d < i; d++) {
            cashier.changeStatus(orders[d]);
            System.out.print("Status do(a) " + options[(orders[d].getOrderNumber()) - 1].getOptionName());
            if (client1.getPersonalization()[d] == 1) {
                System.out.print(" (Mal Passada)");
            } else if (client1.getPersonalization()[d] == 2) {
                System.out.print(" (Ao Ponto)");
            } else if (client1.getPersonalization()[d] == 3) {
                System.out.print(" (Bem Passado)");
            }
            System.out.println(" da mesa " + client1.getTableNumber() +": " + orders[d].getStatus());
        }
        System.out.println();

        // Muda os status para Mesa Disponível
        for (int e = 0; e < i; e++) {
            waiter.changeStatus(orders[e]);
        }
        System.out.println("Status da mesa " + client1.getTableNumber() +": " + orders[0].getStatus());
    }
}