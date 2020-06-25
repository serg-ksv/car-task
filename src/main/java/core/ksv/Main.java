package core.ksv;

import core.ksv.lib.Injector;
import core.ksv.model.Car;
import core.ksv.model.CarDoor;
import core.ksv.model.CarWheel;
import core.ksv.service.CarDoorService;
import core.ksv.service.CarService;
import core.ksv.service.CarWheelService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("core.ksv");

    public static void main(String[] args) {
        final var carDoorService = (CarDoorService) INJECTOR.getInstance(CarDoorService.class);
        final var door1 = new CarDoor();
        final var door2 = new CarDoor();
        final var door3 = new CarDoor();
        door1.openWindow();
        carDoorService.add(door1);
        carDoorService.add(door2);
        door1.openOrCloseWindow();
        carDoorService.update(door1);
        carDoorService.delete(door3);
        carDoorService.getAll().forEach(System.out::println);

        final var carWheelService = (CarWheelService) INJECTOR.getInstance(CarWheelService.class);
        final var wheel1 = new CarWheel();
        final var wheel2 = new CarWheel();
        final var wheel3 = new CarWheel();
        final var wheel4 = new CarWheel();
        wheel3.wearOutTire(15);
        wheel4.wearOutTire(20);
        carWheelService.add(wheel1);
        carWheelService.add(wheel2);
        carWheelService.add(wheel3);
        carWheelService.add(wheel4);
        wheel1.wearOutTire(90);
        carWheelService.update(wheel1);
        carWheelService.delete(wheel2);
        carWheelService.getAll().forEach(System.out::println);

        final var carService = (CarService) INJECTOR.getInstance(CarService.class);
        final var car = new Car();
        car.setAcceleration(4);
        car.setCapacity(5);
        car.setNewCarMaxSpeed(280);
        car.setCurrentNumberOfPassengers(2);
        car.setEngineType("diesel");
        car.setDoors(new CarDoor[]{door1, door2});
        car.setWheels(new CarWheel[]{wheel1, wheel3, wheel4});
        car.setCurrentSpeed(20);
        carService.add(car);
        car.addPassenger();
        carService.update(car);
        carService.getAll().forEach(System.out::println);
        carService.delete(car);
    }
}
