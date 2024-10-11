package com.example.order.service;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderDTOFromFe;
import com.example.order.dto.UserDTO;
import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRespository repository;
    @Autowired
    private SequenceGenerator sequenceGenerator;
    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO save(OrderDTOFromFe order) {
        Order toBeSaved = new Order();
        toBeSaved.setId(sequenceGenerator.generateNextOrderId());
        toBeSaved.setItems(order.getFoodItemsList());
        toBeSaved.setUserDTO(fetchUserDetailsFromUserId(order.getUserId()));
        toBeSaved.setRestaurantDto(order.getRestaurant());
        repository.save(toBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(toBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USERS/user/" + userId, UserDTO.class);
    }
}
