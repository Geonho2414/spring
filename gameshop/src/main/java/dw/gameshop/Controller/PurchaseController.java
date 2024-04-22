package dw.gameshop.Controller;

import dw.gameshop.Model.Purchase;
import dw.gameshop.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/product/purchase")
    public Purchase savePurchase(@RequestBody Purchase purchase) {
        return purchaseService.savePurchase(purchase);
    }

    @GetMapping("/product/purchase")
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/product/purchase/{userId}")
    public List<Purchase> getPurchaseListByUser(@PathVariable String userId) {
        return purchaseService.getPurchaseListByUser(userId);
    }

    @GetMapping("/product/name/{userName}")
    public ResponseEntity<List<Purchase>> getPurchaseListByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(purchaseService.getPurchaseListByUserName(userName), HttpStatus.OK);
    }
}
