package core.ksv.service;

import core.ksv.model.CarDoor;
import java.util.List;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();

    CarDoor update(CarDoor carDoor);

    CarDoor delete(CarDoor carDoor);
}
