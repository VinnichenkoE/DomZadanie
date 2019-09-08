package homework_lesson4.task3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("ford", 2.5, 3.0,100,5.0);
        car.takeCoord();
        car.newcoord(2.5,4.0);
        car.takeCoord();
        car.newcoord(15.0,15.0);
        car.takeCoord();
        car.newcoord(17.0,15.0);
        car.GetCoordX();
    }
}
