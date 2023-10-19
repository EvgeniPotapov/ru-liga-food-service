package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RestaurantEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "restor_seq-gen")
    @SequenceGenerator(name = "restor_seq-gen",sequenceName = "restor_seq", allocationSize = 1)
    @Id
    private long id;

    private String address;

    private String status;

//    @OneToMany(mappedBy = "restauran")
//    List<RestauranMenuItemsEntity> menu;
}
