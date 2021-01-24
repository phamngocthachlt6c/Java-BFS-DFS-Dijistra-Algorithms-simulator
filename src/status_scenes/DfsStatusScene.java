package status_scenes;
import graphics.Edge_List;

public class DfsStatusScene {
	public StatusScene2 start;

	public StatusScene2 end;

	public Edge_List edgeL;

	public DfsStatusScene() {
		start = end = null;

	}

	public void insertEdgeL(Edge_List edgeL) {
		this.edgeL = edgeL;
	}

	public void insertKichBan(String buoc,int []Stack,int l,int nodeDangXet,int nodeKeDangXet,String ketQuaDuyet, int nEdge) {
		StatusScene2 a = new StatusScene2(buoc,Stack,l,nodeDangXet,nodeKeDangXet,ketQuaDuyet,nEdge);
		if (start == null) {
			start = end = a;
		} else {
			end.next = a;
			a.pre = end;
			end = a;
		}
	}
}
