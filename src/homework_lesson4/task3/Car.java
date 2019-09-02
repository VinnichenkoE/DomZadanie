package homework_lesson4.task3;

public class Car {
    String model;
    private double coordX;
    double coordY;
    double distance;
    double fuelСonsumption;
    double fuelInTank;

    public Car(String model, double coordX, double coordY, double fuelInTank, double fuelСonsumption){
        this.model = model;
        this.coordX = coordX;
        this.coordY = coordY;
        this.fuelInTank = fuelInTank;
        this.fuelСonsumption = fuelСonsumption;
    }
    public String GetModel(){
        return model;
    }
    public double GetCoordX(){
        return coordX;
    }
    public double GetCoordY(){
        return coordY;
    }
    public void SetCoordX(double coordX){
        this.coordX=coordX;
    }
    public void SetCoordY(double coordY){
        this.coordY=coordY;
    }
    public void takeCoord(){
        System.out.println("Координата Х: "+coordX);
        System.out.println("Координата У: "+coordY);
    }
    public void newcoord(double newX, double newY){
        distance = Math.sqrt(((newX-coordX)*(newX-coordX))+((newY-coordY)*(newY-coordY)));
        fuelInTank -=(distance*fuelСonsumption);
        if (fuelInTank>0){
            this.coordX=newX;
            this.coordY=newY;
            System.out.println("Пройденная дистанция: "+distance);
            System.out.println("Расход составил: "+(distance*fuelСonsumption));
            System.out.println("В баке осталось: " + fuelInTank);

        }
        else{
            System.out.println("Не доедем, недостаточно топлива!!!");
        }

    }

}
