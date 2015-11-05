package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Report;

import java.util.Date;

/**
 * Created by student on 2015/11/05.
 */
public class ReportFactory {
    public static Report createReport(String referenceCode, String description, Date incidentDate, String studentNumber){
        Report report = new Report
                .Builder(referenceCode)
                .description(description)
                .incidentDate(incidentDate)
                .studentNumber(studentNumber)
                .build();
        return report;
    }
}
