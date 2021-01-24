package logic;

public class MatNum {
	private int[][] A = new int[30][30];
	private int size;
	
	public int getSize(){
		return size;
	}
	public MatNum(){
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
				if(i==j)A[i][j]=0;
				else A[i][j]=1111;
	}
	public void out(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++)
				System.out.printf("%4d",A[i][j]);
			System.out.println();
		}
	}
	public void updateSize(Node_Link ds){
		if(ds.FirstNode!=null){
			size=ds.LastNode.cost+1;
			for(int i=0;i<size;i++)
				A[i][size]=A[size][i]=1111;
				A[size][size]=0;
			
		}
		else {
			size=0;
		}
	}
	public void del_node(int node){
		for(int i=0;i<=size;i++){
			for(int j=node;j<=size;j++)A[i][j]=A[i][j+1];
		}
		for(int i=0;i<=size;i++){
			for(int j=node;j<=size;j++)A[j][i]=A[j+1][i];
		}
	}
	public void insertEdge(int node1,int node2,int Num){
		A[node1][node2]=A[node2][node1]=Num;
	}
	public void delEdge(int node1,int node2){
		A[node1][node2]=A[node2][node1]=1111;
	}
	public int[][] getA(){
		return A;
	}
}
