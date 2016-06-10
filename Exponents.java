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
   
       for (int k = 0; k < 55; ++k) {
           System.out.println("Creating problem number " + k);

           int pSelect = rgen.nextInt(100) + 1;   // This will select the kind of problem

           int xExp = rgen.nextInt(30) + 1; xExp = 15 - xExp;
	   int yExp = rgen.nextInt(30) + 1; yExp = 15 - yExp;  
	   int zExp = rgen.nextInt(30) + 1; zExp = 15 - zExp; if (zExp == 0) zExp = 2;
       	   int wExp = rgen.nextInt(30) + 1; wExp = 15 - wExp; if (wExp == 0) wExp = 3;
           int xExpPrime = rgen.nextInt(30) + 1; xExpPrime = 15 - xExpPrime; 
	   int yExpPrime = rgen.nextInt(30) + 1; yExpPrime = 15 - yExpPrime; 
	   int zExpPrime = rgen.nextInt(30) + 1; zExpPrime = 15 - zExpPrime;  if (zExpPrime == 0) zExpPrime = 3;
 

           switch (pSelect % 4) {
               case 0:
		   fout.format("\\item $\\frac{a^{%d}b^{%d}}{a^{%d}b^{%d}}$\n",
			 xExp, yExp, xExpPrime, yExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            xExp - xExpPrime, 
                            yExp - yExpPrime); 
                   break;
               case 1:
		   fout.format("\\item $\\frac{(a^{%d}b^{%d})^{%d}}{a^{%d}b^{%d}}$\n",
			 xExp, yExp, zExp, xExpPrime, yExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            (xExp*zExp) - xExpPrime, 
                            (yExp*zExp) - yExpPrime); 
                   break;
               case 2:
		   fout.format("\\item $\\frac{a^{%d}b^{%d}}{(a^{%d}b^{%d})^{%d}}$\n",
			 xExp, yExp, xExpPrime, yExpPrime, zExp);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            xExp - xExpPrime * zExp, 
                            yExp - yExpPrime * zExp); 
                   break;
               case 3:
		   fout.format("\\item $\\frac{(a^{%d}b^{%d})^{%d}}{(a^{%d}b^{%d})^{%d}}$\n",
			 xExp, yExp, zExp, xExpPrime, yExpPrime, zExpPrime);
		   answerKey = answerKey + 
		       String.format("\\item $a^{%d}b^{%d}$\n", 
                            xExp*zExp - xExpPrime*zExpPrime, 
                            yExp*zExp - yExpPrime*zExpPrime); 
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
