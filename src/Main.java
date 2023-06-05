public class Main {
    public static void main(String[] args) {

        Option[] options = new Option[12];
        Menu menu = new Menu(options);
        options[0] = new Option((byte)1, "X-Burguer", 19.99, true);
        options[1] = new Option((byte)2, "X-Salada", 24.99, false);
        options[2] = new Option((byte)3, "X-Chicken", 17.99, true);
        options[3] = new Option((byte)4, "X-TUDO", 34.99, true);
        options[4] = new Option((byte)5, "Batata Frita", 9.99, true);
        options[5] = new Option((byte)6, "Nuggets", 14.99, true);
        options[6] = new Option((byte)7, "Batata Chips", 12.99, false);
        options[7] = new Option((byte)8, "Refrigerante Lata", 7.99, true);
        options[8] = new Option((byte)9, "Suco Caixinha", 4.99, true);
        options[9] = new Option((byte)10, "Suco Natural", 8.99, true);
        options[10] = new Option((byte)11, "Cerveja Lata", 9.99, false);
        options[11] = new Option((byte)12, "Drink", 14.99, true);
        menu.showMenu();
    }
}