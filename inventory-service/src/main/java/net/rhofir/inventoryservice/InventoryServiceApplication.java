package net.rhofir.inventoryservice;

import net.rhofir.inventoryservice.entities.Product;
import net.rhofir.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer").price(3000).quantity(20).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Printer").price(2500).quantity(20).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("SmartPhone").price(3300).quantity(20).build());
        };
    }

}
