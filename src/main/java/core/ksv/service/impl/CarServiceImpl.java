package core.ksv.service.impl;

import core.ksv.dao.CarDao;
import core.ksv.model.Car;
import core.ksv.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public Car getById(Long id) {
        return carDao.getById(id, Car.class);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll(Car.class);
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public Car delete(Car car) {
        return carDao.delete(car);
    }
}
