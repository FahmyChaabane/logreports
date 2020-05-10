package com.chaabane.jasperlog.controllers;

import com.chaabane.jasperlog.Company;
import com.chaabane.jasperlog.JasperlogApplication;
import com.chaabane.jasperlog.services.CompanyRepo;
import com.chaabane.jasperlog.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppRestPoint {

    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    ReportService reportService;

    Logger logger = LoggerFactory.getLogger(JasperlogApplication.class);

    @GetMapping("/companies")
    public List<Company> loadCompanies(){
        logger.trace("/companies enpoint is triggered !");
        return companyRepo.findAll();
    }

    @GetMapping("/report/{companyId}")
    public ResponseEntity<byte[]> loadCompanies(@PathVariable Long companyId) {
        logger.trace("/report/{companyId} enpoint is triggered !");
        try {
            byte[] contents = reportService.exportReport(companyId);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            // Here you have to set the actual filename of your pdf
            String filename = "output.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
