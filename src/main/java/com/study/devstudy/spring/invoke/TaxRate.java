package com.study.devstudy.spring.invoke;

public enum TaxRate {
    DEFAULT(0, 1200, 0.06, 0),
    OVER_1400(1400, 5000, 0.15, 84),
    OVER_5000(5000, 8800, 0.24, 624),
    OVER_8800(8800, 15000, 0.35, 1536),
    OVER_15000(15000, 30000, 0.38, 3706);

    private final int minAnnualSalary;

    private final int maxAnnualSalary;
    private final double rate;
    private final int defaultTax;

    TaxRate(int minAnnualSalary, int maxAnnualSalary, double rate, int defaultTax) {
        this.minAnnualSalary = minAnnualSalary;
        this.maxAnnualSalary = maxAnnualSalary;
        this.rate = rate;
        this.defaultTax = defaultTax;
    }

    private static int calculateAnnualTax(int annualSalary) {
        for (TaxRate taxRate : TaxRate.values()) {
            if (annualSalary > taxRate.minAnnualSalary && annualSalary <= taxRate.maxAnnualSalary) {
                return taxRate.defaultTax + (int) ((annualSalary - taxRate.minAnnualSalary) * taxRate.rate);
            }
        }
        return 0;
    }

    public static int calculateMonthlySalary(int annualSalary) {
        return (annualSalary - calculateAnnualTax(annualSalary)) / 12;
    }
}
