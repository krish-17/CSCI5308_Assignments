package srp;

import good.srp.BatterActionsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatterActionsUtilTest {


    @Test
    void testOverallScore() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                        new BatterActionsUtil(null, 12).overallScore();
                      });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                        new BatterActionsUtil(null, 0).overallScore();
                    });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                        new BatterActionsUtil(new int[] {20, 40, 33, 10, -6, 0, 9, 10, 0 ,25,11}, 11).overallScore();
                     });
        int ind_score[] = new int[]{20, 40, 33, 10, 6, 0, 9, 10, 0 ,25,11};
        int overallScore = 164;
        BatterActionsUtil baObject = new BatterActionsUtil(ind_score, 11);
        Assertions.assertEquals(overallScore, baObject.overallScore());
    }

    @Test
    void testAverage() {
        BatterActionsUtil bauObject = new BatterActionsUtil(new int[] {20, 40, 33, 10, 6, 0, 9, 10, 0, 25, 11}, 11);
        int expAverage = 164/11;
        Assertions.assertEquals(expAverage, bauObject.overallBattingAverage());
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new BatterActionsUtil(null, 12).overallScore();
                });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new BatterActionsUtil(null, 0).overallScore();
                });
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new BatterActionsUtil(new int[] {20, 40, 33, 10, -6, 0, 9, 10, 0 ,25,11}, 11).overallScore();
                });
    }



}
