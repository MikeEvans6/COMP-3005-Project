package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StoreView extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private JPanel sBar;
	private JPanel searchInput; 
	private JLabel sBy;
	private JMenuBar searchBar;
	private JMenuItem isbnItem, authorItem, genreItem, 
						priceItem, pagesItem, publisherItem, yearItem, titleItem;
	private JMenu searchMenu;
	private JTextField searchText;
	private JButton search;
	
	public StoreView(boolean login) {
		super("MikeBuyABook");
		this.loggedIn = login;
		this.setLayout(new GridLayout(10,2));
		
		sBar = new JPanel(new GridLayout(1,2));
		searchInput = new JPanel(new FlowLayout()); 
		
		sBy = new JLabel("Search By");
		searchBar = new JMenuBar();
		searchMenu = new JMenu();
		
		isbnItem = searchMenu.add("ISBN");
		isbnItem.addActionListener(this);
		
		titleItem = searchMenu.add("Title");
		titleItem.addActionListener(this);
		
		authorItem = searchMenu.add("Author");
		authorItem.addActionListener(this);
		
		genreItem = searchMenu.add("Genre");
		genreItem.addActionListener(this);
		
		yearItem = searchMenu.add("Year");
		yearItem.addActionListener(this);
		
		priceItem = searchMenu.add("Price");
		priceItem.addActionListener(this);
		
		pagesItem = searchMenu.add("Pages");
		pagesItem.addActionListener(this);
		
		publisherItem = searchMenu.add("Publisher");
		publisherItem.addActionListener(this);
		
		searchText = new JTextField(20);
		search = new JButton("Search");
		search.addActionListener(this);
		
		searchBar.add(searchMenu);
		
		sBar.add(sBy);
		sBar.add(searchBar);
		
		searchInput.add(sBar);
		searchInput.add(searchText);
		searchInput.add(search);
		
		this.add(searchInput);
		this.pack();
		this.setVisible(true);
		
	
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		StoreView store = new StoreView(false);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
