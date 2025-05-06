package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Employee {

    private String employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;
    private boolean punchedIn;
    private LocalDateTime punchIn;
    private LocalDateTime punchOut;

    public Employee(String employeeId, String name, String department, float payRate, float hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchedIn = false;
    }

    public void punchTimeCard() {
        if (!isPunchedIn()) {
            this.punchIn();
        } else {
            this.punchOut();
        }
    }

    public void punchTimeCard(LocalDateTime time) {
        if (!isPunchedIn()) {
            this.punchIn(time);
        } else {
            this.punchOut(time);
        }
    }

    public void punchIn() {
        this.punchIn = LocalDateTime.now();
        setPunchedIn(true);
    }

    public void punchIn(LocalDateTime time) {
        this.punchIn = time;
        setPunchedIn(true);
    }

    public void punchOut() {
        this.punchOut = LocalDateTime.now();
        setPunchedIn(false);
        Duration howLong = Duration.between(this.getPunchIn(), this.getPunchOut());
        float hours=howLong.getSeconds()/3600.f;
        this.setHoursWorked(this.getHoursWorked() + hours);
    }

    public void punchOut(LocalDateTime time) {
        this.punchOut = time;
        setPunchedIn(false);
        Duration howLong = Duration.between(this.getPunchIn(), this.getPunchOut());
        float hours=howLong.getSeconds()/3600.f;
        this.setHoursWorked(this.getHoursWorked() + hours);
    }

    public void setPunchedIn(boolean punchedIn) {
        this.punchedIn = punchedIn;
    }

    public boolean isPunchedIn() {
        return punchedIn;
    }

    public LocalDateTime getPunchIn() {
        return punchIn;
    }

    public LocalDateTime getPunchOut() {
        return punchOut;
    }

    public float getRegularHours() {
        return Math.min(getHoursWorked(), 40);
    }

    public float getOvertimeHours() {
        return Math.max(getHoursWorked() - 40, 0);
    }

    public float getTotalPay() {
        return this.getRegularHours() * this.getPayRate() + this.getOvertimeHours() * this.getPayRate() * 1.5f;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


}
