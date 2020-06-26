package core.ksv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_wheel")
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "wheel_condition")
    private double wheelCondition;

    public CarWheel() {
        wheelCondition = 1.0;
    }

    public double changeTire() {
        return wheelCondition = 1.0;
    }

    public double wearOutTire(int percentage) {
        if (percentage > 0 && percentage <= 100) {
            wheelCondition -= wheelCondition * percentage / 100;
        }
        return wheelCondition;
    }

    public double getWheelCondition() {
        return wheelCondition;
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "wheelCondition=" + wheelCondition
                + '}';
    }
}
