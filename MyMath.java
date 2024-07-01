package Math;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class MyMath {
    public static void printLine(){
    System.out.println("_____________________");
    }
    public static void main(String[] args) {
        // this is to calculate integration using Romeberg integration
        // For this we need I1, I2, I3
        // For I1, we calculate X0, X1...Xn until upper limit is found
        // First find h1, h1 = b - a / 2. here a is lower limit and b is upper limit
        // For X0, X0 = a. here a is lower limit
        // For X1, X2 = a + h1
        // For X2, X2 = a + 2h1
        // For Xn, Xn = b
        // And then, we calculate Y0, Y1... Yn
        // For Y0, Y0 = f(X0)
        // For YN, YN = f(Xn)
        // Then, we calculate I1, using trapezoidal rule
        // I1 = h1/2 [ Y0 + YN + 2( Y1 + Y(N-1) ) ]

        // Similarly for I2, I3
        // h2 = h1/2 for I2,  h3 = h2/2 for I3

        // Now, we need to find I1new & I2new
        // I1new = 1/3 [ 4*I2 - I1 ]
        // I2new = 1/3 [ 4*I3 - I2 ]

        // Finally, we can find I
        // I = 1/3 [ 4*I2new - I1new ]

        double a = -1;
        double b = 1;
        double h1 = (b-a)/2;
        double h2 = h1/2;
        double h3 = h2/2;

        DoubleUnaryOperator func = (double x) -> Math.exp(x)*Math.sin((x));

        Interval x = new Interval(a,b);
        printLine();
        System.out.println("For I1,");
        System.out.println("h1: "+h1);
        printLine();
        System.out.println("Now,");
        x.displayXvalues(h1);
        printLine();
        System.out.println("Now,");
        x.displayYvalues(h1,func);
        printLine();
        System.out.println();
        double I1 = x.calcI(h1,func);
        printLine();
        System.out.println("I1:"+I1);
        printLine();

        System.out.println();
        printLine();
        System.out.println("For I2,");
        System.out.println("h2: "+h2);
        printLine();
        System.out.println("Now,");
        x.displayXvalues(h2);
        printLine();
        System.out.println("Now,");
        x.displayYvalues(h2,func);
        printLine();
        System.out.println();
        double I2 = x.calcI(h2,func);
        printLine();
        System.out.println("I2:"+I2);
        printLine();

        System.out.println();
        printLine();
        System.out.println("For I3,");
        System.out.println("h3: "+h3);
        printLine();
        System.out.println("Now,");
        x.displayXvalues(h3);
        printLine();
        System.out.println("Now,");
        x.displayYvalues(h3,func);
        printLine();
        System.out.println();
        double I3 = x.calcI(h3,func);
        printLine();
        System.out.println("I3:"+I3);
        printLine();

        System.out.println();
        double I1new = (4*I2 - I1)/3;
        printLine();
        System.out.println("I1new: "+I1new);
        printLine();

        System.out.println();
        double I2new = (4*I3 - I2)/3;
        printLine();
        System.out.println("I2new: "+I2new);
        printLine();

        System.out.println();
        double I = (4*I2new - I1new)/3;
        printLine();
        System.out.println("I: "+I);
        printLine();


    }
}
