package com.draw;


import com.logic.Back;
import com.logic.Forward;
import com.logic.InterpolationNewton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Scanner;

public class Window extends JFrame {
    private Forward forward;
    private Back back;

    private double[] x;
    private ArrayList<Double> y;
    private int n;

    private Scanner scanner;

    public Window() {
        scanner = new Scanner(System.in);

        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        forward = new Forward();
        back = new Back();

        initVariables();
        initClass(forward);
        initClass(back);

        draw();

    }

    private XYSeries getSeries(InterpolationNewton newton) {
        XYSeries res = new XYSeries(newton.getKey());
        for (double i = -5; i < 5; i+=0.1) {
            res.add(i, newton.p(i));
        }
        return res;
    }

    /*private XYSeries getSeries() {
        XYSeries res = new XYSeries("orig");
        for (double i = -5; i < 5; i+=0.1) {
            res.add(i, i*i);
        }
        return res;
    }*/

    private void draw(){
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(getSeries(forward));
        collection.addSeries(getSeries(back));
        //collection.addSeries(getSeries());
        JFreeChart chart = ChartFactory
                .createXYLineChart("Result", "x", "y",
                        collection,
                        PlotOrientation.VERTICAL,
                        true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(700, 400);
        add(chartPanel);
    }

    private void initVariables() {
        System.out.println("Input degree of polynomial");
        n = scanner.nextInt();
        x = new double[n + 1];
        y = new ArrayList<>();
        System.out.println("Input number of coordinate");
        int num  = scanner.nextInt();
        System.out.println("Input coordinate");
        for (int i = 0; i < num; i++) {
            x[i] = scanner.nextDouble();
            y.add(scanner.nextDouble());
        }
    }

    private void initClass(InterpolationNewton newton) {
        newton.setX(x);
        newton.setY(y);
        newton.setN(n);
    }
}
