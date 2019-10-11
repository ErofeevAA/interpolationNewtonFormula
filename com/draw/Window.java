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

public class Window extends JFrame {
    private Forward forward;
    private Back back;

    private double[] x;
    private ArrayList<Double> y;

    public Window() {
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        forward = new Forward();
        back = new Back();

        initVariables();
        initClass(forward);
        initClass(back);

        //back.start();

        draw();

    }

    private XYSeries getSeries(InterpolationNewton newton) {
        XYSeries res = new XYSeries(newton.getKey());
        for (double i = -5; i < 5; i+=0.1) {
            res.add(i, newton.p(i));
        }
        return res;
    }

    private void draw(){
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(getSeries(forward));

        JFreeChart chart = ChartFactory
                .createXYLineChart("Result", "x", "y",
                        collection,
                        PlotOrientation.VERTICAL,
                        true, false, false);
        add(new ChartPanel(chart));
    }

    private void initVariables() {
        x = new double[]{300, 400, 500, 600};
        y = new ArrayList<>();
        y.add(52.88);
        y.add(65.61);
        y.add(78.07);
        y.add(99.24);
    }

    private void initClass(InterpolationNewton newton) {
        newton.setX(x);
        newton.setY(y);
        newton.setN(3);
    }
}
