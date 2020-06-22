package core.ksv;

import org.junit.Assert;
import org.junit.Test;

public class CarDoorTest {
    private final CarDoor carDoor = new CarDoor();

    @Test
    public void isDoorOpenOrCloseTest() {
        Assert.assertTrue(carDoor.openDoor());
        Assert.assertFalse(carDoor.closeDoor());
        Assert.assertTrue(carDoor.openOrCloseDoor());
    }

    @Test
    public void isWindowOpenOrCloseTest() {
        Assert.assertTrue(carDoor.openWindow());
        Assert.assertFalse(carDoor.closeWindow());
        Assert.assertTrue(carDoor.openOrCloseWindow());
    }
}
