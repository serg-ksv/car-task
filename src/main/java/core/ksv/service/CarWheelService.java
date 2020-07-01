package core.ksv.service;

import core.ksv.model.CarWheel;
import java.util.List;

public interface CarWheelService {
    CarWheel add(CarWheel carWheel);

    CarWheel getById(Long id);

    List<CarWheel> getAll();

    CarWheel update(CarWheel carWheel);

    CarWheel delete(CarWheel carWheel);
}
