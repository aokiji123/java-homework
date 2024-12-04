package TaxInspector;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<TaxInfo> taxes;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.taxes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<TaxInfo> getTaxes() {
        return taxes;
    }

    public void addTaxInfo(TaxInfo taxInfo) {
        taxes.add(taxInfo);
    }

    public void removeTaxInfo(TaxInfo taxInfo) {
        taxes.remove(taxInfo);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(name).append(", Address: ").append(address).append("\nTaxes:\n");
        for (TaxInfo taxInfo : taxes) {
            builder.append("  - ").append(taxInfo).append("\n");
        }
        return builder.toString();
    }
}
