package edu.wctc;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<Room>();


    public void addRoom(double length, double width, double height){
       Room newRoom = new Room(width, length, height);

       roomList.add(newRoom);

    }

    public String toString(){
        if (roomList.isEmpty()){
            return "There are no rooms";
        }
        else {
        String sum = "";

            for (Integer i = 0; i< roomList.size(); i++)
        {
            int j = i + 1;
            sum += "Room" + " " + j +"." + " " + roomList.get(i).toString() + " ";//roomList.get(roomList.indexOf(i)).toString() + " ";

        }
        return sum;}
    }

}
