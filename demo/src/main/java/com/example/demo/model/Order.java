package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends RepresentationModel<Order> {
    private String orderId;
    private double price;
    private int quantity;

    // standard getters and setters
}