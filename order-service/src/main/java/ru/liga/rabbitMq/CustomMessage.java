package ru.liga.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomMessage {
    private UUID orderId;
    private String message;

}
