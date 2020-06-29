package core.ksv.dao.impl;

import core.ksv.dao.CarWheelDao;
import core.ksv.model.CarWheel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl extends GenericDaoImpl<CarWheel> implements CarWheelDao {
    public CarWheelDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
