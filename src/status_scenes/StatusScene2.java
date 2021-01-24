package status_scenes;


public class StatusScene2 {

	public String buoc;
	public int r, f;
	public int[] Stack;
	public int l;
	

	
	public int nodeDangXet;
	public int nodeKeDangXet;
	
	public String ketQuaDuyet;

	public int nEdge;

	public int i, j;

	public StatusScene2 next;
	public StatusScene2 pre;

	public StatusScene2(String buoc, int []Stack,int l,int nodeDangXet,int nodeKeDangXet,String ketQuaDuyet, int nEdge) {
		this.buoc = buoc;
		
		this.ketQuaDuyet=ketQuaDuyet;
		this.nodeDangXet=nodeDangXet;
		this.nodeKeDangXet=nodeKeDangXet;
		this.nEdge=nEdge;
		int []s = new int[31];
		for(int i=0;i<31;i++) 
			s[i]=Stack[i];	
		
		System.out.println();
		
		this.Stack=s;
		this.l=l;
		/*
		 * this.r=r; this.f=f; this.Stack=Stack; this.nodeDangXet=nodeDangXet;
		 * this.nodeKeDangXet=nodeKeDangXet; this.nEdge=nEdge; this.i=i;
		 * this.j=j;
		 */
		next = null;
	}
}
