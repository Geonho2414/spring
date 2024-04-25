package dw.gameshop.Controller;

import dw.gameshop.Model.Game;
import dw.gameshop.Model.User;
import dw.gameshop.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    GameService gameshopService;
    @Autowired
    public GameController(GameService gameshopService) {
        this.gameshopService = gameshopService;
    }

    @PostMapping("/api/gameshop")
    public ResponseEntity<Game> saveGameshop(@RequestBody Game gameshop){
        return new ResponseEntity<>(gameshopService.saveGameshop(gameshop), HttpStatus.OK);
    }

    @GetMapping("/api/gameshop")
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<>(gameshopService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/api/gameshop/{id}")
    public ResponseEntity<Game> getGameshopById(@PathVariable long id){
        return new ResponseEntity<>(gameshopService.getGameshopById(id), HttpStatus.OK);
    }

    @PutMapping("/api/gameshop/{id}")
    public ResponseEntity<Game> updateGameshopById(@PathVariable long id,
                                                   @RequestBody Game gameshop){
        return new ResponseEntity<>(gameshopService.updateGameshopById(id, gameshop), HttpStatus.OK);
    }

    // 가장 비싼 게임
    @GetMapping("/products/maxprice")
    public ResponseEntity<Game> getGameWithMaxPrice(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPrice(), HttpStatus.OK);
    }

    //제일 비싼 게임 top3 : sort 이용
    @GetMapping("/products/maxpricetop3")
    public ResponseEntity<List<Game>> getTop3MaxPriceGame(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPriceTop3(), HttpStatus.OK);
    }

    //User Controller
    //Save
    @PostMapping("/products/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(gameshopService.saveUser(user), HttpStatus.OK);
    }
}
