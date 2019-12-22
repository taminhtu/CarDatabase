/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.cardatabase.domain;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author tutm
 */

@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository <Car, Long> {
    // Fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);
    
    // Fetch cars by color
    List<Car> findByColor(@Param("color") String color);
    
    // Fetch by year
    List<Car> findByYear(int year);
    
    // Fetch cars by brand and model
    List<Car> findByBrandOrModel(@Param("brand") String brand, @Param("model") String model);
    
    // Fetch cars by brand and color
    List<Car> findByBrandOrColor(@Param("brand") String brand, @Param("color") String color);
    
    //Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);
    
}
