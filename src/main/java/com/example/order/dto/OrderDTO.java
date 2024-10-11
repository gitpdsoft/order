package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private List<FoodItemDTO> items;
    private RestaurantDto restaurantDto;
    private UserDTO userDTO;
}
