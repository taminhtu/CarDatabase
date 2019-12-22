/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.packt.cardatabase.domain.Car;

/**
 *
 * @author tutm
 */

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;
    
    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
