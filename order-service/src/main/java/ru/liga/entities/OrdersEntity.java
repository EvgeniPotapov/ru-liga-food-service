package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ord_seq-gen")
    @SequenceGenerator(name = "ord_seq-gen",sequenceName = "order_seq", allocationSize = 1)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "restauran_id")
    private long restauranId;

    private String status;

    @Column(name = "courier_id")
    private long courierId;

    private String timeStamp;
}
