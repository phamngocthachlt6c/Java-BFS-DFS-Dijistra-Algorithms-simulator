class Line_List{
	Line_in_Nodes p;
	Line_in_Nodes First,Last;
	Line_List(){
		First=Last=null;
	}
	void Insert_Line(Node d,Node c){
		p=new Line_in_Nodes(d,c,null);
		if(First==null){
			First=p;
			Last=p;
		}
		else{
			Last.Next=p;
			Last=p;
		}
	}
	boolean isExist(Node d,Node c){
		p=First;
		while(p!=null){
			
			if(p.d==d&&p.c==c) return true;
			p=p.Next;
		}
		return false;
	}
	void printf(){
		p=First;
		while(p!=null){
			System.out.println(p.d.cost+"-"+p.c.cost);
			p=p.Next;
		}
	}
}
