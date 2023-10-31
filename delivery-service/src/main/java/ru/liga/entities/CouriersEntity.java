package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "couriers")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CouriersEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courier_seq-gen")
    @SequenceGenerator(name = "courier_seq-gen",sequenceName = "couriers_seq", allocationSize = 1)
    private long id;

    private String phone;

    private String status;

    private String coordinates;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "couriers")
    private Set<OrdersEntity> orders;
}
