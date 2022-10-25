package view;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CustomerController;
import factories.SessionFactoryBuilder;
import model.Customer;
import model.Date;

public class CustomerForm {
	private JFrame frame;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;
	private JLabel telephoneLabel;
	private JLabel dateOfBirthLabel;
	private JLabel dateOfMemberShipLabel;
	private JLabel dateOfMembershipExpirationLabel;
	
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField telephoneTextField;
	private JTextField dateOfBirthTextField;
	private JTextField dateOfMemberShipTextField;
	private JTextField dateOfMembershipExpirationTextField;
	
	
	private JButton save;
	private GridBagConstraints gbc;
	
	public CustomerForm() {
		
		frame = new JFrame();
		frame.setLayout(new GridBagLayout());
		
		idLabel = new JLabel("ID Number");
		idTextField = new JTextField();
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		
		addressLabel = new JLabel("Address");
		addressTextField = new JTextField();
		
		emailLabel = new JLabel("Email");
		emailTextField = new JTextField();
		
		telephoneLabel = new JLabel("Telephone");
		telephoneTextField = new JTextField();
		
		dateOfBirthLabel = new JLabel("Date of Birth");
		dateOfBirthTextField = new JTextField();
		
		dateOfMemberShipLabel = new JLabel("Date of Membership");
		dateOfMemberShipTextField = new JTextField();
		
		dateOfMembershipExpirationLabel = new JLabel("Date of Membership Expiration");
		dateOfMembershipExpirationTextField = new JTextField();
		
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
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(addressLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(addressTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(emailLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(emailTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(telephoneLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(telephoneTextField, gbc);
		

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(dateOfBirthLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(dateOfBirthTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(dateOfMemberShipLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(dateOfMemberShipTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.insets = new Insets(10, 0, 0, 0);
		frame.add(dateOfMembershipExpirationLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.ipadx = 150;
		frame.add(dateOfMembershipExpirationTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
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
						
						DateTimeFormatter format= DateTimeFormatter.ofPattern("d-MM-uuuu");
						
						LocalDate dob =LocalDate.parse(dateOfBirthTextField.getText(),format);
						LocalDate membership =LocalDate.parse(dateOfMemberShipTextField.getText(),format);
						LocalDate membershipExpiration =LocalDate.parse(dateOfMembershipExpirationTextField.getText(),format);
						
						
						
						cus.setIdNumber(idTextField.getText());
						cus.setName(nameTextField.getText());
						cus.setAddress(addressTextField.getText());
						cus.setEmail(emailTextField.getText());
						cus.setTelephone(telephoneTextField.getText());
						cus.setDob(new Date(dob.getDayOfMonth(),dob.getMonthValue(),dob.getYear()));
						cus.setDateOfMembership(new Date(membership.getDayOfMonth(),membership.getMonthValue(),membership.getYear()));
						cus.setDateOfExipiry(new Date(membershipExpiration.getDayOfMonth(),membershipExpiration.getMonthValue()
								,membershipExpiration.getYear()));
					}
				control.insertRecord(cus);
				}
			});
	}
	
	public static void main(String[] args) {
		new CustomerForm();

	}
	
	

}
