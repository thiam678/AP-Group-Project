//DATE OF MEMBERSHIP EXPIRATION NOT ADDED YET
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

import controller.CustomerController;
import model.Customer;

public class CustomerForm {
	  private JFrame frame;
    //customer data
    private JLabel idLabel;
    private JLabel nameLabel;

    
    private JTextField idTextField;
    private JTextField nameTextField;
    
    private JButton save;
    private GridBagConstraints gbc;

    public CustomerForm() {

        frame = new JFrame();
        frame.setLayout(new GridBagLayout());

        idLabel = new JLabel("Customer ID");
        idTextField = new JTextField();

        nameLabel = new JLabel("Name");
        nameTextField = new JTextField();

      

        save= new JButton("Save");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(idLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 30, 0, 0);
        gbc.ipadx = 150;
        frame.add(idTextField, gbc);

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
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame.add(save, gbc);
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		
		 save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				  CustomerController control = new CustomerController();
					Customer cus = new Customer();
					
					if(e.getSource() == save) {
						cus.setIdNumber(idTextField.getText());
						cus.setName(nameTextField.getText());
						
					}
				control.insertRecord(cus);
				}
			});
	}
	
	public static void main(String[] args) {
		new CustomerForm();

	}
	
	

}
