package edu.wctc;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Room implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    final List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height) {
        Wall wall1 = new Wall(length, height);
        Wall wall2 = new Wall(length, height);
        Wall wall3 = new Wall(width, height);
        Wall wall4 = new Wall(width, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea() {
        double area = 0;
        for (Wall wall : wallList)
        {
            area += wall.getArea();
        }
        return area;
    }

    public String toString() {
        return String.valueOf(getArea());
    }
}
