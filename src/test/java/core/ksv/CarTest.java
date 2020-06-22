package core.ksv;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    private static final double DELTA = 0.001;
    private final Car car = init();
    
    private Car init() {
        var door1 = new CarDoor();
        var door2 = new CarDoor();
        var door3 = new CarDoor();
        var door4 = new CarDoor();
        var wheel1 = new CarWheel();
        var wheel2 = new CarWheel();
        var wheel3 = new CarWheel();
        var wheel4 = new CarWheel();
        wheel3.wearOutTire(15);
        wheel4.wearOutTire(20);
        var car = new Car();
        car.setAcceleration(4);
        car.setCapacity(5);
        car.setCurrentNumberOfPassengers(2);
        car.setCurrentSpeed(80);
        car.setEngineType("diesel");
        car.setNewCarMaxSpeed(280);
        car.setDoors(new CarDoor[]{door1, door2, door3, door4});
        car.setWheels(new CarWheel[]{wheel1, wheel2, wheel3, wheel4});
        return car;
    }

    @Test
    public void setCurrentSpeedTest() {
        double expected = 110;
        double actual = car.setCurrentSpeed(110);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void addPassengerTest() {
        int expected = 3;
        int actual = car.addPassenger();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPassengerTest() {
        int expected = 1;
        int actual = car.getPassengerOut();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getAllPassengersOutTest() {
        int expected = 0;
        int actual = car.getAllPassengersOut();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDoorByCorrectIndex() {
        CarDoor expected = car.getDoors()[2];
        CarDoor actual = car.getDoorByIndex(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDoorByIncorrectIndex() {
        CarDoor actual = car.getDoorByIndex(4);
        Assert.assertNull(actual);
    }

    @Test
    public void getWheelByCorrectIndex() {
        CarWheel expected = car.getWheels()[3];
        CarWheel actual = car.getWheelByIndex(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWheelByIncorrectIndex() {
        CarWheel actual = car.getWheelByIndex(-1);
        Assert.assertNull(actual);
    }

    @Test
    public void removeAllWheelsTest() {
        CarWheel[] expected = new CarWheel[0];
        CarWheel[] actual = car.removeAllWheels();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addWheelsTest() {
        int expected = 7;
        int actual = car.addWheels(3).length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCurrentMaxSpeedTest() {
        double expected = 224;
        double actual = car.getCurrentMaxSpeed();
        Assert.assertEquals(expected, actual, DELTA);
    }
}
