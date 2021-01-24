package graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class NoteScreen {
	private class DongChuThich{
		Color color;
		String str;
		DongChuThich next;
		
		public DongChuThich(Color color, String str){
			this.color=color;
			this.str=str;
			next = null;
		}
	}
	private class CacDongCT{
		DongChuThich first = null;
		DongChuThich last = null;
		public void insert(Color color, String str){
			if(first==null&&last==null){
				first = last = new DongChuThich(color,str);
			}else{
				DongChuThich next = new DongChuThich(color, str);
				last.next=next;
				last = next;
			}
		}
	}
	CacDongCT list;
	int x, y;
	public void addItem(Color color, String str){
		list.insert(color, str);
	}
	
	public void setPosition(int x, int y){
		this.x=x;
		this.y=y;
	}
	public NoteScreen(int x, int y){
		list = new CacDongCT();
		this.x=x;
		this.y=y;
	}
	public void showCT(Graphics2D g2){
		int i=1;
		DongChuThich p = list.first;
		
		g2.setFont(new Font("Courier New", Font.ITALIC, 12));
		
		
		int dongHienTai = 1;
		while(p!=null){
			if(i%2!=0){
				g2.setColor(p.color);
				g2.fillOval(x, y+20*dongHienTai, 15, 15);
				g2.setColor(Color.black);
				g2.drawString(p.str, x+17, y+13+20*dongHienTai);
			}else{
				g2.setColor(p.color);
				g2.fillOval(x+190, y+20*dongHienTai, 15, 15);
				g2.setColor(Color.black);
				g2.drawString(p.str, x+207, y+13+20*dongHienTai);
				
				dongHienTai++;
			}
			i++;
			p=p.next;
		}
	}
}
