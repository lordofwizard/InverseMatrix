import java.util.Scanner;
/*
 * 
 *	Author : Advait Pandharpurkar 
 *	 
 * 	Aka LordOfWizard
 * 	Free to use
 * Contact: https://cutt.ly/ltZxvLI
 */


public class Adjoint {
	public static String[] string_array = {"Matrix","Co-factor","Adjoint","Inverse",};  // This is actually used in function overloading

	public static void main(String[] args) { // main function 
		int[][] array =  new int[3][3]; // This is the array which takes the input from the user
		//////////////////////////////////////////////////////////////////////////
		System.out.println("Hello Welcome to this Adjoint solver");
		System.out.println("Just type the elements of a matrix line by line and we will find it");
		
		// This is the basic shittiest stuff ;
		Scanner input = new Scanner(System.in); //  Scanner input object to take a string
		// this is input taking process of array in the program 
		
		
		for(int  x= 0; x < 3 ; x++) {
			for(int y = 0; y < 3; y++) {
				
				array[x][y] = input.nextInt();  	// the basic input from user ; takes a 2 Dimensional array as a input and converts into a string
			}	
		}
		
		
		theMatrixPrinter(array,0); // this method is only taking 2 args hence it will do as the first one do and print the 
									// main array of the program on the screen 
		///////////////////////////////////////////////////////////////////////////////////
		
		
		int[][] cofactor_inmain = new int[3][3] ; // This is the cofactor array which is just declared
		cofactor_inmain =  coFactorFinder(array);// IN this method we are finding the cofactor of main input array and putting it in cofactor_main
		theMatrixPrinter(cofactor_inmain,1);// Same also this has 2 inputs so it will do as per theMatrixPrinter 1 will do 
		//////////////////////////////////////////////////////////////////////////////////
		
		
		int[][] adjoint = new int[3][3];
		adjoint = adjointMaker(cofactor_inmain);
		theMatrixPrinter(adjoint , 2 );// THis is the adjoint array and it will change the places of adjoints and prints the array
		///////////////////////////////////////////////////////////////////////////////////
		
		
		int determinant = MatrixSolver(array);// This is where we are calculation the determinant of the program (it is needed for the inverse)
		///////////////////////////////////////////////////////////////////////////////////

		
		int[][] finalArray = new int[3][3];
		finalArray = inverseFinder( adjoint);// THis is where we are printing the final array and we used function overloading here
		theMatrixPrinter(finalArray, 3 , '/',determinant);// as per this is taking an array, num , char , determinant in the account
		///////////////////////////////////////////////////////////////////////////////////
	
	
	}
	
	
	
	public static int[][] coFactorFinder(int[][] input_array) {
		 int[][] Cofactor_array =  new int[3][3];
		 	 
		 
	/*1*/	Cofactor_array[0][0] = (((input_array[1][1])*(input_array[2][2]))-((input_array[1][2])*(input_array[2][1])));//
	/*2*/	Cofactor_array[0][1] = (-1)*(((input_array[1][0])*(input_array[2][2]))-((input_array[1][2])*(input_array[2][0])));//
	/*3*/	Cofactor_array[0][2] = (((input_array[1][0])*(input_array[2][1]))-((input_array[1][1])*(input_array[2][0])));//
	/*4*/	Cofactor_array[1][0] = (-1)*(((input_array[0][1])*(input_array[2][2]))-((input_array[0][2])*(input_array[2][1])));//
	/*5*/	Cofactor_array[1][1] = (((input_array[0][0])*(input_array[2][2]))-((input_array[0][2])*(input_array[2][0])));//
	/*6*/	Cofactor_array[1][2] = (-1)*(((input_array[0][0])*(input_array[2][1]))-((input_array[0][1])*(input_array[2][0])));//
	/*7*/	Cofactor_array[2][0] = (((input_array[0][1])*(input_array[1][2]))-((input_array[0][2])*(input_array[1][1])));//
	/*8*/	Cofactor_array[2][1] = (-1)*(((input_array[0][0])*(input_array[1][2]))-((input_array[0][2])*(input_array[1][0])));//
	/*9*/	Cofactor_array[2][2] = (((input_array[0][0])*(input_array[1][1]))-((input_array[0][1])*(input_array[1][0])));//
	// we are solving the each element in the array by the old process also we can use another method to do that 
	return Cofactor_array;
	
	}
	
	
	
	
	public static int[][]  adjointMaker(int[][] inputCofactoredArray){
		int[][] CofactoredArray = new int[3][3];
		for(int l = 0; l < 3 ; l++) {
			for(int m = 0; m < 3; m++) {
				
				// This take the array of original cofactored array and put the exact same values in the array we created 
				CofactoredArray[l][m] =  inputCofactoredArray[l][m];
				
				
			}	
		}
	//This is where we are exchangine the values
		CofactoredArray[0][1] =   inputCofactoredArray[1][0];
		CofactoredArray[0][2] =   inputCofactoredArray[2][0];
		CofactoredArray[1][2] =   inputCofactoredArray[2][1];
		
		// This are the lines which are get exchanged in the matrix as we know that what adjoint does : ) 
		
		CofactoredArray[1][0] =   inputCofactoredArray[0][1];
		CofactoredArray[2][0] =   inputCofactoredArray[0][2];
		CofactoredArray[2][1] =   inputCofactoredArray[1][2];
		
		
		int[][] adjointedArray = new int[3][3];
		adjointedArray = CofactoredArray; // this was optional but i like to consume extra ram from people's computer
		return adjointedArray;

	}



public static int MatrixSolver(int[][] arr) {// this is the function which determines the determinant of the sum
	
int Determinant = 	(
		
		(arr[0][0] * ((arr[1][1] * arr[2][2]) - (arr[1][2] * arr[2][1])))
		
		+((-arr[0][1]) * ((arr[1][0] * arr[2][2]) - (arr[1][2] * arr[2][0])))
		
		+(arr[0][2] * ((arr[1][0] * arr[2][1]) - (arr[1][1] * arr[2][0])))
		// here we are calculation the determinant by the old school method
		);
	// this is optional as it is the modulus of the determinant i mean |A| , got it now ?
	if (Determinant < 0) {
		Determinant = Determinant * (-1);
		return Determinant;
	}
	else return Determinant;
	
	
}
public static int[][] inverseFinder(int[][] arr){ // does nothing just takes input and returns 
	int[][] inversedMatrix = new int[3][3];
	for(int num = 0 ; num < 3 ; num++) {
		for(int no = 0; no < 3 ; no++) { ///// USELESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs
			inversedMatrix[num][no] = (arr[num][no]); 
		}
	}// This will align the values of the matrices
	return inversedMatrix;
}

	
// this method prints each elment of an array in a specific order 
public static void theMatrixPrinter(int[][] matrix,int no) {
	 System.out.println(string_array[no]);
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int q = 0; q < 3 ; q++) {
			
			for(int e = 0 ; e < 3 ; e++) {
				
				System.out.print("\t" + matrix[q][e]);
				
			
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
}



public static void theMatrixPrinter(int[][] matrix,int no,char a , int dtr) {
	 System.out.println(string_array[no]);
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int q = 0; q < 3 ; q++) {
			
			for(int e = 0 ; e < 3 ; e++) {
				
				System.out.print("\t" + matrix[q][e] + "/" + dtr);
				
				// this is the overloaded functiona and prints the values of the array we gave
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
		System.out.println("Determinant (Totally Optional) -> " + dtr);

}
}

