package core.ksv.model.mapper;

import core.ksv.model.Car;
import core.ksv.model.CarDoor;
import core.ksv.model.CarWheel;
import core.ksv.model.dto.CarRequestDto;
import core.ksv.model.dto.CarResponseDto;
import core.ksv.service.CarDoorService;
import core.ksv.service.CarWheelService;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final CarDoorService carDoorService;
    private final CarWheelService carWheelService;
    private final CarDoorMapper carDoorMapper;
    private final CarWheelMapper carWheelMapper;

    public CarMapper(CarDoorService carDoorService, CarWheelService carWheelService,
                     CarDoorMapper carDoorMapper, CarWheelMapper carWheelMapper) {
        this.carDoorService = carDoorService;
        this.carWheelService = carWheelService;
        this.carDoorMapper = carDoorMapper;
        this.carWheelMapper = carWheelMapper;
    }

    public CarResponseDto getDtoFromCar(Car car) {
        var dto = new CarResponseDto();
        dto.setId(car.getId());
        dto.setManufactureDate(car.getManufactureDate());
        dto.setEngineType(car.getEngineType());
        dto.setNewCarMaxSpeed(car.getNewCarMaxSpeed());
        dto.setAcceleration(car.getAcceleration());
        dto.setCapacity(car.getCapacity());
        dto.setCurrentNumberOfPassengers(car.getCurrentNumberOfPassengers());
        dto.setCurrentSpeed(car.getCurrentSpeed());
        dto.setDoors(Arrays.stream(car.getDoors())
                .map(carDoorMapper::getDtoFromCarDoor)
                .collect(Collectors.toList()));
        dto.setWheels(Arrays.stream(car.getWheels())
                .map(carWheelMapper::getDtoFromCarWheel)
                .collect(Collectors.toList()));
        return dto;
    }

    public Car getCarFromDto(CarRequestDto requestDto) {
        var car = new Car();
        car.setEngineType(requestDto.getEngineType());
        car.setNewCarMaxSpeed(requestDto.getNewCarMaxSpeed());
        car.setAcceleration(requestDto.getAcceleration());
        car.setCapacity(requestDto.getCapacity());
        car.setDoors(requestDto.getDoorsId().stream()
                .map(carDoorService::getById)
                .toArray(CarDoor[]::new));
        car.setWheels(requestDto.getWheelsId().stream()
                .map(carWheelService::getById)
                .toArray(CarWheel[]::new));
        car.setCurrentNumberOfPassengers(requestDto.getCurrentNumberOfPassengers());
        car.setCurrentSpeed(requestDto.getCurrentSpeed());
        return car;
    }
}
