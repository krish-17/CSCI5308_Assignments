package good.srp;

public class BatterActionsUtil {
    private int[] indScore;
    private int noOfBatsmen;

    public BatterActionsUtil(int[] indScore, int noOfBatsmen) {
        this.indScore = indScore;
        this.noOfBatsmen = noOfBatsmen;
    }

    public int overallScore() throws IllegalArgumentException {
        if ( this.noOfBatsmen != 11
                || this.indScore == null) {
            throw new IllegalArgumentException(" Can't have more than 11 batsman in team, " +
                    "only 11 people can play in the game");
        }
        int tScore = 0;
        for (int i = 0; i < this.indScore.length ; i++) {
            if(this.indScore[i] < 0) {
                throw new IllegalArgumentException("Runs can never be negative");
            }
            tScore += this.indScore[i];
        }
        return tScore;
    }

    public int overallBattingAverage() {
        return this.overallScore()/this.noOfBatsmen;
    }

}
