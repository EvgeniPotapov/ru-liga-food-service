package ru.liga.rabbit;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

    private long restauranId;

    private String message;

}
