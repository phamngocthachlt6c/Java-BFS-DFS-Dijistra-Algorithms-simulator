import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class resultSearch extends JFrame{
	
	private int w = 400;
	private int h = 100;
	
	private JLabel result;
	ProsessingTime prosessingTime;
	
	public resultSearch(MainFrame mf,int n){
		super("Result");
		
		this.setAlwaysOnTop(true);
		
		URL iconURL = getClass().getResource("endd.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		this.setLayout(new FlowLayout());
		result = new JLabel("Result: ");
		result.setFont(result.getFont().deriveFont(19.8f));
		this.add(result);
		
		prosessingTime = new ProsessingTime(mf);
		
		
		this.add(prosessingTime);
		
		
		this.setBounds(40,500,w,h);
		
	}
	public void setResult(String str){
		result.setText("result: "+str);
	}
}
