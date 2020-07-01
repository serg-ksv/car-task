package core.ksv.service.impl;

import core.ksv.dao.CarWheelDao;
import core.ksv.model.CarWheel;
import core.ksv.service.CarWheelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    private final CarWheelDao carWheelDao;

    public CarWheelServiceImpl(CarWheelDao carWheelDao) {
        this.carWheelDao = carWheelDao;
    }

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public CarWheel getById(Long id) {
        return carWheelDao.getById(id, CarWheel.class);
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
