package core.ksv.service.impl;

import core.ksv.dao.CarWheelDao;
import core.ksv.lib.Inject;
import core.ksv.lib.Service;
import core.ksv.model.CarWheel;
import core.ksv.service.CarWheelService;
import java.util.List;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Inject
    private CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll(CarWheel.class);
    }

    @Override
    public CarWheel update(CarWheel carWheel) {
        return carWheelDao.update(carWheel);
    }

    @Override
    public CarWheel delete(CarWheel carWheel) {
        return carWheelDao.delete(carWheel);
    }
}
