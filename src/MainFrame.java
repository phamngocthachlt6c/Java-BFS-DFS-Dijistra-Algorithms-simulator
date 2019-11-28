import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Thach Shichibukai
 * 
 */
public class MainFrame extends JFrame implements ActionListener {

	private static final int WIDTH = 1000;
	private static final int HEIGH = 720;

	public static final int width = 501;
	public static final int heigh = 411;

	public resultSearch result;

	/////////////////////////////
	
	int xBFS;
	int xDFS;
	boolean press=false;
	///////////////////////////
	
	
	
	public static int xStartBt = 70;
	public static int yStartBt = 20;
	public static int wStartBt = 50;
	public static int hStartBt = 20;
	
	public static int xStopBt = 130;
	public static int yStopBt = 20;
	public static int wStopBt = 50;
	public static int hStopBt = 20;
	
	public static int xNextBt = 80;
	public static int yNextBt = 20;
	public static int wNextBt = 50;
	public static int hNextBt = 20;
	
	public static int xPreBt = 20;
	public static int yPreBt = 20;
	public static int wPreBt = 50;
	public static int hPreBt = 20;
	
	panelQuanCao qc = new panelQuanCao(15, 20);
	workPanel wp = new workPanel(this);
	JPanel ctrTable = new JPanel();
	JPanel MatricTable;
	JTable table = new JTable();
	TableValues tableValues = new TableValues();

	JButton edit = new JButton("Sửa đô thị");
	
	// //////////////////////////
	private int loccard = 1;
	CardLayout card = new CardLayout();
	JPanel desc = new JPanel();
	// //////cac panel mo phong//////////////
	ImageIcon startIcon = new ImageIcon(MainFrame.class.getResource("startIcon.png"));
	Icon pauseIcon = new ImageIcon(MainFrame.class.getResource("pauseIcon.png"));
	Icon stopIcon = new ImageIcon(MainFrame.class.getResource("stopIcon.png"));
	Icon nextIcon = new ImageIcon(MainFrame.class.getResource("nextIcon.png"));
	Icon previousIcon = new ImageIcon(MainFrame.class.getResource("previousIcon.png"));
	

	private JPanel panelSuadoThi = new PanelSuaDoThi();
	private JPanel panelDuyetRong = new JPanel();
	public panelSoDoBFS panelSoDoBFS = new panelSoDoBFS(this);
	public panelSoDoDFS panelSoDoDFS = new panelSoDoDFS(this);
	public panelDijstra panelDijstra = new panelDijstra(this);

	public JPanel panelDuyetSau = new JPanel();
	public JPanel panelDij = new JPanel();

	// ////// Panel BFS //////////////////////

	JTextField queue = new JTextField();
	public JButton batdau;

	// //////// panel DFS/////////////
	JLabel ketQuaDuyet = new JLabel();
	public JButton batdau2;
	
	/////////////panel Djstra
	public JButton batdau3;
	// ///////////////////////////
	// MENU
	JButton New, Edit, BFS, DFS, DIJStra;
	// statute
	JCheckBox autoNumber, hideNumber;

	
	
