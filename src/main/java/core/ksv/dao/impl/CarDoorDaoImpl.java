package core.ksv.dao.impl;

import core.ksv.dao.CarDoorDao;
import core.ksv.model.CarDoor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoorDaoImpl extends GenericDaoImpl<CarDoor> implements CarDoorDao {
    public CarDoorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
