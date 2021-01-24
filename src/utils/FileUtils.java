package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import logic.Node;
import logic.Node_Link;

public class FileUtils {
	public static void writeGraph(File file, Node_Link nodelink) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (int i = 0; i < 10; i++) {
			bw.write("something");
			bw.newLine();
		}
	 
		bw.close();
	}
	
	private List<Node> parseToList(Node_Link data) {
		
		return null;
	}
	
	private void goThroughAddNode(Node node) {
//		if(node.)
	}
}
