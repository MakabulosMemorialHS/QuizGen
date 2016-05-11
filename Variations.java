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

	fout.println("\\documentclass[12pt,twocolumn]{article}\n"
	    + "\\usepackage{palatino}\n"
	    + "\\usepackage{amsmath,amssymb,amsfonts}\n"
	    + "\\advance\\textheight by 1 in\n"
	    + "\\advance\\voffset by -1 in\n"
	    + "\\begin{document}\n"
	    + "\\twocolumn [\n"
	    + "    \\centerline {\\Large \\textbf{Algebra Drills}}\n"
	    + "    \\centerline{\\textbf{Variation Problems I}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n"
            + "Given that $y$ varies directly with $x$, find (a) the constant of variation,\n"
            + "(b) the equation that relates $x$ and $y$, (c) the value of $y$ given $x = \\alpha$\n\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 20; ++k) {
           System.out.println("Creating problem number " + k);

	   int a = rgen.nextInt(50) + 1; a = 25 - a; if (a == 0) a = 5;
           int b = rgen.nextInt(50) + 1; b = 25 - b; if (b == 0) b = 3; 
           int c = rgen.nextInt(100) + 1; c = 50 - c; if (c == 0) c = 6; 

	   fout.format("\\item $y = %d$ when $x = %d$, $\\alpha = %d$\n",
                 a, b, c);

           // Now the solution.
    
           // The constant of variation is k

           int knumer = a;    // Numerator of k
           int kdenom = b;    // Denominator of k
           int gcf    = Variations.GCF(knumer, kdenom);
           String signum = " ";
           if (knumer * kdenom < 0) signum = "-";
           int kfracx  = Math.abs(knumer/gcf);
           int kfracy  = Math.abs(kdenom/gcf);

           // Value of y when x = alpha
           int alphanumer = c * knumer;
           int alphadenom = kdenom;
           gcf    = Variations.GCF(alphanumer, alphadenom);
           String alphasignum = " ";
           if (alphanumer * alphadenom < 0) alphasignum = "-";
           int alphafracx  = Math.abs(alphanumer/gcf);
           int alphafracy  = Math.abs(alphadenom/gcf);


           answerKey = answerKey + 
               "\\item $k = "
               + signum
               + kfracx 
               + "/"
               + kfracy + "$"
               + ";  $y(\\alpha) = " 
               + alphasignum
               + alphafracx + "/" + alphafracy + "$\n\n";
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


    /* ************************************************************************
     * Set 02
     * ***********************************************************************/

    public static void Set02() {

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
	    + "    \\centerline{\\textbf{Rational Equations I}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n");

       // Now generate ten random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       int k = 0;
       while (k < 24) {

           System.out.println("Creating problem number " + k);

	   int a = rgen.nextInt(24) + 1; a = 12 - a; if (a == 0) a = 1;
           int b = rgen.nextInt(24) + 1; b = 12 - b; if (b == 0 || Math.abs(b) == 1) b = 3; 
           int c = rgen.nextInt(24) + 1; c = 12 - c; if (c == 0) c = -2; 
           int d = rgen.nextInt(24) + 1; d = 12 - d; if (d == 0) d = -5; 
           int e = rgen.nextInt(24) + 1; e = 12 - e; if (e == 0 || Math.abs(e) == 1) e = 5; 
           int f = rgen.nextInt(24) + 1; f = 12 - f; if (f == 0) f = 6; 
           int g = rgen.nextInt(24) + 1; g = 12 - g; if (g == 0) g = 9; 
           int h = rgen.nextInt(24) + 1; h = 12 - h; if (h == 0) h = -8; 

           int discriminator = g*f - c*h;

           if (discriminator == 0) continue;

           k = k + 1;
  
           System.out.format("Values selected are %d, %d, %d, %d, %d, %d, %d, %d\n", a, b, c, d, e, f, g, h);

           // Note that we are not using d and e yet.

           fout.format("\\item\n"
       	       + "\\begin{displaymath}\n"
	       + "\\frac{%d}{x + %d} + \\frac{%d}{%d} = \\frac{%d}{%d}\n"
	       + "\\end{displaymath}\n"
	       + "\n", a, b, c, f, g, h);
        

           // Now the solution.

           int xnumer = a*h*f - b*discriminator;    // Numerator of the solution.
           int xdenom = discriminator;         // Denominator of the solution.
           String signum = " ";
           if (xnumer * xdenom < 0) signum = "-";
           int gcf    = LinearEquations.GCF(xnumer, xdenom);
           int fracx  = Math.abs(xnumer/gcf);
           int fracy  = Math.abs(xdenom/gcf);
           int wholepart = 0;
           int fracpart = fracx;

           if (fracx > fracy) {          // Also get the mixed form.
               wholepart = fracx / fracy;
               fracpart  = fracx % fracy;
           }

           answerKey = answerKey + "\\item $x = "
               + signum
               + "\\frac{" 
               + fracx 
               + "}{"
               + fracy
               + "} = " 
               + signum
               + wholepart 
               + "\\frac{" + fracpart + "}{" + fracy + "}$\n\n";
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
