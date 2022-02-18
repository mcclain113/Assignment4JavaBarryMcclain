package edu.wctc;


import java.io.Serializable;
import java.util.*;

public class Room implements Serializable {
    private List<Wall> wallList= new ArrayList<>();

    public Room(double width, double length, double height){

        Wall wallN =  new Wall(width,height);
        Wall wallS =  new Wall(width,height);
        Wall wallE =  new Wall(length,height);
        Wall wallW =  new Wall(length,height);

        wallList.add(wallN);
        wallList.add(wallS);
        wallList.add(wallE);
        wallList.add(wallW);

    }

    public double getArea() {
        int sum = 0;
        for (Integer i = 0; i< wallList.size(); i++) {
            sum += wallList.get(i).getArea();
        }
        return sum;
    }

    public String toString(){

        return String.valueOf(getArea());
    }



}
