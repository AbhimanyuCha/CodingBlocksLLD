import dao.ContestRepo;
import dao.UserRepo;
import enitities.Leaderboard;
import enitities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {


    Leaderboard leaderboard;
    UserRepo userRepo;
    ContestRepo contestRepo;

    public App(){
        userRepo = UserRepo.getInstance();
        leaderboard = new Leaderboard();
        contestRepo = ContestRepo.getInstance();
    }

    public void run(){
        userRepo.addUser("joey");
        userRepo.addUser("monica");
        userRepo.addUser("ross");
        userRepo.addUser("rachel");
        userRepo.addUser("phoebe");
        contestRepo.createContest(4, Arrays.asList(5 , 15 , 35 , 45));
        contestRepo.attendContest(1, Arrays.asList("joey", "monica", "ross"));
        leaderboard.showRatings();
        contestRepo.createContest(5, Arrays.asList(10, 15 , 20 , 25, 30));
        leaderboard.showRatingsInRange(1 , 2);
        contestRepo.printContestHistory(1);
        contestRepo.printContestHistory(2);
        leaderboard.showRatings();
    }

    public static void main(String[] args) {
        App server = new App();
        server.run();
    }
}
