/* **************************************************
 * RationalEqn.java
 *
 * Rational equations.
 *
 * Written by Robert Pascual/
 *
 * *************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class RationalEqn {

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
	    + "    \\centerline{\\textbf{Rational Equations I}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n");

       // Now generate ten random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 20; ++k) {
           int a = rgen.nextInt(51) + 1;
           int b = rgen.nextInt(20) + 1;
           int c = rgen.nextInt(12) + 1;

	   fout.println("\\item\n"
	       + "\\begin{displaymath}\n"
	       + "\\frac{1}{x} + \\frac{" + a + "}{" + b + "x} = " + c + "\n"
	       + "\\end{displaymath}\n"
	       + "\n");

           // Now the solution.

           int xnumer = a + b;       // Numerator of the solution.
           int xdenom = b*c;         // Denominator of the solution.
           int gcf    = RationalEqn.GCF(xnumer, xdenom);
           answerKey = answerKey + "\\item $x = \\frac{" 
               + xnumer/gcf 
               + "}{"
               + xdenom/gcf
               + "}$\n\n";
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
	    + "    \\centerline{\\textbf{Rational Equations II}}\n"
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

           int discriminator = a*d + b*c;

           if (discriminator == 0) continue;

           k = k + 1;
  
           // System.out.format("Values selected are %d, %d, %d, %d, %d, %d, %d, %d\n", a, b, c, d, e, f, g, h);

           // Note that we are not using d and e yet.

           int firstCoeff = a*c;
           int secondCoeff = b*d;
           int thirdCoeff  = a*d + b*c;    // Discriminator

           fout.format("\\item\n"
       	       + "\\begin{displaymath}\n"
	       + "\\frac{%dx}{%d(%dx - %d)} + \\frac{%d}{x(%dx - %d)} = \\frac{%d}{%dx - %d}\n"
	       + "\\end{displaymath}\n"
	       + "\n", 
                 firstCoeff, e, f, g, 
                 secondCoeff, e*f, e*g,
                 thirdCoeff, e*f, e*g);

           // Now the solutions. Since we have a quadratic equation,
           // there shall be two solutions.

      
           int xnumerOne = b;    // Numerator of the solution One.
           int xdenomOne = a;     // Denominator of the solution One.
           String signumOne = " ";
           if (xnumerOne * xdenomOne < 0) signumOne = "-";
           int gcf    = RationalEqn.GCF(xnumerOne, xdenomOne);
           int fracxOne  = Math.abs(xnumerOne/gcf);
           int fracyOne  = Math.abs(xdenomOne/gcf);

	   // int wholepartOne = 0;
	   // int fracpartOne = fracxOne;
	   // 
	   // if (fracx > fracy) {          // Also get the mixed form.
	   // wholepart = fracx / fracy;
	   // fracpart  = fracx % fracy;
	   // }

           int xnumerTwo = d;    // Numerator of the solution Two.
           int xdenomTwo = c;     // Denominator of the solution Two.
           String signumTwo = " ";
           if (xnumerTwo * xdenomTwo < 0) signumTwo = "-";
           gcf    = RationalEqn.GCF(xnumerTwo, xdenomTwo);
           int fracxTwo  = Math.abs(xnumerTwo/gcf);
           int fracyTwo  = Math.abs(xdenomTwo/gcf);

           answerKey = answerKey + "\\item $x = "
               + signumOne
               + "\\frac{" 
               + fracxOne 
               + "}{"
               + fracyOne
               + "}; x = "
               + signumTwo
               + "\\frac{" 
               + fracxTwo 
               + "}{"
               + fracyTwo
               + "}$\n\n"; 
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
