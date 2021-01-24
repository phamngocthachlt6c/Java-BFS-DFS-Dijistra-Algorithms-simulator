package status_scenes;
import graphics.Edge_List;

public class BfsStatusScene {
	public StatusScene start,end;
	
	public Edge_List edgeL;
	
	public BfsStatusScene(){
		start=end=null;
		
	}
	public void insertEdgeL(Edge_List edgeL){
		this.edgeL=edgeL;
	}
	public void insertSceneStatus(String buoc, int f, int r, int [] queue,int nodeDangXet,int nodeKeDangXet, int nEdge,int i,int j,String kqDuyet, int soDinhDaDuyet){
		StatusScene a = new StatusScene(buoc,f,r,queue,nodeDangXet, nodeKeDangXet, nEdge,i,j, kqDuyet, soDinhDaDuyet);
		if(start==null){
			start=end=a;
		}else{
			end.next=a;
			a.pre=end;
			end=a;
		}
	}
}
