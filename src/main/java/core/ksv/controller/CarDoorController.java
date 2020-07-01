package core.ksv.controller;

import core.ksv.model.dto.CarDoorRequestDto;
import core.ksv.model.dto.CarDoorResponseDto;
import core.ksv.model.mapper.CarDoorMapper;
import core.ksv.service.CarDoorService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-doors")
public class CarDoorController {
    private final CarDoorService carDoorService;
    private final CarDoorMapper carDoorMapper;

    public CarDoorController(CarDoorService carDoorService, CarDoorMapper carDoorMapper) {
        this.carDoorService = carDoorService;
        this.carDoorMapper = carDoorMapper;
    }

    @PostMapping
    public void add(@RequestBody CarDoorRequestDto requestDto) {
        carDoorService.add(carDoorMapper.getCarDoorFromDto(requestDto));
    }

    @GetMapping
    public List<CarDoorResponseDto> getAll() {
        return carDoorService.getAll().stream()
                .map(carDoorMapper::getDtoFromCarDoor)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarDoorResponseDto getById(@PathVariable Long id) {
        var carDoor = carDoorService.getById(id);
        return carDoorMapper.getDtoFromCarDoor(carDoor);
    }
}
