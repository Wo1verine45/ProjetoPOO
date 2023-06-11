import java.util.Objects;

public class Option {
    private byte optionNumber;
    private String optionName;
    private double optionPrice;
    private boolean optionAvailable;
    private String[] ingredients;

    public Option(byte optionNumber, String optionName, double optionPrice, boolean optionAvailable, String[] ingredients) {
        this.optionNumber = optionNumber;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.optionAvailable = optionAvailable;
        this.ingredients = ingredients;
    }

    public byte getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(byte optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(float optionPrice) {
        this.optionPrice = optionPrice;
    }

    public boolean isOptionAvailable() {
        return optionAvailable;
    }

    public void setOptionAvailable(boolean optionAvailable) {
        this.optionAvailable = optionAvailable;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}
