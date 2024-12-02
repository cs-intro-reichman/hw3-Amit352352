// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(times(3,4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3  
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123)); //answer is not an interger
	} 
	
	// convert -x to x
	public static int ConvertToPositive(int x) { //
		int limX = x; 
		x = 0 ;
			for (int i = 0; i > limX; i--) { 
				x++ ;
			}
			return x;
	}

	// convert x to -x
	public static int ConvertToNegative(int x) { //
		int limX = x; 
		x = 0 ;
			for (int i = 0; i < limX; i++) { // gets from 0 to x
				x-- ; // same but double faster so it gets from x to -x // it was true when i wrote x-- ; for 2 lines
			}
			return x;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) { //check
		for (int i = 0; i < x2; i++) {
			x1++ ;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) { //check
		for (int i = 0; i < x2; i++) {
			x1-- ;
		}
		return x1;
	}
	// Returns x1 * x2 
	public static int times(int x1, int x2) { 	//check
		int resultX1 = 0 ;
		if (x1==0 || x2==0) {
			resultX1 = 0;
		}
		else if (x1>0 && x2<0) {	//check
			for (int i = 0; i > x2; i--) {
				resultX1 += minus(0,x1) ;
			}
		}
		else if (x1<0 && x2>0) {	//check
			for (int i = 0; i > x1; i--) {
				resultX1 += minus(0,x2) ;
			}
			
		}
		else if (x1<0 && x2<0) { //check 
			x1 = ConvertToPositive(x1);
			x2 = ConvertToPositive(x2);
			for (int i = 0; i < x2; i++) {
				resultX1 += plus(0,x1) ;
			}
		}
		else { // x1>0 && x2>0	//check
			for (int i = 0; i < x2; i++) {
				resultX1 += plus(0,x1) ;
			}
		}
		
		return resultX1 ;
	}

	// Returns x^n (for n >= 0) 5^3 = 125
	public static int pow(int x, int n) { //pow pow
		int resultX1 = x; // n=1
		if (n==0) { // n=0
			resultX1 = 1;
			
		}
		else if (n>1) {for (int i = 1; i < n; i++) { //n>1
			resultX1 = times(resultX1, x);

		}
	}
		
		return resultX1;
	}

	// Returns the integer part of x1 / x2 = 12 / 3 = 4				14/ 3 = 4 
	public static int div(int x1, int x2) {
		int ResultDiv = 0;
		int allNumbers = 0 ; //count
		if (x1 >0  & x2 > 0 || x1==0) {// x1 & x2 > 0 || x1==0
			while (ResultDiv>x1==false) {  
				allNumbers++ ;
				ResultDiv = plus(minus(x2,1) , times(x2, allNumbers)); 
			}
		}
		else if (x1 < 0  & x2 < 0) { // x1 & x2 < 0
			x1 = ConvertToPositive(x1);
			x2 = ConvertToPositive(x2);
		
			while (ResultDiv>x1==false) {  
				allNumbers++ ;
				ResultDiv = plus(minus(x2,1) , times(x2, allNumbers)); 
			}
		}
		else if ( x1 < 0 & x2 > 0) { // x1 = -14 , x2= 3 == -4
			//while (ResultDiv!=x1) {  
			while (ResultDiv<x1==false) { //	
				allNumbers-- ;
				//ResultDiv = times(x2, allNumbers); //old
				ResultDiv = minus(times(x2, allNumbers), minus(x2,1) ); 
			}
		}
		else if ( x1 > 0 & x2 < 0) { // x1 = 14 , x2= -3 == -4
			while (ResultDiv>x1==false) { //	
				allNumbers-- ;
				//ResultDiv = times(x2, allNumbers); //old
				ResultDiv = plus(minus(ConvertToPositive(x2),1) , times(x2, allNumbers)); //Alegent but not efficint
			}
		}		

		return allNumbers;
	}

	// Returns x1 % x2 		= 120%6 = 0 
	public static int mod(int x1, int x2) { //a = q*b+r AKA a mod b = r
		int a = x1;
		int b = x2;
		int q = 0;
		int r = 0;
		if (b > a & a > 0) { 
			 r = a ;
		}
		else if (a==0) {
			// r = 0 ;
		}
		else if (a > 0) { 
			while (a!= plus(times(q, b), r)) { //
				q++;
				if (a== plus(times(q, b), r)){ // if r = 0
					r = 0 ;
					break ;
				} 
				for ( r = 0; r < b; r++) {// 0 < b	
					if (a== plus(times(q, b), r)) break; 
				}
			}
		}
		else if (a < 0) { // 0 < b
			while (a!= plus(times(q, b), r)) { //
				q--;
				for ( r = 0; r < b; r++) {	
					if (a== plus(times(q, b), r)) break; 
				}
			}
			
		}
		return r ;	
	}

	// Returns the integer part of sqrt(x)  sqrt36 (36) = 6 == 6^2 = 36
	public static int sqrt(int x) {
		int ResultSqrt = 0;
			while (x!= pow(ResultSqrt, 2)) { //
				ResultSqrt++;
			}
		return ResultSqrt;
	}	  	  
}