package freeTV;
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class freTV1 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//���
	JFrame frame ;
    JMenuBar menubar;//�˵�
    JMenu file,setting,help;
    JMenuItem open,exit;
   
    //add setting menu item here
    
    JMenuItem Help,aboutfreetv,feedback;
    JPopupMenu popupMenu;//�Ҽ��˵�
    JMenuItem mopen,mprior,mnext;
    JButton prior,next;
    JTextField jtf;//�ײ�״̬����Ϣ
    
	JPanel background = new JPanel();
	//String backstr = "/img/bb.jpg";
	//Image backImage =new ImageIcon(this.getClass().getResource(backstr)).getImage();  
	JPanel window = new JPanel();
 	JLabel label  = new JLabel();
	JPanel active = new JPanel();
	JPanel monitor = new JPanel();
	JLabel stalabel = new JLabel();
	JToolBar toolbar = new JToolBar();
	
	String []imagepath = new String[100];//�ļ�·��
	int pos = 0;//��¼λ��
	int num = 0;//��¼ͼƬ��Ŀ
	int current = 0;
  public freTV1(){
   {
   	//������
   	frame = new JFrame("3DFreeTV");
	 try{
       	 String src ="/img/logo.png";//����logo
       	 Image image = ImageIO.read(this.getClass().getResource(src));
       	 frame.setIconImage(image);
        }catch(IOException e){
       	 e.printStackTrace();
        }
	frame.setSize(1230, 648);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ����Ļ��С
	String scrSize = new String("ScreenSize Width:"+screenSize.width+" Hight:"+screenSize.height);
	//���ùر�ʱ��ʾ��Ϣ
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   /* frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
        	Object[] o = {"ȡ��","�˳�"};
            int a = JOptionPane.showOptionDialog(frame, "ȷ�Ϲرս��˳�����", "��ܰ��ʾ",
                    JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,o,o[0]);
            if (a == 1) {
            	 frame.dispose();
            }
        }
    });*/
	
	//�˵�
	menubar = new JMenuBar();
	file = new JMenu("File");
	setting = new JMenu("Setting");
	help = new JMenu("Help");
	menubar.add(file);
	menubar.add(setting);
	menubar.add(help);
	
	open = new JMenuItem("Open",KeyEvent.VK_O);
	open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	String stropen = "/img/open.png";
	ImageIcon iconopen = new ImageIcon(this.getClass().getResource(stropen));
	open.setIcon(iconopen);
	
	exit = new JMenuItem("Exit");
	String strexit = "/img/exit.png";
	ImageIcon iconexit = new ImageIcon(this.getClass().getResource(strexit));
	exit.setIcon(iconexit);
  	
	//add setting menu item here
	
	Help = new JMenuItem("Help",KeyEvent.VK_H);
	Help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
	String strhelp = "/img/help.png";
	ImageIcon iconhelp = new ImageIcon(this.getClass().getResource(strhelp));
	Help.setIcon(iconhelp);
	
	aboutfreetv = new JMenuItem("About FreeTV");
	String strtv = "/img/freetv.png";
	ImageIcon icontv = new ImageIcon(this.getClass().getResource(strtv));
	aboutfreetv.setIcon(icontv);
	
	feedback = new JMenuItem("Feedback");
	String strback = "/img/feedback.png";
	ImageIcon iconback = new ImageIcon(this.getClass().getResource(strback));
	feedback.setIcon(iconback);
	
	file.add(open);
	file.add(exit);
	//add setting menu item here
	help.add(Help);
	help.add(aboutfreetv);
	help.add(feedback);
	frame.setJMenuBar(menubar);

	//�Ҽ��˵�
	popupMenu = new JPopupMenu();
	
	mopen = new JMenuItem("Open         ");
	mopen.setIcon(iconopen);
	
	mprior = new JMenuItem("Prior       ");
	String strleft = "/img/left.png";
	ImageIcon iconleft = new ImageIcon(this.getClass().getResource(strleft));
	mprior.setIcon(iconleft);
	
	mnext = new JMenuItem("Next         ");
	String strright = "/img/right.png";
	ImageIcon iconright = new ImageIcon(this.getClass().getResource(strright));
	mnext.setIcon(iconright);
	
	popupMenu.add(mopen);
	popupMenu.add(mprior);
	popupMenu.add(mnext);
	add(popupMenu);
	//��ʾ�Ҽ��˵�
	frame.addMouseListener(new MouseAdapter(){
		public void mouseReleased(MouseEvent e){
			if(e.isPopupTrigger()){
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	});

	//���沼��
	background.setBackground(new Color(45,45,48));
	FlowLayout backlayout = new FlowLayout(FlowLayout.LEADING);
	backlayout.setHgap(10);//����������
	background.setLayout(backlayout);
	frame.add(background,BorderLayout.CENTER);
	
	//������
	window.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	window.setLayout(null);
	window.setBackground(new Color(45,45,48));//set mainFrame background color
	window.setPreferredSize(new Dimension(851,545));
	
	label.setSize(new Dimension(851,545));
	label.setHorizontalAlignment(0);
	
	prior = new JButton("");
	prior.setToolTipText("prior view");
	prior.setBounds(-10, -120, 100, 800);
	prior.setContentAreaFilled(false);//ȥ����ť���ݻ���
	prior.setBorder(null);//ȥ����ť�߿�
	prior.setFocusPainted(false);//ȥ����ť����߿�
	prior.addMouseListener(new MouseAdapter()
	{
		public void mouseEntered(MouseEvent e){
			String str = "/img/prior.png";
			ImageIcon iconn = new ImageIcon(this.getClass().getResource(str));
			prior.setIcon(iconn);
		}
		public void mouseExited(MouseEvent e){
			String str = "/img/blank.png";
			ImageIcon iconn = new ImageIcon(this.getClass().getResource(str));
			prior.setIcon(iconn);
		}
		public void mousePressed(MouseEvent e ){
			String str = "src/img/prior_small.png";
			ImageIcon iconn = new ImageIcon(str);
			prior.setIcon(iconn);	
		}
		public void mouseReleased(MouseEvent e)
		{
			String str = "src/img/prior.png";
			ImageIcon iconn = new ImageIcon(str);
			prior.setIcon(iconn);	
		}
	});
	
	next = new JButton();
	next.setToolTipText("next view");
	next.setBounds(760, -120, 100, 800);
	next.setContentAreaFilled(false);
	next.setBorder(null);
	next.setFocusPainted(false);
	next.addMouseListener(new MouseAdapter()
	{
		public void mouseEntered(MouseEvent e){
			String str = "/img/next.png";
			ImageIcon iconn = new ImageIcon(this.getClass().getResource(str));
			next.setIcon(iconn);
		}
		public void mouseExited(MouseEvent e){
		    String str = "/img/blank.png";
			ImageIcon iconn = new ImageIcon(this.getClass().getResource(str));
			next.setIcon(iconn);
		}
		public void mousePressed(MouseEvent e ){
			String str = "src/img/next_small.png";
			ImageIcon iconn = new ImageIcon(str);
			next.setIcon(iconn);	
		}
		public void mouseReleased(MouseEvent e)
		{
			String str = "src/img/next.png";
			ImageIcon iconn = new ImageIcon(str);
			next.setIcon(iconn);	
		}
		
	});
    window.add(prior);
	window.add(next);
    window.add(label);
	
	//�¼�����
	active.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	active.setLayout(new FlowLayout(FlowLayout.LEADING));
	active.setBackground(new Color(30,30,30));//set historyFrame background color
	active.setPreferredSize(new Dimension(340,545));
	monitor.setBackground(new Color(236,240,241));
	monitor.setPreferredSize(new Dimension(325,200));
	active.add(monitor);
	
   //״̬��
	toolbar.setUI(null);
	toolbar.setBackground(new Color(30,30,30));
	toolbar.add(stalabel);
	toolbar.setPreferredSize(new Dimension(1202,22));
	jtf = new JTextField(""+scrSize);
	jtf.setForeground(Color.WHITE);
	jtf.setBackground(new Color(30,30,30));
	toolbar.add(jtf);
	background.add(window);
	background.add(active);
	background.add(toolbar);
   
	//�¼�����
	open.addActionListener(this);
	exit.addActionListener(this);
	Help.addActionListener(this);
	aboutfreetv.addActionListener(this);
	feedback.addActionListener(this);
	mopen.addActionListener(this);
	prior.addActionListener(this);
	next.addActionListener(this);
	mprior.addActionListener(this);
	mnext.addActionListener(this);
    }
    } 
   //�¼�����
  //�¼�����
 	public void actionPerformed(ActionEvent e){
     	//���ļ�
     	if(e.getSource()== open||e.getSource()==mopen){
     		JFileChooser fileChooser=new JFileChooser();
     		//�����ļ���չ����������ֻ��ʾͼƬ��ʽ���ļ�
    		FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG,GIF,BMP,PNG,SVG,PSD,EPS,AI Images","jpg","jpeg","gif","bmp","png","svg","psd","eps","ai");
    		fileChooser.setFileFilter(filter);									//Ϊ�ļ��Ի���������չ��������
     		fileChooser.setMultiSelectionEnabled(true);
     		fileChooser.setDialogTitle("Open");
     		int option = fileChooser.showOpenDialog(this);
     		if(option==JFileChooser.APPROVE_OPTION){
     		File fileArray[] = fileChooser.getSelectedFiles();   
     		String filelist = "nothing";
     		current  = num;
     		num += fileArray.length;
     		if(fileArray.length>0)
     			filelist = fileArray[0].getName();
     		 for (int i = 0; i < fileArray.length; i++) {  
  	            filelist += ", " + fileArray[i].getName( );  
  	          }
     		 for (int j = current,i = 0; j < num&&i < fileArray.length;j++,i++) {  
   	            imagepath[j] = fileArray[i].getPath();  
   	          }
     		pos = current;
     		jtf.setForeground(Color.WHITE);
     		jtf.setText("you choosed:"+filelist);//��ʾ״̬
     		 ImageIcon windowlabel = new ImageIcon(imagepath[pos]);
     	    if(windowlabel.getIconWidth()>850||windowlabel.getIconHeight()>540)
 				for(double i=0.9;i>0;i-=0.1){
 					{
 						double imgLen = i*windowlabel.getIconWidth();
 						double imgHei = i*windowlabel.getIconHeight();
 						if(imgLen<=850 && imgHei<=540)
 						{
 							windowlabel.setImage(windowlabel.getImage().getScaledInstance((int)imgLen,(int)imgHei, Image.SCALE_SMOOTH));
 							break;
 						}
 					}
 				}
     	    //���ͼƬ��С�������򴴽�һ��800X500��ѹ���汾
     	    label.setIcon(windowlabel); 
     		}//if
     		else{
     			jtf.setForeground(Color.RED);
     			jtf.setText(" you canceled");	
     		}

     	}

    	//�˳�����
    	else if(e.getSource()==exit){
    		Object[] o = {"ȡ��","�˳�"};
            int a = JOptionPane.showOptionDialog(frame, "ȷ�Ϲرս��˳�����", "��ܰ��ʾ",
                    JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,o,o[0]);
            if (a == 1) {
            	 frame.dispose();
            }
    	}
    	//add setting menu item here
    	//����
    	else if(e.getSource()==Help){
    		
    	}
    	//���ڳ���
    	else if(e.getSource()==aboutfreetv){
    		
    	}
    	//����
    	else if(e.getSource()==feedback){
    		
    	}
    	//��һ��
    	else if(e.getSource()== prior||e.getSource()==mprior){
    		if(pos == 0){
    			pos = num-1;
    		}
    		else{
    			pos--;
    		}
			ImageIcon windowlabel = new ImageIcon(imagepath[pos]);
			if(windowlabel.getIconWidth()>850||windowlabel.getIconHeight()>540)
				for(double i=0.9;i>0;i-=0.1){
					{
						double imgLen = i*windowlabel.getIconWidth();
						double imgHei = i*windowlabel.getIconHeight();
						if(imgLen<=850 && imgHei<=540)
						{
							windowlabel.setImage(windowlabel.getImage().getScaledInstance((int)imgLen,(int)imgHei, Image.SCALE_FAST));
							break;
						}
					}
				
				}
				
			
      	    label.setIcon(windowlabel);
    		jtf.setForeground(Color.WHITE);
			jtf.setText(imagepath[pos]);
    	}
    	//��һ��
    	else if(e.getSource()== next||e.getSource()==mnext){
    		if(pos == num-1){
    	    pos = 0;	
    		}
    		else{
    			pos++;
    		}
    		ImageIcon windowlabel = new ImageIcon(imagepath[pos]);
			if(windowlabel.getIconWidth()>850||windowlabel.getIconHeight()>540)
				for(double i=0.9;i>0;i-=0.1){
					{
						double imgLen = i*windowlabel.getIconWidth();
						double imgHei = i*windowlabel.getIconHeight();
						if(imgLen<=850 && imgHei<=540)
						{
							windowlabel.setImage(windowlabel.getImage().getScaledInstance((int)imgLen,(int)imgHei, Image.SCALE_SMOOTH));
							break;
						}
					}
				
				}
      	    label.setIcon(windowlabel);
      	    jtf.setForeground(Color.WHITE);
  		    jtf.setText(imagepath[pos]);	
    	}

    }    	
	
    public static void main(String args[]){
    	 java.awt.EventQueue.invokeLater(new Runnable(){
    	   public  void run(){
    		new freTV1();   
    	   }
       });
    }
}
