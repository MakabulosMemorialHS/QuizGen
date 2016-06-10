/* **************************************************
 * Sequences.java
 *
 * Simple Variatonal Problem Drills.
 *
 * Written by Robert Pascual/
 *
 * *************************************************/
import java.lang.*;
import java.util.*;
import java.io.*;     // for PrintWriter and FileOutputStream

public class Sequences {

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
            + "Find the next two terms of the sequence.\n"
            + "All are $a_n = \\alpha a_{n-1} + \\beta a_{n-2} + \\gamma n + \\epsilon$\n"
            + "\\vspace {0.2in}\n"
	    + "]\n");

       // Now generate random problems and write it out.

       Random rgen = new Random();
       String answerKey = "";
 
       fout.println("\\begin{enumerate}\n");
   
       for (int k = 0; k < 60; ++k) {
           // System.out.println("Creating problem number " + k);

           int pSelect = rgen.nextInt(100) + 1;   // This will select the kind of problem

           int alpha   = rgen.nextInt(10); alpha   = 5 - alpha; if (alpha == 0) alpha = 2;
           int beta    = rgen.nextInt(10); beta    = 5 - beta; if (beta == 0) beta = 1;
           int gamma   = rgen.nextInt(10); gamma   = 5 - gamma; if (gamma == 0) gamma = 1; 
           int epsilon = rgen.nextInt(20); epsilon = 10 - epsilon; if (epsilon == 0) epsilon = 3; 
           int azero   = rgen.nextInt(30); azero  = 15 - azero;
           int aone    = rgen.nextInt(30);  aone  = 15 - aone; if (aone == azero) aone = azero + 3;
           int atwo, n;

           switch (pSelect % 8) {
               case 0:  // We make this the easiest. Just an arithmetic series actually.
                   alpha = 1;
                   beta = 0;
                   gamma = 0;
                   fout.print("\\item " + aone + "\\,\\, ");
                   for (n = 1; n < 5; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 5);
                   answerKey = answerKey + "\\item ";
                   for (n = 5; n < 7; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 1: // For this case, alpha is no longer equal to 1.
                   beta = 0;
                   gamma = 0;
                   fout.print("\\item " + aone + "\\,\\, ");
                   for (n = 1; n < 5; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 5);
                   answerKey = answerKey + "\\item ";
                   for (n = 5; n < 7; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 2: // For this case, beta is no longer zero.
                   gamma = 0;
                   fout.print("\\item " + azero + "\\,\\, " + aone + "\\,\\, ");
                   for (n = 1; n < 4; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 4);
                   answerKey = answerKey + "\\item ";
                   for (n = 4; n < 6; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 3: // In this special case we let alpha = beta = 1
                   alpha = 1;
                   beta = 1;
                   gamma = 0;
                   fout.print("\\item " + azero + "\\,\\, " + aone + "\\,\\, ");
                   for (n = 1; n < 4; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 4);
                   answerKey = answerKey + "\\item ";
                   for (n = 4; n < 6; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 4: // In this special case, we just let alpha = 1
                   alpha = 1;
                   gamma = 0;
                   fout.print("\\item " + azero + "\\,\\, " + aone + "\\,\\, ");
                   for (n = 1; n < 4; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 4);
                   answerKey = answerKey + "\\item ";
                   for (n = 4; n < 6; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 5: // Here we just let beta = 1
                   beta = 1;
                   gamma = 0;
                   fout.print("\\item " + azero + "\\,\\, " + aone + "\\,\\, ");
                   for (n = 1; n < 4; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 4);
                   answerKey = answerKey + "\\item ";
                   for (n = 4; n < 6; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 6: // For this case, we let gamma equal to 1.
                   beta = 0;
                   gamma = 1;
                   fout.print("\\item " + aone + "\\,\\, ");
                   for (n = 1; n < 5; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 5);
                   answerKey = answerKey + "\\item ";
                   for (n = 5; n < 7; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
                   break;

               case 7: // For this case, we let gamma equal to 2.
                   beta = 0;
                   gamma = 2;
                   fout.print("\\item " + aone + "\\,\\, ");
                   for (n = 1; n < 5; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       fout.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   fout.print("\n");

                   assert (n == 5);
                   answerKey = answerKey + "\\item ";
                   for (n = 5; n < 7; ++n) {
                       atwo = (alpha * aone) + (beta * azero) + (gamma * n) + epsilon;
                       answerKey = answerKey + String.format("%d\\,\\, ", atwo);
                       aone = atwo;
                       azero = aone;
                   }
                   answerKey = answerKey 
                      + String.format("\\,(%d, %d, %d, %d)\n", alpha, beta, gamma, epsilon);
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
