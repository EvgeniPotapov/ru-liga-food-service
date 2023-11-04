package ru.liga.deliveryController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.liga.dto.CouriersDto;
import ru.liga.mappers.CourierMappers;
import ru.liga.repository.CouriersRepository;
import ru.liga.services.CouriersServices;

import javax.persistence.EntityNotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CouriersControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CouriersRepository couriersRepository;
    @Autowired
    private CouriersServices couriersServices;
    @Autowired
    private CourierMappers courierMappers;

    //Проверка работы CouriersController
    @Test
    public void deliveryControllerTest() throws Exception{

        CouriersDto couriersDto=new CouriersDto(4,"89400761111","on","4334.1212");

        couriersRepository.save(courierMappers.dtoToEntity(couriersDto));


        mockMvc.perform(
                get("/couriers/{id}",couriersDto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("4"))
                .andExpect(jsonPath("$.phone").value("89400761111"))
                .andExpect(jsonPath("$.status").value("on"))
                .andExpect(jsonPath("$.coordinates").value("4334.1212"));

        couriersRepository.deleteById(couriersDto.getId());

    }
    //Проверка на неправильную работу
    @Test
    public void deliveryControllerTestNotExistingCouriers() throws Exception{

        CouriersDto couriersDto=new CouriersDto(4,"89400761111","on","4334.1212");

        couriersRepository.save(courierMappers.dtoToEntity(couriersDto));


        mockMvc.perform(
                        get("/couriers/{id}",couriersDto.getId()+1))
                .andExpect(status().isNotFound())
                .andExpect(mvcResult -> mvcResult.getResolvedException().getClass().equals(EntityNotFoundException.class));

        couriersRepository.deleteById(couriersDto.getId());

    }

}
