package pl.mikolaj.ecomproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mikolaj.ecomproj.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
