package pl.mikolaj.ecomproj.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import pl.mikolaj.ecomproj.model.Product;
import pl.mikolaj.ecomproj.service.ProductService;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
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

    @BeforeEach
    void setupRequestContext() {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/api/product");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @AfterEach
    void clearRequestContext() {
        RequestContextHolder.resetRequestAttributes();
    }

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
        product.setStockQuantity(10);
        return product;
    }

    private MultipartFile createImage() {
        return new MockMultipartFile(
                "image",
                "product.jpg",
                "image/jpeg",
                "image-bytes".getBytes(StandardCharsets.UTF_8)
        );
    }

    @Test
    void returnsAllProductsWhenProductsExist() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(createTestProduct(1, "Product 1", new BigDecimal("99.99")));
        products.add(createTestProduct(2, "Product 2", new BigDecimal("49.99")));

        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.getAllProducts();
        List<Product> result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void returnsEmptyListWhenNoProductsExist() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Product>> response = productController.getAllProducts();
        List<Product> result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void returnsProductWhenProductExists() throws Exception {
        Product product = createTestProduct(1, "Laptop", new BigDecimal("999.99"));

        when(productService.getProductById(1)).thenReturn(product);

        ResponseEntity<Product> response = productController.getProductById(1);
        Product result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Laptop", result.getName());
        assertEquals(new BigDecimal("999.99"), result.getPrice());
        verify(productService, times(1)).getProductById(1);
    }

    @Test
    void returnsNotFoundWhenProductDoesNotExist() throws Exception {
        when(productService.getProductById(999)).thenReturn(null);

        ResponseEntity<Product> response = productController.getProductById(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).getProductById(999);
    }

    @Test
    void createsProductSuccessfully() throws Exception {
        Product product = createTestProduct(0, "Mouse", new BigDecimal("29.99"));
        MultipartFile image = createImage();

        when(productService.addProduct(product, image)).thenReturn(product);

        ResponseEntity<?> response = productController.addProduct(product, image);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(productService, times(1)).addProduct(product, image);
    }

    @Test
    void createsProductWithAllFields() throws Exception {
        Product product = createTestProduct(0, "Keyboard", new BigDecimal("79.99"));
        product.setStockQuantity(50);
        product.setAvailable(true);
        product.setCategory("Electronics");
        MultipartFile image = createImage();

        when(productService.addProduct(product, image)).thenReturn(product);

        ResponseEntity<?> response = productController.addProduct(product, image);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(productService, times(1)).addProduct(product, image);
    }

    @Test
    void createsProductWithMinimalFields() throws Exception {
        Product product = new Product();
        product.setName("Monitor");
        product.setPrice(new BigDecimal("199.99"));
        MultipartFile image = createImage();

        when(productService.addProduct(product, image)).thenReturn(product);

        ResponseEntity<?> response = productController.addProduct(product, image);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(productService, times(1)).addProduct(product, image);
    }

    @Test
    void updatesProductSuccessfully() throws Exception {
        Product product = createTestProduct(1, "Updated Mouse", new BigDecimal("34.99"));

        ResponseEntity<String> response = productController.updateProduct(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product updated successfully", response.getBody());
        verify(productService, times(1)).updateProduct(product);
    }

    @Test
    void updatesProductAvailabilityStatus() throws Exception {
        Product product = createTestProduct(3, "Product", new BigDecimal("99.99"));
        product.setAvailable(false);

        ResponseEntity<String> response = productController.updateProduct(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(productService, times(1)).updateProduct(product);
    }

    @Test
    void deletesProductSuccessfully() throws Exception {
        ResponseEntity<String> response = productController.deleteProduct(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product deleted successfully", response.getBody());
        verify(productService, times(1)).deleteProduct(1);
    }

    @Test
    void deletesProductWithDifferentId() throws Exception {
        ResponseEntity<String> response = productController.deleteProduct(100);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product deleted successfully", response.getBody());
        verify(productService, times(1)).deleteProduct(100);
    }

    @Test
    void callsServiceMethodForEachRequest() throws Exception {
        Product product = createTestProduct(1, "Test", new BigDecimal("10.00"));
        when(productService.getProductById(1)).thenReturn(product);

        productController.getProductById(1);
        productController.getProductById(1);

        verify(productService, times(2)).getProductById(1);
    }

    @Test
    void handlesMultipleProductsCorrectly() throws Exception {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            products.add(createTestProduct(i, "Product " + i, new BigDecimal(i * 10)));
        }

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts().getBody();

        assertNotNull(result);
        assertEquals(5, result.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getId());
        }
    }

    @Test
    void getsProductWithZeroId() throws Exception {
        when(productService.getProductById(0)).thenReturn(null);

        ResponseEntity<Product> response = productController.getProductById(0);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(productService, times(1)).getProductById(0);
    }

    @Test
    void createsProductWithZeroPrice() throws Exception {
        Product product = createTestProduct(0, "Free Item", new BigDecimal("0.00"));
        MultipartFile image = createImage();

        when(productService.addProduct(product, image)).thenReturn(product);

        ResponseEntity<?> response = productController.addProduct(product, image);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(productService, times(1)).addProduct(product, image);
    }

    @Test
    void deletesProductWithNegativeIdPassedToService() throws Exception {
        ResponseEntity<String> response = productController.deleteProduct(-1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(-1);
    }
}


