package core.ksv.model.mapper;

import core.ksv.model.CarDoor;
import core.ksv.model.dto.CarDoorRequestDto;
import core.ksv.model.dto.CarDoorResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {
    public CarDoorResponseDto getDtoFromCarDoor(CarDoor carDoor) {
        var dto = new CarDoorResponseDto();
        dto.setId(carDoor.getId());
        dto.setDoorOpen(carDoor.isDoorOpen());
        dto.setWindowOpen(carDoor.isWindowOpen());
        return dto;
    }

    public CarDoor getCarDoorFromDto(CarDoorRequestDto requestDto) {
        var carDoor = new CarDoor();
        carDoor.setDoorOpen(requestDto.isDoorOpen());
        carDoor.setWindowOpen(requestDto.isWindowOpen());
        return carDoor;
    }
}
