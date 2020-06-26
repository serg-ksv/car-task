package core.ksv.service.impl;

import core.ksv.dao.CarDao;
import core.ksv.dao.impl.CarDaoImpl;
import core.ksv.lib.Inject;
import core.ksv.lib.Service;
import core.ksv.model.Car;
import core.ksv.service.CarService;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private final CarDao carDao = new CarDaoImpl();

    @Override
    public Car add(Car car) {
        return carDao.add(car);
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
