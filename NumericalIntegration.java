package Math;
import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;

class Simpson extends Interval{
    private double n;
    public Simpson(double a, double b, double n){
        super(a,b);
        this.n = n;
    }

    protected ArrayList<Double> generateValues(double step){
        ArrayList<Double> X = new ArrayList<>();
        X.add(super.getA());
        while (n != 0){
            X.add(X.get(X.size()-1)+step);
            n--;
        }
        return X;
    }
    private double calcSimp1by3(ArrayList<Double> X, DoubleUnaryOperator function, double h){
        ArrayList<Double> Y = new ArrayList<>();
        for (Double x : X) {
            double y = function.applyAsDouble(x);
            Y.add(y);
        }
        double o = 0.0;
        double e = 0.0;
        for (int j = 1; j < (Y.size() - 1); j++) {
            if(Y.indexOf(Y.get(j))%2 == 0)
                e += Y.get(j);
            else
                o += Y.get(j);
        }

        double v = Y.getFirst() + Y.getLast() + 2 * e + 4 * o;
        return (v * h) / 3;
    }
    public double calcSimpson1by3(double h, DoubleUnaryOperator func){
        ArrayList<Double> X = generateValues(h);
        return calcSimp1by3(X,func,h);
    }
    public void displayXvalues(double h){
        super.displayXvalues(h);
    }
    public void displayYvalues(double h, DoubleUnaryOperator function){
        super.displayYvalues(h,function);
    }

}
class Trapezodial extends Interval{
    private double n;
    public Trapezodial(double a, double b, double n) {
        super(a, b);
        this.n = n;
    }

    public double calcTrapezodial(double h,DoubleUnaryOperator func){
       return super.calcI(h,func);
    }

    @Override
    public void displayXvalues(double h) {
        super.displayXvalues(h);
    }

    @Override
    public void displayYvalues(double h, DoubleUnaryOperator function) {
        super.displayYvalues(h, function);
    }
}
class Simpson3by8 extends Simpson{

    public Simpson3by8(double a, double b, double n) {
        super(a, b, n);
    }
    private double calcSimp3by8(ArrayList<Double> X, DoubleUnaryOperator function, double h){
        ArrayList<Double> Y = new ArrayList<>();
        for (Double x : X) {
            double y = function.applyAsDouble(x);
            Y.add(y);
        }
        double r = 0.0;
        double m3 = 0.0;
        for (int j = 1; j < (Y.size() - 1); j++) {
            if(Y.indexOf(Y.get(j))%3 == 0)
                m3 += Y.get(j);
            else
                r += Y.get(j);
        }

        double v = Y.getFirst() + Y.getLast() + 2 * m3 + 3 * r;
        return ((v * h) * 3)/8 ;
    }
    public double calcSimpson3by8(double h, DoubleUnaryOperator func){
        ArrayList<Double> X = generateValues(h);
        return calcSimp3by8(X,func,h);
    }

    @Override
    public void displayXvalues(double h) {
        super.displayXvalues(h);
    }

    @Override
    public void displayYvalues(double h, DoubleUnaryOperator function) {
        super.displayYvalues(h, function);
    }
}
