package enitities;

import lombok.Builder;

@Builder
public class Problem {
    public String id;
    public String statement;
    public int difficulty;
}
