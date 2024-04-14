package net.rhofir.orderservices.repositories;

import net.rhofir.orderservices.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {

}
