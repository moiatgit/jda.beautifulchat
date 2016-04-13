import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.event.*;

class LogonApp implements ActionListener, WindowListener
{
	Image icon  = Toolkit.getDefaultToolkit().getImage("icon.gif") ;
	JFrame frameMain = new JFrame("Login Details");
	JPanel panMain = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel panLogin = new JPanel();
	JLabel lblName = new JLabel("Enter your user Name: ");
	JTextField txtName = new JTextField();
	JLabel lblIP = new JLabel("Enter the servers IP address: ");
	JTextField txtIP = new JTextField();
	JButton butConnect = new JButton("Connect");
	
	public LogonApp()
	{
		
	
		frameMain.setIconImage(icon);
		pan1.setLayout(new GridLayout(2,2));
		pan2.setLayout(new BorderLayout());
		pan1.add(lblName);
		pan1.add(txtName);
		pan1.add(lblIP);
		pan1.add(txtIP);
		pan2.add(butConnect, BorderLayout.SOUTH);
		panMain.add(pan1,BorderLayout.CENTER);
		panMain.add(pan2,BorderLayout.SOUTH);
		frameMain.setContentPane(panMain);
		frameMain.setSize(400,120);
		frameMain.setVisible(true);
		butConnect.addActionListener(this);
		frameMain.addWindowListener(this);
		txtIP.addActionListener(this);
		txtName.addActionListener(this);
	}
	public static void main(String args[])
	{
		LogonApp l1 = new LogonApp();	
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
	
		if(ae.getSource().equals(txtIP))
		{
			butConnect.requestFocus();
		}
		if(ae.getSource().equals(txtName))
		{
			txtIP.requestFocus();
		}
		if(ae.getSource().equals(butConnect))
		{
			if(!(txtIP.getText().equals("")))
			{
				
				if(txtName.getText().equals(""))
				{
					ClientApp c1 = new ClientApp("ANON",txtIP.getText());
					frameMain.dispose();
				}
				else
				{
					ClientApp c1 = new ClientApp(txtName.getText(),txtIP.getText());
					frameMain.dispose();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(
				frameMain,
				"Please Enter a Valid Server IP",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		public void windowOpened(WindowEvent e)
	{}
	public void windowClosing(WindowEvent e)
	{	
	
		System.exit(0);
	}
	public void windowClosed(WindowEvent e)
	{
		
	}
	public void windowIconified(WindowEvent e)
	{}
	public void windowDeiconified(WindowEvent e)
	{
	
	}
	public void windowActivated(WindowEvent e)
	{}
	public void windowDeactivated(WindowEvent e)
	{
		
	} 
}