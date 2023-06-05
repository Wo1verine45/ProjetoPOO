public class Menu {
    private Option[] options;

    public Menu(Option[] options) {
        this.options = options;
    }

    public void showMenu() {
        for (Option option : options) {
            System.out.print(option.getOptionNumber() >= 10 ? option.getOptionNumber() : "0" + option.getOptionNumber());
            System.out.print(" - " + option.getOptionName() + " --- R$" + option.getOptionPrice());
            System.out.println(option.isOptionAvailable() ? "" : " (Indisponível)");
        }
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }
}
