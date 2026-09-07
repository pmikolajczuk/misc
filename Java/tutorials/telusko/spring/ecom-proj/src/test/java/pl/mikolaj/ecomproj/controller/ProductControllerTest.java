package pl.mikolaj.ecomproj.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.mikolaj.ecomproj.model.Product;
import pl.mikolaj.ecomproj.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product createTestProduct(int id, String name, BigDecimal price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDesc("Test description");
        product.setBrand("Test brand");
        product.setPrice(price);
        product.setCategory("Test category");
        product.setReleaseDate(new Date());
        product.setAvailable(true);
        product.setQuantity(10);
        return product;
    }

    @Test
    void returnsAllProductsWhenProductsExist() {
        List<Product> products = new ArrayList<>();
        products.add(createTestProduct(1, "Product 1", new BigDecimal("99.99")));
        products.add(createTestProduct(2, "Product 2", new BigDecimal("49.99")));

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void returnsEmptyListWhenNoProductsExist() {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        List<Product> result = productController.getAllProducts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void returnsProductWhenProductExists() {
        Product product = createTestProduct(1, "Laptop", new BigDecimal("999.99"));

        when(productService.getProductById(1)).thenReturn(product);

        Product result = productController.getProductById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Laptop", result.getName());
        assertEquals(new BigDecimal("999.99"), result.getPrice());
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void returnsNullWhenProductDoesNotExist() {
        when(productService.getProductById(999)).thenReturn(null);

        Product result = productController.getProductById(999);

        assertNull(result);
        verify(productService, times(1)).getProductById(999);
    }

    @Test
    void createsProductSuccessfully() {
        Product product = createTestProduct(0, "Mouse", new BigDecimal("29.99"));

        productController.createProduct(product);

        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void createsProductWithAllFields() {
        Product product = createTestProduct(0, "Keyboard", new BigDecimal("79.99"));
        product.setQuantity(50);
        product.setAvailable(true);
        product.setCategory("Electronics");

        productController.createProduct(product);

        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void createsProductWithMinimalFields() {
        Product product = new Product();
        product.setName("Monitor");
        product.setPrice(new BigDecimal("199.99"));

        productController.createProduct(product);

        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void updatesProductSuccessfully() {
        Product product = createTestProduct(1, "Updated Mouse", new BigDecimal("34.99"));

        productController.updateProduct(product);

        verify(productService, times(1)).updateProduct(product);
    }

    @Test
    void updatesProductWithDifferentPrice() {
        Product product = createTestProduct(5, "Product", new BigDecimal("150.00"));

        productController.updateProduct(product);

        verify(productService, times(1)).updateProduct(product);
    }

    @Test
    void updatesProductAvailabilityStatus() {
        Product product = createTestProduct(3, "Product", new BigDecimal("99.99"));
        product.setAvailable(false);

        productController.updateProduct(product);

        verify(productService, times(1)).updateProduct(product);
    }

    @Test
    void deletesProductSuccessfully() {
        productController.deleteProduct(1);

        verify(productService, times(1)).deleteProduct(1);
    }

    @Test
    void deletesProductWithDifferentId() {
        productController.deleteProduct(100);

        verify(productService, times(1)).deleteProduct(100);
    }

    @Test
    void callsServiceMethodForEachRequest() {
        Product product = createTestProduct(1, "Test", new BigDecimal("10.00"));
        when(productService.getProductById(1)).thenReturn(product);

        productController.getProductById(1);
        productController.getProductById(1);

        verify(productService, times(2)).getProductById(1);
    }

    @Test
    void handlesMultipleProductsCorrectly() {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            products.add(createTestProduct(i, "Product " + i, new BigDecimal(i * 10)));
        }

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();

        assertEquals(5, result.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getId());
        }
    }

    @Test
    void getsProductWithZeroId() {
        when(productService.getProductById(0)).thenReturn(null);

        Product result = productController.getProductById(0);

        assertNull(result);
        verify(productService, times(1)).getProductById(0);
    }

    @Test
    void createsProductWithZeroPrice() {
        Product product = createTestProduct(0, "Free Item", new BigDecimal("0.00"));

        productController.createProduct(product);

        verify(productService, times(1)).createProduct(product);
    }

    @Test
    void deletesProductWithNegativeIdPassedToService() {
        productController.deleteProduct(-1);

        verify(productService, times(1)).deleteProduct(-1);
    }
}