	public MainFrame() {

		
		
		super("Algorithms simulator");
		setLayout(null);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		URL iconURL = getClass().getResource("endd.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);

		New = new JButton("Create new");
		
		New.addActionListener(this);
		Edit = new JButton("Edit");
		Edit.addActionListener(this);
		BFS = new JButton("BFS Algorithm");
		BFS.addActionListener(this);
		DFS = new JButton("DFS Algorithm");
		DFS.addActionListener(this);
		DIJStra = new JButton("Dijkstra Algorithm");
		DIJStra.addActionListener(this);
		
		mb.add(New);
		mb.add(Edit);
		mb.add(BFS);
		mb.add(DFS);
		mb.add(DIJStra);

		

		wp.setBounds(5, 5, width, heigh);
		add(wp);

		makeCtrlTable();

		makeMatricTable();

		makeDescr();
		
		JLabel lbMakeNode = new JLabel("Click left mouse to make a point");
		lbMakeNode.setBounds(25,60,200,20);
		panelSuadoThi.add(lbMakeNode);
	

	}

	public void come_card(int a, int maxcard) {
		if (a > loccard) {
			for (int i = 0; i < a - loccard; i++)
				card.next(desc);
			loccard = a;
		} else if (a < loccard) {
			for (int i = 0; i < maxcard - loccard + a; i++)
				card.next(desc);
			loccard = a;
		}
	}

	private void makeDescr() {
		int WIDTH = 465, HEIGHT = 647;

		
		
		
		Container c = getContentPane();

		desc.setBounds(510, 3, WIDTH, HEIGHT);

		desc.setLayout(card);

		desc.add(panelSuadoThi, "edit");
		panelSuadoThi.setBorder(BorderFactory.createTitledBorder("Edit graph"));
		panelSuadoThi.setLayout(null);
		panelSuadoThi.add(qc);

		panelDuyetRong.setBorder(BorderFactory
				.createTitledBorder("BFS"));

		JPanel tuDong = new JPanel();
		tuDong.setBounds(5, 520, 300, 80);
		tuDong.setLayout(null);
		tuDong.setBorder(BorderFactory.createTitledBorder("Auto"));
		panelDuyetRong.add(tuDong);

		batdau = new JButton(startIcon);
		
		batdau.setBounds(xStartBt, yStartBt, wStartBt, hStartBt);

		

		batdau.addActionListener(new ActionListener() {
			// STARTBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!panelSoDoBFS.run){
					/*if (wp.ds.FirstNode != null) {
						panelSoDoBFS.makeKichBanBFS(wp.ds.FirstNode.cost + 1,
								wp.data);
						panelSoDoBFS.buoc = panelSoDoBFS.kBan.start;
					}*/
					if(wp.ds.FirstNode!=null){
						if(panelSoDoBFS.buoc==null) {
							
							
							panelSoDoBFS.buoc=panelSoDoBFS.kBan.start;
						}else if(panelSoDoBFS.buoc.buoc=="buff2")
							panelSoDoBFS.buoc=panelSoDoBFS.kBan.start;
							
						panelSoDoBFS.run = true;
						batdau.setIcon(pauseIcon);
					}
					
				}else {
					panelSoDoBFS.run=false;
					batdau.setIcon(startIcon);
				}
				
			}

		});
		tuDong.add(batdau);
		JButton tamDung = new JButton(stopIcon);
		tamDung.setBounds(xStopBt, yStopBt, wStopBt, hStopBt);
		tamDung.addActionListener(new ActionListener() {
			// PAUSEBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panelSoDoBFS.buoc=null;
				panelSoDoBFS.run = false;
				batdau.setIcon(startIcon);
				panelSoDoBFS.buoc=panelSoDoBFS.kBan.start;
				panelSoDoBFS.setState();
				panelSoDoBFS.render();
				
			}

		});
		tuDong.add(tamDung);
		//JButton tiepTuc = new JButton("Continue");
		/*tiepTuc.setBounds(200, 20, 90, 20);
		tiepTuc.addActionListener(new ActionListener() {
			// tiep tuc
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelSoDoBFS.run = true;
				if (panelSoDoBFS.buoc == null)
					panelSoDoBFS.buoc = panelSoDoBFS.kBan.start;
			}

		});*/
		//tuDong.add(tiepTuc);

		JLabel lbSpeed = new JLabel("Speed");
		lbSpeed.setBounds(20, 50, 100, 20);
		tuDong.add(lbSpeed);

		JPanel bangTay = new JPanel();
		bangTay.setBounds(305, 520, 155, 50);
		bangTay.setBorder(BorderFactory.createTitledBorder("Step by step"));

		JButton tiepTheo = new JButton(nextIcon);
		bangTay.setLayout(null);
		tiepTheo.setBounds(xNextBt, yNextBt, wNextBt, hNextBt);
		tiepTheo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (panelSoDoBFS.buoc == null && wp.ds.FirstNode != null) {
					panelSoDoBFS.makeKichBanBFS(wp.ds.FirstNode.cost + 1,
							wp.data);
					panelSoDoBFS.buoc = panelSoDoBFS.kBan.start;
				}
				panelSoDoBFS.actionPerformd();
			}

		});
		bangTay.add(tiepTheo);
		JButton lui = new JButton(previousIcon);
		lui.setBounds(xPreBt,yPreBt,wPreBt,hPreBt);
		lui.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				panelSoDoBFS.actionPerformd2();
			}

		});
		bangTay.add(lui);
		panelDuyetRong.add(bangTay);

		JLabel lbQueue = new JLabel("Queue");
		lbQueue.setBounds(10, 610, 90, 20);
		panelDuyetRong.add(lbQueue);
		queue.setBounds(80, 610, 200, 20);
		panelDuyetRong.add(queue);

		panelDuyetRong.setLayout(null);

		panelSoDoBFS.setBounds(5, 20, 455, 500);

		panelDuyetRong.add(panelSoDoBFS);
		desc.add(panelDuyetRong, "bfs");

		
		volumeSpeed speed1 = new volumeSpeed(panelSoDoBFS, panelSoDoDFS,
				panelDijstra, 1);
		speed1.setBounds(70, 50, 220, 20);
		tuDong.add(speed1);

		// ********************DUYET CHIEU SAU**************************
		desc.add(panelDuyetSau, "dfs");
		panelDuyetSau.setBorder(BorderFactory
				.createTitledBorder("DFS"));

		panelDuyetSau.setLayout(null);

		panelSoDoDFS.setBounds(5, 20, panelSoDoDFS.w, panelSoDoDFS.h);
		panelDuyetSau.add(panelSoDoDFS);

		JPanel tuDong2 = new JPanel();
		tuDong2.setBounds(5, 520, 300, 80);
		tuDong2.setLayout(null);
		tuDong2.setBorder(BorderFactory.createTitledBorder("Auto"));
		panelDuyetSau.add(tuDong2);

		batdau2 = new JButton(startIcon);
		batdau2.setBounds(xStartBt, yStartBt, wStartBt, hStartBt);

		batdau2.addActionListener(new ActionListener() {
			// STARTBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (wp.ds.FirstNode != null) {
					if(!panelSoDoDFS.run){
						if(panelSoDoDFS.buoc==null){
							
							panelSoDoDFS.buoc = panelSoDoDFS.kBan.start;
						}
						if(panelSoDoDFS.buoc.buoc=="buff2"){
							panelSoDoDFS.buoc=panelSoDoDFS.kBan.start;
						}
						panelSoDoDFS.run=true;
						batdau2.setIcon(pauseIcon);
					}else{
						panelSoDoDFS.run = false;
						batdau2.setIcon(startIcon);
					}
					
					
				}
				
			}

		});
		tuDong2.add(batdau2);
		JButton tamDung2 = new JButton(stopIcon);
		tamDung2.setBounds(xStopBt, yStopBt, wStopBt, hStopBt);
		tamDung2.addActionListener(new ActionListener() {
			// PAUSEBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panelSoDoDFS.buoc=null;
				panelSoDoDFS.run = false;
				batdau2.setIcon(startIcon);
				panelSoDoDFS.buoc=panelSoDoDFS.kBan.start;
				panelSoDoDFS.render();
			}

		});
		tuDong2.add(tamDung2);
		/*JButton tiepTuc2 = new JButton("Continue");
		tiepTuc2.setBounds(200, 20, 90, 20);
		tiepTuc2.addActionListener(new ActionListener() {
			// tiep tuc
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelSoDoDFS.run = true;
				if (panelSoDoDFS.buoc == null)
					panelSoDoDFS.buoc = panelSoDoDFS.kBan.start;
			}

		});
		tuDong2.add(tiepTuc2);*/

		JLabel lbSpeed2 = new JLabel("Speed");
		lbSpeed2.setBounds(20, 50, 100, 20);
		tuDong2.add(lbSpeed2);

		JPanel bangTay2 = new JPanel();
		bangTay2.setBounds(305, 520, 155, 50);
		bangTay2.setBorder(BorderFactory.createTitledBorder("Step by step"));

		JButton tiepTheo2 = new JButton(nextIcon);//để hình cho các nút
		bangTay2.setLayout(null);
		tiepTheo2.setBounds(xNextBt, yNextBt, wNextBt, hNextBt);
		tiepTheo2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (panelSoDoDFS.buoc == null && wp.ds.FirstNode != null) {
					panelSoDoDFS.makeKichBanDFS(wp.ds.FirstNode.cost + 1,
							wp.data);
					panelSoDoDFS.buoc = panelSoDoDFS.kBan.start;
				}
				panelSoDoDFS.actionPerformd();
			}

		});
		bangTay2.add(tiepTheo2);
		JButton lui2 = new JButton(previousIcon);
		lui2.setBounds(xPreBt, yPreBt, wPreBt, hPreBt);
		lui2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				panelSoDoDFS.actionPerformd2();
			}

		});
		bangTay2.add(lui2);
		panelDuyetSau.add(bangTay2);

		volumeSpeed speed2 = new volumeSpeed(panelSoDoBFS, panelSoDoDFS,
				panelDijstra, 2);
		speed2.setBounds(70, 50, 220, 20);
		tuDong2.add(speed2);

		JLabel lbOutput = new JLabel("Result: ");
		lbOutput.setBounds(10, 605, 100, 20);
		panelDuyetSau.add(lbOutput);

		ketQuaDuyet.setBounds(60, 605, 300, 20);
		panelDuyetSau.add(ketQuaDuyet);

		// ************************DIJTRA****************************

		desc.add(panelDij, "dj");
		panelDij.setBorder(BorderFactory
				.createTitledBorder("Dijkstra"));

		c.add(desc);
		panelDij.setLayout(null);
		panelDijstra.setBounds(5, 20, panelDijstra.w, panelDijstra.h);
		panelDij.add(panelDijstra);

		JPanel tuDong3 = new JPanel();
		tuDong3.setBounds(5, 520, 300, 80);
		tuDong3.setLayout(null);
		tuDong3.setBorder(BorderFactory.createTitledBorder("Auto"));
		panelDij.add(tuDong3);

		batdau3 = new JButton(startIcon);
		batdau3.setBounds(xStartBt, yStartBt, wStartBt, hStartBt);

		batdau3.addActionListener(new ActionListener() {
			// STARTBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				
				if (wp.ds.FirstNode != null) {
					if(!panelDijstra.run){
						if(panelDijstra.buoc==null){
							panelDijstra.buoc = panelDijstra.kBan.start;
							
						}
						if(panelDijstra.buoc.text=="buff2"){
							panelDijstra.buoc=panelDijstra.kBan.start;
							panelDijstra.tb.format();
						}
						
						
						panelDijstra.run=true;
						batdau3.setIcon(pauseIcon);
					}else{
						panelDijstra.run=false;
						batdau3.setIcon(startIcon);
					}
					
				}
			}

		});
		tuDong3.add(batdau3);
		JButton tamDung3 = new JButton(stopIcon);
		tamDung3.setBounds(xStopBt, yStopBt, wStopBt, hStopBt);
		tamDung3.addActionListener(new ActionListener() {
			// PAUSEBFS
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panelDijstra.run = false;
				panelDijstra.buoc=null;
				panelDijstra.tb.format();
				panelDijstra.render();
				batdau3.setIcon(startIcon);
			}

		});
		tuDong3.add(tamDung3);
		/*JButton tiepTuc3 = new JButton("Continue");
		tiepTuc3.setBounds(200, 20, 90, 20);
		tiepTuc3.addActionListener(new ActionListener() {
			// tiep tuc
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelDijstra.run = true;
				if (panelDijstra.buoc == null)
					panelDijstra.buoc = panelDijstra.kBan.start;
			}

		});
		tuDong3.add(tiepTuc3);*/

		JLabel lbSpeed3 = new JLabel("Speed");
		lbSpeed3.setBounds(20, 50, 100, 20);
		tuDong3.add(lbSpeed3);

		JPanel bangTay3 = new JPanel();
		bangTay3.setBounds(305, 520, 155, 50);
		bangTay3.setBorder(BorderFactory.createTitledBorder("Step by step"));

		JButton tiepTheo3 = new JButton(nextIcon);
		bangTay3.setLayout(null);
		tiepTheo3.setBounds(xNextBt, yNextBt, wNextBt, hNextBt);
		tiepTheo3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (panelDijstra.buoc == null && wp.ds.FirstNode != null) {
					panelDijstra.makeKichBan(wp.data);
					panelDijstra.buoc = panelDijstra.kBan.start;
				}
				panelDijstra.actionPerformd();
			}

		});
		bangTay3.add(tiepTheo3);
		JButton lui3 = new JButton(previousIcon);
		lui3.setBounds(xPreBt, yPreBt, wPreBt, hPreBt);
		lui3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				panelDijstra.actionPerformd2();
			}

		});
		bangTay3.add(lui3);
		panelDij.add(bangTay3);

		volumeSpeed speed3 = new volumeSpeed(panelSoDoBFS, panelSoDoDFS,
				panelDijstra, 3);
		speed3.setBounds(70, 50, 220, 20);
		tuDong3.add(speed3);

	}

	private void makeMatricTable() {
		MatricTable = new JPanel();
		MatricTable.setLayout(null);
		MatricTable.setBounds(5, 470, 501, 180);
		MatricTable.setBorder(BorderFactory
				.createTitledBorder("Matrix"));
		add(MatricTable);
		table.setModel(tableValues);

		JScrollPane scr = new JScrollPane();
		scr.setBounds(10, 20, 480, 155);

		scr.setViewportView(table);
		for (int i = 0; i < table.getColumnCount(); i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		MatricTable.add(scr);
	}

	private void makeCtrlTable() {
		ctrTable.setBounds(5, 420, 501, 50);
		// ctrTable.setBackground(Color.decode("#819FF7"));
		ctrTable.setLayout(null);
		ctrTable.setBorder(BorderFactory.createTitledBorder("Mode"));
		add(ctrTable);

		

		autoNumber = new JCheckBox("Auto generate weight number");
		autoNumber.setBounds(15,20,200,20);
		autoNumber.addActionListener(this);
		ctrTable.add(autoNumber);
		
		
		hideNumber = new JCheckBox("Hide weight number");
		hideNumber.setBounds(220,20,150,20);
		hideNumber.addActionListener(this);
		ctrTable.add(hideNumber);
		
		setSize(WIDTH, HEIGH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == New) {
			
			batdau.setIcon(startIcon);
			batdau2.setIcon(startIcon);
			batdau3.setIcon(startIcon);
			
			if(result!=null) {
				result.setVisible(false);
				result = null;
			}
			
			
			
			wp.ds = new Node_Link();
			wp.repaint();
			wp.data = 0;
			wp.matNum.updateSize(wp.ds);
			wp.updateTable();
			
			wp.edit = true;
			wp.BFS = false;
			wp.DFS = false;
			wp.DJ = false;
			wp.listEdge.format();
			wp.repaint();
			qc.setRun(true);
			panelDijstra.timer.stop();
			panelDijstra.setRun(false);
			panelSoDoBFS.timer.stop();
			panelSoDoDFS.timer.stop();
			panelSoDoBFS.buoc = null;
			panelSoDoDFS.buoc = null;
			panelDijstra.buoc = null;
			panelDijstra.kBan = new kichBanDJ();
			card.show(desc, "edit");
			
			
		}

		if (e.getSource() == this.Edit) {
			
			batdau.setIcon(startIcon);
			batdau2.setIcon(startIcon);
			batdau3.setIcon(startIcon);
			
			
			if(result!=null) {
				result.setVisible(false);
				result = null;
			}
			
			
			wp.edit = true;
			wp.BFS = false;
			wp.DFS = false;
			wp.DJ = false;
			wp.repaint();
			// come_card(1,4);
			panelDijstra.timer.stop();
			panelDijstra.setRun(false);
			panelSoDoBFS.timer.stop();
			panelSoDoDFS.timer.stop();
			card.show(desc, "edit");
			panelSoDoBFS.buoc = null;
			panelSoDoDFS.buoc = null;
			panelDijstra.buoc = null;
			panelDijstra.kBan = new kichBanDJ();
			qc.setRun(true);
		}
		if (e.getSource() == this.BFS) {
			
			panelSoDoBFS.buoc = null;
			panelSoDoDFS.buoc = null;
			panelDijstra.buoc = null;
			
			batdau.setIcon(startIcon);
			
			
			
			if(result!=null) {
				
				result.setVisible(false);
				result = null;
			}
			result = new resultSearch(this, 1);
			result.setVisible(true);
			
			
				wp.BFS = true;
				wp.DFS = false;
				wp.DJ = false;
				// come_card(2,4);

				card.show(desc, "bfs");
				panelSoDoBFS.insertMatric(wp.matNum.getA());
				panelSoDoBFS.kBan.start = null;
				if (wp.ds.FirstNode != null){
					panelSoDoBFS.setKhoiTao(wp.ds.FirstNode.cost + 1,
							wp.data);
					panelSoDoBFS.makeKichBanBFS(wp.ds.FirstNode.cost + 1,
							wp.data);
					result.prosessingTime.setNumStep(panelSoDoBFS.kBan);
				}
					

				
				panelSoDoBFS.timer.start();
				panelSoDoDFS.run=false;
				panelSoDoDFS.timer.stop();
				panelDijstra.timer.stop();
				
				panelDijstra.setRun(false);
				wp.edit = false;
				wp.repaint();
				qc.setRun(false);
		} 
		if (e.getSource() == this.DFS) {
			
			panelSoDoBFS.buoc = null;
			panelSoDoDFS.buoc = null;
			panelDijstra.buoc = null;
			
			
			batdau2.setIcon(startIcon);

			
			if(result!=null) {
				result.setVisible(false);
				result = null;
			}
			result = new resultSearch(this, 2);
			result.setVisible(true);
			
			
				wp.BFS = false;
				wp.DFS = true;
				wp.DJ = false;
				// come_card(3,4);
				panelSoDoBFS.run=false;
				panelSoDoBFS.timer.stop();
				panelDijstra.timer.stop();
				panelDijstra.setRun(false);
				card.show(desc, "dfs");
				
				panelSoDoDFS.kBan.start = null;
				if (wp.ds.FirstNode != null){
					panelSoDoDFS.insertMatric(wp.matNum.getA());
					
					panelSoDoDFS.setKhoiTao(wp.ds.FirstNode.cost + 1,
							wp.data);
					panelSoDoDFS.makeKichBanDFS(wp.ds.FirstNode.cost + 1,
							wp.data);
					result.prosessingTime.setNumStep(panelSoDoDFS.kBan);
				}
					
				// panelSoDoDFS.makeKichBanDFS(wp.ds.FirstNode.cost + 1,
				// wp.data);
				panelSoDoDFS.timer.start();
				wp.edit = false;
				wp.repaint();
				qc.setRun(false);
		} 
		if(e.getSource() == this.DIJStra){
			
		
			batdau3.setIcon(startIcon);
			
			if(result!=null) {
				result.setVisible(false);
				result = null;
			}
			
			
				wp.BFS = false;
				wp.DFS = false;
				wp.DJ = true;
				// come_card(4,4);

				panelDijstra.insertMatric(wp.matNum.getA());
				panelDijstra.tb.setNumOfNode(wp.data);
				panelDijstra.makeKichBan(wp.data);
				panelDijstra.tb.format();

				if (wp.ds.FirstNode != null){
					//panelDijstra.Dijkstra(wp.matNum.getA(), wp.matNum.getSize(), 1, 5);
					//panelDijstra.dijkstra.dijkstraResult(wp.matNum.getA(), wp.data+1, 1, 5);
				}
				
				panelSoDoBFS.timer.stop();
				panelSoDoDFS.timer.stop();
				
				card.show(desc, "dj");
				panelDijstra.timer.start();
				wp.edit = false;
				wp.repaint();
				qc.setRun(false);
		}
			
		

		if(this.autoNumber.isSelected()){
			wp.ranDome = true;
		}else wp.ranDome = false;
		
		if(this.hideNumber.isSelected()){
			wp.showNumb = false;
			wp.repaint();
		}else {
			wp.showNumb = true;
			wp.repaint();
		}
	}

	

}
