package core.ksv;

public class CarWheel {
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
