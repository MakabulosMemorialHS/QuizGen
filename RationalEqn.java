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
        
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 20; ++k) {
           int a = rgen.nextInt(51) + 1;
           int b = rgen.nextInt(51) + 1;
           int c = rgen.nextInt(51) + 1;

	   fout.println("\\item\n"
	       + "\\begin{displaymath}\n"
	       + "\\frac{1}{x} + \\frac{" + a + "}{" + b + "x} = " + c + "\n"
	       + "\\end{displaymath}\n"
	       + "\n");
       }
       
       fout.println("\\end{enumerate}\n\\end{document}\n");
       fout.close();
    }
}
