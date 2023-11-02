package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о курьере")
public class CouriersDto {

    @Schema(description = "идентификатор курьера")
    private long id;

    @Schema(description = "номер телефона")
    private String phone;

    @Schema(description = "Статут курьера")
    private String status;

    @Schema(description = "кординаты местоположения курьера")
    private String coordinates;
}
