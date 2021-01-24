package status_scenes;
import graphics.Edge_List;

public class kichBanDJ {
	public StatusScene3 start;
	public StatusScene3 end;

	public Edge_List edgeL;
	
	
	public void insertEdgeL(Edge_List edgeL){
		this.edgeL=edgeL;
	}

	public kichBanDJ() {
		start = end = null;

	}

	

	public void insertKichBan(String text, int r, int c, int edgeN,kqDuyet kq, int nkq) {
		StatusScene3 a = new StatusScene3(text,r,c, edgeN,kq,nkq);
		if (start == null) {
			start = end = a;
		} else {
			end.next = a;
			a.prev = end;
			end = a;
		}
	}
}
