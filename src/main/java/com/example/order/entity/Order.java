package com.example.order.entity;

import com.example.order.dto.FoodItemDTO;
import com.example.order.dto.RestaurantDto;
import com.example.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer id;
    private List<FoodItemDTO> items;
    private RestaurantDto restaurantDto;
    private UserDTO userDTO;
}
