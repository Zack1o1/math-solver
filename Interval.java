package Math;
import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;
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

class Interval {
    private double a,b;

    public Interval(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }


    private ArrayList<Double> generateValues(double step){
        ArrayList<Double> X = new ArrayList<>();
        X.add(a);
        while (X.getLast() < b)
            X.add(X.get(X.size()-1)+step);
        return X;
    }


    private void printXvalues(ArrayList<Double> X){
        int i=0;
        for(Double x:X){
            System.out.println("X"+i+": "+x);
            i++;
        }
    }
    private void printYvalues(ArrayList<Double> X, DoubleUnaryOperator function, double h){
        int i=0;
        for(Double x:X){
            double a =function.applyAsDouble(x);
            System.out.println("Y"+i+": "+ a);
            i++;
        }

    }
    private double calculateIntegral(ArrayList<Double> X, DoubleUnaryOperator function, double h) {
        ArrayList<Double> Y = new ArrayList<>();
        for (Double x : X) {
            double y = function.applyAsDouble(x);
            Y.add(y);
        }

        double m = 0.0;
        for (int j = 1; j < (Y.size() - 1); j++) {
            m += Y.get(j);
        }
        double v = Y.getFirst() + Y.getLast() + 2 * m;
        return (v * h) / 2;
    }
    public double calcI(double h, DoubleUnaryOperator func){
        ArrayList<Double> X = generateValues(h);
        return calculateIntegral(X,func,h);
    }

    public void displayXvalues(double h){
        ArrayList<Double> X = generateValues(h);
        printXvalues(X);
    }
    public void displayYvalues(double h, DoubleUnaryOperator function){
        ArrayList<Double> X = generateValues(h);
        printYvalues(X,function,h);
    }



}

