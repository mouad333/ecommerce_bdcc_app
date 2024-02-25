package net.rhofir.inventoryservice.repositories;

import jakarta.persistence.Id;
import net.rhofir.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

}
