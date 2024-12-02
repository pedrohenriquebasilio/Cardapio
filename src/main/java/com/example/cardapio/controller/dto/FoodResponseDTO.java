package com.example.cardapio.controller.dto;

import com.example.cardapio.model.Food;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {


    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getImage(), food.getTitle(), food.getPrice());
    }
}
