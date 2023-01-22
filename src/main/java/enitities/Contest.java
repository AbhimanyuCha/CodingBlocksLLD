package enitities;

import lombok.Builder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public class Contest {
    public List<Problem> problemList;
    public int id;
    public Map<User, Integer> result;

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
        for(User u : userList){
            int score = problemList.stream().mapToInt(problem -> Math.random()> 0.5 ? problem.difficulty : 0).sum();
            u.updateRating(score);
        }
    }
}
