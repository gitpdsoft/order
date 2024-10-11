package com.example.order.controller;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderDTOFromFe;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTOFromFe order) {
        return new ResponseEntity<>(service.save(order), HttpStatus.CREATED);
    }
}
