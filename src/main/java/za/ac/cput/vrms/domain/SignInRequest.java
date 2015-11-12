package za.ac.cput.vrms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
//@Entity
public class SignInRequest implements Serializable {
/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private Long ID;
    private Date visitDate;
    private String reasonForVisit;
    private Visitor visitor;
    private Security security;
    private String visit_code;

    private SignInRequest(){}
    public SignInRequest(Builder builder){

        ID = builder.ID;
        visitDate = builder.visitDate;
        visitor = builder.visitor;
        security = builder.security;
        visit_code = builder.visit_code;
        reasonForVisit = builder.reasonForVisit;


    }

    public Long getID() {
        return ID;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Security getSecurity() {
        return security;
    }

    public String getVisit_code() {
        return visit_code;
    }

    public static class Builder{

        private Long ID;
        private Date visitDate;
        private String reasonForVisit;
        private Visitor visitor;
        private Security security;
        private String visit_code;

        public Builder(Visitor visitor, Security security){
            this.security = security;
            this.visitor = visitor;
        }

        public Builder ID(Long value){
            this.ID = value;
            return this;
        }

        public Builder visitDate(Date value){
            this.visitDate = value;
            return this;
        }
        public Builder reasonForVisit(String value){
            this.reasonForVisit = value;
            return this;
        }
        public Builder visitor(Visitor value){
            this.visitor = value;
            return this;
        }

        public Builder visit_code(String  value){
            this.visit_code = value;
            return this;
        }

        public Builder security(Security value){
            this.security = value;
            return this;
        }
        public Builder copy(SignInRequest signInRequest){
            this.visitor = signInRequest.visitor;
            this.visitDate = signInRequest.visitDate;
            this.reasonForVisit = signInRequest.reasonForVisit;
            this.visit_code = signInRequest.visit_code;
            this.security = signInRequest.security;
            return this;
        }

        public SignInRequest build() {
            return new SignInRequest(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignInRequest signInRequest = (SignInRequest) o;

        return !(ID != null ? !ID.equals(signInRequest.ID) : signInRequest.ID != null);

    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
                "ID=" + ID +
                ", VisitDate='" + visitDate + '\'' +
                '}';
    }
}
