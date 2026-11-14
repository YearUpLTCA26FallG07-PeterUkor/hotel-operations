package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void timeIsCorrectAfterPunchInAndPunchOut() {
        // arrange
        int employeeId = 999;
        String name = "Employee Name";
        String department = "Housekeeping";
        double payRate = 25;
        int hoursWorked = 0;
        int punchInTime = 9; // clock in at 9am
        int punchOutTime = 17; // clock out at 5pm
        int expectedHoursWorked = 8;

        Employee employee = new Employee(employeeId, name, department, payRate, hoursWorked);

        // act
        employee.punchIn(punchInTime);
        employee.punchOut(punchOutTime);

        // assert
        assertEquals(expectedHoursWorked, employee.getRegularHours());
    }

}