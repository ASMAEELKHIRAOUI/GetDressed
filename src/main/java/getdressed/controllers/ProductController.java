package getdressed.controllers;

import getdressed.domain.Product;
import getdressed.domain.Product;
import getdressed.dto.requests.ProductRequestDTO;
import getdressed.dto.responses.ProductResponseDTO;
import getdressed.dto.responses.ProductResponseDTO;
import getdressed.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_sbahlkhir')")
    public ResponseEntity<List<ProductResponseDTO>> getAll(){
        List<Product> products = productService.getAll();
        if (products.isEmpty()) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(products.stream().map(ProductResponseDTO::fromProduct).toList(), HttpStatus.OK);
    }

    @GetMapping("/f")
    @PreAuthorize("hasRole('ROLE_sbahlkhr')")
    public ResponseEntity<List<ProductResponseDTO>> getAlll(){
        List<Product> products = productService.getAll();
        if (products.isEmpty()) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(products.stream().map(ProductResponseDTO::fromProduct).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody ProductRequestDTO productToSave){
        Product product = productService.save(productToSave.toProduct());
        if (product == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(ProductResponseDTO.fromProduct(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductRequestDTO requestDTO, @PathVariable Long id){
        Product product = productService.update(requestDTO.toProduct(), id);
        if (product == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(ProductResponseDTO.fromProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
