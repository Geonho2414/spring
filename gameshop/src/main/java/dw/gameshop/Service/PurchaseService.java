package dw.gameshop.Service;

import dw.gameshop.Exception.ResourceNotFoundExceotion;
import dw.gameshop.Model.Purchase;
import dw.gameshop.Model.User;
import dw.gameshop.Repository.PurchaseRepository;
import dw.gameshop.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    UserRepository userRepository;
    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchaseListByUser(String userId){
        // 유저 아이디로 유저객체 찾기
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundExceotion("User", "ID", userId);
        }
        return purchaseRepository.findByUser(userOptional.get());
    }
}
