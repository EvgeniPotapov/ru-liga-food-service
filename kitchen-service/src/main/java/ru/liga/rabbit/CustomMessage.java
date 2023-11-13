package ru.liga.rabbit;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

    private UUID orderId;;

    private String message;

}
