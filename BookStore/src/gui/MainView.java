package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MainView implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame first;
	private JFrame signIn;
	private JFrame createA;
	private StoreView store;
	
	public MainView(boolean vis) {	
		first = new JFrame();
		first.setLayout(new BorderLayout());
		first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel greeting = new JPanel(new GridLayout(2, 1));
		
		JPanel welcome = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel w = new JLabel("Welcome to MikeBuyABook");
		w.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		welcome.add(w);
		
		greeting.add(welcome);
		
		JPanel choice = new JPanel(new FlowLayout());
		JButton sIn = new JButton("SIGN IN");
		sIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sIn.addActionListener(this);
		
		JButton create = new JButton("Create Account");
		create.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		create.addActionListener(this);
		
		JButton guest = new JButton("Continue As Guest");
		guest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		guest.addActionListener(this);
		
		choice.add(sIn);
		choice.add(create);
		choice.add(guest);
		
		greeting.add(choice);
		
		first.add(greeting, BorderLayout.CENTER);
		first.pack();
		first.setVisible(vis);
	}
	
	public void signIn() {
		signIn = new JFrame("Sign In");
		signIn.setLayout(new BorderLayout());
		
		JPanel cred = new JPanel(new GridLayout(3,1));
		
		JPanel i = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel info = new JLabel("Enter Login Information");
		info.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		i.add(info);
		
		JPanel eInput = new JPanel(new FlowLayout());
		JTextField em = new JTextField(40);
		em.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		eInput.add(email);
		eInput.add(em);
		
		JPanel pInput = new JPanel(new FlowLayout());
		JTextField p = new JTextField(20);
		p.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel pW = new JLabel("Password");
		pW.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pInput.add(pW);
		pInput.add(p);
		
		JPanel sBut = new JPanel(new FlowLayout());
		JButton signBut = new JButton("SIGN IN");
		signBut.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		signBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String eIn = "'" + em.getText() + "'";
				String pIn = p.getText();
				String query = "select name from customer where email = " + eIn + "and password = " + "'" + pIn + "'";
				ResultSet result;
				String name;
				try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
					result = s.executeQuery(query);
					if(result.next()) {
						name = result.getString("name");
						first.dispose();
						signIn.dispose();
						store = new StoreView(true, name);
						
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			
		});
		sBut.add(signBut);
		
		cred.add(i);
		cred.add(eInput);
		cred.add(pInput);
		
		signIn.add(cred, BorderLayout.CENTER);
		signIn.add(sBut, BorderLayout.SOUTH);
		signIn.pack();
		signIn.setVisible(true);
		
	}
	public void createFrame() {
		createA = new JFrame();
		createA.setLayout(new BorderLayout());
		
		JPanel aInfo = new JPanel(new GridLayout(8,1));
		
		JPanel personal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel pinfo = new JLabel("Enter Personal Information");
		pinfo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		personal.add(pinfo);
		
		JPanel eInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField em = new JTextField(40);
		em.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		eInput.add(email);
		eInput.add(em);
		
		JPanel nInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField name = new JTextField(20);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel fName = new JLabel("Full Name");
		fName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nInput.add(fName);
		nInput.add(name);
		
		JPanel aInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField addr = new JTextField(30);
		addr.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel address = new JLabel("Home Address");
		address.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		aInput.add(address);
		aInput.add(addr);
		
		JPanel postInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField postal = new JTextField(5);
		postal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel pCode = new JLabel("Postal Code");
		pCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		postInput.add(pCode);
		postInput.add(postal);
		
		JPanel proInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField province = new JTextField(15);
		province.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel prov = new JLabel("Province");
		prov.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		proInput.add(prov);
		proInput.add(province);
		
		JPanel phoneInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField phone = new JTextField(10);
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JLabel phoneNum = new JLabel("Phonenumber");
		phoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		phoneInput.add(phoneNum);
		phoneInput.add(phone);
		
		JPanel pInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField p = new JTextField(20);
		p.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel pW = new JLabel("Password");
		pW.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pInput.add(pW);
		pInput.add(p);
		
		
		JPanel eBut = new JPanel(new FlowLayout());
		JButton enterBut = new JButton("SIGN IN");
		enterBut.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		enterBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = em.getText();
				String fullname = name.getText();
				String address = addr.getText() + " " + postal.getText() + " " + province.getText();
				String phonenum = phone.getText();
				String pIn =  p.getText();
				
				String query = "insert into customer values ('" + email + "', '" + fullname + "', '" + address + "', '" + phonenum + "', '" + pIn + "')";
				
				try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
					s.executeQuery(query);
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(new JFrame(), "Account Created Log in now");
				createA.dispose();
			}
			
		});
		
		eBut.add(enterBut);
		
		aInfo.add(personal);
		aInfo.add(eInput);
		aInfo.add(nInput);
		aInfo.add(aInput);
		aInfo.add(postInput);
		aInfo.add(proInput);
		aInfo.add(phoneInput);
		aInfo.add(pInput);
		
		createA.add(aInfo, BorderLayout.CENTER);
		createA.add(eBut, BorderLayout.SOUTH);
		createA.pack();
		createA.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainView view = new MainView(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		if(a.equals("SIGN IN")) {
			this.signIn();
		}
		else if(a.equals("Create Account")) {
			this.createFrame();
		}
		else if(a.contentEquals("Continue As Guest")) {
			first.dispose();
			store = new StoreView(false, "Guest");
		}
		
	}
}
