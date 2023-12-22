package id.bni297.microservicedemo.service;

import id.bni297.microservicedemo.model.Product;
import id.bni297.microservicedemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //find productbyId
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product product){
        return getProductById(id).map(products ->{
                    products.setName(product.getName());
                    products.setPrice(product.getPrice());
                    return products;
                }).orElseThrow(()->new RuntimeException("Product not Found"));
    }

}
