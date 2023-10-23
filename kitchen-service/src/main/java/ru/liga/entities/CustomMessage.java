package ru.liga.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

    private String massageId;
    private  String message;
    private Date messageDate;
}
