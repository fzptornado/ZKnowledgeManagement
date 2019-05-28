package txtFileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class Responsibility: Work with file to Manage Data with text file. In
 * each row, one record was stored.
 * 
 * @author f.zarepour
 * @version 1.0
 * @category Data Store Connection
 * @since 2019-05-01
 */
public class TFileManeger implements IFileManager {
	private String fileName;
	private String folderPath;

	public TFileManeger(String fileName) {
		super();
		// this.fileName = "K:\\Java WorkSpace\\" + fileName;
		this.fileName = fileName;
		this.folderPath = "Files";
		this.CreateFile();
	}

	///////////////////////////////////////////////////////////////// setter and
	///////////////////////////////////////////////////////////////// getter of
	///////////////////////////////////////////////////////////////// fileName
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String getFileAddress() {
		return folderPath + "\\" + this.getFileName();
	}

	////////////////////////////////////////////////////////////////////////////// CreateFile
	private void CreateFile() {
		// Check Folder Exist

		File f1 = new File(this.folderPath);
		if (!f1.exists()) {
			try {
				f1.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 f1 = new File(this.getFileAddress());
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	///////////////////////////////////////////////////////////////////////// *******RowBaseOperations*********

	////////////////////////////////////////////////////////////////////////// AppendRow
	public void AppendRow(String newRow) {
		String s = getFromFile();
		if (s == "")
			s = newRow;
		else
			s += "\r\n" + newRow;
		setStringToFile(s);
	}

	///////////////////////////////////////////////////////////////////////////// DeleteRow
	public void deleteRow(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			return;
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				sc.nextLine();
				continue;
			}
			if (output == "")
				output += sc.nextLine();
			else

				output += "\r\n" + sc.nextLine();
		}
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);

	}

	//////////////////////////////////////////////////////////////////////// insertRow

	public void insertRow(int index, String text) {
		if (index < 0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			return;
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				if (output == "")
					output += text;
				else

					output += "\r\n" + text;
			}
			if (output == "")
				output += sc.nextLine();
			else

				output += "\r\n" + sc.nextLine();
		}
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);
	}

	/////////////////////////////////////////////////////////////////////// UpdateRow
	@Override
	public void UpdateRow(int index, String text) {
		if (index < 0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc =getScanner();
		} catch (FileNotFoundException e) {
			return;
		}

		int cIndex = 0;// Counter of File Lines

		while (sc.hasNext()) {
			if (cIndex++ == index) {
				if (output == "")
					output += text;
				else

					output += "\r\n" + text;
			} else {
				if (output == "")
					output += sc.nextLine();
				else

					output += "\r\n" + sc.nextLine();
			}
		}
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		this.setStringToFile(output);
	}

	/////////////////////////////////////////////////////////////////////// GetRow
	public String getRow(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("index cannot be negative.");
		}
		String output = "";
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			if (cIndex++ == index) {
				output = sc.nextLine();
				break;
			}
			sc.nextLine();
		}
		if (cIndex < (index + 1)) {
			throw new IllegalArgumentException("Index is out of array row range");
		}
		sc.close();
		return output;
	}

	/////////////////////////////////////////////////////////////////////// GetRowStartWith
	public String getRowStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		String output = null;
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output = temp;
				break;
			}

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// GetRowsStartWith
	public List<String> getRowsStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		List<String> output = new ArrayList<>();
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output.add(temp);
				break;
			}

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// getRowIndexStartWith
	public int getFirstRowIndexStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		int output = -1;
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output = cIndex;
				break;
			}
			cIndex++;

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// getRowsIndexStartWith
	public List<Integer> getRowsIndexStartWith(String startWith) {
		if (startWith.isEmpty()) {
			throw new IllegalArgumentException("startWith param is Empty");
		}
		List<Integer> output = new ArrayList<Integer>();
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Found");
		}
		int cIndex = 0;
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			if (temp.startsWith(startWith)) {
				output.add(cIndex);
			}
			cIndex++;

		}
		sc.close();

		return output;
	}

	/////////////////////////////////////////////////////////////////////// *******FileBaseOperations**********
	/////////////////////////////////////////////////////////////////////// GetFromFile
	private String getFromFile() {
		String output = "";
		try {
			// Create a new Scanner object which will read the data
			// from the file passed in. To check if there are more
			// line to read from it we check by calling the
			// scanner.hasNextLine() method. We then read line one
			// by one till all lines is read.
			Scanner input = getScanner();
			while (input.hasNextLine()) {
				if (output == "") {
					output += input.nextLine();

				} else
					output += "\r\n" + input.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}

	//////////////////////////////////////////////////////////////////////// SetStringToFile
	private void setStringToFile(String s) {

		try {
			PrintWriter out = new PrintWriter(this.getFileAddress());
			out.print(s);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	////////////////////////////////////////////////////////////////////////// clearFile
	public void Clear() {
		setStringToFile("");
	}

	//////////////////////////////////////////////////////////////////// getRowCount
	public int getRowCount() {
		int rowCount = 0;
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return rowCount;
		}
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			rowCount++;
		}
		sc.close();
		return rowCount;
	}

	//////////////////////////////////////////////////////////////////// getArrayFromFile
	@Override
	public String[] getArray() {
		int rowCount = this.getRowCount();
		String[] output = new String[rowCount];
		Scanner sc;
		try {
			sc = getScanner();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		int i = 0;
		while (sc.hasNextLine()) {
			output[i++] = sc.nextLine();
		}
		sc.close();
		return output;
	}
	
	private Scanner getScanner() throws FileNotFoundException{
		return new Scanner(new File(this.getFileAddress()));
	}

	@Override
	public String toString() {
		return this.getFromFile();

	}
	

}
