package core.ksv.controller;

import core.ksv.model.dto.CarRequestDto;
import core.ksv.model.dto.CarResponseDto;
import core.ksv.model.mapper.CarMapper;
import core.ksv.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public void add(@RequestBody CarRequestDto requestDto) {
        carService.add(carMapper.getCarFromDto(requestDto));
    }

    @GetMapping
    public List<CarResponseDto> getAll() {
        return carService.getAll().stream()
                .map(carMapper::getDtoFromCar)
                .collect(Collectors.toList());
    }

    @GetMapping("/car")
    public CarResponseDto getById(@RequestParam Long id) {
        var car = carService.getById(id);
        return carMapper.getDtoFromCar(car);
    }

    @PostMapping("/update-car")
    public CarResponseDto updateCar(@RequestParam Long id,
                                    @RequestBody CarRequestDto requestDto) {
        var car = carMapper.getCarFromDto(requestDto);
        car.setId(id);
        return carMapper.getDtoFromCar(carService.update(car));
    }

    @GetMapping("/delete-car")
    public CarResponseDto deleteById(@RequestParam Long id) {
        var car = carService.delete(carService.getById(id));
        return carMapper.getDtoFromCar(car);
    }
}
