import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;




public class workPanel extends JPanel{
	
	//*************popup menu*******************
	JPopupMenu Change_node=new JPopupMenu("Change_node");
	JMenuItem thisroot=new JMenuItem("Change to root node",
			new ImageIcon(MainFrame.class.getResource("root_syb.png")));
	JMenuItem del_node=new JMenuItem("Delete this root",
			new ImageIcon(MainFrame.class.getResource("delete_syb.png")));
	
	JPopupMenu Change_edge=new JPopupMenu("Change_edge");
	JMenuItem changeNum=new JMenuItem("Change weight number",
			new ImageIcon(MainFrame.class.getResource("changeEdge.png")));
	JMenuItem del_edge=new JMenuItem("Delete this edge",
			new ImageIcon(MainFrame.class.getResource("delete_syb.png")));
	
	private boolean showMenu = false;
	private boolean showMenuEdge = false;
	private Node nodeChange;
	
	private Node mouseMove=null;
	private int xMouse,yMouse;
	
	public drawNode drawN=new drawNode();
	
	private int ts=1;
	private String TS;
	private int a,b;
	
	public boolean ranDome=false;
	private Random r = new Random();
	
	private doubleNode edge;
	public boolean showNumb=true;
	//***************DATA***************************
	public Node_Link ds = new Node_Link();
	Edge_List listEdge=new Edge_List();
	
	public int data = 0;
	
	public MatNum matNum;
	//*****************SU KIEN CHUOT**********************
	private Point startDrag,endDrag,start;
	
	public int button=-1;
	private boolean isCatch=false;
	private boolean isMovenode=false;
	Node nodeMove=null;
	
	private int begin=0,end=0;
	//*********************THANH PHAN VE*******************
	public BackGround bg = new BackGround();
	public Graphs gp = new Graphs();
	
	
	//*********************Chu thich tren do thi**********************
	
	public KhungChuThich BFSChuThich;
	public KhungChuThich DFSChuThich;
	public KhungChuThich Dijkstra;
	
	public boolean edit=true;
	public boolean BFS = false;
	public boolean DFS = false;
	public boolean DJ = false;
	
	private MainFrame mf;
	public workPanel(final MainFrame mf) {
		matNum = new MatNum();
		this.mf=mf;
	
		
		BFSChuThich =new KhungChuThich(20,330);
		BFSChuThich.addItem(Color.decode("#508006"), "Root node passed");
		BFSChuThich.addItem(Color.blue, "Node passed");
		BFSChuThich.addItem(Color.decode("#808080"), "Node not passed");
		BFSChuThich.addItem(Color.decode("#fa8b39"), "Node going to pass");
		BFSChuThich.addItem(Color.decode("#ff0000"), "Node is passing");
		BFSChuThich.addItem(Color.decode("#a536f2"), "Node in checking");
		
		DFSChuThich = new KhungChuThich(20,330);
		DFSChuThich.addItem(Color.decode("#508006"), "Root node passed");
		DFSChuThich.addItem(Color.blue, "Node passed");
		DFSChuThich.addItem(Color.decode("#808080"), "Node not passed");
		DFSChuThich.addItem(Color.red, "Node is passing");
		
		Change_node.add(thisroot);
		Change_node.add(del_node);
		this.add(Change_node);
		
		Change_edge.add(changeNum);
		Change_edge.add(del_edge);
		this.add(Change_edge);
		
		ActionListener action = new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==thisroot) {
					ds.set_root(nodeChange);
					showMenu=false;
				}
				if(e.getSource()==del_node){
					ds.del_node(nodeChange);
					ds.after_delete_node(nodeChange);
					listEdge.del_edge(nodeChange);
					data--;
					showMenu=false;
					
					matNum.del_node(nodeChange.cost);
					matNum.updateSize(ds);
					
					begin=end=0;
					
					updateTable();
				}
				if(e.getSource()==changeNum){
					try{
						TS=JOptionPane.showInputDialog("Import number",ts);
						if(Integer.parseInt(TS)<100)ts=Integer.parseInt(TS);
						if(ts==0) ts=1;
					}catch(Exception eee){};
					listEdge.changeNum(edge.a, edge.b, ts);
					matNum.insertEdge(edge.a.cost, edge.b.cost, ts);
					updateTable();
					showMenuEdge=false;
				}
				if(e.getSource()==del_edge){
					listEdge.del_edge(edge.a, edge.b);
					ds.del_edge(edge.a, edge.b);
					showMenuEdge=false;
					matNum.delEdge(edge.a.cost, edge.b.cost);
					updateTable();
				}
				
