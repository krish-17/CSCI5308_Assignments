package srp;

import good.srp.BowlerActionsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BowlerActionsUtilTest {

    @Test
    void validateTotalRunsConceded() {
        Assertions.assertThrows(NullPointerException.class,
                () -> { new BowlerActionsUtil(null, 0, 0).totalRunsConceded(); });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> { new BowlerActionsUtil(new int[] {10, 89, 0, 45, -15, 20, 56, 0, 0 ,0, 0}, 5, 300).totalRunsConceded(); });
        int[] concededRuns = new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0};
        int noOfWickets = 8;
        int noOfBalls = 300;
        BowlerActionsUtil bwActionObject = new BowlerActionsUtil(concededRuns, noOfWickets, noOfBalls);
        Assertions.assertEquals(235, bwActionObject.totalRunsConceded());
    }

    @Test
    void validateOverallBowlerAverage() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> { new BowlerActionsUtil(new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0}, 5, 1).overallBowlerAverage(); });
        int[] concededRuns = new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0};
        int noOfWickets = 8;
        int noOfBalls = 300;
        BowlerActionsUtil bwActionObject = new BowlerActionsUtil(concededRuns, noOfWickets, noOfBalls);
        Assertions.assertEquals(29, bwActionObject.overallBowlerAverage());
    }

    @Test
    void validateNetRunRate() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> { new BowlerActionsUtil(new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0}, 5, -1).netRunRate(); });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> { new BowlerActionsUtil(new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0}, 5, 0).netRunRate(); });
        Assertions.assertEquals(0, new BowlerActionsUtil(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0}, 0, 0).netRunRate());
        int[] concededRuns = new int[] {10, 89, 0, 45, 15, 20, 56, 0, 0 ,0, 0};
        int noOfWickets = 8;
        int noOfBalls = 300;
        BowlerActionsUtil bwActionObject = new BowlerActionsUtil(concededRuns, noOfWickets, noOfBalls);
        int expNetrunRate = 235*6/noOfBalls;
        System.out.println(expNetrunRate);
        Assertions.assertEquals(expNetrunRate, bwActionObject.netRunRate());
    }
}
