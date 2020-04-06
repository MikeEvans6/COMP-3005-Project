package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class StoreView extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private JPanel searchInput, customerBar; 
	private JLabel sBy;
	private JTextField searchText;
	private JButton search, cart, customer;
	private JRadioButton titleB, authorB, isbnB, genreB;
	private String name;
	private MainView main;
	
	public StoreView(boolean login, String name) {
		super("MikeBuyABook");
		this.loggedIn = login;
		this.name = name;
		this.setLayout(new GridLayout(10,2));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		searchInput = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		sBy = new JLabel("Search By");
		
		titleB = new JRadioButton("Title", true);
		titleB.addActionListener(this);
		
		authorB = new JRadioButton("Author", false);
		authorB.addActionListener(this);
		
		isbnB = new JRadioButton("ISBN", false);
		isbnB.addActionListener(this);
		
		genreB = new JRadioButton("Genre", false);
		genreB.addActionListener(this);
		
		searchText = new JTextField(20);
		search = new JButton("Search");
		search.addActionListener(this);
		
		searchInput.add(sBy);
		searchInput.add(titleB);
		searchInput.add(authorB);
		searchInput.add(isbnB);
		searchInput.add(genreB);
		searchInput.add(searchText);
		searchInput.add(search);
		
		customerBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		cart = new JButton("Cart");
		cart.addActionListener(this);
		if(loggedIn) {
			customer = new JButton(name);
			customer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		else {
			customer = new JButton("Sign In");
			customer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					main = new MainView(false);
					main.signIn(true);
					customer.setText("Michael");
				}
				
			
			});
		}
		
		customerBar.add(cart);
		customerBar.add(customer);
		
		
		
		this.add(searchInput);
		this.add(customerBar);
		this.pack();
		this.setVisible(true);
		
		
	}
	public void signingIn(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		StoreView store = new StoreView(true, "Guest");
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
