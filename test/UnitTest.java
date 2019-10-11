package test;

import com.logic.Back;
import com.logic.Forward;
import com.util.Factorial;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void takeFactorial() {
        assertEquals(1, Factorial.take(1));
        assertEquals(24, Factorial.take(4));
    }

    @Test
    public void takePolynomialForward() {
        Forward forward = new Forward();
        forward.setX(new double[]{300, 400, 500, 600});
        ArrayList<Double> y = new ArrayList<>();
        y.add(52.88);
        y.add(65.61);
        y.add(78.07);
        y.add(99.24);
        forward.setY(y);
        forward.setN(3);
        assertEquals((int) 71.13, (int) forward.p(450));
    }

    @Test
    public void takePolynomialBack() {
        Back back = new Back();
        back.setX(new double[]{300, 400, 500, 600});
        ArrayList<Double> y = new ArrayList<>();
        y.add(52.88);
        y.add(65.61);
        y.add(78.07);
        y.add(99.24);
        back.setY(y);
        back.setN(3);
        assertEquals((int) 87.01, (int) back.p(550));
    }
}