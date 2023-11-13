package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String address;

    private String status;

    @Column(name = "name_restaurant")
    private String nameRestaurant;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restauran_id")
    private List<RestauranMenuItemsEntity> listMenuItems;
}
