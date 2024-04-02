package mymath.abstractnums;

import java.util.ArrayList;

// very inefficient, room for optimization
public class Matrix
{
	private final double[][] data;
	private final int numRows;
	private final int numCols;

	public static final double NaN = 0.0 / 0.0;

	public Matrix(int numRows, int numCols)
	{
		this.numRows = numRows;
		this.numCols = numCols;
		this.data = new double[numRows][numCols];
	}

	public Matrix(int rowLength, double[] data)
	{
		this.data = new double[data.length / rowLength][rowLength];
		this.numRows = this.data.length;
		this.numCols = rowLength;

		for (int i = 0; i < data.length; i++)
		{
			this.data[i / rowLength][i % rowLength] = data[i];
		}
	}

	public Matrix(double[][] data)
	{
		this.numRows = data.length;
		if (this.numRows != 0) this.numCols = data[0].length;
		else this.numCols = 0;
		
		this.data = new double[this.numRows][this.numCols];
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				this.data[row][col] = data[row][col];
			}
		}
	}

	public Matrix(ArrayList<ArrayList<Double>> data)
	{
		this.numRows = data.size();
		if (this.numRows != 0) this.numCols = data.get(0).size();
		else this.numCols = 0;
		
		this.data = new double[this.numRows][this.numCols];
		for (int row = 0; row < numRows; row++)
		{
			for (int col = 0; col < numCols; col++)
			{
				this.data[row][col] = data.get(row).get(col);
			}
		}
	}

	public int getNumRows()
	{
		return this.numRows;
	}

	public int getNumCols()
	{
		return this.numCols;
	}
	
	// all get methods start at index 0
	public double getElem(int rowNum, int colNum)
	{
		return this.data[rowNum][colNum];
	}

	public double[] getRow(int rowNum)
	{
		return this.data[rowNum];
	}

	public double[] getCol(int numCol)
	{
		double[] col = new double[this.numRows];
		for (int numRow = 0; numRow < this.numRows; numRow++)
			col[numRow] = this.data[numRow][numCol];
		return col;
	}

	public Matrix plus(Matrix other)
	{
		if (this.numCols != other.numCols) return null;
		if (this.numRows != other.numRows) return null;
		
		double[][] newData = new double[this.numRows][this.numCols];
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			for (int colNum = 0; colNum < this.numCols; colNum++)
			{
				newData[rowNum][colNum] = this.data[rowNum][colNum];
				newData[rowNum][colNum] += other.data[rowNum][colNum];
			}
		}

		return new Matrix(newData);
	}

	public Matrix minus(Matrix other)
	{
		if (this.numCols != other.numCols) return null;
		if (this.numRows != other.numRows) return null;
		
		double[][] newData = new double[this.numRows][this.numCols];
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			for (int colNum = 0; colNum < this.numCols; colNum++)
			{
				newData[rowNum][colNum] = this.data[rowNum][colNum];
				newData[rowNum][colNum] -= other.data[rowNum][colNum];
			}
		}

		return new Matrix(newData);
	}

	public Matrix times(double scalar)
	{
		double[][] newData = new double[this.numRows][this.numCols];
		
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			for (int colNum = 0; colNum < this.numCols; colNum++)
				newData[rowNum][colNum] = this.data[rowNum][colNum] * scalar;
		}

		return new Matrix(newData);
	}

	public Matrix dividedBy(double scalar)
	{
		double[][] newData = new double[this.numRows][this.numCols];
		
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			for (int colNum = 0; colNum < this.numCols; colNum++)
				newData[rowNum][colNum] = this.data[rowNum][colNum] / scalar;
		}

		return new Matrix(newData);
	}

	public Matrix scalarMult(double scalar)
	{
		return this.times(scalar);
	}

	public Matrix times(Matrix other)
	{
		if (this.numCols != other.numRows) return null;
		int n = this.numCols;
		
		int newNumRows = this.numRows;
		int newNumCols = other.numCols;
		double[][] newData = new double[newNumRows][newNumCols];
		
		for (int rowNum = 0; rowNum < newNumRows; rowNum++)
		{
			for (int colNum = 0; colNum < newNumCols; colNum++)
			{
				double[] row = this.getRow(rowNum);
				double[] col = other.getCol(colNum);
				for (int i = 0; i < n; i++)
					newData[rowNum][colNum] += row[i] * col[i];
			}
		}

		return new Matrix(newData);
	}

	/** returns the matrix composed of all elements
	 * of this matrix discluding those in row and col 
	 * specified */
	public Matrix without(int row, int col)
	{
		double[][] data = new double[this.numRows - 1][this.numCols - 1];
		int size = data.length;
		
		int i = 0;
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			if (rowNum == row) continue;
			for (int colNum = 0; colNum < this.numCols; colNum++)
			{
				if (colNum == col) continue;
				data[i / size][i % size] = this.data[rowNum][colNum];
				i++;
			}
		}

		return new Matrix(data);

	}

	public double cofactor(int row, int col)
	{
		if (this.numRows != this.numCols) return NaN;
		return Math.pow(-1, row + col) * this.without(row, col).determinant();
	}

	public double determinant()
	{
		if (this.numRows != this.numCols) return NaN;
		if (this.numRows == 1) return this.getElem(0, 0);
		if (this.numRows == 2)
		{
			double ad = this.data[0][0] * this.data[1][1];
			double bc = this.data[0][1] * this.data[1][0];
			return ad - bc;
		}
		else 
		{
			double determinant = 0.0;
			for (int i = 0; i < this.numCols; i++)
				determinant += this.getElem(0, i) * this.without(0, i).determinant() * Math.pow(-1, i);
			return determinant;
		}
	}

	public Matrix adjugate()
	{
		double[][] adjugateData = new double[this.numRows][this.numCols];
		for (int rowNum = 0; rowNum < this.numRows; rowNum++)
		{
			for (int colNum = 0; colNum < this.numCols; colNum++)
				adjugateData[rowNum][colNum] = this.cofactor(colNum, rowNum);
		}
		return new Matrix(adjugateData);
	}

	public Matrix inverse()
	{
		if (this.numRows != this.numCols) return null;
		if (this.numRows == 1) return new Matrix(new double[][] {{this.getElem(0, 0)}});
		if (this.numRows == 2)
		{
			double[][] newData = new double[2][2];
			newData[0][0] = this.data[1][1];
			newData[1][1] = this.data[0][0];
			newData[0][1] = -this.data[0][1];
			newData[1][0] = -this.data[1][0];

			double determinant = this.determinant();
			if (determinant == 0.0) return null;

			return (new Matrix(newData)).dividedBy(determinant);
		}
		else
		{
			Matrix adjugate = this.adjugate();
			double determinant = this.determinant();
			if (determinant == 0.0) return null;
			return adjugate.dividedBy(determinant);
		}	
	}

	public String toString()
	{
		String string = "{ ";
		for (int i = 0; i < this.numRows - 1; i++)
		{
			string += "{ ";
			for (int j = 0; j < this.numCols - 1; j++)
				string += this.data[i][j] + ", ";
			string += this.data[i][this.numCols - 1] + " },\n";
		}
		string += "{ ";
		for (int j = 0; j < this.numCols - 1; j++)
			string += this.data[this.numRows - 1][j] + ", ";
		string += this.data[this.numRows - 1][this.numCols - 1] + " } }";
		return string;
	}
}
