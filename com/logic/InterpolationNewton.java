package com.logic;


import java.util.ArrayList;

public abstract class InterpolationNewton {

    double[] x;
    ArrayList<Double> y;
    int n;

    double h;

    ArrayList<ArrayList<Double>> delta_y;

    ArrayList<Double> a;

    public void setX(double[] x) {
        this.x = x;
    }
    public void setY(ArrayList<Double> y) {
        this.y = y;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void start() {
        h = x[1] - x[0];
        countDelta();
        setA();
    }

    abstract void countDelta();
    abstract void setA();

    public abstract String getKey();

    public double p(double x) {
        start();
        return 0;
    }
}