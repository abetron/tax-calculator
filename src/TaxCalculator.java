public class TaxCalculator {
    private double salary;
    private double taxWithholding;
    final private double standardDeduction;
    // 0 = single
    // 1 = married, filing jointly.
    private int filingStatus;
    final private Double[] taxRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
    final private int[] lowerBracket = {0, 11926, 48476, 103351, 197301, 250526, 626351};
    final private int[] upperBracket = {11925, 48475, 103350, 197300, 250525, 626350, Integer.MAX_VALUE};

    /*
    Tax Brackets for income earned in 2025.

    Tax brackets pulled from https://turbotax.intuit.com/tax-tools/calculators/tax-bracket/
*/

    public TaxCalculator() {
        this.standardDeduction = 13850;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTaxWithholding() {
        return this.taxWithholding;
    }

    public void setTaxWithholding(double taxWithholding) {
        this.taxWithholding = taxWithholding;
    }

    public String getFilingStatus() {
        if (filingStatus == 0) return "Single"; else {
            return "Married, filing jointly";
        }
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public double calculateEffectiveTaxRate() {
        return this.calculateTotalTax() / this.salary * 100;
    }

    public double calculateTotalTax() {
        double totalTaxOwed = 0;

        int i = 0;
        while (this.salary - this.standardDeduction > this.lowerBracket[i]) {
            if (this.salary - this.standardDeduction > this.upperBracket[i]) {
                totalTaxOwed += (this.upperBracket[i] - this.lowerBracket[i]) * this.taxRates[i];
            } else {
                totalTaxOwed += ((this.salary - this.standardDeduction) - this.lowerBracket[i]) * this.taxRates[i];
            }
            i++;
        }

        return totalTaxOwed;
    }
}
