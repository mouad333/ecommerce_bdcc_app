package net.rhofir.orderservices;

import net.rhofir.orderservices.entities.Order;
import net.rhofir.orderservices.entities.OrderStatus;
import net.rhofir.orderservices.entities.ProductItem;
import net.rhofir.orderservices.repositories.OrderRepository;
import net.rhofir.orderservices.repositories.ProductItemRepository;
import net.rhofir.orderservices.restClient.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class OrderServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository,
                                        ProductItemRepository productItemRepository,
                                        InventoryRestClient inventoryRestClient){
        return args -> {
            //List<Product> allProducts = inventoryRestClient.getAllProducts();
            List<String> productsIds=List.of("P01","P02","P03");
            for(int i=0;i<5;i++){
                Order order=Order.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDate.now())
                        .state(OrderStatus.PENDING)
                        .build();
                Order savedOrder = orderRepository.save(order);

                productsIds.forEach(pId->{
                    ProductItem productItem=ProductItem.builder()
                            .productId(pId)
                            .quantity(new Random().nextInt(20))
                            .price(Math.random()*6000+1000)
                            .order(savedOrder)
                            .build();
                    productItemRepository.save(productItem);
                });
            }



        };
    }
}
