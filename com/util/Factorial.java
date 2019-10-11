package com.util;

public abstract class Factorial {
    public static int take(int n) {
        int res = n;
        for (int i = n - 1; i > 0; i--) {
            res *= i;
        }
        return res;
    }
}