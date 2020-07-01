package core.ksv.model.dto;

import java.util.List;

public class CarRequestDto {
    private String engineType;
    private double newCarMaxSpeed;
    private int acceleration;
    private int capacity;
    private int currentNumberOfPassengers;
    private double currentSpeed;
    private List<Long> wheelsId;
    private List<Long> doorsId;

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

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public List<Long> getWheelsId() {
        return wheelsId;
    }

    public void setWheelsId(List<Long> wheelsId) {
        this.wheelsId = wheelsId;
    }

    public List<Long> getDoorsId() {
        return doorsId;
    }

    public void setDoorsId(List<Long> doorsId) {
        this.doorsId = doorsId;
    }
}
