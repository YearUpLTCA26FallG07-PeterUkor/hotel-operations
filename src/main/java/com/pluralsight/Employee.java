package com.pluralsight;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;

    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        // calculate total pay for regular hours
        double totalPay = payRate * getRegularHours();

        // calculate overtime pay rate and total overtime pay
        double overtimePayRate = payRate + (payRate / 100) * 50;
        totalPay += overtimePayRate * getOvertimeHours();

        return totalPay;
    }

    public int getRegularHours() {
        // return hours worked if it is less than 40
        return Math.min(hoursWorked, 40);
    }

    public int getOvertimeHours() {
        // check if hours are over 40 and return hours over 40
        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
    }
}
