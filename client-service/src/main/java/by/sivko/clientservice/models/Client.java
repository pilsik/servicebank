package by.sivko.clientservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_gen")
    @SequenceGenerator(name = "clients_gen", sequenceName = "clients_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "sex", nullable = false)
    private Boolean sex;

    @Column(name = "pensioner", nullable = false)
    private Boolean pensioner;

    @Column(name = "monthly_income", nullable = false)
    private BigDecimal monthly_income;

    @Column(name = "bpl", nullable = false)
    private String bpl;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private Contact contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_of_residence_id", nullable = false)
    private City cityOfResidence;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_of_registration_id", nullable = false)
    private City cityOfRegistration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marital_status_id", nullable = false)
    private MaritalStatus maritalStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "citizenship_id", nullable = false)
    private Citizenship citizenship;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disability_id", nullable = false)
    private Disability disability;

    public Client() {
    }

    public Client(String surname, String name, String patronymic, Date dob, Boolean sex, Boolean pensioner, BigDecimal monthly_income, String bpl, Passport passport, Contact contact, City cityOfResidence, City cityOfRegistration, MaritalStatus maritalStatus, Citizenship citizenship, Disability disability) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = dob;
        this.sex = sex;
        this.pensioner = pensioner;
        this.monthly_income = monthly_income;
        this.bpl = bpl;
        this.passport = passport;
        this.contact = contact;
        this.cityOfResidence = cityOfResidence;
        this.cityOfRegistration = cityOfRegistration;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
        this.disability = disability;
    }

    public void setPensioner(Boolean pensioner) {
        this.pensioner = pensioner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getPensioner() {
        return pensioner;
    }

    public void setPepensioner(Boolean pensioner) {
        this.pensioner = pensioner;
    }

    public BigDecimal getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(BigDecimal monthly_income) {
        this.monthly_income = monthly_income;
    }

    public String getBpl() {
        return bpl;
    }

    public void setBpl(String bpl) {
        this.bpl = bpl;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public City getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(City cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public City getCityOfRegistration() {
        return cityOfRegistration;
    }

    public void setCityOfRegistration(City cityOfRegistration) {
        this.cityOfRegistration = cityOfRegistration;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!surname.equals(client.surname)) return false;
        if (!name.equals(client.name)) return false;
        if (!patronymic.equals(client.patronymic)) return false;
        if (!dob.equals(client.dob)) return false;
        if (!sex.equals(client.sex)) return false;
        if (passport != null ? !passport.equals(client.passport) : client.passport != null) return false;
        return contact != null ? contact.equals(client.contact) : client.contact == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + dob.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                ", pepensioner=" + pensioner +
                ", monthly_income=" + monthly_income +
                ", bpl='" + bpl + '\'' +
                ", passport=" + this.getPassport() +
                ", contact=" + this.getContact() +
                ", cityOfResidence=" + cityOfResidence +
                ", cityOfRegistration=" + cityOfRegistration +
                ", maritalStatus=" + maritalStatus +
                ", citizenship=" + citizenship +
                ", disability=" + disability +
                '}';
    }
}
