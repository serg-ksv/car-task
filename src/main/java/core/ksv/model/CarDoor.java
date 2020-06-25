package core.ksv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_door")
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_door_open")
    private boolean isDoorOpen;
    @Column(name = "is_window_open")
    private boolean isWindowOpen;

    public boolean openDoor() {
        return isDoorOpen = true;
    }

    public boolean closeDoor() {
        return isDoorOpen = false;
    }

    public boolean openOrCloseDoor() {
        return isDoorOpen = !isDoorOpen;
    }

    public boolean openWindow() {
        return isWindowOpen = true;
    }

    public boolean closeWindow() {
        return isWindowOpen = false;
    }

    public boolean openOrCloseWindow() {
        return isWindowOpen = !isWindowOpen;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "isDoorOpen=" + isDoorOpen
                + ", isWindowOpen=" + isWindowOpen
                + '}';
    }
}
