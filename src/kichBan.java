public class kichBan{
	
	String buoc;
	int r,f;
	int [] queue;
	int nodeDangXet;
	int nodeKeDangXet;
	
	String kqDuyet;
	
	int soDinhDaDuyet;
	
	int nEdge;
	
	int i,j;
	
	kichBan next;
	kichBan pre;
	
	public kichBan(String buoc, int f, int r, int[] queue,int nodeDangXet, int nodeKeDangXet, int nEdge,int i,int j, String kqDuyet, int soDinhDaDuyet){
		this.buoc=buoc;
		this.r=r;
		this.f=f;
		this.queue=queue;
		this.nodeDangXet=nodeDangXet;
		this.nodeKeDangXet=nodeKeDangXet;
		this.nEdge=nEdge;
		this.i=i;
		this.j=j;
		this.soDinhDaDuyet=soDinhDaDuyet;
		
		this.kqDuyet=kqDuyet;
		
		next = null;
	}
}