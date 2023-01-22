package enitities;

import dao.ContestRepo;
import dao.UserRepo;
import java.util.HashMap;
import java.util.Map;

public class Leaderboard {
    private static UserRepo userRepo;
    private int id;
    private static ContestRepo contestRepo;

    public Leaderboard(){
        userRepo = UserRepo.getInstance();
        contestRepo = ContestRepo.getInstance();
    }

    public void showRatings(){
        userRepo.getUsers()
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public void showRatingsInRange(int contestIdStart, int contestIdEnd){
        Map<User, Integer> users = new HashMap<>();
        contestRepo.getContests().entrySet()
                .stream()
                .filter(entry -> entry.getKey() >= contestIdStart && entry.getKey() <= contestIdEnd)
                .map(entry -> entry.getValue().getResult())
                .forEach(resultMap -> resultMap.entrySet().stream().forEach(k ->  users.put(k.getKey()
                        , users.getOrDefault(k.getKey() , 0) + k.getValue())));
        for(Map.Entry<User, Integer> entry : users.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
