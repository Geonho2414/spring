package dw.gameshop.Service;

import dw.gameshop.Exception.ResourceNotFoundExceotion;
import dw.gameshop.Model.Gameshop;
import dw.gameshop.Model.User;
import dw.gameshop.Repository.GameshopRepository;
import dw.gameshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameshopService {
    @Autowired
    GameshopRepository gameshopRepository;
    UserRepository userRepository;

    public GameshopService(GameshopRepository gameshopRepository, UserRepository userRepository) {
        this.gameshopRepository = gameshopRepository;
        this.userRepository = userRepository;
    }

    public Gameshop saveGameshop(Gameshop gameshop){
        gameshopRepository.save(gameshop);
        return gameshop;
    }

    public List<Gameshop> getAllGames(){
        return gameshopRepository.findAll();
    }

    public Gameshop getGameshopById(long id) {
        Optional<Gameshop> gameshop = gameshopRepository.findById(id);
        if(gameshop.isPresent()){
            return gameshop.get();
        }else {
            throw new ResourceNotFoundExceotion("Gamshop", "ID", id);
        }
    }

    public Gameshop updateGameshopById(long id, Gameshop gameshop) {
        Optional<Gameshop> gameshop1 = gameshopRepository.findById(id);
        if (gameshop1.isPresent()){
            gameshop1.get().setTitle(gameshop.getTitle());
            gameshop1.get().setGenre(gameshop.getGenre());
            gameshop1.get().setImage(gameshop.getImage());
            gameshop1.get().setPrice(gameshop.getPrice());
            gameshop1.get().setText(gameshop.getText());
            gameshopRepository.save(gameshop1.get());
            return gameshop1.get();
        }else {
            throw new ResourceNotFoundExceotion("Gamshop", "ID", id);
        }
    }


    //User
    //Save
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
