package com.pluralsight;

public class Employee {
    private double payRate;
    private int hoursWorked;

    public Employee(double payRate, int hoursWorked) {
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        // calculate total regular hours pay
        double totalPay = payRate * getRegularHours();

        // calculate overtime pay rate and total overtime pay
        double overtimePayRate = (payRate / 100) * 50;
        totalPay += overtimePayRate * getOvertimeHours();

        return totalPay;
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
