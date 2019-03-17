package lesson4.zadanie2;

import java.lang.Math;


public class Circle{
    private double xCenter;
    private double yCenter;
    private double xCircle;
    private double yCircle;
    private double ploshad;
    private double dlina;

    public Circle (double xCenter, double yCenter, double xCircle, double yCircle){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xCircle = xCircle;
        this.yCircle = yCircle;

    }

    public double getxCenter() {
        return xCenter;
    }
    public void setxCenter(double xCenter) {
        this.xCenter = xCenter;
    }


    public double getyCenter() {
        return yCenter;
    }
    public void setyCenter(double yCenter) {
        this.yCenter = yCenter;
    }


    public double getxCircle() {
        return xCircle;
    }
    public void setxCircle(double xCircle) {
        this.xCircle = xCircle;
    }


    public double getyCircle() {
        return yCircle;
    }
    public void setyCircle(double yCircle) {
        this.yCircle = yCircle;
    }

    public double getPloshad () {
        double radius = Math.sqrt( Math.pow ( (yCircle-yCenter), 2) + Math.pow ( (xCircle-xCenter), 2) );
        ploshad = Math.PI * Math.pow(radius,2);
        return ploshad;
    }

    public double getDlinaOcruznosti () {
        double radius = Math.sqrt( Math.pow ( (yCircle-yCenter), 2) + Math.pow ( (xCircle-xCenter), 2) );
        dlina = 2 * Math.PI * radius;
        return dlina;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                ", xCircle=" + xCircle +
                ", yCircle=" + yCircle +
                '}';
    }


}

