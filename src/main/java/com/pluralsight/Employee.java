package com.pluralsight;

public class Employee {
    private double payRate;
    private int hoursWorked;

    public Employee(double payRate, int hoursWorked) {
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public int getRegularHours() {
        // return hours worked if it is less than 40
        return Math.min(hoursWorked, 40);
    }

    public int getOvertimeHours() {
        // check if hours are over 40 and return hours over 40
        return hoursWorked > 40 ? hoursWorked - 40 : 0;
    }
}
