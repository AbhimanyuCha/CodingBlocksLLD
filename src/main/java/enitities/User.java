package enitities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class User {
    public String username;
    private int rating;
    public void updateRating(int points){
        rating += (points - 50);
    }
    public int getRating(){
        return rating;
    }
}
