package pl.mikolaj.simplewebapp.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.mikolaj.simplewebapp.model.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ProductService {
    List<Product> products = new ArrayList<>(List.of(
            new Product(101, "iPhone", 100),
            new Product(201, "Samsung", 200),
            new Product(301, "Google Pixel", 300)
    ));

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        products.removeIf(p -> p.getId() == product.getId());
        products.add(product);
    }

    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
