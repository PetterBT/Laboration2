package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeManagerTest {

    public Employee stubEmployee() {
        return new Employee("1", 100.0);
    }

    @Test
    void getIdShouldReturnStubEmployeeId() {
        Employee employee = stubEmployee();
        assertThat(employee.getId()).isEqualTo("1");
    }
    @Test
    void getSalaryShouldReturnStubEmployeeSalary() {
        Employee employee = stubEmployee();
        assertThat(employee.getSalary()).isEqualTo(100.0);
    }
    @Test
    void shouldSetIdOfStubEmployee() {
        Employee employee = stubEmployee();
        employee.setId("2");
        assertThat(employee.getId()).isEqualTo("2");
    }
    @Test
    void shouldSetSalaryOfStubEmployee() {
        Employee employee = stubEmployee();
        employee.setSalary(50.0);
        assertThat(employee.getSalary()).isEqualTo(50.0);
    }

}