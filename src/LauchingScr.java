import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LauchingScr extends JFrame{
	
	class ContentPanel extends JPanel {
		  Image bgimage = null;
		   private Image image=null;
		  ContentPanel() {
			  URL url = getClass().getResource("end.png");
		        image = Toolkit.getDefaultToolkit().getImage(url);
		  }
		  protected void paintComponent(Graphics g) {
			    super.paintComponent(g);
			  
			    g.drawImage(image,0,0,this);
			  }
	}
	
	public LauchingScr(){
		super("Algorithms simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final LauchingScr a = this;
		
//		URL iconURL = getClass().getResource("endd.png");
//		// iconURL is null when not found
//		ImageIcon icon = new ImageIcon(iconURL);
//		setIconImage(icon.getImage());
//		this.setBounds(100,30,800,480);
//		this.setVisible(true);
//		this.setLayout(null);
		
		a.setVisible(false);
		new MainFrame();
		
		
		
		JButton go = new JButton("Continue");
		go.setBounds(350,400,100,30);
		add(go);
		go.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				a.setVisible(false);
				new MainFrame();
			}
			
		});
		
		ContentPanel p = new ContentPanel();
		p.setBounds(0,0,800, 390);
		
		add(p);
	}
	
	public static void main(String[] as) {
		new LauchingScr();
	}
}
