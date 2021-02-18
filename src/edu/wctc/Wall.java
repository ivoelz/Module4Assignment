package edu.wctc;

import java.io.Serial;

public class Wall implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    final double width;
    final double height;

    public Wall(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.getHeight() * this.getWidth();
    }
}
