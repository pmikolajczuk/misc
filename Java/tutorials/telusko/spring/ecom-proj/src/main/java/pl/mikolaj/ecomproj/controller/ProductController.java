package pl.mikolaj.ecomproj.controller;

import org.springframework.web.bind.annotation.*;
import pl.mikolaj.ecomproj.model.Product;
import pl.mikolaj.ecomproj.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
