package ru.liga.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//класс объект сообщения принимаемого из кухонного сервиса
public class CustomMessage {
    private long orderId;
    private String message;

}