				repaint();//repaint la ve lai, chu y khi thay doi cai j do ta nen dung repaint :v
			}
		};
		thisroot.addActionListener(action);
		del_node.addActionListener(action);
		changeNum.addActionListener(action);
		del_edge.addActionListener(action);
		
		this.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				startDrag = new Point(e.getX(), e.getY());
				
				if(BFS){
					BFSChuThich.setPosition(startDrag.x, startDrag.y-15);
					repaint();
				}
				if(DFS){
					DFSChuThich.setPosition(startDrag.x, startDrag.y-15);
					repaint();
				}
				if(edit){
					if(!showMenu){
						button = e.getButton();
						
						if(button==1&&ds.isNodeHere(startDrag)) {
							isCatch=true;
							startDrag=bg.get_Point_put_Node(startDrag);
						}
						
						if(button==3&&ds.isNodeHere(startDrag)){
							isMovenode=true;
							start=bg.get_Point_put_Node(startDrag);
							nodeMove=ds.get_xy(start);
						}
					}
				}
				
			}

			public void mouseReleased(MouseEvent e) {

				endDrag = new Point(e.getX(), e.getY());

				if(DJ){
					
					if(e.getButton()==1&&isEqual(startDrag,endDrag)){
					
						if(ds.getNode_enterNode(endDrag)!=null)
							begin=ds.getNode_enterNode(endDrag).cost;
						repaint();
					}else if(e.getButton()==3&&isEqual(startDrag,endDrag)){
					
						if(ds.getNode_enterNode(endDrag)!=null)
							end=ds.getNode_enterNode(endDrag).cost;
						repaint();
					}
				}
				
				if(edit){
					if(!showMenu&&!showMenuEdge){
					
						if (button == 1 && isEqual(startDrag, endDrag)
								&& !ds.isExist(bg.get_Point_put_Node(startDrag))){
							ds.InsertNode(data++, bg.get_Point_put_Node(startDrag));
							matNum.updateSize(ds);
							updateTable();
						}
							
		
						if(isCatch&&!isEqual(startDrag,endDrag)&&ds.isNodeHere(endDrag)){
							
							ds.nutxet_nutke(a=ds.getnode_xy(bg.get_Point_put_Node(startDrag)), 
									b=ds.get_xy(endDrag).cost);
							if(a!=b&&!listEdge.isExistEdge(ds.get_Node(a), ds.get_Node(b))){
								
								if(ranDome){
									while(true){
										ts=r.nextInt(99);
										if(ts!=0) break;
									}
									
								}else
								try{
									
									TS=JOptionPane.showInputDialog("Import number for this edge,\n" +
											"The number is lesser 100",ts);
									if(Integer.parseInt(TS)<100)ts=Integer.parseInt(TS);
									if(ts==0) ts=1;
								}catch(Exception ee){}
								listEdge.InsertEdge(ts, ds.get_Node(a), ds.get_Node(b));
								matNum.insertEdge(a, b, ts);
								updateTable();
							}
							ds.sort_link();
						}	
						
						if(isMovenode&&!isEqual(startDrag,endDrag)){
							if(!ds.isExist(bg.get_Point_put_Node(endDrag))){
								nodeMove.x=bg.get_Point_put_Node(endDrag).x;
								nodeMove.y=bg.get_Point_put_Node(endDrag).y;
							}else{
								nodeMove.x=start.x;
								nodeMove.y=start.y;
							}
						}
						if(isMovenode&&isEqual(startDrag,endDrag)){
							Change_node.show(workPanel.this,startDrag.x,startDrag.y);
							showMenu=true;
							nodeChange=ds.getNode_enterNode(startDrag);
						}else
						if(button==3&&isEqual(startDrag,endDrag)&&EdgeIsHere(ds,endDrag)){
							Change_edge.show(workPanel.this,endDrag.x,endDrag.y);
							edge=NodeEdgeNode(ds,endDrag.x,endDrag.y);
							showMenuEdge=true;
						}
						
						button = -1;
						//endDrag = null;
						isCatch=false;
						isMovenode=false;
						repaint();
					}else{
						showMenu=false;
						showMenuEdge=false;
					}
				}
				
			
				
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				
					
					endDrag=new Point(e.getX(),e.getY());
					if(button==1&&isCatch) repaint();
					
					if(button==3&&isMovenode){
						nodeMove.x=endDrag.x;
						nodeMove.y=endDrag.y;
						repaint();
					}
				
				if(BFS){
					BFSChuThich.setPosition(endDrag.x, endDrag.y-15);
					repaint();
				}
				if(DFS){
					DFSChuThich.setPosition(endDrag.x, endDrag.y-15);
					repaint();
				}
			}
			public void mouseMoved(MouseEvent e){
				if(edit){
					try{
						xMouse=e.getX();
						yMouse=e.getY();
						mouseMove=ds.getNode_enterNode(new Point(e.getX(),e.getY()));
					}catch(Exception ee){}
					repaint();
				}
			}
		});
	}
	
	public void updateTable(){
		mf.tableValues.Input(matNum.getA(), matNum.getSize());
		mf.table.updateUI();
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		bg.GridBackGr(g2);
		gp.drawHideGraph(g2, ds);
		if(edit){
			if(isCatch) bg.drawEdge(g2, startDrag, endDrag);
			gp.drawGraph(g2, ds);
			
			if(mouseMove!=null) drawN.drawNodeMouseEntered(g2, mouseMove);
			else drawEdgeEntered(ds,new Point(xMouse,yMouse),g2);
				
			if(showNumb)gp.drawNum(g2, listEdge);
			
			
			
			//if(showNum)graphs.drawNum(dbg2,listEdge);
		}else if(BFS){
			gp.drawResultBFS(g2, ds);
			BFSChuThich.showCT(g2);
		}else if(DFS){
			gp.drawResultDFS(g2, ds);
			DFSChuThich.showCT(g2);
		} else if (DJ) {
			gp.drawHideGraph(g2, ds);
			
			
			if(showNumb) gp.drawNum(g2, listEdge);
		}
	}
	private boolean isEqual(Point start,Point end){
		if(start.x==end.x&&start.y==end.y) return true;
		return false;
	}
	
	private void drawEdgeEntered(Node_Link ds,Point mouse,Graphics2D g){
		
		Node p=ds.FirstNode;
		Link l;
		while(p!=null){
			
			l=p.adj;
			while(l!=null){
				if(bg.enteredLine(new Point(p.x,p.y), new Point(l.cost.x,l.cost.y), mouse)){
					
					gp.drawEdgeIsEntered(g, p, l.cost, ds);
					drawN.drawNodeMouseEntered(g, p);
					drawN.drawNodeMouseEntered(g, l.cost);
				}
					
				l=l.adj;
			}
			
			p=p.NodeNext;
		}
	}
	private boolean EdgeIsHere(Node_Link ds, Point startDrag){
		
		Node p=ds.FirstNode;
		Link l;
		while(p!=null){
			
			l=p.adj;
			while(l!=null){
				if(bg.enteredLine(new Point(p.x,p.y), new Point(l.cost.x,l.cost.y),
						new Point(startDrag.x,startDrag.y))){
					return true;
				}
					
				l=l.adj;
			}
			
			p=p.NodeNext;
		}
		
		return false;
	}
	private doubleNode NodeEdgeNode(Node_Link ds,int x,int y){
		
		Node p=ds.FirstNode;
		Link l;
		while(p!=null){
			
			l=p.adj;
			while(l!=null){
				if(bg.enteredLine(new Point(p.x,p.y), new Point(l.cost.x,l.cost.y), new Point(x,y))){
					return new doubleNode(p,l.cost);
				}
					
				l=l.adj;
			}
			
			p=p.NodeNext;
		}
		
		return null;
	}
}
