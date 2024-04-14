package net.rhofir.orderservices.repositories;

import net.rhofir.orderservices.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
