
public class kichBanDJ {
	kichBan3 start;
	kichBan3 end;

	Edge_List edgeL;
	
	
	public void insertEdgeL(Edge_List edgeL){
		this.edgeL=edgeL;
	}

	public kichBanDJ() {
		start = end = null;

	}

	

	public void insertKichBan(String text, int r, int c, int edgeN,kqDuyet kq, int nkq) {
		kichBan3 a = new kichBan3(text,r,c, edgeN,kq,nkq);
		if (start == null) {
			start = end = a;
		} else {
			end.next = a;
			a.prev = end;
			end = a;
		}
	}
}
