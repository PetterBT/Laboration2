package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {

    public Employee stubEmployee() {
        return new Employee("1", 100.0);
    }

    private List<Employee> stubEmployeeList() {
        return Arrays.asList(
                new Employee("1", 10.0),
                new Employee("2", 50.0),
                new Employee("3", 100.0));
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
    @Test
    void shouldSetPaidOfStubEmployee() {
        Employee employee = stubEmployee();
        employee.setPaid(true);
        assertThat(employee.isPaid()).isTrue();
        employee.setPaid(false);
        assertThat(employee.isPaid()).isFalse();
    }
    @Test
    void toStringShouldContainEmployeeId() {
        Employee employee = stubEmployee();
        assertThat(employee.toString()).contains(employee.getId());
    }
    @Test
    void toStringShouldContainEmployeeSalary() {
        Employee employee = stubEmployee();
        assertThat(employee.toString()).contains(String.valueOf(employee.getSalary()));
    }
    @Test
    void numberOfPaymentsShouldBeEqualToNumberOfEmployees() {
        EmployeeRepository mockEmployeeRepository = mock(EmployeeRepository.class);
        BankService mockBankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(mockEmployeeRepository, mockBankService);

        List<Employee> employees = stubEmployeeList();
        when(mockEmployeeRepository.findAll()).thenReturn(employees);

        assertThat(employeeManager.payEmployees()).isEqualTo(3);
    }
}