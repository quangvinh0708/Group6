package phuongtrinhbac2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes.DialogType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dialog;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class quadratic extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField text_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quadratic frame = new quadratic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public quadratic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int a = Integer.parseInt(text_1.getText());
					int b = Integer.parseInt(textField_2.getText());
					int c = Integer.parseInt(textField_3.getText());
					int d = (b*b - 4*a*c);
					int result = 0;
					if(d == 0)
					{
						result = -b/(2*a);
						textField_4.setText("x1 = x2 = " + result);
					}
					else if(d < 0) JOptionPane.showMessageDialog(textField_3, "The equation is no root");
				}
			}
		});
		textField_3.setBounds(169, 125, 113, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter a :");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(28, 76, 67, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter b :");
		lblNewLabel_1.setBounds(28, 23, 67, 17);
		contentPane.add(lblNewLabel_1);
		
		text_1 = new JTextField();
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int a = Integer.parseInt(text_1.getText());
					int b = Integer.parseInt(textField_2.getText());
					int c = Integer.parseInt(textField_3.getText());
					int d = (b*b - 4*a*c);
					int result = 0;
					if(d == 0)
					{
						result = -b/(2*a);
						textField_4.setText("x1 = x2 = " + result);
					}
					else if(d < 0) JOptionPane.showMessageDialog(text_1, "The equation is no root");
				}
			}
		});
		text_1.setColumns(10);
		text_1.setBounds(169, 21, 113, 20);
		contentPane.add(text_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int a = Integer.parseInt(text_1.getText());
					int b = Integer.parseInt(textField_2.getText());
					int c = Integer.parseInt(textField_3.getText());
					int d = (b*b - 4*a*c);
					int result = 0;
					if(d == 0)
					{	
						result = -b/(2*a);
						textField_4.setText("x1 = x2 = " + result);
					}
					else if(d < 0) JOptionPane.showMessageDialog(textField_2, "The equation is no root");
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(169, 74, 113, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter c :");
		lblNewLabel_1_1.setBounds(47, 127, 67, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Solve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(text_1.getText());
				int b = Integer.parseInt(textField_2.getText());
				int c = Integer.parseInt(textField_3.getText());
				int d = (b*b - 4*a*c);
				int result = 0;
				if(d == 0)
				{
					result = -b/(2*a);
					textField_4.setText("x1 = x2 = " + result);
				}
				else if(d < 0) JOptionPane.showMessageDialog(btnNewButton, "The equation is no root");
				
					
				
			}
		});
		
		btnNewButton.setBounds(43, 187, 101, 30);
		contentPane.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(181, 183, 146, 39);
		contentPane.add(textField_4);
	}
}
