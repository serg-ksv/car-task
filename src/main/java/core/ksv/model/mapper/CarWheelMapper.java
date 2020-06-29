package core.ksv.model.mapper;

import core.ksv.model.CarWheel;
import core.ksv.model.dto.CarWheelRequestDto;
import core.ksv.model.dto.CarWheelResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {
    public CarWheelResponseDto getDtoFromCarWheel(CarWheel carWheel) {
        var dto = new CarWheelResponseDto();
        dto.setId(carWheel.getId());
        dto.setWheelCondition(carWheel.getWheelCondition());
        return dto;
    }

    public CarWheel getCarWheelFromDto(CarWheelRequestDto requestDto) {
        var carWheel = new CarWheel();
        carWheel.setWheelCondition(requestDto.getWheelCondition());
        return carWheel;
    }
}
