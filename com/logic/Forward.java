package com.logic;

import com.util.Factorial;

import java.util.ArrayList;

public class Forward extends InterpolationNewton {

    @Override
    public String getKey() {
        return "Interpolated forward";
    }

    public Forward() {
        delta_y = new ArrayList<>();
        a = new ArrayList<>();
    }

    @Override
    void setA() {
        super.setA();
        a.add(delta_y.get(0).get(0));
        for (int i = 1; i <= n; i++) {
            a.add(delta_y.get(i).get(0));
            a.set(i, a.get(i) / (Factorial.take(i) * Math.pow(h, i)));
        }
    }

    @Override
    public double p(double x) {
        super.p(x);
        double p = 0;
        for (int i = 0; i <= n; i++) {
            double mem = a.get(i);
            for (int j = 0; j < i; j++) {
                mem *= (x - this.x[j]);
            }
            p += mem;
        }
        return p;
    }
}