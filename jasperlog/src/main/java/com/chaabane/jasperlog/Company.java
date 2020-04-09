package com.chaabane.jasperlog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Company {

    @Id
    long companyId;
    String companyName;
    String companyAddress;
    String companyDescription;
    @OneToMany(mappedBy = "employeeCompany")
    Set<Employee> companyEmployees;

    public Company() {
    }

    public Company(long companyId, String companyName, String companyAddress, String companyDescription) {
        this.companyId = companyId;
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
