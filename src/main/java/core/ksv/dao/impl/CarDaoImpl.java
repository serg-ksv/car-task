package core.ksv.dao.impl;

import core.ksv.dao.CarDao;
import core.ksv.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car> implements CarDao {
    public CarDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
