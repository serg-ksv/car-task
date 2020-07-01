package core.ksv.model.dto;

import java.time.LocalDate;
import java.util.List;

public class CarResponseDto {
    private Long id;
    private LocalDate manufactureDate;
    private String engineType;
    private double newCarMaxSpeed;
    private int acceleration;
    private int capacity;
    private int currentNumberOfPassengers;
    private double currentSpeed;
    private List<CarWheelResponseDto> wheels;
    private List<CarDoorResponseDto> doors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
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

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public List<CarWheelResponseDto> getWheels() {
        return wheels;
    }

    public void setWheels(List<CarWheelResponseDto> wheels) {
        this.wheels = wheels;
    }

    public List<CarDoorResponseDto> getDoors() {
        return doors;
    }

    public void setDoors(List<CarDoorResponseDto> doors) {
        this.doors = doors;
    }
}
