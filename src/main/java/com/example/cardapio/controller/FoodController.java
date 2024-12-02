package com.example.cardapio.controller;


import com.example.cardapio.controller.dto.FoodRequestDTO;
import com.example.cardapio.controller.dto.FoodResponseDTO;
import com.example.cardapio.model.Food;
import com.example.cardapio.model.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAllFoods(){
        List<FoodResponseDTO>foodList = repository.findAll().stream().map(FoodResponseDTO :: new).collect(Collectors.toList());

        return ResponseEntity.ok(foodList);
    }


}
