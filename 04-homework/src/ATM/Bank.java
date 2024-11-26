package ATM;
import java.util.*;

public class Bank {
    private List<ATM> atmNetwork;

    public Bank() {
        atmNetwork = new ArrayList<>();
    }

    public void addATM(ATM atm) {
        atmNetwork.add(atm);
    }

    public int getTotalCashInBank() {
        int totalCash = 0;
        for (ATM atm : atmNetwork) {
            totalCash += atm.getTotalAmount();
        }
        return totalCash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Bank)) return false;
        Bank other = (Bank) obj;
        return atmNetwork.equals(other.atmNetwork);
    }

    @Override
    public int hashCode() {
        return atmNetwork.hashCode();
    }

    @Override
    public String toString() {
        return "Bank{" +
                "atmNetwork=" + atmNetwork +
                '}';
    }
}
