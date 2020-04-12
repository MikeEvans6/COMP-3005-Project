package gui;
import java.awt.BorderLayout;

import javax.swing.*;

public class CartView extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public CartView() {
		super("Cart");
		this.setLayout(new BorderLayout());
		
		
	}
	public void showCart() {
		this.setVisible(true);
		
	}
	public void addToCart(String title, int quantity) {
		
	}
	
}
