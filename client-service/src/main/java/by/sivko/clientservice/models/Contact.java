package by.sivko.clientservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_home", nullable = false)
    private String phone_home;

    @Column(name = "phone_mobile", nullable = false)
    private String phone_mobile;

    @Column(name = "email", nullable = false)
    private String email;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId
    private Client client;

    public Contact() {
    }

    public Contact(Client client, String address, String phone_home, String phone_mobile, String email) {
        this.address = address;
        this.phone_home = phone_home;
        this.phone_mobile = phone_mobile;
        this.email = email;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(String phone_home) {
        this.phone_home = phone_home;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        if (phone_home != null ? !phone_home.equals(contact.phone_home) : contact.phone_home != null) return false;
        if (phone_mobile != null ? !phone_mobile.equals(contact.phone_mobile) : contact.phone_mobile != null)
            return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        return client != null ? client.equals(contact.client) : contact.client == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone_home != null ? phone_home.hashCode() : 0);
        result = 31 * result + (phone_mobile != null ? phone_mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone_home='" + phone_home + '\'' +
                ", phone_mobile='" + phone_mobile + '\'' +
                ", email='" + email+
                '}';
    }
}
