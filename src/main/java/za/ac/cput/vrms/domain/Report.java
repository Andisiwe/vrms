package za.ac.cput.vrms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/11/04.
 */
public class Report implements Serializable{
    private Long id;
    private String referenceCode;
    private String description;
    private Date incidentDate;
    private String studentNumber;
    private Report(){
    }
    public Report(Builder builder){
        this.id = builder.id;
        this.referenceCode = builder.referenceCode;
        this.description = builder.description;
        this.incidentDate = builder.incidentDate;
        this.studentNumber = builder.studentNumber;
    }
    public static class Builder {
        private Long id;
        private String referenceCode;
        private String description;
        private Date incidentDate;
        private String studentNumber;
        public Builder(String referenceCode) {
            this.referenceCode = referenceCode;
        }
        public Builder description(String value) {
            this.description = value;
            return this;
        }
        public Builder incidentDate(Date value) {
            this.incidentDate = value;
            return this;
        }
        public Builder studentNumber(String value) {
            this.studentNumber = value;
            return this;
        }
        public Builder id(Long value) {
            this.id = value;
            return this;
        }
        public Builder copy(Report value) {
            this.id = value.id;
            this.referenceCode = value.referenceCode;
            this.description = value.description;
            this.incidentDate = value.incidentDate;
            this.studentNumber = value.studentNumber;
            return this;
        }
        public Report build() {
            return new Report(this);
        }
    }
    public Long getId(){
        return id;
    }
    public String getReferenceCode(){
        return referenceCode;
    }
    public String getDescription(){
        return description;
    }
    public Date getIncidentDate(){
        return incidentDate;
    }
    public String getStudentNumber(){
        return studentNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id.equals(report.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "Report{" +
                "referenceCode='" + referenceCode + '\'' +
                ", description ='" + description + '\'' +
                ", incidentDate ='" + incidentDate + '\'' +
                ", studentNumber ='" + studentNumber + '\'' +
                '}';
    }
}
