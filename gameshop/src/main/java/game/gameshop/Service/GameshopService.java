package game.gameshop.Service;

import game.gameshop.Model.Gameshop;
import game.gameshop.Repository.GameshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameshopService {
    @Autowired
    GameshopRepository gameshopRepository;
    public Gameshop saveGameshop(Gameshop gameshop){
        gameshopRepository.save(gameshop);
        return gameshop;
    }

}
