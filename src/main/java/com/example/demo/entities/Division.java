package com.example.demo.entities;

import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customers;

    public void set(Country country) {
        this.country = country;
        this.country_id = country.getId();
    }
}
