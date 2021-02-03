package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import graphics.Edge_List;
import logic.Edge;
import logic.Link;
import logic.Node;
import logic.Node_Link;

public class FileUtils {
	
	public static int readGraph(File file, Node_Link nodelink, Edge_List edgeList) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		int currentSegment = 0;
		nodelink.FirstNode = null;
		edgeList.First = null;
		int data = 0;
		while((line = br.readLine()) != null) {
			if(line.equals("#")) {
				currentSegment++;
				continue;
			}
			String[] values = line.split(" ");
			switch(currentSegment) {
				case 0:
					//this variable just for counting the number of node, so that can be the next value
					data++;
					Node node = new Node(Integer.parseInt(values[0]), null, null, 
							Integer.parseInt(values[1]), Integer.parseInt(values[2]));
					nodelink.InsertNode(node);
					break;
				case 1:
					Node a = nodelink.get_Node(Integer.parseInt(values[0]));
					Node b = nodelink.get_Node(Integer.parseInt(values[1]));
					int cost = Integer.parseInt(values[2]);
					edgeList.InsertEdge(cost, a, b);
					nodelink.nutxet_nutke(a.cost, b.cost);
					break;
			}
		}

		br.close();
		return data;
	}
	
	public static void writeGraph(File file, Node_Link nodelink, Edge_List edgeList) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		// Write all nodes
		goThroughAddNode(bw, nodelink.FirstNode);
		
		// Write end segment
		bw.write("#");
		
		// Write all links (edges/connections)
		Edge edge = edgeList.First;
		while(edge != null) {
			bw.write(edge.a.cost + " " + edge.b.cost + " " + edge.ts);
			bw.newLine();
			edge = edge.next;
		}
	 
		bw.close();
	}
	
	private List<Node> parseToList(Node_Link data) {
		
		return null;
	}
	
	private static void goThroughtLink(Node_Link nodelink, BufferedWriter bw) throws IOException {
		List<String> listLink = new ArrayList<String>();
		goThroughNodeForLink(nodelink.FirstNode, listLink);
		for(String link : listLink) {
			bw.write(link);
			bw.newLine();
		}
	}
	
	private static void goThroughAddNode(BufferedWriter bw, Node node) throws IOException {
		bw.write(node.cost + " " + node.x + " " + node.y + " ");
		bw.newLine();
		if(node.NodeNext != null) {
			goThroughAddNode(bw, node.NodeNext);
		}
	}
	
	private static void goThroughNodeForLink(Node node, List<String> listLink){
		
		goThroughtLinkInNode(listLink, node, node.adj);
		if(node.NodeNext != null) {
			goThroughNodeForLink(node.NodeNext, listLink);
		}
	}
	
	private static void goThroughtLinkInNode(List<String> listLink, Node rootNote, Link link) {
		listLink.add(rootNote.cost + " " + link.cost.cost);
		if(link.adj != null) {
			goThroughtLinkInNode(listLink, rootNote, link.adj);
		}
	}
}
