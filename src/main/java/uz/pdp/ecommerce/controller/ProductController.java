package uz.pdp.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.dto.ProductDto;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.service.ProductService;

@RequestMapping("/api/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(201).body(productService.addProduct(productDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Product product = productService.updateProduct(id, productDto);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable Integer categoryId) {
        if (categoryId == null) {
            return ResponseEntity.status(200).body(productService.getAllProducts());
        } else {
            return ResponseEntity.status(200).body(productService.getProductByCategoryId(categoryId));
        }
    }

}
