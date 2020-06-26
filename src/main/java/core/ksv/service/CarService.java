package core.ksv.service;

import core.ksv.model.Car;
import java.util.List;

public interface CarService {
    Car add(Car car);

    List<Car> getAll();

    Car update(Car car);

    Car delete(Car car);
}
