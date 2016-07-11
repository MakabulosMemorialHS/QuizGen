/* **************************************************
 * Polynomials.java
 *
 * Simple Variatonal Problem Drills.
 *
 * Written by Robert Pascual/
 *
 * *************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class Polynomials {

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
	    + "    \\centerline{\\textbf{Sequences}}\n"
	    + "    \\vspace {0.15 in}\n"
            + "Multiply the polynomials.\n"
            + "\\vspace {0.2in}\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 55; ++k) {
           // System.out.println("Creating problem number " + k);

           int pSelect = rgen.nextInt(100) + 1;   // This will select the kind of problem

           switch (pSelect % 3) {
               case 0:  // Binomial times a binomial
		   int a = rgen.nextInt(30); a = 15 - a; if (a == 0) a = 2;
		   int b = rgen.nextInt(30); b = 15 - b; if (b == 0) b = 1;
		   int c = rgen.nextInt(30); c = 15 - c; if (c == 0) c = 1; 
		   int d = rgen.nextInt(30); d = 15 - d; if (d == 0) d = 3; 
                   fout.format("\\item $(%dx + %dy)(%dx + %dy)$\n", a, b, c, d);

                   answerKey = answerKey 
                       + String.format("\\item $%dx^2 + %dxy + %dy^2$\n",
                         a*c, a*d + b*c, b*d); 
                   break;
              case 1: // binomial times trinomial
		   a = rgen.nextInt(30); a = 15 - a; if (a == 0) a = 2;
		   b = rgen.nextInt(30); b = 15 - b; if (b == 0) b = 1;
		   c = rgen.nextInt(30); c = 15 - c; if (c == 0) c = 1; 
		   d = rgen.nextInt(30); d = 15 - d; if (d == 0) d = 3; 
		   int e = rgen.nextInt(30); e = 15 - e; if (e == 0) e = 3; 
                   fout.format("\\item $(%dx + %dy)(%dx + %dy + %dz)$\n", a, b, c, d, e);
                   answerKey = answerKey 
                       + String.format("\\item $%dx^2 + %dxy + %dxz + %dyz + %dy^2$\n",
                        a*c, a*d + b*c, a*e, b*e, b*d); 
                   break;
              case 2: // Trinomial times a trinomial
		   a = rgen.nextInt(30); a = 15 - a; if (a == 0) a = 2;
		   b = rgen.nextInt(30); b = 15 - b; if (b == 0) b = 8;
		   c = rgen.nextInt(30); c = 15 - c; if (c == 0) c = -1; 
		   d = rgen.nextInt(30); d = 15 - d; if (d == 0) d = 7; 
		   e = rgen.nextInt(30); e = 15 - e; if (e == 0) e = -12; 
       		   int f = rgen.nextInt(30); f = 15 - f; if (f == 0) f = 3; 
                   fout.format("\\item $(%dx + %dy + %dz)(%dx + %dy + %dz)$\n", 
                       a, b, c, d, e, f);
                   answerKey = answerKey 
                       + String.format("\\item $%dx^2 + %dy^2 + %dz^2 + %dxy + %dxz + %dyz$\n",
                       a*d, b*e, c*f, a*e + b*d, a*f + c*d, b*f + c*e); 
                   break;

           }
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
	    + "    \\centerline{\\textbf{Perfect Squares}}\n"
	    + "    \\vspace {0.5 in}\n"
            + "What should be added to each of the following to make a "
            + "perfect square?\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 60; ++k) {
           int pSelect = rgen.nextInt(100) + 1;   // This will select the kind of problem

           switch (pSelect % 4) {
               case 0:
                   int b = 2*rgen.nextInt(50) + 1;  // Guaranteed to be odd.
                   Fraction d = new Fraction(b,2);
                   fout.format("\\item $x^2 + %dx$\n", b);
		   answerKey = answerKey + 
		       String.format("\\item $(%s)^2 = %d/4$\n", d.toString(), b*b);
                   break;
               case 1:
                   b = 2*rgen.nextInt(50) + 1;  // Guaranteed to be odd.
                   Fraction c = new Fraction(b,2);
                   fout.format("\\item $x^2 - %dx$\n", b);
		   answerKey = answerKey + 
		       String.format("\\item $(%s)^2 = %d/4$\n", c.toString(), b*b);
                   break;
               case 2:
                   b = rgen.nextInt(50) + 1;
                   fout.format("\\item $x^2 - %dx$\n", 2*b);
		   answerKey = answerKey + 
		       String.format("\\item $%d^2 = %d$\n", b, b*b);
                   break;
               case 3:
                   b = rgen.nextInt(50) + 1;
                   fout.format("\\item $x^2 + %dx$\n", 2*b);
		   answerKey = answerKey + 
		       String.format("\\item $%d^2 = %d$\n", b, b*b);
                   break;
           }
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

    }  // Set 02.


}
