package dw.gameshop.Controller;

import dw.gameshop.Model.Gameshop;
import dw.gameshop.Model.User;
import dw.gameshop.Service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameshopController {
    GameshopService gameshopService;
    @Autowired
    public GameshopController(GameshopService gameshopService) {
        this.gameshopService = gameshopService;
    }

    @PostMapping("/api/gameshop")
    public ResponseEntity<Gameshop> saveGameshop(@RequestBody Gameshop gameshop){
        return new ResponseEntity<>(gameshopService.saveGameshop(gameshop), HttpStatus.OK);
    }

    @GetMapping("/api/gameshop")
    public ResponseEntity<List<Gameshop>> getAllGames(){
        return new ResponseEntity<>(gameshopService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/api/gameshop/{id}")
    public ResponseEntity<Gameshop> getGameshopById(@PathVariable long id){
        return new ResponseEntity<>(gameshopService.getGameshopById(id), HttpStatus.OK);
    }

    @PutMapping("/api/gameshop/{id}")
    public ResponseEntity<Gameshop> updateGameshopById(@PathVariable long id,
                                       @RequestBody Gameshop gameshop){
        return new ResponseEntity<>(gameshopService.updateGameshopById(id, gameshop), HttpStatus.OK);
    }

    // 가장 비싼 게임
    @GetMapping("/products/maxprice")
    public ResponseEntity<Gameshop> getGameWithMaxPrice(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPrice(), HttpStatus.OK);
    }

    //제일 비싼 게임 top3 : sort 이용
    @GetMapping("/products/maxpricetop3")
    public ResponseEntity<List<Gameshop>> getTop3MaxPriceGame(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPriceTop3(), HttpStatus.OK);
    }

    //User Controller
    //Save
    @PostMapping("/products/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(gameshopService.saveUser(user), HttpStatus.OK);
    }
}
