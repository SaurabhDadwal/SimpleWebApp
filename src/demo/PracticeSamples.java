/**
 * 
 */
package demo;

import java.util.Scanner;

/**
 * @author DELL
 *
 */
public class PracticeSamples {

	/** Swap two variables */
	  public static void swap(int n1, int n2) {
	    int temp = n1;
	    n1 = n2;
	    n2 = temp;
	  }

	  /** Swap the first two elements in the array */
	  public static void swapFirstTwoInArray(int[] array) {
	    int temp = array[0];
	    array[0] = array[1];
	    array[1] = temp;
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Provide inputs");
		 int[] a = {1, 2};

		    // Swap elements using the swap method
		    System.out.println("Before invoking swap");
		    System.out.println("array is {" + a[0] + ", " + a[1] + "}");
		    swap(a[0], a[1]);
		    System.out.println("After invoking swap");
		    System.out.println("array is {" + a[0] + ", " + a[1] + "}");

		    // Swap elements using the swapFirstTwoInArray method
		    System.out.println("Before invoking swapFirstTwoInArray");
		    System.out.println("array is {" + a[0] + ", " + a[1] + "}");
		    swapFirstTwoInArray(a);
		    System.out.println("After invoking swapFirstTwoInArray");
		    System.out.println("array is {" + a[0] + ", " + a[1] + "}");		 
		 //System.out.println(max(1, 2));
		 Math.exp(2);
		 System.out.println("math methods:"+Math.round(8.1));
		 System.out.println();
		 
				 
		 byte i = 100;
		 long k = i * 3 + 4;
		 double d = i * 3.1 + k / 2;
		 
		 int x1 = (int)(5/2.0);
		 System.out.println("d value ="+d);
		 float l = 100F;
		 System.out.println("long: "+l);
		 Double input1 = Double.parseDouble(scanner.next());
		 Double input2 = Double.parseDouble(scanner.next());
		 System.out.println(Math.pow(input1, input2));
		 System.out.println("nl");
		 String check =scanner.nextLine();
		 if(check==null || check.trim().isEmpty()){
			 System.out.println("Empty");
		 }else
			 System.out.println(check);
		 scanner.close();

	}
	
	public PracticeSamples(String s) {
		// TODO Auto-generated constructor stub
		System.out.println("PracticeSamples");
	}
	
	public PracticeSamples(){
		
	}

}
