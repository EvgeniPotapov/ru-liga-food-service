package ru.liga.mappers;


import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.liga.entities.CustomersEntity;
import ru.liga.orderDto.CustomerDto;

@NoArgsConstructor
@Service
public class CustomerMappers {


        public CustomersEntity dtoToEntity(CustomerDto customerDto) {
            if ( customerDto == null ) {
                return null;
            }

            CustomersEntity customersEntity = new CustomersEntity();

            customersEntity.setId(customerDto.getId());
            customersEntity.setPhone(customerDto.getPhone());
            customersEntity.setEmail(customerDto.getEmail());
            customersEntity.setAddress(customerDto.getAddress());

            return customersEntity;
        }
        public CustomerDto entityTODto(CustomersEntity customersEntity) {
            if ( customersEntity == null ) {
                return null;
            }

            CustomerDto customerDto = new CustomerDto();

            customerDto.setId(customersEntity.getId());
            customerDto.setPhone(customersEntity.getPhone());
            customerDto.setEmail(customersEntity.getEmail());
            customerDto.setAddress(customersEntity.getAddress());

            return customerDto;
        }

}
