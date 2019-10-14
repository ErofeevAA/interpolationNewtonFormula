package com.logic;

import com.util.Factorial;

import java.util.ArrayList;

public class Back extends InterpolationNewton {

    @Override
    public String getKey() {
        return "Interpolated back";
    }

    public Back() {
        delta_y = new ArrayList<>();
    }

    @Override
    void setA() {
        super.setA();
        a.add(delta_y.get(0).get(n));
        for (int i = 1; i <= n ; i++) {
            a.add(delta_y.get(i).get(n - i) / (Factorial.take(i) * Math.pow(h, i)));
        }
    }

    @Override
    public double p(double x) {
        super.p(x);
        double p = 0;
        for (int i = 0; i <= n; i++) {
            double mem = a.get(i);
            for (int j = n; j > n - i; j--) {
                double dx = (x - this.x[j]);
                mem *= dx;
            }
            p += mem;
        }
        return p;
    }
}
