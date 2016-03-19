/* ****************************************************************************
 * QuadraticEqn.java
 *
 * Create quadratic equations. The output is sent to a LaTeX file
 * named temp.tex.
 *
 * Written by Robert Pascual/
 *
 * ****************************************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class QuadraticEqn {

    public static int GCF(int a, int b) {
        /* a and b should both be positive integers, otherwise
           this function won't work. */

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


    /* Problem Set 1 of quadratic equations involve quadratic equations with
       rational roots. */

    public static void Set01() {

        // Open the target file and write out the TeX header.

        PrintWriter fout = null;
        try {fout = new PrintWriter(new FileOutputStream("temp.tex"));}
        catch (FileNotFoundException e) {/* err handler here. */};

	fout.println("\\documentclass[12pt,twocolumn]{article}\n"
	    + "\\usepackage{palatino}\n"
	    + "\\usepackage{amsmath,amssymb,amsfonts}\n"
	    + "\\advance\\textheight by 1 in\n"
	    + "\\advance\\voffset by -1 in\n"
	    + "\\begin{document}\n"
	    + "\\twocolumn [\n"
	    + "    \\centerline {\\Large \\textbf{Algebra Drills}}\n"
	    + "    \\centerline{\\textbf{Quadratic Equations I}}\n"
            + "    \\centerline{\\textbf{Solve by factoring}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 20; ++k) {
           System.out.println("Creating problem number " + k);

           /* We shall create quadratic equations with the form (ax + b)(cx + d) = 0.
              This expands to acx^2 + (bc + ad)x + bd = 0 */
     
           int a = rgen.nextInt(20) + 1;   /* Will be scaled to the range (-10, 10) */
           int b = rgen.nextInt(50) + 1;   /* (-25, 25) */
           int c = rgen.nextInt(20) + 1;   /* (-10, 10) */
           int d = rgen.nextInt(50) + 1;   /* (-25, 25) */

           /* Now scaling */
           a = a - 10;
           b = b - 25;
           c = c - 10;
           d = d - 25;

           /* None of the variables above must be a zero! So we fix,
              if it does, by converting it to a 1. */

           if (a == 0) a = 1;
           if (b == 0) b = 1;
           if (c == 0) c = 1;
           if (d == 0) d = 1;
 
           /* ASSERT: None of a, b, c, d is zero. */
           /* Given the above values, the following would be the coefficients. */

           int A = a*c;
           int B = b*c + a*d;
           int C = b*d;

           /* ASSERT: A, C cannot be zero. B might. */

           /* Signs of B, and C. */
           String signB, signC;

           if (B < 0) signB = " - ";
           else signB =  " + ";

           if (C < 0) signC = " - ";
           else signC = " + ";

           /* ASSERT: signB and signC are not empty. */

	   fout.println("\\item\n"
	       + "\\begin{displaymath}\n"
	       + A + "x^2" 
               + signB
               + Math.abs(B) + "x"
               + signC
               + Math.abs(C)
               + " = 0\n"
	       + "\\end{displaymath}\n"
	       + "\n");

           /* Now for the solutions. There shall be two solutions for each quadratic
              equation. Naturally. */

          /* First solution */

           int xnumer = Math.abs(b);         // Numerator of the solution.
           int xdenom = Math.abs(a);         // Denominator of the solution.
           int gcf    = QuadraticEqn.GCF(xnumer, xdenom);
      
           /* Determine the sign of this solution */
           if (-1 * a * b > 0) {
	       answerKey = answerKey + "\\item $x = \\frac{" 
		   + xnumer/gcf 
		   + "}{"
		   + xdenom/gcf
		   + "}$, ";
           }
           else {
	       answerKey = answerKey + "\\item $x = -\\frac{" 
		   + xnumer/gcf 
		   + "}{"
		   + xdenom/gcf
		   + "}$, ";
          }

          /* Second solution */

           xnumer = Math.abs(d);         // Numerator of the solution.
           xdenom = Math.abs(c);         // Denominator of the solution.
           gcf    = QuadraticEqn.GCF(xnumer, xdenom);

           /* Choose the form of the solution depending on the sign. */

           if (-1 * a * b > 0) {
	       answerKey = answerKey + "$x = \\frac{" 
		   + xnumer/gcf 
		   + "}{"
		   + xdenom/gcf
		   + "}$\n\n";
           }
           else {
	       answerKey = answerKey + "$x = -\\frac{" 
		   + xnumer/gcf 
		   + "}{"
		   + xdenom/gcf
		   + "}$\n\n";
          }
       }
       
       // Close the enumerate environment of the problem set

       fout.println("\\end{enumerate}\n");

       // Start print of the answer key.
       // The header ...

       fout.println("\\vfill\\eject\n"
           + "\\twocolumn[\n"
           + "\\centerline{\\Large\\textbf{Answer key}}\n"
           + "\\vspace {0.5 in}\n"
           + "]\n\n");

       // Here goes the answers ...

       fout.println(
          "\\begin{enumerate}\n"
          + "\\setlength\\itemsep{0.25in}\n"
          + answerKey
          + "\\end{enumerate}\n"
          + "\\end{document}\n");

       // And close the output file.

       fout.close();
    }
}
