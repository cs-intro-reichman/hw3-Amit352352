// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {	 	
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));  // brute force
		System.out.println("number of iterations: " + iterationCounter);

		// // Computes the periodical payment using bisection search
		// System.out.print("\nPeriodical payment, using bi-section search: ");
		// System.out.println((int) bisectionSolver(loan, rate, n, epsilon)); // bisectionSolver
		// System.out.println("number of iterations: " + iterationCounter);
		// //endBalance(100000,5,10,10000); //debuger
	}






	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		//System.out.println((int) (5+0.7));
		
		double newLoan = loan; 
		//System.out.println("n : "+n );
		for (int i = 0; i < n; i++) {
			//System.out.println("newloan: "+newLoan);
			newLoan = (newLoan - payment)*(1.0 + rate / 100.0);
			//System.out.println("newloan: "+newLoan);
			//System.out.println("payment: "+payment);
			//PrintLoan =  Math.round(loan);
			
			//System.out.println(PrintLoan);
		}
		return newLoan; 
	}



	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double g = loan/n; //f(g) > 0
		//System.out.println("here g: "+g);
 		 while (endBalance(loan,rate,n,g)  > 0 && (g <= 0)) { // Math.abs (endBalance(loan,rate,n,g) - 0)  > 0

			g += epsilon ; //If increment is too small then endBalance will miss 0 and get to negative and we miss the answer and
			iterationCounter++; // get into an infinite loop
 		}


		return g;
    }
    




    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        
		return 0;
    }
}