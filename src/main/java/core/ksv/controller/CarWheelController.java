package core.ksv.controller;

import core.ksv.model.dto.CarWheelRequestDto;
import core.ksv.model.dto.CarWheelResponseDto;
import core.ksv.model.mapper.CarWheelMapper;
import core.ksv.service.CarWheelService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-wheels")
public class CarWheelController {
    private final CarWheelService carWheelService;
    private final CarWheelMapper carWheelMapper;

    public CarWheelController(CarWheelService carWheelService, CarWheelMapper carWheelMapper) {
        this.carWheelService = carWheelService;
        this.carWheelMapper = carWheelMapper;
    }

    @PostMapping
    public void add(@RequestBody CarWheelRequestDto requestDto) {
        carWheelService.add(carWheelMapper.getCarWheelFromDto(requestDto));
    }

    @GetMapping
    public List<CarWheelResponseDto> getAll() {
        return carWheelService.getAll().stream()
                .map(carWheelMapper::getDtoFromCarWheel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarWheelResponseDto getById(@PathVariable Long id) {
        var carWheel = carWheelService.getById(id);
        return carWheelMapper.getDtoFromCarWheel(carWheel);
    }
}
