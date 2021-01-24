package status_scenes;

public class kqDuyet {
	public goiKqDuyet first, end;

	public kqDuyet() {
		first = end = null;
	}

	public void insertGoiDuyet(int from, int to, String kqDuyet, int ts) {
		if (first == null) {
			first = end = new goiKqDuyet(from, to, kqDuyet, ts);
		} else {
			goiKqDuyet a = new goiKqDuyet(from, to, kqDuyet, ts);
			end.next = a;
			end = a;
		}
	}
	public void out(){
		goiKqDuyet p = first;
		while(p!=null){
			System.out.println(p.from+"-"+p.to+": "+p.kqDuyet+","+p.ts);
			p=p.next;
		}
	}
	public goiKqDuyet getGoiKqDuyet(int n){
		goiKqDuyet p = first;
		int i=0;
		while(p!=null&&i<n){
			p=p.next;
			i++;
		}
		return p;
	}
}
