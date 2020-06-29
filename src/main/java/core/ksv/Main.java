package core.ksv;

import core.ksv.config.AppConfig;
import core.ksv.model.Car;
import core.ksv.model.CarDoor;
import core.ksv.model.CarWheel;
import core.ksv.service.CarDoorService;
import core.ksv.service.CarService;
import core.ksv.service.CarWheelService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext APPLICATION_CONTEXT
            = new AnnotationConfigApplicationContext(AppConfig.class);
    private static final CarDoorService CAR_DOOR_SERVICE
            = APPLICATION_CONTEXT.getBean(CarDoorService.class);
    private static final CarWheelService CAR_WHEEL_SERVICE
            = APPLICATION_CONTEXT.getBean(CarWheelService.class);
    private static final CarService CAR_SERVICE
            = APPLICATION_CONTEXT.getBean(CarService.class);

    public static void main(String[] args) {
        final var door1 = new CarDoor();
        final var door2 = new CarDoor();
        final var door3 = new CarDoor();
        door1.openWindow();
        CAR_DOOR_SERVICE.add(door1);
        CAR_DOOR_SERVICE.add(door2);
        door1.openOrCloseWindow();
        CAR_DOOR_SERVICE.update(door1);
        CAR_DOOR_SERVICE.delete(door3);
        CAR_DOOR_SERVICE.getAll().forEach(System.out::println);

        final var wheel1 = new CarWheel();
        final var wheel2 = new CarWheel();
        final var wheel3 = new CarWheel();
        final var wheel4 = new CarWheel();
        wheel3.wearOutTire(15);
        wheel4.wearOutTire(20);
        CAR_WHEEL_SERVICE.add(wheel1);
        CAR_WHEEL_SERVICE.add(wheel2);
        CAR_WHEEL_SERVICE.add(wheel3);
        CAR_WHEEL_SERVICE.add(wheel4);
        wheel1.wearOutTire(90);
        CAR_WHEEL_SERVICE.update(wheel1);
        CAR_WHEEL_SERVICE.delete(wheel2);
        CAR_WHEEL_SERVICE.getAll().forEach(System.out::println);

        final var car = new Car();
        car.setAcceleration(4);
        car.setCapacity(5);
        car.setNewCarMaxSpeed(280);
        car.setCurrentNumberOfPassengers(2);
        car.setEngineType("diesel");
        car.setDoors(new CarDoor[]{door1, door2});
        car.setWheels(new CarWheel[]{wheel1, wheel3, wheel4});
        car.setCurrentSpeed(20);
        CAR_SERVICE.add(car);
        car.addPassenger();
        CAR_SERVICE.update(car);
        CAR_SERVICE.getAll().forEach(System.out::println);
        CAR_SERVICE.delete(car);
    }
}
