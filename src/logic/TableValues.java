package logic;
import javax.swing.table.AbstractTableModel;

public class TableValues extends AbstractTableModel {
	public Object[][] A = new Object[30][30];

	public void Input(int matric[][], int size) {
		for (int i = 0; i < 30; i++)
			for (int j = 0; j < 30; j++)
				if (j < size && i < size) {
					if (matric[i][j] == 1111)
						A[i][j] = "∞";
					else
						A[i][j] = matric[i][j];
				} else
					A[i][j] = "";

	}

	public int getColumnCount() {
		return A[0].length;

	}

	public int getRowCount() {

		return A.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return A[rowIndex][columnIndex];
	}

}
