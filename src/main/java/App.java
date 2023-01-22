import dao.ContestRepo;
import dao.UserRepo;
import enitities.Leaderboard;
import enitities.User;

import java.util.ArrayList;
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
        UserRepo userRepo = UserRepo.getInstance();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String s = scanner.next();
            if(s == "CreateUser"){
                String name = scanner.next();
                userRepo.addUser(name);
                continue;
            }
            if(s == "Leaderboard"){
                leaderboard.showRatings();
                continue;
            }
            if(s == "LeaderboardInRange"){
                int st = Integer.parseInt(scanner.next());
                int en = Integer.parseInt(scanner.next());
                leaderboard.showRatingsInRange(st, en);
                continue;
            }
            if(s == "ContestHistory"){
                int contestId = Integer.parseInt(scanner.next());
                contestRepo.printContestHistory(contestId);
                continue;
            }
            if(s == "CreateContest"){
                int count = Integer.parseInt(scanner.next());
                List<Integer> list = new ArrayList<>();
                for(int i = 0 ; i < count ; i++)
                    list.add(Integer.parseInt(scanner.next()));
                contestRepo.createContest(count, list);
                continue;
            }
            if(s == "AttendContest"){
                int contestId = Integer.parseInt(scanner.next());
                List<String> usernames = new ArrayList<>();
                for()

            }
        }
    }

    public static void main(String[] args) {
        App server = new App();
        server.run();
    }
}
