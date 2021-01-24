package graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import status_scenes.StatusScene2;

public class SoDoDFS {
	private void vectorDown(Graphics2D g2, int x, int y) {
		g2.drawLine(x, y, x - 3, y - 4);
		g2.drawLine(x, y, x + 3, y - 4);
	}

	private void vectorRight(Graphics2D g2, int x, int y) {
		g2.drawLine(x, y, x - 4, y - 3);
		g2.drawLine(x, y, x - 4, y + 3);
	}

	private void vectorLeft(Graphics2D g2, int x, int y) {
		g2.drawLine(x, y, x + 4, y - 3);
		g2.drawLine(x, y, x + 4, y + 3);
	}

	private void vectorTop(Graphics2D g2, int x, int y) {
		g2.drawLine(x, y, x - 3, y + 4);
		g2.drawLine(x, y, x + 3, y + 4);
	}

	public void showStart(Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.drawOval(170, 10, 100, 30);
		g2.drawString("Begin", 200, 30);
	}

	public void khoitao(Graphics2D g2, Color c, int x, int y, int n,
			int xuatphat) {
		g2.setColor(c);

		g2.drawLine(220, 40, 220, 60);
		vectorDown(g2, x + 55, y);

		g2.drawLine(x, y, x + 110, y);

		g2.drawString("Stack=∅", x + 10, y + 15);
		g2.drawString("topS=0", x + 10, y + 30);
		g2.drawString("n:=" + n + ",start:=" + xuatphat, x + 10, y + 45);

		g2.drawLine(x - 10, y + 50, x + 100, y + 50);

		g2.drawLine(x, y, x - 10, y + 50);
		g2.drawLine(x + 110, y, x + 100, y + 50);
	}

	public void B1(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);

		g2.drawLine(x + 65, y - 20, x + 65, y);
		this.vectorDown(g2, x + 65, y);

		g2.drawLine(x, y, x + 140, y);

		g2.drawString("Stack[topS++]:=start", x + 5, y + 15);
		

