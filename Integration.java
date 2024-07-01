package Math;
import java.util.function.DoubleUnaryOperator;

public class Integration {
    public static void main(String[] args) {
        double a = 0;
        double b = 22/7;
        double n = 6;
        double h = (b-a)/n;
        Simpson s = new Simpson(a,b,n);
        Trapezodial t = new Trapezodial(a,b,n);

        DoubleUnaryOperator func = (double x) -> (Math.sin(x));
//
        System.out.println(h);
        s.displayXvalues(h);
        System.out.println();
        s.displayYvalues(h,func);

        double ans = s.calcSimpson1by3(h,func);
        System.out.println("\nSimpson 1/3\n"+"Ans:"+ans);
//
//        System.out.println(h);
//        t.displayXvalues(h);
//        System.out.println();
//        t.displayYvalues(h,func);
//
//        double ans1 = t.calcTrapezodial(h,func);
//        System.out.println("\n Trapezoidal\n"+"Ans:"+ans1);

    }
}
