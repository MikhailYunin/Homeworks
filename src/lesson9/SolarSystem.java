package lesson9;

public enum SolarSystem {
    MERCURY(0.055,0.382,0.38), VENUS(0.815, 0.949, 0.72),
    EARTH(1,1,1), MARS(0.107,0.53,1.52),
    JUPITER(318,11.2,5.2), SATURN(95,9.41,9.54),
    URANUS(14.6,3.98,19.22), NEPTUNE(17.2,3.81,30.06);

    private double m, r, orbit;

    SolarSystem(double m, double r, double orbit) {
        this.m = m*5.974*Math.pow(10,23);
        this.r = r*6378.1;
        this.orbit = orbit*147098290;
    }

    public double getM() {
        return m;
    }

    public double getR() {
        return r;
    }

    public double getOrbit() {
        return orbit;
    }


}
