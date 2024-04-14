package net.rhofir.orderservices.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
@Table(name = "ORDERS")
public class Order {

        @Id
        private String id;
        private LocalDate date;
        @Enumerated(EnumType.STRING)
        private OrderStatus state;
        @OneToMany(mappedBy = "order")
        private List<ProductItem> productItems;

}
