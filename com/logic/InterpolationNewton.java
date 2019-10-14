package com.logic;


import java.util.ArrayList;

public abstract class InterpolationNewton {

    double[] x;
    private ArrayList<Double> y;

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

    private void countDelta() {
        delta_y.add(y);
        for (int i = 1; i < y.size(); i++) {
            delta_y.add(new ArrayList<>());
            for (int j = 1; j <= y.size() - i; j++) {
                delta_y.get(i).add(delta_y.get(i - 1).get(j) - (delta_y.get(i - 1).get(j - 1)));

                delta_y.get(i).set(j - 1, delta_y.get(i).get(j - 1));
            }
        }
    }

    void setA() {
        a = new ArrayList<>();
    }

    public abstract String getKey();

    public double p(double x) {
        start();
        return 0;
    }
}