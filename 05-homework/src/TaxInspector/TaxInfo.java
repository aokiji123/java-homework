package TaxInspector;

public class TaxInfo {
    private String type;
    private String city;
    private double amount;

    public TaxInfo(String type, String city, double amount) {
        this.type = type;
        this.city = city;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", City: " + city + ", Amount: $" + amount;
    }
}
