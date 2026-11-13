package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;
    private int punchTime;
    private boolean clockedIn;

    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        clockedIn = false;
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

    public void punchIn(int time) {
        punchTime = time;
    }

    // overload punchIn method
    public void punchIn() {
        punchIn(getHoursFromTime());
    }

    public void punchOut(int time) {
        // subtract start time from end time and ensure it's not negative
        hoursWorked += Math.abs(time - punchTime);
    }

    // overload punchOut method
    public void punchOut() {
        punchOut(getHoursFromTime());
    }

    // calculate the hour now
    public int getHoursFromTime() {
        // get the time now
        LocalDateTime timeNow = LocalDateTime.now();
        int hourNow = timeNow.getHour();

        // add one to hourNow if minute is greater than 0
        hourNow += (timeNow.getMinute() > 0) ? 1 : 0;

        return hourNow;
    }

    public void punchTimeCard(int time) {
        // keep the time within 24 hr limit
        time = Math.abs(time);
        time %= 24;

        // if employee is clocked-in calculate hours worked and clock out
        // or else set the punch time and clock in
        if (clockedIn) {

            hoursWorked += Math.abs(time - punchTime);
            punchTime = 0;
            clockedIn = false;
        } else {

            punchTime = time;
            clockedIn = true;
        }
    }
}
