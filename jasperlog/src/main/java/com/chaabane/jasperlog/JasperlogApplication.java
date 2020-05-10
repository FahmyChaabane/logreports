package com.chaabane.jasperlog;

import com.chaabane.jasperlog.services.CompanyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JasperlogApplication implements CommandLineRunner {

	@Autowired
	private CompanyRepo companyRepo;

	public static void main(String[] args) {
		SpringApplication.run(JasperlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company c1 = new Company("VERMEG", "LAC", "Finance & Informatics");
		Company c2 = new Company("K2Lis", "TechnoPark Ghazela", "Blockchain");
		Company c3 = new Company("CNI", "Beb Saadoun", "Informatics");
		Employee e1 = new Employee("Fahmi", "Hay Tahrir", 800, "Junior Dev");
		Employee e2 = new Employee("Helmi", "Hay Tahrir", 800, "Junior Dev");
		Employee e3 = new Employee("Saber", "Hay Hadika", 800, "Senior Dev");
		Employee e4 = new Employee("Ramy", "Hay Hadika", 800, "Operation");
		Employee e5 = new Employee("Mohsen", "Bardo", 800, "Project Leader");
		Employee e6 = new Employee("Ahmed", "Bardo", 800, "Technicien");
		Employee e7 = new Employee("Ahmed", "Hay Hadika", 800, "Employee");
		Employee e8 = new Employee("Mohammed", "Hay Rafeha", 800, "Junior Dev");
		Employee e9 = new Employee("Houssem", "Hay Nasr", 800, "Senior Dev");

		c1.getCompanyEmployees().add(e1);
		c1.getCompanyEmployees().add(e3);
		c1.getCompanyEmployees().add(e5);

		e1.setEmployeeCompany(c1);
		e3.setEmployeeCompany(c1);
		e5.setEmployeeCompany(c1);

		c2.getCompanyEmployees().add(e2);
		c2.getCompanyEmployees().add(e4);
		c2.getCompanyEmployees().add(e6);

		e2.setEmployeeCompany(c2);
		e4.setEmployeeCompany(c2);
		e6.setEmployeeCompany(c2);

		c3.getCompanyEmployees().add(e7);
		c3.getCompanyEmployees().add(e8);
		c3.getCompanyEmployees().add(e9);

		e7.setEmployeeCompany(c3);
		e8.setEmployeeCompany(c3);
		e9.setEmployeeCompany(c3);

		companyRepo.save(c1);
		companyRepo.save(c2);
		companyRepo.save(c3);

		Logger logger = LoggerFactory.getLogger(JasperlogApplication.class);
		logger.info("Application Started Successfully !");


	}
}
