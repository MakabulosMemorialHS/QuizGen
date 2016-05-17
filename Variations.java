/* **************************************************
 * Variations.java
 *
 * Simple Variatonal Problem Drills.
 *
 * Written by Robert Pascual/
 *
 * *************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class Variations {

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

    public static void Set01() {

        // Open the target file and write out the TeX header.

        PrintWriter fout = null;
        try {fout = new PrintWriter(new FileOutputStream("temp.tex"));}

        catch (FileNotFoundException e) {/* err handler here. */};

	fout.println("\\documentclass[12pt,twocolumn,legalpaper]{article}\n"
	    + "\\usepackage{palatino}\n"
	    + "\\usepackage{amsmath,amssymb,amsfonts}\n"
	    + "\\advance\\textheight by 1 in\n"
	    + "\\advance\\voffset by -1 in\n"
	    + "\\begin{document}\n"
	    + "\\twocolumn [\n"
	    + "    \\centerline {\\Large \\textbf{Algebra Drills}}\n"
	    + "    \\centerline{\\textbf{Variation Problems I}}\n"
	    + "    \\vspace {0.5 in}\n"
            + "Given $x,y$ find $\\kappa$, direct variation, $\\lambda$, inverse variation,\n"
            + "$y_d = \\kappa \\alpha$ and $y_i = \\lambda/\\alpha$.\n\n"
	    + "\\vspace {0.5 in}\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 40; ++k) {
           System.out.println("Creating problem number " + k);

	   int yval = rgen.nextInt(50) + 1; yval = 25 - yval; if (yval == 0) yval = 5;
           int xval = rgen.nextInt(50) + 1; xval = 25 - xval; if (xval == 0) xval = 3; 
           int alpha = rgen.nextInt(100) + 1; alpha = 50 - alpha; if (alpha == 0) alpha = 6; 

	   fout.format("\\item $y = %d$ when $x = %d$, $\\alpha = %d$\n",
                 yval, xval, alpha);

           // Now the solution.
    
           // The constant of direct variation is kappa (assume Fraction)
           // The constant of indirect variation is lambda (assume integer)

           Fraction kappa = new Fraction(yval, xval);
           int lambda = yval*xval;
           Fraction Yd = new Fraction(kappa.Numerator() * alpha, kappa.Denominator());
           Fraction Yi = new Fraction(lambda, alpha);
    
           String signum = "";
           if (kappa.Sign() < 0) signum = "-";

           String yiSignum = "";
           if (Yi.Sign() < 0) yiSignum = "-";
 
           answerKey = answerKey + 
               "\\item $\\kappa = "
               + signum
               + kappa.Numerator()
               + "/"
               + kappa.Denominator() + "$"
               + ";  $\\lambda = " 
               + lambda + "$;\n"
               + "$y_d = "
               + Yd.SignumString()
               + Yd.Numerator() + "/"
               + Yd.Denominator() + "$;\n"
               + "$y_i = "
               + Yi.SignumString() + Yi.Numerator()
               + "/"
               + Yi.Denominator()
               + "$\n\n";
       }
       
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
          + "%%%% \\setlength\\itemsep{0.25in}\n"
          + answerKey
          + "\\end{enumerate}\n"
          + "\\end{document}\n");

       // And close the output file.

       fout.close();
    }


    /* ************************************************************************
     * Set 02
     * ***********************************************************************/

    public static void Set02() {

        PrintWriter fout = null;
        try {fout = new PrintWriter(new FileOutputStream("temp.tex"));}
        catch (FileNotFoundException e) {/* err handler here. */};

	fout.println("\\documentclass[12pt,twocolumn,legalpaper]{article}\n"
	    + "\\usepackage{palatino}\n"
	    + "\\usepackage{amsmath,amssymb,amsfonts}\n"
	    + "\\advance\\textheight by 1 in\n"
	    + "\\advance\\voffset by -1 in\n"
	    + "\\begin{document}\n"
	    + "\\twocolumn [\n"
	    + "    \\centerline {\\Large \\textbf{Algebra Drills}}\n"
	    + "    \\centerline{\\textbf{Variation Problems II}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n");

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       int itemcount  = 0;
       while (itemcount < 18) {

           System.out.println("Creating problem number " + itemcount);

           // Generate a random integer and create a direct variation problem if integer is even.
	   int a = rgen.nextInt(100) + 1;
           int b = rgen.nextInt(100) + 1; b = 50 - b; if (b == 0) b = 3; 
           int c = rgen.nextInt(50) + 1; c = 25 - c; if (c == 0) c = 2; 

           if (a % 2 == 0) {
               // Generate a direct variation problem.
               Fraction kappa = new Fraction(b, c);

               fout.format("\\item \\begin{tabular}[c]{cc}\n"
                         + "$x$  & $y$\\\\"
                         + "\\hline\n");

               for (int sample = 0; sample < 3; ++sample) {
                   int d = rgen.nextInt(100) + 1; d = 50 - d; if (d == 0) d = 12;
                   Fraction spoint = new Fraction(d, 1);
                   spoint = spoint.multiplyBy(kappa);
                   fout.format("%d  &  %s\\\\\n", d, spoint.toString());
               }
	       int d = rgen.nextInt(100) + 1; d = 50 - d; if (d == 0) d = 12;
	       Fraction spoint = new Fraction(d, 1);
	       spoint = spoint.multiplyBy(kappa);
	       fout.format("%d  &  ??\\\\\n", d);
               
               fout.format("\\hline\n"
                         + "\\end{tabular}\n");
               answerKey = answerKey 
                         + String.format("\\item $y = %s$ (linear)\n", spoint.toString());
           }
           else {
               // Generate an inverse variation problem
               Fraction lambda = new Fraction(b, c);
               fout.format("\\item \\begin{tabular}[c]{cc}\n"
                         + "$x$  & $y$\\\\"
                         + "\\hline\n");

               for (int sample = 0; sample < 3; ++sample) {
                   int d = rgen.nextInt(50) + 1; d = 25 - d; if (d == 0) d = 12;
                   Fraction spoint = new Fraction(1,d);
                   spoint = spoint.multiplyBy(lambda);
                   fout.format("%d  &  %s\\\\\n", d, spoint.toString());
               }
	       int d = rgen.nextInt(60) + 1; d = 30 - d; if (d == 0) c = 12;
	       Fraction spoint = new Fraction(1,d);
	       spoint = spoint.multiplyBy(lambda);
	       fout.format("%d  &  ??\\\\\n", d);
               
               fout.format("\\hline\n"
                         + "\\end{tabular}\n");
               answerKey = answerKey 
                         + String.format("\\item $y = %s$ (inverse)\n", spoint.toString());

           }

           itemcount = itemcount + 1;
       }
       
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
