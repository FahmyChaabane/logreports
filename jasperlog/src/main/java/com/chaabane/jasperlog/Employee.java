package com.chaabane.jasperlog;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;
    String employeeName;
    String employeeAddress;
    long employeeSalary;
    String employeeGrad;
    @ManyToOne
    @JoinColumn(name = "CODE_ENTREPRISE")
    Company employeeCompany;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String employeeAddress, long employeeSalary, String employeeGrad) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.employeeGrad = employeeGrad;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeGrad() {
        return employeeGrad;
    }

    public void setEmployeeGrad(String employeeGrad) {
        this.employeeGrad = employeeGrad;
    }

    public Company getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(Company employeeCompany) {
        this.employeeCompany = employeeCompany;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeGrad='" + employeeGrad + '\'' +
                '}';
    }
}
