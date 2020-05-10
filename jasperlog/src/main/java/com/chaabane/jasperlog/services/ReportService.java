package com.chaabane.jasperlog.services;

import com.chaabane.jasperlog.Company;
import com.chaabane.jasperlog.JasperlogApplication;
import com.chaabane.jasperlog.services.CompanyRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private CompanyRepo companyRepo;

    public byte[] exportReport(Long companyId) throws FileNotFoundException, JRException {
        Logger logger = LoggerFactory.getLogger(JasperlogApplication.class);

        final Company company = companyRepo.getOne(companyId);
        // load file and compile it
        File file = ResourceUtils.getFile("classpath:company.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(company.getCompanyEmployees());
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("owner", "Fahmi");
        params.put("name", company.getCompanyName());
        params.put("address", company.getCompanyAddress());
        params.put("description", company.getCompanyDescription());
        params.put("total", company.getCompanyEmployees().size());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        logger.trace("Report Generated Successfully !");
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
