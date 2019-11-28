
public class TapDinh {
	public class Dinh{
		int dinh;
		int d;
		int path;
		Dinh next;
		Dinh(int v,int d,int path){
			this.dinh=v;
			this.d=d;
			this.path=path;
			next=null;
		}
	}
	Dinh start, end;
	
	public TapDinh(){
		start=end=null;
		
	}
	public void insertDinh(int v, int d, int path){
		Dinh dinh = new Dinh(v,d,path);
		if(start==null){
			start=end=dinh;
		}else
		{
			end.next=dinh;
			end=dinh;
		}
	}
	public int getMin(){
		if(start!=null){
			Dinh m = start;
			Dinh p = start;
			int min = start.d;
			while(m!=null){
				if(m.d<min) {
					p=m;
					min=m.d;
				}
				m=m.next;
			}
			return p.dinh;
		}
		return -1;
	}
	public void delete(int v){
		if(start!=null)
		{
			if(start.dinh==v) start=start.next;
			else {
				Dinh p = start;
				Dinh pp = null;
				while(p!=null) {
					if(p.dinh==v) pp=p;
					p=p.next;
				}
				Dinh p2 = start;
				Dinh p2p = null;
				while(p2.next!=null){
					if(p2.next.dinh==v) p2p=p2;
					p2=p2.next;
				}
				if(p2p!=null&&pp!=null)p2p.next=pp.next;
			}
		}
	}
	public void out(){
		Dinh p = start;
		while(p!=null){
			System.out.println("**"+p.dinh);
			p=p.next;
		}
	}
	private boolean isEmpty(){
		if(start==end&&start==null) return true;
		return false;
	}
	public boolean inTapDinh(int v){
		Dinh p = start;
		while(p!=null){
			if(p.dinh==v) return true;
			p=p.next;
		}
		return false;
	}
	public void plusVandIBeHon(Dinh V,int i,int dd, int path){
		
		Dinh p2 = start;
		Dinh p2p=null;
		while(p2!=null){
			if(p2.dinh==i) p2p=p2;
			p2=p2.next;
		}
		
		if(dd+V.d<p2p.d){
			p2p.d=V.d+dd;
			p2p.path=path;
		}
		if(p2p.d==1111) p2p.path=path;
		
	}
	public Dinh getDinh(int v){
		Dinh p = start;
		
		while(p!=null){
			if(p.dinh==v) return p;
			p=p.next;
		}
		return null;
	}
	public Dinh getVisDMin(){
		if(start!=null){
			int min = start.d;
			Dinh DMin = start;
			Dinh p = start;
			while(p!=null){
				if(p.d<min) {
					min=p.d;
					DMin = p;
				}
				p=p.next;
			}
			return DMin;
		}
		else return null;
	}
}
