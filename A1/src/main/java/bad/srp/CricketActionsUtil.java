package bad.srp;

public class CricketActionsUtil {

    int[] ind_score;
    boolean[] wick_arr;

    public CricketActionsUtil(int[] ind_score, boolean[] wick_arr) {
        this.ind_score = ind_score;
        this.wick_arr = wick_arr;
    }

    int scoreCalculator() {
        int t_score = 0;
        for (int i = 0; i < this.ind_score.length; i++) {
            t_score += this.ind_score[i];
        }
        return t_score;
    }

    int wicketsCalculator() {
        int t_wickets = 0;
        for (int i = 0; i < this.wick_arr.length; i++) {
            t_wickets += this.wick_arr[i] ? 1 : 0;
        }
        return t_wickets;
    }

    int bat_average() {
        int t_score = scoreCalculator();
        return t_score / ind_score.length;
    }

    int bowl_average() {
        int t_score = scoreCalculator();
        int t_wickets = wicketsCalculator();
        return t_score/t_wickets;
    }

}
