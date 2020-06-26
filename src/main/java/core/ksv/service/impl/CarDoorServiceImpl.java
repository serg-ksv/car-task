package core.ksv.service.impl;

import core.ksv.dao.CarDoorDao;
import core.ksv.lib.Inject;
import core.ksv.lib.Service;
import core.ksv.model.CarDoor;
import core.ksv.service.CarDoorService;
import java.util.List;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Inject
    private CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
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
