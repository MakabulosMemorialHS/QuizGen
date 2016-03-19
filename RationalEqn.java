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
}
