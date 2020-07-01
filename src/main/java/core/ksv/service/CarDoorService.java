package core.ksv.service;

import core.ksv.model.CarDoor;
import java.util.List;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    CarDoor getById(Long id);

    List<CarDoor> getAll();

    CarDoor update(CarDoor carDoor);

    CarDoor delete(CarDoor carDoor);
}
