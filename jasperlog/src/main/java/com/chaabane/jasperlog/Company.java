package com.chaabane.jasperlog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long companyId;
    String companyName;
    String companyAddress;
    String companyDescription;
    @OneToMany(mappedBy = "employeeCompany", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    Set<Employee> companyEmployees = new HashSet<Employee>();

    public Company() {
    }

    public Company(String companyName, String companyAddress, String companyDescription) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyDescription = companyDescription;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Set<Employee> getCompanyEmployees() {
        return companyEmployees;
    }

    public void setCompanyEmployees(Set<Employee> companyEmployees) {
        this.companyEmployees = companyEmployees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                '}';
    }
}
