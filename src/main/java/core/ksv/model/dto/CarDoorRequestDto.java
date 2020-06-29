package core.ksv.model.dto;

public class CarDoorRequestDto {
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        isWindowOpen = windowOpen;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }
}
