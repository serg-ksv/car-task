package core.ksv;

public class CarDoor {
    private boolean isDoorOpen;
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
