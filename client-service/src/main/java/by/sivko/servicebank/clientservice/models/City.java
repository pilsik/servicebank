package by.sivko.servicebank.clientservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_gen")
    @SequenceGenerator(name = "cities_gen", sequenceName = "cities_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cityOfRegistration")
    private Set<Client> clientsByRegistration;

    @JsonIgnore
    @OneToMany(mappedBy = "cityOfResidence")
    private Set<Client> clientsByResidence;

    @JsonIgnore
    public Set<Client> getClientsByRegistration() {
        return clientsByRegistration;
    }

    @JsonIgnore
    public void setClientsByRegistration(Set<Client> clientsByRegistration) {
        this.clientsByRegistration = clientsByRegistration;
    }

    public Set<Client> getClientsByResidence() {
        return clientsByResidence;
    }

    public void setClientsByResidence(Set<Client> clientsByResidence) {
        this.clientsByResidence = clientsByResidence;
    }

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!id.equals(city.id)) return false;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}