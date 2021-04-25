package good.srp;

public class BowlerActionsUtil {

    private int[] concededRuns;
    private int noOfWickets;
    private int noOfBalls;

    public BowlerActionsUtil(int[] concededRuns, int noOfWickets, int noOfBalls) {
        this.concededRuns = concededRuns;
        this.noOfWickets = noOfWickets;
        this.noOfBalls = noOfBalls;
    }

    public int totalRunsConceded() throws NullPointerException, IllegalArgumentException {
        if ( this.concededRuns == null ) {
            throw new NullPointerException(" Conceded Runs array can't be empty");
        }
        int tRuns = 0;
        for( int i = 0; i < this.concededRuns.length; i++) {
            if ( this.concededRuns[i] < 0 ) {
                throw new IllegalArgumentException(" Runs can't be negative");
            }
            tRuns += this.concededRuns[i];
        }
        return tRuns;
    }

    public int overallBowlerAverage() throws IllegalArgumentException {
        int tRuns = this.totalRunsConceded();
        if ( this.noOfWickets > this.noOfBalls ) {
            throw new IllegalArgumentException(" Bowler can't get a wicket without bowling a ball");
        }
        return tRuns/noOfWickets;
    }

    public int netRunRate() throws IllegalArgumentException {
        int tRuns = this.totalRunsConceded();
        if ( this.noOfBalls < 0 || ( this.noOfBalls == 0 && tRuns > 0 )) {
            throw new IllegalArgumentException("Without bowling a ball, number of runs can't be greater than 0," +
                    "no: ofBalls bowled can not be negative");
        }
        if( this.noOfBalls == 0 ) {
            return 0;
        }
        return ( tRuns*6/this.noOfBalls );
    }
 }
