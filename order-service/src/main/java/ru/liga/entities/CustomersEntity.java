package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cust_seq-gen")
    @SequenceGenerator(name = "cust_seq-gen",sequenceName = "custom_seq", allocationSize = 1)
    private long id;

    private String phone;

    private String email;

    private String address;
}
