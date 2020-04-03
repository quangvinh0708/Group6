package sum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GraphicSquareEquation extends JFrame implements ActionListener, KeyListener, ItemListener {
	private int temp;
	private JLabel lbTittle,lbA,lbB,lbC,lbR,lb1,lb2,lb3;
	private JTextField txA,txB,txC,txR;
	private JButton btnCount,btnReset,btnExit;
	private JPanel pT,pA,pB,pC,pR,pBtn,p1,p2,p3,pPt;
	private JRadioButton rb1,rb2,rb3,rbPtb1,rbPtb2;
	
	public GraphicSquareEquation() {
		//1.thiet lap cho Frame
		super.setTitle("Display Count Square Equation");
		super.setSize(250,400);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
//		super.setLayout(new GridLayout(6,4));
		super.setLayout(new FlowLayout());
		
		//2.tao cac components
		pT=new JPanel();
		lbTittle=new JLabel("Solve Square Equation");
		pT.add(lbTittle);
		
		pA=new JPanel();
		lbA=new JLabel("Enter A");
		txA=new JTextField(5);
		pA.add(lbA);
		pA.add(txA);
		
		pB=new JPanel();
		lbB=new JLabel("Enter B");
		txB=new JTextField(5);
		pB.add(lbB);
		pB.add(txB);
		
		pC=new JPanel();
		lbC=new JLabel("Enter C");
		txC=new JTextField(5);
		pC.add(lbC);
		pC.add(txC);
		
		pR=new JPanel();
		lbR=new JLabel("Result");
		txR=new JTextField(5);
		txR.setEnabled(false);
		pR.add(lbR);
		pR.add(txR);
		
		pBtn=new JPanel();
		btnCount=new JButton("Solve");
		btnReset=new JButton("Reset");
		btnExit=new JButton("Exit");
		btnCount.setBackground(Color.GREEN);
		btnReset.setBackground(Color.red);
		btnExit.setBackground(Color.yellow);
		pBtn.add(btnCount);
		pBtn.add(btnReset);
		pBtn.add(btnExit);
		
		pPt=new JPanel();
		rbPtb1=new JRadioButton("LinearEquation");
		rbPtb2=new JRadioButton("SquareEquation");
		pPt.add(rbPtb1);
		pPt.add(rbPtb2);
		
		p1=new JPanel();
		rb1=new	JRadioButton("Pink");
		rb1.addItemListener(this);
		p1.add(rb1);
		
//		p2=new JPanel();
		rb2=new JRadioButton("LightGray");
		rb2.addItemListener(this);
		p1.add(rb2);
		
//		p3=new JPanel();
		rb3=new JRadioButton("Orange");
		rb3.addItemListener(this);
		p1.add(rb3);
		
	
		//3.them cac pannel
		super.add(pT);
		super.add(pA);
		super.add(pB);
		super.add(pC);
		super.add(pR);
		super.add(pPt);
		super.add(pBtn);
		super.add(p1);
//		super.add(p2);
//		super.add(p3);
		
		
		//4.them cac sukien
		btnCount.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		txA.addKeyListener(this);
		txB.addKeyListener(this);
		txC.addKeyListener(this);
		btnCount.addKeyListener(this);
		
		
		super.validate();

	}

	public static void main(String[] args) {
		GraphicSquareEquation gse=new GraphicSquareEquation();

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(rb1.isSelected())
			this.getContentPane().setBackground(Color.pink);
		if(rb2.isSelected())
			this.getContentPane().setBackground(Color.LIGHT_GRAY);
		if(rb3.isSelected())
			this.getContentPane().setBackground(Color.orange);
		
		if(rbPtb1.isSelected())
			temp=1;
		if(rbPtb2.isSelected()) {
			temp=2;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCount&& temp==1) {
			double b=Double.parseDouble(txB.getText());
			double c=Double.parseDouble(txC.getText());
			if(b==0 && c==0) {
				txR.setText("phuong trinh co nghiem co vo so nghiem");
			}
			else {
				if(b==0 && c!=0) {
					txR.setText("Phuong trinh vo nghiemm");
				}
					else {
						txR.setText("phuong trinh co 1 nghiem duy nhat: "+(-c/b));
					}
			}
		}
		if(e.getSource()==btnCount && temp==2) {
			double a=Double.parseDouble(txA.getText());
			double b=Double.parseDouble(txB.getText());
			double c=Double.parseDouble(txC.getText());
			if(a==0) {
				if(b==0) {
					txR.setText("No roof");
				}
				else {
					txR.setText("Phuong trinh co mot nghiem duy nhat: x= "+(-c/b));
				}
			}
			float delta=(float) ((b*b)-4*a*c);
			float x1,x2;
			if(delta>0) {
				x1=(float) ((-b+ Math.sqrt(delta))/(2*a));
				x2=(float) ((-b- Math.sqrt(delta))/(2*a));
				txR.setText("Phuong trinh co 2 nghiem: "+"x1= "+x1 +" & x2= "+x2);
			}
			else if(delta==0){
					txR.setText("Phuong trinh co nghiem kep x= "+(-b/2*a));
				}
				else {
					txR.setText("No roof");
			}
		}
		if(e.getSource()==btnReset) {
			txA.setText("");
			txB.setText("");
			txC.setText("");
			txR.setText("");
			txA.requestFocus();
		}
		if(e.getSource()==btnExit) {
			System.exit(0);
		}
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txA) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				txB.requestFocus();
		}
		if(e.getSource()==txB) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				txC.requestFocus();
		}
		if(e.getSource()==txC) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				btnCount.requestFocus();
		}
		if(e.getSource()==btnCount&& temp==1) {
			double b=Double.parseDouble(txB.getText());
			double c=Double.parseDouble(txC.getText());
			if(b==0 && c==0) {
				txR.setText("phuong trinh co nghiem co vo so nghiem");
			}
			else {
				if(b==0 && c!=0) {
					txR.setText("Phuong trinh vo nghiemm");
				}
					else {
						txR.setText("phuong trinh co 1 nghiem duy nhat: "+(-c/b));
					}
			}
		}
		if(e.getSource()==btnCount&& temp==2) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			double a=Double.parseDouble(txA.getText());
			double b=Double.parseDouble(txB.getText());
			double c=Double.parseDouble(txC.getText());
			if(a==0) {
				if(b==0) {
					txR.setText("No roof");
				}
				else {
					txR.setText("Phuong trinh co mot nghiem duy nhat: x= "+(-c/b));
				}
			}
			float delta=(float) ((b*b)-4*a*c);
			float x1,x2;
			if(delta>0) {
				x1=(float) ((-b+ Math.sqrt(delta))/(2*a));
				x2=(float) ((-b- Math.sqrt(delta))/(2*a));
				txR.setText("Phuong trinh co 2 nghiem: "+"x1= "+x1 +" & x2= "+x2);
			}
			else if(delta==0){
					txR.setText("Phuong trinh co nghiem kep x= "+(-b/2*a));
				}
				else {
					txR.setText("No roof");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

