package com.study.devstudy.spring.invoke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
class EmployeeReflectionTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.hire("김철수", 5000);
    }

    @Test
    void 연봉을_변경한다() {
        Assertions.assertEquals(5000, ReflectionTestUtils.getField(employee, "annualSalary"));

        ReflectionTestUtils.setField(employee, "annualSalary", 6000);
        Assertions.assertEquals(6000, ReflectionTestUtils.getField(employee, "annualSalary"));
    }

    @Test
    void 월급을_확인한다() {
        int monthlySalary = ReflectionTestUtils.invokeMethod(employee, "calculateMonthlySalary");
        Assertions.assertEquals(416, monthlySalary);
    }

    @Test
    void 연봉의_연소득세를_확인한다() {
        int tax = ReflectionTestUtils.invokeMethod(TaxRate.class, "calculateAnnualTax", 5000);
        Assertions.assertEquals(624, tax);
    }

    @Test
    void 소득세를뺀_월급을_확인한다() {
        int monthlySalaryWithTax = ReflectionTestUtils.invokeMethod(employee, "calculateMonthlySalaryWithTax");
        Assertions.assertEquals(364, monthlySalaryWithTax);
    }

}