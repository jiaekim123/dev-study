package com.study.devstudy.spring.invoke;

import lombok.Builder;
import lombok.Getter;

@Builder(access = lombok.AccessLevel.PRIVATE)
public class Employee {

    @Getter
    private final String name;

    private int annualSalary;

    public static Employee hire(String name, int salary) {
        return Employee.builder()
                .name(name)
                .annualSalary(salary)
                .build();
    }

    private void setAnnualSalary(int annualSalary) {
        if (annualSalary < 0) {
            throw new IllegalArgumentException("연봉은 0보다 작을 수 없습니다.");
        }
        this.annualSalary = annualSalary;
    }

    private int getAnnualSalary() {
        return annualSalary;
    }

    private int calculateMonthlySalary() {
        return annualSalary / 12;
    }

    private int calculateMonthlySalaryWithTax() {
        return TaxRate.calculateMonthlySalary(annualSalary);
    }
}
