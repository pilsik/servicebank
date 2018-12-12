package by.sivko.servicebank.clientservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "passports")
public class Passport implements Serializable {

    @Id
    private Long id;

    @Column(name = "passport_series", nullable = false)
    private String passport_series;

    @Column(name = "passport_number", nullable = false)
    private String passport_number;

    @Column(name = "passport_authority", nullable = false)
    private String passport_authority;

    @Column(name = "passport_date_of_issue", nullable = false)
    private Date passport_date_of_issue;

    @Column(name = "passport_identification_number", nullable = false)
    private String passport_identification_number;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId
    private Client client;

    public Passport() {
    }

    public Passport(Client client, String passport_series, String passport_number, String passport_authority, Date passport_date_of_issue, String passport_identification_number) {
        this.passport_series = passport_series;
        this.passport_number = passport_number;
        this.passport_authority = passport_authority;
        this.passport_date_of_issue = passport_date_of_issue;
        this.passport_identification_number = passport_identification_number;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getPassport_authority() {
        return passport_authority;
    }

    public void setPassport_authority(String passport_authority) {
        this.passport_authority = passport_authority;
    }

    public Date getPassport_date_of_issue() {
        return passport_date_of_issue;
    }

    public void setPassport_date_of_issue(Date passport_date_of_issue) {
        this.passport_date_of_issue = passport_date_of_issue;
    }

    public String getPassport_identification_number() {
        return passport_identification_number;
    }

    public void setPassport_identification_number(String passport_identification_number) {
        this.passport_identification_number = passport_identification_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (!id.equals(passport.id)) return false;
        if (!passport_series.equals(passport.passport_series)) return false;
        if (!passport_number.equals(passport.passport_number)) return false;
        if (!passport_authority.equals(passport.passport_authority)) return false;
        if (!passport_date_of_issue.equals(passport.passport_date_of_issue)) return false;
        return passport_identification_number.equals(passport.passport_identification_number);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + passport_series.hashCode();
        result = 31 * result + passport_number.hashCode();
        result = 31 * result + passport_authority.hashCode();
        result = 31 * result + passport_date_of_issue.hashCode();
        result = 31 * result + passport_identification_number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passport_series='" + passport_series + '\'' +
                ", passport_number='" + passport_number + '\'' +
                ", passport_authority='" + passport_authority + '\'' +
                ", passport_date_of_issue=" + passport_date_of_issue +
                ", passport_identification_number='" + passport_identification_number + '\'' +
                '}';
    }
}
