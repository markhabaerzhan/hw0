package edu.narxoz.galactic.bodies;
public abstract class CelestialBody {
    private String name;
    private double x;
    private double y;
    protected CelestialBody(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public String getName(){
        return name;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distanceTo(CelestialBody other){
        if(other==null){
            throw new IllegalArgumentException("other can't be null");
        }
        double x1 = other.x -x;
        double y1 = other.y -y;
        return Math.sqrt(x1*x1+y1*y1);
    }
}