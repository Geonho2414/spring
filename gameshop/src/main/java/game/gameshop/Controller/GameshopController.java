package game.gameshop.Controller;

import game.gameshop.Repository.GameshopRepository;
import game.gameshop.Service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameshopController {
    GameshopService gameshopService;
    @Autowired
    public GameshopController(GameshopService gameshopService) {
        this.gameshopService = gameshopService;
    }
}
