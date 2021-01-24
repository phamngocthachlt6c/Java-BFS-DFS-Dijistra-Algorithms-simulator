package status_scenes;

public class StatusScene{
	
	public String buoc;
	public int r,f;
	public int [] queue;
	public int nodeDangXet;
	public int nodeKeDangXet;
	
	public String kqDuyet;
	
	public int soDinhDaDuyet;
	
	public int nEdge;
	
	public int i,j;
	
	public StatusScene next;
	public StatusScene pre;
	
	public StatusScene(String buoc, int f, int r, int[] queue,int nodeDangXet, int nodeKeDangXet, int nEdge,int i,int j, String kqDuyet, int soDinhDaDuyet){
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