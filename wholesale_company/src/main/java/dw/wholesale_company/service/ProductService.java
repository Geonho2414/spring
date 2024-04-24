package dw.wholesale_company.service;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //실습 : 제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> grtProductByInventoryUnder(int num){
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(p -> p.getInventory() < num).collect(Collectors.toList());
    }
}
