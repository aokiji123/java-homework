package ATM;

public class ATM {
    private int[] denominations;
    private final int[] banknotes = {1, 2, 5, 10, 20, 50, 100, 200, 500};
    private int minAmount;
    private int maxNotes;

    public ATM(int minAmount, int maxNotes) {
        this.minAmount = minAmount;
        this.maxNotes = maxNotes;
        this.denominations = new int[banknotes.length];
    }

    public void loadCash(int[] amounts) {
        if (amounts.length != banknotes.length) {
            throw new IllegalArgumentException("Кількість номіналів не співпадає.");
        }
        for (int i = 0; i < amounts.length; i++) {
            this.denominations[i] += amounts[i];
        }
    }

    public int[] withdrawCash(int amount) throws Exception {
        if (amount < minAmount) {
            throw new Exception("Мінімальна сума для зняття: " + minAmount);
        }

        int[] withdrawn = new int[banknotes.length];
        int remainingAmount = amount;

        for (int i = banknotes.length - 1; i >= 0; i--) {
            int denomination = banknotes[i];
            int availableNotes = denominations[i];
            int maxNotesToWithdraw = Math.min(remainingAmount / denomination, availableNotes);
            maxNotesToWithdraw = Math.min(maxNotesToWithdraw, maxNotes);

            if (maxNotesToWithdraw > 0) {
                withdrawn[i] = maxNotesToWithdraw;
                remainingAmount -= maxNotesToWithdraw * denomination;
                denominations[i] -= maxNotesToWithdraw;
            }

            if (remainingAmount == 0) break;
        }

        if (remainingAmount > 0) {
            throw new Exception("Неможливо видати таку суму, спробуйте іншу суму.");
        }

        return withdrawn;
    }

    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < banknotes.length; i++) {
            total += banknotes[i] * denominations[i];
        }
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ATM)) return false;
        ATM other = (ATM) obj;
        return this.minAmount == other.minAmount &&
                this.maxNotes == other.maxNotes &&
                java.util.Arrays.equals(this.denominations, other.denominations);
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.hashCode(denominations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ATM{");
        for (int i = 0; i < banknotes.length; i++) {
            sb.append(banknotes[i]).append("x").append(denominations[i]).append(" ");
        }
        sb.append(", minAmount=").append(minAmount).append(", maxNotes=").append(maxNotes).append("}");
        return sb.toString();
    }
}

