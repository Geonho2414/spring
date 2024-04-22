package dw.gameshop.Service;

import dw.gameshop.Exception.ResourceNotFoundException;
import dw.gameshop.Model.Gameshop;
import dw.gameshop.Model.User;
import dw.gameshop.Repository.GameshopRepository;
import dw.gameshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameshopService {
    @Autowired
    GameshopRepository gameshopRepository;
    @Autowired
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
            throw new ResourceNotFoundException("Gameshop", "ID", id);
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
            throw new ResourceNotFoundException("Gameshop", "ID", id);
        }
    }

    //제일 비싼 게임의 정보
    public Gameshop getGameWithMaxPrice(){
        List<Gameshop> games = gameshopRepository.findAll();
        //람다시기 아닌 일반 자바코드 사용 예
//        Gameshop Max = games.get(0);
//        for (int i = 0; i< games.size()-1; i++) {
//            if(Max.getPrice() > games.get(i+1).getPrice()){
//                Max = games.get(i);
//            }
//        }
//        return Max;
        //람다식 사용 예
        return games.stream()
                .sorted(Comparator.comparingInt(Gameshop::getPrice)
                        .reversed())
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Max Price", " ", " "));
        //
    }

    //제일 비싼 게임 top3 : sort 이용
    public List<Gameshop> getGameWithMaxPriceTop3(){
          List<Gameshop> games = gameshopRepository.findAll();
//        games.sort(Comparator.comparingInt(Gameshop game) -> game.getPrice()).reversed());
//        List<Gameshop> newGames = new ArrayList<>();
//        newGames.add(games.get(0));
//        newGames.add(games.get(1));
//        newGames.add(games.get(2));
//        return newGames;
        return games.stream()
                .sorted(Comparator.comparingInt(Gameshop::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    //User
    //Save
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
