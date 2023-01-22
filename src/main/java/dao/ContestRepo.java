package dao;

import enitities.Contest;
import enitities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContestRepo {
    private static final int REQUIRED_SUM = 100;
    private static final int OFFSET = 1;
    private static ContestRepo instance = null;
    public static Map<Integer, Contest> contests;

    private ContestRepo(){ }

    public static ContestRepo getInstance(){
        if(instance != null){
            instance = new ContestRepo();
        }
        return instance;
    }

    public Map<Integer, Contest> getContests(){
        return contests;
    }

    public void printContestHistory(int contestId){
        if(contests.containsKey(contestId))
            contests.get(contestId).getResult()
                    .entrySet()
                    .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        else
            System.out.println("ERROR : contest is not present");
    }

    public void attendContest(int contestId, List<String> usersList){
        List<User> users = new ArrayList<User>();
        for(String name : usersList){
            User user = UserRepo.getInstance().getUser(name);
            if(user == null){
                System.out.println("ERROR : User not present with name " + name);
                return;
            }
            users.add(user);
        }
        if(!contests.containsKey(contestId)){
            System.out.println("ERROR : invalid contestId : " + contestId);
            return;
        }
        contests.get(contestId).attendContest(users);
    }

    public boolean createContest(int countOfProblems, List<Integer> difficultyPoints){
        int id = contests.size() + OFFSET;
        Contest newContest = Contest.builder().id(id).build();
        int sum = difficultyPoints.stream().mapToInt(i -> i.intValue()).sum();
        if(sum != REQUIRED_SUM){
            System.out.println("ERROR : The sum of values is not equal to " + REQUIRED_SUM);
            return false;
        }
        newContest.createContest(difficultyPoints);
        contests.put(newContest.id, newContest);
        return true;
    }
}
