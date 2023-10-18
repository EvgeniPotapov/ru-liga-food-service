package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RestaurantEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String address;

    private String status;
}
