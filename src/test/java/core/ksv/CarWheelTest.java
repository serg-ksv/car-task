package core.ksv;

import org.junit.Assert;
import org.junit.Test;

public class CarWheelTest {
    private static final double DELTA = 0.001;
    private final CarWheel carWheel = new CarWheel();

    @Test
    public void wearOutTireWithCorrectInput() {
        double expected = 0.75;
        double actual = carWheel.wearOutTire(25);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void wearOutTireWithIncorrectInput() {
        double expected = 1.0;
        double actual = carWheel.wearOutTire(101);
        Assert.assertEquals(expected, actual, DELTA);
    }
}
