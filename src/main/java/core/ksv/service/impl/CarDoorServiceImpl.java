package core.ksv.service.impl;

import core.ksv.dao.CarDoorDao;
import core.ksv.model.CarDoor;
import core.ksv.service.CarDoorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    private final CarDoorDao carDoorDao;

    public CarDoorServiceImpl(CarDoorDao carDoorDao) {
        this.carDoorDao = carDoorDao;
    }

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public CarDoor getById(Long id) {
        return carDoorDao.getById(id, CarDoor.class);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll(CarDoor.class);
    }

    @Override
    public CarDoor update(CarDoor carDoor) {
        return carDoorDao.update(carDoor);
    }

    @Override
    public CarDoor delete(CarDoor carDoor) {
        return carDoorDao.delete(carDoor);
    }
}
