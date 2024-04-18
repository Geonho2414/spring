package gameshop.gameshop.Controller;

import gameshop.gameshop.Model.Gameshop;
import gameshop.gameshop.Repository.GameshopRepository;
import gameshop.gameshop.Service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Gameshop saveGameshop(@RequestBody Gameshop gameshop){
        return gameshopService.saveGameshop(gameshop);
    }

    @GetMapping("/api/gameshop")
    public List<Gameshop> getAllGames(){
        return gameshopService.getAllGames();
    }

    @GetMapping("/api/gameshop/{id}")
    public Gameshop getGameshopById(@PathVariable long id){
        return gameshopService.getGameshopById(id);
    }

    @PutMapping("/api/gameshop/{id}")
    public Gameshop updateGameshopById(@PathVariable long id,
                                       @RequestBody Gameshop gameshop){
        return gameshopService.updateGameshopById(id, gameshop);
    }
}