		g2.drawLine(x, y + 20, x + 140, y + 20);
		g2.drawLine(x, y, x, y + 20);
		g2.drawLine(x + 140, y, x + 140, y + 20);
	}

	public void fKhacRFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		g2.drawLine(x + 50, y, x, y + 20);
		g2.drawLine(x + 50, y, x + 100, y + 20);
		g2.drawLine(x, y + 20, x + 50, y + 40);
		g2.drawLine(x + 50, y + 40, x + 100, y + 20);
		this.vectorDown(g2, x + 50, y);

		g2.drawString("topS>0", x + 32, y + 25);
	}

	public void fKhacRSecond(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 10, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y - 10, x - 80, y - 10);
		this.vectorRight(g2, x + 50, y - 10);
		g2.drawLine(x - 80, y - 10, x - 80, y + 190);
		this.vectorTop(g2, x - 80, y - 10);
		g2.drawLine(x - 80, y + 190, x, y + 190);
		this.vectorLeft(g2, x - 80, y + 190);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		g2.drawLine(x + 50, y, x, y + 20);
		g2.drawLine(x + 50, y, x + 100, y + 20);
		g2.drawLine(x, y + 20, x + 50, y + 40);
		g2.drawLine(x + 50, y + 40, x + 100, y + 20);

		g2.drawString("S", x - 15, y + 180);

		g2.drawString("topS>0", x + 32, y + 25);
	}
	public void fKhacThird(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 10, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y - 10, x - 40, y - 10);
		this.vectorRight(g2, x + 50, y - 10);
		g2.drawLine(x - 40, y - 10, x - 40, y + 103);
		this.vectorTop(g2, x - 40, y - 10);
		g2.drawLine(x - 40, y + 103, x, y + 103);
		this.vectorLeft(g2, x - 40, y + 103);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		g2.drawLine(x + 50, y, x, y + 20);
		g2.drawLine(x + 50, y, x + 100, y + 20);
		g2.drawLine(x, y + 20, x + 50, y + 40);
		g2.drawLine(x + 50, y + 40, x + 100, y + 20);

		g2.drawString("S", x - 15, y + 99);

		g2.drawString("topS>0", x + 32, y + 25);
	}
	public void B2(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawString("Đ", x + 35, y - 3);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x, y, x + 100, y);
		g2.drawString("v=Stack[--topS]", x + 5, y + 15);
		
		g2.drawLine(x, y + 20, x + 100, y + 20);
		g2.drawLine(x, y, x, y + 20);
		g2.drawLine(x + 100, y, x + 100, y + 20);
	}

	public void jBeHonNFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y, x + 50, y - 20);
		g2.drawLine(x + 50, y, x, y + 15);
		g2.drawLine(x + 50, y, x + 100, y + 15);
		g2.drawLine(x, y + 15, x + 50, y + 30);
		g2.drawLine(x + 50, y + 30, x + 100, y + 15);
		g2.drawString("u>=1", x + 40, y + 20);
	}

	public void jBeHonNSecond(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 13, x - 50, y - 13);

		g2.drawLine(x - 50, y - 13, x - 50, y + 30);
		this.vectorTop(g2, x - 50, y - 13);
		this.vectorRight(g2, x + 50, y - 13);
		g2.drawLine(x + 50, y, x, y + 15);
		g2.drawLine(x + 50, y, x + 100, y + 15);
		g2.drawLine(x, y + 15, x + 50, y + 30);
		g2.drawLine(x + 50, y + 30, x + 100, y + 15);
		g2.drawString("u>=1", x + 40, y + 20);

		g2.drawLine(x + 50, y - 10, x + 50, y);

		this.vectorDown(g2, x + 50, y);
	}

	public void daTham(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 55, y, x + 55, y - 20);
		this.vectorDown(g2, x + 55, y);
		g2.drawString("Đ", x + 42, y - 5);
		g2.drawLine(x + 55, y, x, y + 30);
		g2.drawLine(x + 55, y, x + 110, y + 30);
		g2.drawLine(x, y + 30, x + 55, y + 60);
		g2.drawLine(x + 55, y + 60, x + 110, y + 30);
		g2.drawString("Visited[i]=0", x + 27, y + 27);
		g2.drawString("a[i][j]=1", x + 30, y + 42);
	}

	public void B3(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		this.vectorRight(g2, x, y + 15);
		g2.drawString("Đ", x - 15, y + 10);
		g2.drawLine(x - 25, y + 15, x, y + 15);
		g2.drawLine(x, y, x + 100, y);
		//g2.drawString("Tham[i]:=1", x + 5, y + 15);
		g2.drawString("Stack[topS++]:=u", x + 5, y + 30);
		g2.drawLine(x, y + 35, x + 100, y + 35);
		g2.drawLine(x, y, x, y + 35);
		g2.drawLine(x + 100, y, x + 100, y + 35);
	}

	public void theEnd(Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.drawString("S", 280, 180);
		g2.drawOval(300, 170, 100, 30);
		g2.drawString("End", 325, 190);
		g2.drawLine(270, 185, 300, 185);
		this.vectorRight(g2, 300, 185);
	}

	public void plusJFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x - 80, y + 50, x - 30, y + 50);
		g2.drawString("u--", x - 65, y + 65);
		g2.drawLine(x - 80, y + 70, x - 30, y + 70);
		g2.drawLine(x - 80, y + 50, x - 80, y + 70);
		g2.drawLine(x - 30, y + 50, x - 30, y + 70);

		g2.drawLine(x - 50, y + 150, x + 180, y + 150);
		g2.drawLine(x + 180, y + 150, x + 180, y + 120);
		this.vectorDown(g2, x + 180, y + 150);
		this.vectorLeft(g2, x - 50, y + 150);
		g2.drawLine(x - 50, y + 150, x - 50, y + 70);
		this.vectorTop(g2, x - 50, y + 70);
	}

	public void plusJSecond(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x - 80, y + 50, x - 30, y + 50);
		g2.drawString("u--", x - 65, y + 65);
		g2.drawLine(x - 80, y + 70, x - 30, y + 70);
		g2.drawLine(x - 80, y + 50, x - 80, y + 70);
		g2.drawLine(x - 30, y + 50, x - 30, y + 70);

		g2.drawLine(x - 50, y + 100, x - 5, y + 100);

		this.vectorLeft(g2, x - 50, y + 100);

		g2.drawLine(x - 50, y + 100, x - 50, y + 70);
		this.vectorTop(g2, x - 50, y + 70);

		g2.drawString("S", x - 15, y + 95);
	}

	public void showState(Graphics2D g2, int f, int r, int i, int j) {
		Graphics2D G2 = g2;
		G2.setColor(Color.red);

		g2.drawString("F=" + f, 10, 20);
		g2.drawString("R=" + r, 10, 35);
		g2.drawString("i=" + i, 10, 50);
		g2.drawString("j=" + j, 10, 65);
	}
	
	public void stack(StatusScene2 buoc,Graphics2D g2){
		
		
	
		
		if(buoc!=null){
			int yo=430;
			for(int i=0;i<buoc.l;i++){
				g2.setColor(Color.blue);
				g2.fillRect(22, yo+1, 27, 18);
				g2.setColor(Color.white);
				g2.drawString(buoc.Stack[i]+"", 28, yo+14);
				yo-=20;
				
			
			}
			
		}
		
		g2.setColor(Color.black);
		g2.drawLine(20, 150, 20, 450);
		g2.drawLine(50, 150, 50, 450);
		g2.drawLine(20, 450, 50, 450);
		g2.drawString("Stack", 20, 465);
		
	}
	public void daThamChua(Graphics2D g2, Color c, int x, int y){
		g2.setColor(c);
		
		g2.drawLine(x + 50, y - 10, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y, x, y + 18);
		g2.drawLine(x + 50, y, x + 100, y + 18);
		g2.drawLine(x, y + 18, x + 50, y + 36);
		g2.drawLine(x + 50, y + 36, x + 100, y + 18);
		
		g2.drawString("Visited[v]=1", x+19, y+23);
	}
	public void printToScreen(Graphics2D g2, Color c, int x, int y){
		g2.setColor(c);
		g2.drawString("Đ", x + 35, y - 3);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x-13, y, x + 121, y);
		g2.drawString("print v,Visited[v]:=1,u:=n", x -8, y + 15);
		
		g2.drawLine(x-13, y + 20, x + 121, y + 20);
		g2.drawLine(x-13, y, x-13, y + 20);
		g2.drawLine(x + 121, y, x + 121, y + 20);
	}
	public void showSoDo(Graphics2D g2, int n, int xuatphat) {
		showStart(g2, Color.black);
		khoitao(g2, Color.black, 165, 60, n, xuatphat);
		B1(g2, Color.black, 155, 130);
		fKhacRFirst(g2, Color.black, 170, 165);
		fKhacRSecond(g2, Color.black, 170, 165);
		B2(g2, Color.black, 170, 220);
		jBeHonNFirst(g2, Color.black, 170, 340);
		daTham(g2, Color.black, 165, 390);
		B3(g2, Color.black, 300, 405);
		theEnd(g2, Color.black);

		this.jBeHonNSecond(g2, Color.black, 170, 340);
		plusJFirst(g2, Color.black, 170, 320);
		plusJSecond(g2, Color.black, 170, 320);
		
		daThamChua(g2,Color.black, 170, 250);
		
		printToScreen(g2,Color.black, 170,300);
		
		this.fKhacThird(g2, Color.black, 170, 165);
	}
}
