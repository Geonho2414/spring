package gameshop.gameshop.Controller;

import gameshop.gameshop.Model.Gameshop;
import gameshop.gameshop.Model.User;
import gameshop.gameshop.Service.GameshopService;
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



    //User Controller
    //Save
    @PostMapping("/products/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(gameshopService.saveUser(user), HttpStatus.OK);
    }

}
