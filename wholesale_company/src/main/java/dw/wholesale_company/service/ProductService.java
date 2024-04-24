package dw.wholesale_company.service;

import dw.wholesale_company.model.Employee;
import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    //실습 : 제품 중에서 제품명을 매개변수로 받아서 처리
    public List<Product> getProductBySearch(String str) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(product -> product.getProductName().contains(str.toLowerCase())).collect(Collectors.toList());
    }

    //실습 : 제품 단가가 5,000원 이상 10,000원 이하인 제품
    // postman : localhost:8082/products/price?low=9000&high=9999
    public List<Product> getProductByPriceRange(int lowPrice, int highPrice) {
        List<Product> productList = productRepository.findAll();
        return  productList.stream().filter(product -> product.getUnitPrice() >= lowPrice && product.getUnitPrice() <= highPrice).collect(Collectors.toList());
    }

    //실습 : 제품 제품번호가 1, 2, 4, 7, 11, 20인 제품의 모든 정보를 보이시오.
    public List<Product> getProductByIdWithList(List<Long> idList) {
        List<Product> productList = productRepository.findAll();
//        List<Product> newProducts = new ArrayList<>();
//        for(int i=0; i<productList.size(); i++) {
//            for(int j=0; j< idList.size(); j++) {
//                if (productList.get(i).getProductId() == idList.get(j)) {
//                    newProducts.add(productList.get(i));
//                }
//            }
//        }
//        return newProducts;
        return productList.stream().filter(product -> idList.contains(product.getProductId()))
                .collect(Collectors.toList());
    }

    //실습 : 제품 재고금액이 높은 상위 10개 제품
    //(재고금액 = 단가*재고)
//    //미해결
//    public List<Product> getTop10ProductsByValue() {
//        List<Product> productList = productRepository.findAll();
//        List<Product> top10Products = productList.stream()
//                .sorted(Comparator.comparing(productList.).reversed())
//                .limit(10)
//                .collect(Collectors.toList());
//        return top10Products;
//    }
}
