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
        assertEquals(24, Factorial.take(4));
    }

    @Test
    public void takePolynomialForward() {
        Forward forward = new Forward();
        forward.setX(new double[]{-2, -1, 0, 1});
        ArrayList<Double> y = new ArrayList<>();
        y.add(4.0);
        y.add(1.0);
        y.add(0.0);
        y.add(1.0);
        forward.setY(y);
        forward.setN(3);
        assertEquals((int) 4.0, (int) forward.p(2));
    }

    @Test
    public void takePolynomialBack() {
        Back back = new Back();
        back.setX(new double[]{-2, -1, 0, 1});
        ArrayList<Double> y = new ArrayList<>();
        y.add(4.0);
        y.add(1.0);
        y.add(0.0);
        y.add(1.0);
        back.setY(y);
        back.setN(3);
        assertEquals((int) 4.0, (int) back.p(2));
    }
}