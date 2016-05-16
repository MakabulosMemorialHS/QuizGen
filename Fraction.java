/* ********************************************************************
 * Fraction.java
 *
 * Methods and functions that handle fractions.
 *
 * ********************************************************************/
import java.lang.*;
import java.util.*;

public class Fraction {
    private int numerator;
    private int denominator;
    private int theSign;          // Sign of the entire fraction (-1, 1)

    public static int GCF(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
    
    public Fraction(int numer, int denom) {
        if (numer * denom < 0) theSign = -1;
        else theSign = 1;
        
        int gcf = Fraction.GCF(numer, denom);

        numerator     = Math.abs(numer/gcf);
        denominator   = Math.abs(denom/gcf);

    }

    // Accessors

    public int Numerator() {
        return numerator;
    }

    public int Denominator() {
        return denominator;
    }

    public int Sign() {
        return theSign;
    }

    public String SignumString() {
        if (theSign < 0) return "-";
        else return "";
    }
}

