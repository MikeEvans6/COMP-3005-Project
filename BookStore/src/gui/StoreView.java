package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class StoreView extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private JPanel searchInput, bookList, bookInfo; 
	private JLabel sBy;
	private JTextField searchText, quantity;
	private JButton search, cart, customer, addCart;
	private JRadioButton titleB, authorB, isbnB, genreB;
	private String name;
	private JFrame signingIn, bookSel;
	private ArrayList<String> books = new ArrayList<String>();
	private JButton[] bookButtons;
	private JLabel[] bookTitles;
	private int count;
	private boolean titleS, authorS, isbnS, genreS;
	private CartView cartView;
	
	/**
	 * Store View Constructor 
	 * @param login
	 * @param name
	 */
	public StoreView(boolean login, String name) {
		super("MikeBuyABook");
		this.loggedIn = login;
		this.name = name;
		this.setLayout(new GridLayout(2,1));
		cartView = new CartView();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		searchInput = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		sBy = new JLabel("Search By");
		sBy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		titleB = new JRadioButton("Title", true);
		titleS = true;
		titleB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		titleB.addActionListener(this);
		
		authorB = new JRadioButton("Author", false);
		authorS = false;
		authorB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		authorB.addActionListener(this);
		
		isbnB = new JRadioButton("ISBN", false);
		isbnS = false;
		isbnB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		isbnB.addActionListener(this);
		
		genreB = new JRadioButton("Genre", false);
		genreS = false;
		genreB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		genreB.addActionListener(this);
		
		searchText = new JTextField(20);
		searchText.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		search = new JButton("Search");
		search.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		search.addActionListener(this);
		
		cart = new JButton("Cart");
		cart.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cart.addActionListener(this);
		if(loggedIn) {
			customer = new JButton(name);
			customer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			customer.addActionListener(this);
		}
		else {
			customer = new JButton("Sign In");
			customer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			customer.addActionListener(this);
		}
		
		searchInput.add(sBy);
		searchInput.add(titleB);
		searchInput.add(authorB);
		searchInput.add(isbnB);
		searchInput.add(genreB);
		searchInput.add(searchText);
		searchInput.add(search);
		searchInput.add(cart);
		searchInput.add(customer);
		
		String query = "select * from book";
		ResultSet result;
		count = 0;
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
			result = s.executeQuery(query);
			while(result.next()) {
				books.add(result.getString("title"));
				count++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		bookList = new JPanel(new GridLayout(count, 2));
		bookButtons = new JButton[count];
		bookTitles = new JLabel[count];
		
		for(int i = 0; i < count; i++) {
			bookTitles[i] = new JLabel(books.get(i));
			bookTitles[i].setFont(new Font("Times New Roman", Font.PLAIN, 16));
			bookButtons[i] = new JButton("Select");
			bookButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 16));
			bookButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < count; i++) {
						if(bookButtons[i] == e.getSource()) {
							bookSelect(books.get(i));
						}
					}
				}
			});
			bookList.add(bookTitles[i]);
			bookList.add(bookButtons[i]);
		}
		JScrollPane scroll = new JScrollPane(bookList);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 30, 300, 50);
		this.add(searchInput);
		this.add(scroll);
		this.setSize(850,600);
		this.setVisible(true);
		
	}
	
	
	/**
	 * Sign in view for Store
	 */
	public void signingIn() {
		signingIn = new JFrame("Sign In");
		signingIn.setLayout(new BorderLayout());
		
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
				try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
					result = s.executeQuery(query);
					if(result.next()) {
						name = result.getString("name");
						customer.setText(name);
						signingIn.dispose();
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
		
		signingIn.add(cred, BorderLayout.CENTER);
		signingIn.add(sBut, BorderLayout.SOUTH);
		signingIn.pack();
		signingIn.setVisible(true);
	}
	
	
	/**
	 * Book Select View
	 * @param title
	 */
	public void bookSelect(String title) {
		bookSel = new JFrame("Book Select");
		
		bookSel.setLayout(new BorderLayout());
		bookInfo = new JPanel(new FlowLayout());
		ResultSet result, authorSet;
		String authorQ;
		
		JLabel author, publisher, isbn, genre, year, price, pages, titleL, quant;
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
			String query = "select * from book where title = '" + title + "'";
			result = s.executeQuery(query);
			
			if(result.next()) {
		
				titleL = new JLabel("Title: " + title);
				titleL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				isbn = new JLabel("ISBN: " + result.getString("ISBN"));
				isbn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				bookInfo.add(isbn);
				bookInfo.add(titleL);
				
				genre = new JLabel("Genre: " + result.getString("genre"));
				genre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				year = new JLabel("Year: " + result.getString("year"));
				year.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				price = new JLabel("Price: " + result.getString("price"));
				price.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				pages = new JLabel("Pages: " + result.getString("pages"));
				pages.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				publisher = new JLabel("Publisher: " + result.getString("p_name"));
				publisher.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				authorQ = "select a_name from written_by where ISBN = '" + result.getString("ISBN") + "'";
			
				
				authorSet = s.executeQuery(authorQ);
				if(authorSet.next()) {
					author = new JLabel("Author: " + authorSet.getString("a_name"));
					author.setFont(new Font("Times New Roman", Font.PLAIN, 16));
					
					bookInfo.add(author);
				}
				
				bookInfo.add(publisher);
				bookInfo.add(genre);
				bookInfo.add(year);
				bookInfo.add(pages);
				bookInfo.add(price);				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		addCart = new JButton("Add To Cart");
		addCart.addActionListener(this);
		quantity = new JTextField(3);
		quantity.setText("0");
		quant = new JLabel("Quantity: ");
		quant.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		bookInfo.add(quant);
		bookInfo.add(quantity);
		bookInfo.add(addCart);
		
		
		bookSel.add(bookInfo);
		bookSel.pack();
		bookSel.setVisible(true);
	}
	
	
	/**
	 * Book Search Function
	 * @param searchType
	 * @param searchVal
	 */
	public void bookSearchView(String searchType, String searchVal) {
		String query;
		ResultSet result;
		int searchcount = 0;
		books = new ArrayList<String>();
		for(int i = 0; i< bookButtons.length; i++) {
			bookButtons[i].removeActionListener(this);
		}
		
		if(searchType.equals("author") && !searchVal.equals("")) {
			query = "select book.title from book, written_by where written_by.a_name = '" + searchVal + "' and book.ISBN = written_by.ISBN";
			try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
				result = s.executeQuery(query);
				while(result.next()) {
					books.add(result.getString("Title"));
					searchcount++;
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(books.size()> 0) {
				for(int i = 0; i < count; i++) {
					if(i < searchcount) {
						bookTitles[i].setText(books.get(i));
						bookTitles[i].setVisible(true);
						bookButtons[i].setVisible(true);
						
					}
					else {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
					}
				}
			}
			else {
				for(int i = 0; i < count; i++) {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
				}
			}

		}
		else if(searchVal.equals("")){
			query = "select * from book";
			try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
				result = s.executeQuery(query);
				while(result.next()) {
					books.add(result.getString("title"));
					searchcount++;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(books.size()> 0) {
				for(int i = 0; i < count; i++) {
					if(i < searchcount) {
						bookTitles[i].setText(books.get(i));
						bookTitles[i].setVisible(true);
						bookButtons[i].setVisible(true);
					
					}
					else {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
					}
				}
			}
			else {
				for(int i = 0; i < count; i++) {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
				}
			}
		}
		else {
			query = "select * from book where " + searchType + " = '" + searchVal + "'";
			try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "passwd"); Statement s = c.createStatement();){
				result = s.executeQuery(query);
				while(result.next()) {
					books.add(result.getString("title"));
					searchcount++;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(books.size()> 0) {
				for(int i = 0; i < count; i++) {
					if(i < searchcount) {
						bookTitles[i].setText(books.get(i));
						bookTitles[i].setVisible(true);
						bookButtons[i].setVisible(true);
					}
					else {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
					}
				}
			}
			else {
				for(int i = 0; i < count; i++) {
						bookTitles[i].setVisible(false);
						bookButtons[i].setVisible(false);
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		
		if(a.equals("Sign In")) {
			this.signingIn();
		}
		else if(a.equals("Search")) {
			if(titleS) {
				this.bookSearchView("title", searchText.getText());
			}
			else if(authorS) {
				this.bookSearchView("author", searchText.getText());
			}
			else if(isbnS) {
				this.bookSearchView("ISBN", searchText.getText());
			}
			else if(genreS) {
				this.bookSearchView("genre", searchText.getText());
			}
			
		}
		else if(a.equals("Cart")) {
			
		}
		else if(a.equals("Add To Cart")) {
			
		}
		else if(a.equals("Title")) {
			if(titleS) {
				titleS = false;
			}
			else {
				titleS = true;
				authorS = false;
				isbnS = false;
				genreS = false;
				authorB.setSelected(false);
				isbnB.setSelected(false);
				genreB.setSelected(false);
			}
		}
		else if(a.equals("Author")) {
			if(authorS) {
				authorS = false;
			}
			else {
				authorS = true;
				titleS = false;
				isbnS = false;
				genreS = false;
				titleB.setSelected(false);
				genreB.setSelected(false);
				isbnB.setSelected(false);
			}
		}
		else if(a.equals("ISBN")) {
			if(isbnS) {
				isbnS = false;
			}
			else {
				isbnS = true;
				authorS = false;
				titleS = false;
				genreS = false;
				titleB.setSelected(false);
				genreB.setSelected(false);
				authorB.setSelected(false);
			}
		}
		else if(a.equals("Genre")) {
			if(genreS) {
				genreS = false;
				
			}
			else {
				genreS = true;
				titleS = false;
				isbnS = false;
				authorS = false;
				titleB.setSelected(false);
				authorB.setSelected(false);
				isbnB.setSelected(false);
			}
		}
	}

}
