package com.logic;

import java.util.ArrayList;

public class Back extends InterpolationNewton {

    @Override
    public String getKey() {
        return "Interpolated back";
    }

    public Back() {
        delta_y = new ArrayList<>();
        a = new ArrayList<>();
    }

    @Override
    void countDelta() {

    }

    @Override
    void setA() {

    }

    @Override
    public double p(double x) {
        super.p(x);
        return 0;
    }
}
