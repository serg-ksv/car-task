package core.ksv.model.dto;

public class CarDoorResponseDto {
    private Long id;
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public Long getId() {
        return id;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        isWindowOpen = windowOpen;
    }
}
