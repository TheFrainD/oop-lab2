package com.oop.lab2;
import java.util.Scanner;

/*
 * This class represents an algebraic matrix made using two-dimensional arrays 
 * of long numbers. There are few methods representing simple operations over matrix(ces)
 * 
 * @author	Dmytro Zykov
 */

public class Matrix {
	
	private int rows;
	private int cols;
	private long[][] matrix;
	
	// Default constructor
	public Matrix() {
		
		this.rows = 0;
		this.cols = 0;
	}
	
	// Constructor
	public Matrix(int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		
		// Initializing matrix
		this.matrix = new long[rows][cols];
	}
	/*	
	 * Method that allows to get number of rows in certain matrix.
	 * 
	 * @return	the number of rows in the matrix
	 */
	public int getSizeRows() {
		return this.rows;
	}
	
	/*	
	 * Method that allows to get number of columns in certain matrix.
	 * 
	 * @return	the number of columns in the matrix
	 */
	public int getSizeCols() {
		return this.cols;
	}
	
	/*
	 * Method that allows to get value of element at given coordinates.
	 * 
	 * @param	row	the vertical position of the element
	 * @param	col	the horizontal position of the element
	 * @return	the value of the element
	 */
	public long getAt(int row, int col) {
		return this.matrix[row][col];
	}
	
	/*
	 * Method that allows to set value of element at given coordinates.
	 * 
	 * @param	row	the vertical position of the element
	 * @param	col	the horizontal position of the element
	 * @param	value the value that is going to be set to the element
	 */
	public void setAt(int row, int col, long value) {
		this.matrix[row][col] = value;
	}
	
	/*
	 * Implements inputting of individual element of matrix.
	 * 
	 * @param	scan java.util.Scanner instance to read the input
	 */
	public void input(Scanner scan) {
		
		for (int row = 0; row < this.rows; ++row) {
			for (int col = 0; col < this.cols; ++col) {
				
				this.matrix[row][col] = scan.nextLong();
			}
		}
	}
	
	/*
	 * Prints all elements of the matrix. Each row prints on
	 * different lines. The elements are separated with space.
	 */
	public void print() {
		
		for (int row = 0; row < this.rows; ++row) {
			for (int col = 0; col < this.cols; ++col) {
				
				System.out.printf("%d ",this.matrix[row][col]);
			}
			
			// End of row
			System.out.print("\n");
		}
	}
	
	/*
	 * Obtains the direct sum of two matrices.
	 * 
	 * @param 	other the second addendum
	 * @return	the resulting matrix containing the direct sum
	 */
	public Matrix directSumOf(Matrix other) {
		
		int newRows = this.rows + other.getSizeRows();
		int newCols = this.cols + other.getSizeCols();
		
		Matrix result = new Matrix(newRows, newCols);
		
		// Placing the first matrix
		for (int row = 0; row < this.rows; ++row) {
			for (int col = 0; col < this.cols; ++col) {
				
				result.setAt(row, col, this.matrix[row][col]);
			}
		}
		
		// Placing the second matrix
		for (int row = 0; row < other.getSizeRows(); ++row) {
			for (int col = 0; col < other.getSizeCols(); ++col) {
				
				result.setAt(row + this.rows, col + this.cols, other.getAt(row, col));
			}
		}
		
		return result;
	}
}
