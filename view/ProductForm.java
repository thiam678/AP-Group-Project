package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ProductController;
import model.Product;

public class ProductForm {
	private JFrame frame;
	private JLabel codeLabel;
	private JLabel nameLabel;
	private JLabel shortDesLabel;
	private JLabel longDesLabel;
	private JLabel itemsInStockLabel;
	private JLabel unitPriceLabel;
	
	
	private JTextField codeTextField;
	private JTextField nameTextField;
	private JTextField shortDesTextField;
	private JTextField longDesTextField;
	private JTextField itemsInTextField;
	private JTextField unitPriceTextField;
	
	private JButton save;
	private GridBagConstraints gbc;
	
	public ProductForm() {
		
		frame = new JFrame();
		frame.setLayout(new GridBagLayout());
		
		codeLabel = new JLabel("Product Code");
		codeTextField = new JTextField();
		
		nameLabel = new JLabel("Product Name");
		nameTextField = new JTextField();
		
		shortDesLabel = new JLabel("Short Description");
		shortDesTextField = new JTextField();
		
		longDesLabel = new JLabel("Long Description");
		longDesTextField= new JTextField();
		
		itemsInStockLabel = new JLabel("Items in Stock");
		itemsInTextField= new JTextField();
		
		unitPriceLabel = new JLabel("Unit Price");
		unitPriceTextField= new JTextField();
		
		save = new JButton("Save");
	
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(codeLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(codeTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(nameLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(nameTextField, gbc);
		

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(shortDesLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(shortDesTextField, gbc);
		

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(longDesLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 50;
		frame.add(longDesTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(itemsInStockLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 50;
		frame.add(itemsInTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(unitPriceLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 50;
		frame.add(unitPriceTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.ipadx = 50;
		gbc.insets = new Insets(30, 0, 0, 0);
		frame.add(save, gbc);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		
         save.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductController control = null;
				Product product = new Product();
				
				if(e.getSource() == save) {
					product.setProductCode(codeTextField.getText());
					product.setproductName(nameTextField.getText());
					product.setShortDescription(shortDesTextField.getText());
					product.setLongDescription(longDesTextField.getText()); 
					product.setItemsInStock(Integer.parseInt(itemsInTextField.getText()));
					product.setUnitPrice(Float.parseFloat(unitPriceTextField.getText()));
					
				}
				control.insertRecord(product);
			}
		});
		
    }
	
	public static void main(String[] args) {
		new ProductForm();

	}


}
