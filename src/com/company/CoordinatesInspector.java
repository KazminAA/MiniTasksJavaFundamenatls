package com.company;


import java.awt.geom.Point2D;

public class CoordinatesInspector {

    public Point2D coordinates(Double degrees, Double radius) {
        double radians = Math.toRadians(degrees);
        return new Point2D.Double(Math.round(radius * Math.cos(radians) * 1e10) / 1e10, Math.round(radius * Math.sin(radians) * 1e10) / 1e10);
    }
}
