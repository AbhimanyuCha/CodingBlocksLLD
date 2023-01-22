package enitities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Contest {
    public List<Problem> problemList;
    public int id;
    public Map<User, Integer> result;

    public Contest(int id){
        result = new HashMap<>();
        problemList = new ArrayList<>();
        this.id = id;
    }

    public void createContest(List<Integer> problemDifficultyList){
        this.problemList = problemDifficultyList.stream()
                .map(problemDifficulty ->
                        Problem.builder()
                                .difficulty(problemDifficulty)
                                .id(id + "_" + (int) (Math.random() * 100))
                                .statement("SAMPLE_STRING")
                                .build())
                .collect(Collectors.toList());
    }

    public Map<User, Integer> getResult(){
        return result;
    }

    public void attendContest(List<User> userList){
        if(!result.isEmpty()){
            System.out.println("ERROR : The contest is already over/attended : " + id);
            return;
        }

        for(User u : userList){
            int score = problemList.stream().mapToInt(problem -> Math.random()> 0.5 ? problem.difficulty : 0).sum();
            result.put(u, score);
            u.updateRating(score);
        }
    }
}
