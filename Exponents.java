/* **************************************************
 * Exponents.java
 *
 * Simple Variatonal Problem Drills.
 *
 * Written by Robert Pascual/
 *
 * *************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class Exponents {

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
	    + "    \\centerline{\\textbf{Exponents I}}\n"
	    + "    \\vspace {0.5 in}\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 60; ++k) {
           System.out.println("Creating problem number " + k);

           int pSelect = rgen.nextInt(100) + 1;   // This will select the kind of problem

           int xExp = rgen.nextInt(30) + 1; xExp = 15 - xExp;
	   int yExp = rgen.nextInt(30) + 1; yExp = 15 - yExp;  
	   int zExp = rgen.nextInt(30) + 1; zExp = 15 - zExp; if (zExp == 0) zExp = 2;
           int xExpPrime = rgen.nextInt(30) + 1; xExpPrime = 15 - xExpPrime; 
	   int yExpPrime = rgen.nextInt(30) + 1; yExpPrime = 15 - yExpPrime; 
	   int zExpPrime = rgen.nextInt(30) + 1; zExpPrime = 15 - zExpPrime;  if (zExpPrime == 0) zExpPrime = 3;
 

           switch (pSelect % 4) {
               case 0:
		   fout.format("\\item $a^{%d}b^{%d}(a^{%d}b^{%d})^{%d}c^{%d}$\n",
			 xExp, yExp, xExpPrime, yExpPrime, zExpPrime, zExp);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}c^{%d}$\n", 
                            xExp + xExpPrime * zExpPrime, 
                            yExp + yExpPrime * zExpPrime, 
                            zExp); 
                   break;
               case 1:
		   fout.format("\\item $(a^{%d}b^{%d}c^{%d})^{%d}$\n",
			 xExp, yExp, zExp, xExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}c^{%d}$\n", 
                            xExp * xExpPrime, 
                            yExp * xExpPrime, 
                            zExp * xExpPrime); 
                   break;
               case 2:
		   fout.format("\\item $(a^{%d}b^{%d})^{%d}(a^{%d}b^{%d})^{%d}$\n",
			 xExp, yExp, zExp, xExpPrime, yExpPrime, zExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            xExp*zExp + xExpPrime * zExpPrime, 
                            yExp*zExp + yExpPrime * zExpPrime); 
                   break;
               case 3:
		   fout.format("\\item $a^{%d}b^{%d} \\cdot a^{%d}b^{%d}$\n",
			 xExp, yExp, xExpPrime, yExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            xExp + xExpPrime, yExp + yExpPrime);
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
                         + String.format("\\item $y = %s$ (direct)\n", spoint.toString());
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
	       int d = rgen.nextInt(60) + 1; d = 30 - d; if (d == 0) d = 12;
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
