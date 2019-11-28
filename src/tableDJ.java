import java.awt.Graphics2D;


public class tableDJ {
	
	private int n;
	private int x,y;
	private int numOfNode,numOfRow;
	private int widthOfCol=50;
	
	private String [][]valuesOfTable=new String[31][31];
	
	public void set(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void setNumOfNode(int numOfNode){
		this.numOfNode=numOfNode+1;
		this.numOfRow=numOfNode+2;
		n=numOfNode;
	}
	public int getN(){
		return n;
	}
	public tableDJ(int x,int y){
		
		this.x=x;
		this.y=y;
		
		
		for(int i=0;i<31;i++)
			for(int j=0;j<31;j++) valuesOfTable[i][j]="";
	}
	public void setWidthOfCol(int w){
		this.widthOfCol=w;
	}
	public void showTable(Graphics2D g2){
		g2.drawRect(x, y, widthOfCol*numOfNode, 20*numOfRow);
		for(int i=1;i<numOfNode;i++){
			g2.drawLine(x+i*widthOfCol, y, x+i*widthOfCol, 20*numOfRow+y);
			if(i>=1) g2.drawString(""+i, x+i*widthOfCol+5, y+15);
		}
		for(int i=1;i<numOfRow;i++){
			g2.drawLine(x, y+i*20, x+widthOfCol*numOfNode, y+i*20);
		}
		for(int i=0;i<31;i++)
			for(int j=0;j<31;j++) setText(g2,valuesOfTable[i][j], i, j); 
	}
	private void setText(Graphics2D g2, String text,int r,int c){
		
		g2.drawString(text, x+r*widthOfCol+2, y+35+c*20);
	}
	public int ToaDoDuoiCuaBang(){
		return 20*numOfRow+20;
	}
	public void setTextForTb(String text, int r, int c){
		valuesOfTable[c][r]=text;
	}
	public void format(){
		for(int i=0;i<31;i++)
			for(int j=0;j<31;j++) valuesOfTable[i][j]="";
	}
	public void delete(int r,int c){
		valuesOfTable[c][r]="";
	}
}
