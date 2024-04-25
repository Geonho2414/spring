package dw.gameshop.Service;

import dw.gameshop.Exception.ResourceNotFoundException;
import dw.gameshop.Model.Game;
import dw.gameshop.Model.User;
import dw.gameshop.Repository.GameRepository;
import dw.gameshop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameshopService {
    @Autowired
    GameRepository gameshopRepository;
    @Autowired
    UserRepository userRepository;

    public GameshopService(GameRepository gameshopRepository, UserRepository userRepository) {
        this.gameshopRepository = gameshopRepository;
        this.userRepository = userRepository;
    }

    public Game saveGameshop(Game gameshop){
        gameshopRepository.save(gameshop);
        return gameshop;
    }

    public List<Game> getAllGames(){
        return gameshopRepository.findAll();
    }

    public Game getGameshopById(long id) {
        Optional<Game> gameshop = gameshopRepository.findById(id);
        if(gameshop.isPresent()){
            return gameshop.get();
        }else {
            throw new ResourceNotFoundException("Gameshop", "ID", id);
        }
    }

    public Game updateGameshopById(long id, Game gameshop) {
        Optional<Game> gameshop1 = gameshopRepository.findById(id);
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
    public Game getGameWithMaxPrice(){
        List<Game> games = gameshopRepository.findAll();
        //람다시기 아닌 일반 자바코드 사용 예
//        Gameshop Max = games.get(0);
//        for (int i = 0; i< games.size()-1; i++) {
//            if(Max.getPrice() > games.get(i+1).getPrice()){
//                Max = games.get(i);
//            }
//        }
//        return Max;
        //람다식 사용 예
//        return games.stream()
//                .sorted(Comparator.comparingInt(Gameshop::getPrice)
//                        .reversed())
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException("Max Price", " ", " "));
        //JPQL 사용 예
        return gameshopRepository.getGameWithMaxPrice();
    }

    //제일 비싼 게임 top3 : sort 이용
    public List<Game> getGameWithMaxPriceTop3(){
          List<Game> games = gameshopRepository.findAll();
          // 자바코드 예
//        games.sort(Comparator.comparingInt(Gameshop game) -> game.getPrice()).reversed());
//        List<Gameshop> newGames = new ArrayList<>();
//        newGames.add(games.get(0));
//        newGames.add(games.get(1));
//        newGames.add(games.get(2));
//        return newGames;
        // 람다식 예
//        return games.stream()
//                .sorted(Comparator.comparingInt(Gameshop::getPrice).reversed())
//                .limit(3)
//                .collect(Collectors.toList());
        //JPQL 사용 예
        return gameshopRepository.getGameWithMaxPriceTop3()
                .stream().limit(3).collect(Collectors.toList());
    }

    //User
    //Save
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
