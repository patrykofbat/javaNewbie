package Lab2;

public class Punkt3D extends Punkt2D {
    private double z;

    Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Punkt3D point) {
        return Math.sqrt(Math.pow(getX() - point.getX(), 2) + Math.pow(getY() - point.getY(), 2) + Math.pow(getZ() - point.getZ(), 2));
    }

    @Override
    public String toString() {
        return "x: " + getX() + " y: " + getY() + " z: " + getZ();
    }
}
