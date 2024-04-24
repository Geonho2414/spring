package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    //실습 : 제품의 재고가 50개 미만인 제품 정보 얻기
    @GetMapping("/products/inventory/under/{num}")
    public ResponseEntity<List<Product>> getProductByInventoryUnder(@PathVariable int num) {
        return new ResponseEntity<>(productService.grtProductByInventoryUnder(num), HttpStatus.OK);
    }

    //실습 : 제품 중에서 제품명을 매개변수로 받아서 처리
    @GetMapping("/products/search/{str}")
    public ResponseEntity<List<Product>> getProductBySearch(@PathVariable String str) {
        return new ResponseEntity<>(productService.getProductBySearch(str), HttpStatus.OK);
    }

    //실습 : 제품 단가가 5,000원 이상 10,000원 이하인 제품
    // postman : localhost:8082/products/price?low=9000&high=9999
    @GetMapping("/products/price")
    public ResponseEntity<List<Product>> getProductByPriceRange(@RequestParam int low,
                                                                @RequestParam int high) {
        return new ResponseEntity<>(productService.getProductByPriceRange(low, high),
                HttpStatus.OK);
    }

    //실습 : 제품 제품번호가 1,2,4,7,11,20 인 제품의 모든 정보를 보이시오
    //포스트맨에서 배열형태로 요청함
    //본문에 [1,2,4,7,11,20] 형태로 요청
    @GetMapping("/products/idlist")
    public ResponseEntity<List<Product>> getProductByIdWithList(@RequestBody List<Long> idList) {
        return new ResponseEntity<>(productService.getProductByIdWithList(idList),
                HttpStatus.OK);
    }
}
