package ru.liga.rabbit;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//Сообщение передаваемое в модуль доставки
public class CustomMessage {

    private long orderId;

    private String message;

}
