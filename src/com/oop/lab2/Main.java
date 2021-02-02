package com.oop.lab2;
import java.util.Scanner;

/*
 * OOP - lab2
 * 
 * C5 = 3 --> 'A⊕B'
 * C7 = 4 --> 'long'
 * C11 = 2 --> sum of max at each column
 * 
 * @author	Dmytro Zykov
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Matrix A;
		Matrix B;
		int rows, cols;
		
		System.out.print("Enter matrix A size(separated with space): ");
		rows = scan.nextInt();
		cols = scan.nextInt();
		A = new Matrix(rows, cols);
		
		System.out.println("Enter matrix' elements: ");
		A.input(scan);
		
		System.out.print("Enter matrix B size(separated with space): ");
		rows = scan.nextInt();
		cols = scan.nextInt();
		B = new Matrix(rows, cols);
		
		System.out.println("Enter matrix' elements:");
		B.input(scan);
		
		Matrix C = A.directSumOf(B);
		
		System.out.println("Direct sum of A and B:");
		C.print();
		
		long sum = 0;
		
		for (int col = 0; col < C.getSizeCols(); ++col) {
			
			// Initial max
			long max = 0;
			
			for (int row = 0; row < C.getSizeRows(); ++row) {
				// Comparing each element with the max if bigger, this element's value assigns to max
				if (max < C.getAt(row, col)) {
					max = C.getAt(row, col);
				}
			}
			
			// Adding max number of each column to sum
			sum += max;
		}
		
		System.out.printf("\nSum of max numbers in each column: %d\n", sum);
	}

}
