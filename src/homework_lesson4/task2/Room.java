package homework_lesson4.task2;

import java.awt.*;

public class Room {
    private String colorOfWall;
    private Dimentions dimentions;
    private String floorMaterial;
    private Window window;
    private Furniture[] furnitureInside;

    public Room(String colorOfWall, double width, double length, double deep, String floorMaterial, double windowLength, double windowWidth){
        this.colorOfWall= colorOfWall;
        this.dimentions = new Dimentions(width, length, deep);
        this.floorMaterial = floorMaterial;
        this.window = new Window(windowLength, windowWidth);}
    public String GetColorOfWall(){
        return colorOfWall;
        }
    public Dimentions GetDimentions(){
        return dimentions;
        }
    public String GetFloorMaterial(){
        return floorMaterial;
    }
    public Window GetWindow(){
        return window;
    }
    public void SetColorOfWall(String colorOfWall){
        this.colorOfWall=colorOfWall;
    }
    public void SetFloorMaterial(String floorMaterial){
        this.floorMaterial=floorMaterial;
    }





}
