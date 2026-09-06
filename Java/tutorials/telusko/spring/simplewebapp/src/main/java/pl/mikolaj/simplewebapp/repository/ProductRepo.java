package pl.mikolaj.simplewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mikolaj.simplewebapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
