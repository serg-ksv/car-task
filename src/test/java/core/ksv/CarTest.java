package core.ksv;

import core.ksv.model.Car;
import core.ksv.model.CarDoor;
import core.ksv.model.CarWheel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private static final double DELTA = 0.001;
    private Car car;

    @Before
    public void setUp() {
        car = init();
    }

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
        car.setNewCarMaxSpeed(280);
        car.setCurrentNumberOfPassengers(2);
        car.setEngineType("diesel");
        car.setDoors(new CarDoor[]{door1, door2, door3, door4});
        car.setWheels(new CarWheel[]{wheel1, wheel2, wheel3, wheel4});
        car.setCurrentSpeed(80);
        return car;
    }

    @Test
    public void setCurrentSpeedCorrectValue() {
        double expected = 110;
        double actual = car.setCurrentSpeed(110);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCurrentSpeedGreaterThanMaxValue() {
        car.setCurrentSpeed(car.getCurrentMaxSpeed() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCurrentSpeedNegativeValue() {
        car.setCurrentSpeed(-1);
    }

    @Test(expected = NullPointerException.class)
    public void setCurrentSpeedNullValue() {
        Double nullDouble = null;
        car.setCurrentSpeed(nullDouble);
    }

    @Test
    public void addPassengerTest() {
        int expected = 3;
        int actual = car.addPassenger();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void addPassengerWhenCarIsFull() {
        car.setCurrentNumberOfPassengers(car.getCapacity());
        int expected = car.getCapacity();
        int actual = car.addPassenger();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPassengerTest() {
        int expected = 1;
        int actual = car.getPassengerOut();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPassengerWhenCarIsEmpty() {
        car.setCurrentNumberOfPassengers(0);
        int expected = car.getCurrentNumberOfPassengers();
        int actual = car.getPassengerOut();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPassengersOutTest() {
        int expected = 0;
        int actual = car.getAllPassengersOut();
        Assert.assertEquals(expected, actual);
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
    public void addWheelsPositiveValue() {
        int expected = 7;
        int actual = car.addWheels(3).length;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWheelsNegativeValue() {
        car.addWheels(-1);
    }

    @Test(expected = NullPointerException.class)
    public void addWheelsNullValue() {
        Integer nullInteger = null;
        car.addWheels(nullInteger);
    }

    @Test
    public void getCurrentMaxSpeedTest() {
        double expected = 224;
        double actual = car.getCurrentMaxSpeed();
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getCurrentMaxSpeedWhenCarIsEmpty() {
        car.setCurrentNumberOfPassengers(0);
        double expected = 0;
        double actual = car.getCurrentMaxSpeed();
        Assert.assertEquals(expected, actual, DELTA);
    }
}
