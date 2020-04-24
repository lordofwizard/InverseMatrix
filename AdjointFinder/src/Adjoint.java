import java.util.Scanner;
/*
 * 
 *	Author : Advait Pandharpurkar 
 *	 
 * 	Aka LordOfWizard
 * 
 * 
 * 
 */




public class Adjoint {

	public static void main(String[] args) { // main function 
		int[][] array =  new int[3][3];
		
		System.out.println("Hello Welcome to this Adjoint solver");
		System.out.println("Just type the elements of a matrix line by line and we will find it");
	
		Scanner input = new Scanner(System.in);
		
		// this is input taking process of array in the program 
		for(int  x= 0; x < 3 ; x++) {
			for(int y = 0; y < 3; y++) {
				
				array[x][y] = input.nextInt();  	// the basic input from user ;
			}	
		}
		
		int[][] cofactor = new int[3][3] ;
		cofactor =  coFactorFinder(array);
		int[][] adjoint = new int[3][3];
		adjoint = adjointMaker(cofactor);
		int determinant = MatrixSolver(array);
		
		int[][] finalArray = new int[3][3];
		finalArray = inverseFinder( adjoint , determinant );
		// printing cofactor
		
		
		System.out.println("input array");
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int x = 0; x < 3 ; x++) {
			
			for(int y = 0 ; y < 3 ; y++) {
				//array[x][y] = input.nextInt();
				
				System.out.print("\t" + array[x][y]);
				
			
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
	
		
		
		
		
		
		System.out.println("cofactor");
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int x = 0; x < 3 ; x++) {
			
			for(int y = 0 ; y < 3 ; y++) {
				//array[x][y] = input.nextInt();
				
				System.out.print("\t" + cofactor[x][y]);
				
			
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
	
	
		System.out.println("adjoint");
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int x = 0; x < 3 ; x++) {
			
			for(int y = 0 ; y < 3 ; y++) {
				//array[x][y] = input.nextInt();
				
				System.out.print("\t" + adjoint[x][y]);
				
			
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
	
		
		
		System.out.println("inverse");
		System.out.println();
		System.out.print("[");
		System.out.println();
		for (int x = 0; x < 3 ; x++) {
			
			for(int y = 0 ; y < 3 ; y++) {
				//array[x][y] = input.nextInt();
				
				System.out.print("\t" + finalArray[x][y]);
				
			
			}
		System.out.println();
		}System.out.print("]");
		System.out.println();
	
	System.out.println("Determinant (totally optional) -> "+ determinant);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[][] coFactorFinder(int[][] input_array) {
		int[][] Cofactor_array =  new int[3][3];
	/*1*/	Cofactor_array[0][0] = (((input_array[1][1])*(input_array[2][2]))-((input_array[1][2])*(input_array[2][1])));//
	/*2*/	Cofactor_array[0][1] = (((input_array[1][0])*(input_array[2][2]))-((input_array[1][2])*(input_array[2][0])));//
	/*3*/	Cofactor_array[0][2] = (((input_array[1][0])*(input_array[2][1]))-((input_array[1][1])*(input_array[2][0])));//
	/*4*/	Cofactor_array[1][0] = (((input_array[0][1])*(input_array[2][2]))-((input_array[0][2])*(input_array[2][1])));//
	/*5*/	Cofactor_array[1][1] = (((input_array[0][0])*(input_array[2][2]))-((input_array[0][2])*(input_array[2][0])));//
	/*6*/	Cofactor_array[1][2] = (((input_array[0][0])*(input_array[2][1]))-((input_array[0][1])*(input_array[2][0])));//
	/*7*/	Cofactor_array[2][0] = (((input_array[0][1])*(input_array[1][2]))-((input_array[0][2])*(input_array[1][1])));//
	/*8*/	Cofactor_array[2][1] = (((input_array[0][0])*(input_array[1][2]))-((input_array[0][2])*(input_array[1][0])));//
	/*9*/	Cofactor_array[2][2] = (((input_array[0][0])*(input_array[1][1]))-((input_array[0][1])*(input_array[1][0])));//
	
		
		
	return Cofactor_array;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[][]  adjointMaker(int[][] inputCofactoredArray){
		int[][] CofactoredArray = new int[3][3];
		for(int i = 0; i < 3 ; i++) {
			for(int j = 0; j < 3; j++) {
				
				// This take the array of original cofactored array and put the exact same values in the array we created 
				inputCofactoredArray[i][j] =  CofactoredArray[i][j];
				
				
			}	
		}
	
		inputCofactoredArray[0][1] =  CofactoredArray[1][0];
		inputCofactoredArray[0][2] =  CofactoredArray[2][0];
		inputCofactoredArray[1][2] =  CofactoredArray[2][1];
		
		// This are the lines which are get exchanged in the matrix as we know that what adjoint does : ) 
		
		inputCofactoredArray[1][0] =  CofactoredArray[0][1];
		inputCofactoredArray[2][0] =  CofactoredArray[0][2];
		inputCofactoredArray[2][1] =  CofactoredArray[1][2];
		
		
		int[][] adjointedArray = new int[3][3];
		adjointedArray = CofactoredArray;
		return adjointedArray;

	}



public static int MatrixSolver(int[][] arr) {// this is the function which determines the determinant of the sum
	
int Determinant = 	(
		
		
		(arr[0][0] * ((arr[1][1] * arr[2][2]) - (arr[1][2] * arr[2][1])))
		
		+((-arr[0][1]) * ((arr[1][0] * arr[2][2]) - (arr[1][2] * arr[2][0])))
		
		+(arr[0][2] * ((arr[1][0] * arr[2][1]) - (arr[1][1] * arr[2][0])))
		
		
		
		
		
		);
	if (Determinant < 0) {
		Determinant = ((-(Determinant)) * 2) - Determinant;
	}
	return Determinant;
	
	
	
}
public static int[][] inverseFinder(int[][] arr, int deter){
	int[][] inversedMatrix = new int[3][3];
	for(int num = 0 ; num < 3 ; num++) {
		for(int no = 0; no < 3 ; no++) {
			
			inversedMatrix[num][no] = (arr[num][no]/deter); 
			
			
		}
	}// This will align the values of the matrices
	
	
	
	return inversedMatrix;
}

	

}



