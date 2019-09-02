package homework_lesson4.task3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("ford", 2.5, 3.0,100,5.0);
        car.takeCoord();
        car.newcoord(6.0,15.0);
        car.takeCoord();
        car.newcoord(40.0,32.5);
        car.takeCoord();
        car.GetCoordX();
    }
}
