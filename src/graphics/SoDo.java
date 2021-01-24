package graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class SoDo {
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

		g2.drawString("Queue=∅", x + 10, y + 15);
		g2.drawString("f:=0,r:=0", x + 10, y + 30);
		g2.drawString("n:=" + n + ",Start:=" + xuatphat, x + 10, y + 45);

		g2.drawLine(x - 10, y + 50, x + 100, y + 50);

		g2.drawLine(x, y, x - 10, y + 50);
		g2.drawLine(x + 110, y, x + 100, y + 50);
	}

	public void B1(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);

		g2.drawLine(x + 65, y - 20, x + 65, y);
		this.vectorDown(g2, x + 65, y);

		g2.drawLine(x, y, x + 125, y);

		g2.drawString("Queue[r++]:=Start", x + 5, y + 15);
		g2.drawString("Visit[Start]:=1", x + 10, y + 30);

		g2.drawLine(x, y + 35, x + 125, y + 35);
		g2.drawLine(x, y, x, y + 35);
		g2.drawLine(x + 125, y, x + 125, y + 35);
	}

	public void fKhacRFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 15, x + 50, y);
		g2.drawLine(x + 50, y, x, y + 25);
		g2.drawLine(x + 50, y, x + 100, y + 25);
		g2.drawLine(x, y + 25, x + 50, y + 50);
		g2.drawLine(x + 50, y + 50, x + 100, y + 25);
		this.vectorDown(g2, x + 50, y);

		g2.drawString("f<>r", x + 40, y + 30);
	}

	public void fKhacRSecond(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 10, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y - 10, x - 80, y - 10);
		this.vectorRight(g2, x + 50, y - 10);
		g2.drawLine(x - 80, y - 10, x - 80, y + 165);
		this.vectorTop(g2, x - 80, y - 10);
		g2.drawLine(x - 80, y + 165, x, y + 165);
		this.vectorLeft(g2, x - 80, y + 165);
		g2.drawLine(x + 50, y, x, y + 25);
		g2.drawLine(x + 50, y, x + 100, y + 25);
		g2.drawLine(x, y + 25, x + 50, y + 50);
		g2.drawLine(x + 50, y + 50, x + 100, y + 25);

		g2.drawString("S", x - 15, y + 160);

		g2.drawString("f<>r", x + 40, y + 30);
	}

	public void B2(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawString("Đ", x + 35, y - 5);
		g2.drawLine(x + 50, y - 20, x + 50, y);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x, y, x + 100, y);
		g2.drawString("i:=Queue[f++]", x + 5, y + 15);
		g2.drawString("j:=1", x + 5, y + 30);
		g2.drawString("print out screen", x + 5, y + 45);
		g2.drawLine(x, y + 50, x + 100, y + 50);
		g2.drawLine(x, y, x, y + 50);
		g2.drawLine(x + 100, y, x + 100, y + 50);
	}

	public void jBeHonNFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		this.vectorDown(g2, x + 50, y);
		g2.drawLine(x + 50, y, x + 50, y - 20);
		g2.drawLine(x + 50, y, x, y + 25);
		g2.drawLine(x + 50, y, x + 100, y + 25);
		g2.drawLine(x, y + 25, x + 50, y + 50);
		g2.drawLine(x + 50, y + 50, x + 100, y + 25);
		g2.drawString("j<=n", x + 40, y + 30);
	}

	public void jBeHonNSecond(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x + 50, y - 13, x - 50, y - 13);

		g2.drawLine(x - 50, y - 13, x - 50, y + 50);
		this.vectorTop(g2, x - 50, y - 13);
		this.vectorRight(g2, x + 50, y - 13);
		g2.drawLine(x + 50, y, x, y + 25);
		g2.drawLine(x + 50, y, x + 100, y + 25);
		g2.drawLine(x, y + 25, x + 50, y + 50);
		g2.drawLine(x + 50, y + 50, x + 100, y + 25);
		g2.drawString("j<=n", x + 40, y + 30);

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
		g2.drawString("Visit[i]=0", x + 30, y + 27);
		g2.drawString("a[i][j]=1", x + 30, y + 42);
	}

	public void B3(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		this.vectorRight(g2, x, y + 15);
		g2.drawString("Đ", x - 15, y + 10);
		g2.drawLine(x - 25, y + 15, x, y + 15);
		g2.drawLine(x, y, x + 100, y);
		g2.drawString("Visit[i]:=1", x + 5, y + 15);
		g2.drawString("Queue[r++]:=1", x + 5, y + 30);
		g2.drawLine(x, y + 35, x + 100, y + 35);
		g2.drawLine(x, y, x, y + 35);
		g2.drawLine(x + 100, y, x + 100, y + 35);
	}

	public void theEnd(Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.drawString("S", 280, 200);
		g2.drawOval(300, 190, 100, 30);
		g2.drawString("End", 325, 210);
		g2.drawLine(270, 205, 300, 205);
		this.vectorRight(g2, 300, 205);
	}

	public void plusJFirst(Graphics2D g2, Color c, int x, int y) {
		g2.setColor(c);
		g2.drawLine(x - 80, y + 50, x - 30, y + 50);
		g2.drawString("j++", x - 65, y + 65);
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
		g2.drawString("j++", x - 65, y + 65);
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

	public void showSoDo(Graphics2D g2, int n, int xuatphat) {
		showStart(g2, Color.black);
		khoitao(g2, Color.black, 165, 60, n, xuatphat);
		B1(g2, Color.black, 155, 130);
		fKhacRFirst(g2, Color.black, 170, 180);
		fKhacRSecond(g2, Color.black, 170, 180);
		B2(g2, Color.black, 170, 250);
		jBeHonNFirst(g2, Color.black, 170, 320);
		daTham(g2, Color.black, 165, 390);
		B3(g2, Color.black, 300, 405);
		theEnd(g2, Color.black);

		this.jBeHonNSecond(g2, Color.black, 170, 320);
		plusJFirst(g2, Color.black, 170, 320);
		plusJSecond(g2, Color.black, 170, 320);
	}
}
