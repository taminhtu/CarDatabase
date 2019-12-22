package com.packt.cardatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.UserRepository;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class CardatabaseApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CardatabaseApplication.class);
    }

    @Autowired
    private CarRepository repository;
    
    @Autowired
    private OwnerRepository orepository;
    
    @Autowired
    private UserRepository urepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner() {
        return args -> {
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            // add owner object and save these to db
            orepository.save(owner1);
            orepository.save(owner2);
            
            // save demo data to database
            repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000));
            repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 59000));
            repository.save(new Car("Toyota", "Primus", "Silver", "KKO-0212", 2018, 39000));
            
            // user name: user password: user
            urepository.save(new User("user", "$2a$10$amXbMsTLS7f1eW.UGlQmX.i6il06salJ5zaEB6q/WQwg7mOPzT8My", "USER")); // mailan
            urepository.save(new User("admin", "$2a$10$amXbMsTLS7f1eW.UGlQmX.i6il06salJ5zaEB6q/WQwg7mOPzT8My", "ADMIN")); // mailan
            
        };
    }

}
