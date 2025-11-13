package Models;


public class Budget {
    private double totalBudget;
    private double usedBudget;

    public Budget(double totalBudget) {
        this.totalBudget = Math.max(0.0, totalBudget);
        this.usedBudget = 0.0;
    }

    public double getTotalBudget() { return totalBudget; }
    public double getUsedBudget() { return usedBudget; }
    public double getRemaining() { return totalBudget - usedBudget; }

    public boolean allocate(double amount) {
        if (amount <= 0) return false;
        if (usedBudget + amount > totalBudget) return false;
        usedBudget += amount;
        return true;
    }

    public void addFunds(double amount) {
        if (amount > 0) totalBudget += amount;
    }

    public void refund(double amount) {
        if (amount > 0) usedBudget = Math.max(0.0, usedBudget - amount);
    }

    @Override
    public String toString() {
        return String.format("Budget(total=%.2f, used=%.2f, remaining=%.2f)", totalBudget, usedBudget, getRemaining());
    }
}
