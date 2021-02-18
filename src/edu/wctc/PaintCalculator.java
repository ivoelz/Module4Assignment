package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.io.Serial;

public class PaintCalculator implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    final List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height) {
        Room room = new Room(length, width, height);
        this.roomList.add(room);
    }

    public String toString() {
        if (this.roomList.size() == 0)
        {
            return "No rooms yet";
        }
        else {
            String output = "";
            for (int i = 0; i < this.roomList.size(); i++)
            {
                Room room = this.roomList.get(i);
                output += "Room " + (i + 1) + " Total Area: " + room.toString() + "\n";
            }
            return output;
        }
    }
}
