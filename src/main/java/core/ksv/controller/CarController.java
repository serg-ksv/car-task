package core.ksv.controller;

import core.ksv.model.dto.CarRequestDto;
import core.ksv.model.dto.CarResponseDto;
import core.ksv.model.mapper.CarMapper;
import core.ksv.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/{id}")
    public CarResponseDto getById(@PathVariable Long id) {
        var car = carService.getById(id);
        return carMapper.getDtoFromCar(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable Long id,
                                    @RequestBody CarRequestDto requestDto) {
        var car = carMapper.getCarFromDto(requestDto);
        car.setId(id);
        return carMapper.getDtoFromCar(carService.update(car));
    }

    @DeleteMapping("/{id}")
    public CarResponseDto deleteById(@PathVariable Long id) {
        var car = carService.delete(carService.getById(id));
        return carMapper.getDtoFromCar(car);
    }
}
