

public class KichBanDFS {
	kichBan2 start;

	kichBan2 end;

	Edge_List edgeL;

	public KichBanDFS() {
		start = end = null;

	}

	public void insertEdgeL(Edge_List edgeL) {
		this.edgeL = edgeL;
	}

	public void insertKichBan(String buoc,int []Stack,int l,int nodeDangXet,int nodeKeDangXet,String ketQuaDuyet, int nEdge) {
		kichBan2 a = new kichBan2(buoc,Stack,l,nodeDangXet,nodeKeDangXet,ketQuaDuyet,nEdge);
		if (start == null) {
			start = end = a;
		} else {
			end.next = a;
			a.pre = end;
			end = a;
		}
	}
}
