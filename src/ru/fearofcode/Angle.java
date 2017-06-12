package ru.fearofcode;

/**
 * Created by maks on 6/12/2017.
 */
public class Angle {
    public static int pointDerection(double x0, double y0, double x1, double y1){
        double angle = Math.toDegrees( Math.atan2( y1 - y0, x1 - x0) );
        if (angle < 0){
            angle += 360;
        }
        return (int)angle;
    }
}
