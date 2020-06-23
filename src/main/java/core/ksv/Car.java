package core.ksv;

import java.time.LocalDate;
import java.util.Arrays;

public class Car {
    private final LocalDate manufactureDate;
    private String engineType;
    private double newCarMaxSpeed;
    private int acceleration;
    private int capacity;
    private int currentNumberOfPassengers;
    private double currentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    public Car() {
        manufactureDate = LocalDate.now();
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getNewCarMaxSpeed() {
        return newCarMaxSpeed;
    }

    public void setNewCarMaxSpeed(double newCarMaxSpeed) {
        this.newCarMaxSpeed = newCarMaxSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public CarWheel[] getWheels() {
        return wheels;
    }

    public void setWheels(CarWheel[] wheels) {
        this.wheels = wheels;
    }

    public CarDoor[] getDoors() {
        return doors;
    }

    public void setDoors(CarDoor[] doors) {
        this.doors = doors;
    }

    public double setCurrentSpeed(double newSpeed) {
        double currentMaxSpeed = getCurrentMaxSpeed();
        if (newSpeed > currentMaxSpeed || newSpeed < 0) {
            throw new IllegalArgumentException("Can't set speed greater than max speed: "
                    + currentMaxSpeed + " or less than 0!");
        }
        currentSpeed = newSpeed;
        return currentSpeed;
    }

    public int addPassenger() {
        if (currentNumberOfPassengers == capacity) {
            return currentNumberOfPassengers;
        }
        return ++currentNumberOfPassengers;
    }

    public int getPassengerOut() {
        if (currentNumberOfPassengers == 0) {
            return currentNumberOfPassengers;
        }
        return --currentNumberOfPassengers;
    }

    public int getAllPassengersOut() {
        return currentNumberOfPassengers = 0;
    }

    public CarDoor getDoorByIndex(int index) {
        return doors != null && index >= 0 && index < doors.length
                ? doors[index]
                : null;

    }

    public CarWheel getWheelByIndex(int index) {
        return wheels != null && index >= 0 && index < wheels.length
                ? wheels[index]
                : null;
    }

    public CarWheel[] removeAllWheels() {
        wheels = new CarWheel[0];
        return wheels;
    }

    public CarWheel[] addWheels(int numberOfWheels) {
        if (numberOfWheels <= 0) {
            throw new IllegalArgumentException("Number of wheels must be positive!");
        }
        int newLength = numberOfWheels;
        CarWheel[] newWheels = new CarWheel[newLength];
        if (wheels != null) {
            newLength += wheels.length;
            newWheels = Arrays.copyOf(wheels, newLength);
        }
        for (int i = 0; i < numberOfWheels; i++) {
            newWheels[newLength - numberOfWheels + i] = new CarWheel();
        }
        wheels = newWheels;
        return wheels;
    }

    public double getCurrentMaxSpeed() {
        if (currentNumberOfPassengers == 0) {
            return 0;
        }
        double theMostWornWheel = 1.0;
        for (CarWheel wheel : wheels) {
            double wheelCondition = wheel.getWheelCondition();
            if (wheelCondition < theMostWornWheel) {
                theMostWornWheel = wheelCondition;
            }
        }
        return newCarMaxSpeed * theMostWornWheel;
    }

    @Override
    public String toString() {
        return "Car{"
                + "manufactureDate=" + manufactureDate
                + ", engineType='" + engineType + '\''
                + ", newCarMaxSpeed=" + newCarMaxSpeed
                + ", acceleration=" + acceleration
                + ", capacity=" + capacity
                + ", currentNumberOfPassengers=" + currentNumberOfPassengers
                + ", currentSpeed=" + currentSpeed
                + ", wheels=" + Arrays.toString(wheels)
                + ", doors=" + Arrays.toString(doors)
                + ", currentMaxSpeed=" + getCurrentMaxSpeed()
                + '}';
    }
}
