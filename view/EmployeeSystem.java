package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Result;

import controller.ProductController;
import controller.StaffController;

import model.Employee;
import model.Product;


public class EmployeeSystem {
	
    private JFrame frame;
    private JFrame frame1;
    //employee data
    private JLabel empIdLabel;
    private JLabel empNameLabel;
    private JLabel empTeleLabel;
    private JLabel empEmailLabel;
    private JLabel empDepLabel;

    private JTextField empIdTextField;
    private JTextField empNameTextField;
    private JTextField empTeleTextField;
    private JTextField empEmailTextField;
    private JTextField empDepTextField;

    private JButton create;
    private JButton view;
    private JButton update;
    private JButton delete;
    private GridBagConstraints gbc;

    public EmployeeSystem()
    {
    	
        frame1 = new JFrame();
        frame1.setLayout(new GridBagLayout());

        empIdLabel = new JLabel("Employee ID");
        empIdTextField = new JTextField();

        empNameLabel = new JLabel("Employee Name");
        empNameTextField = new JTextField();

        empTeleLabel = new JLabel("Employee Telephone");
        empTeleTextField = new JTextField();

        empEmailLabel = new JLabel("Employee Email:");
        empEmailTextField = new JTextField();
        
        empDepLabel = new JLabel("Employee Department:");
        empDepTextField = new JTextField();

        create= new JButton("Create");
        update= new JButton("Update");
        view= new JButton("  View ");
        delete= new JButton("Delete");
               gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame1.add(create, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame1.add(view, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame1.add(update, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame1.add(delete, gbc);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 600);
        frame1.setVisible(true);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // StaffController control = new StaffController();
               // Employee emp = new Employee();
                if(e.getSource() == create) {
                	Create myCreate = new Create();   
                }
                
            }
        });  
        
        view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaffController control = new StaffController();
                Employee emp = new Employee();
				if(e.getSource() == view) {
					try {
						View myview = new View();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
        	
        	
        });
        
        


    }
    
    
    public class Create {
    	
    	
    	
    	JFrame frame = new JFrame("Create An Employee");
    	JPanel panel=new JPanel();
    	
    	Create(){
    		
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(420,420);
    		frame.setLayout(new GridBagLayout());
    		frame.setVisible(true);

    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 0;
    		frame.add(empIdLabel, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 0;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;
    		frame.add(empIdTextField, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 1;
    		frame.add(empNameLabel, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 1;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;
    		frame.add(empNameTextField, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 2;
    		frame.add(empTeleLabel, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 2;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;
    		frame.add(empTeleTextField, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 3;
    		frame.add(empEmailLabel, gbc);

    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 3;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;
    		frame.add(empEmailTextField, gbc);
    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 4;
    		//frame.add(empDepLabel, gbc);
    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 4;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;   
    		//frame.add(empDepTextField, gbc);
    		
    		JButton back = new JButton("Back");
    	    
    		gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.ipadx = 50;
            gbc.insets = new Insets(30, 0, 0, 0);
            frame.add(back, gbc);

    	    back.addActionListener(actionListener -> {
    	        frame.dispose();
    	        frame1.setVisible(true);
    	    });
    	    
    	    JButton submit = new JButton("Submit");
    	  
    	    gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.ipadx = 50;
            gbc.insets = new Insets(30, 0, 0, 0);
            frame.add(submit, gbc);
            
            submit.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				 StaffController control = new StaffController();
    	                Employee emp = new Employee();
    	                if(e.getSource() == submit) {
    	                    emp.setEmpID(empIdTextField.getText());
    	                    emp.setName(empNameTextField.getText());
    	                    emp.setEmpTele(empTeleTextField.getText());
    	                    emp.setEmpEmail(empEmailTextField.getText());
    	                   // emp.setDep(empDepTextField.getText());
    	                }
    	                control.createEmployeeRecord(emp);
    	            }
    	        });    	
            }
          
    }
    
 public class View {
    	
    	JFrame frame2 = new JFrame("View List Of Employees");
    	JPanel panel2=new JPanel();
    	
    	View() throws SQLException{		
		       
		        
		        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frame2.setSize(420,420);
	    		frame2.setLayout(new GridBagLayout());
	    		frame2.setVisible(true);

	    		
	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 0;
	    		gbc.gridy = 0;
	    		frame2.add(empIdLabel, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 1;
	    		gbc.gridy = 0;
	    		gbc.insets = new Insets(0, 30, 0, 0);
	    		gbc.ipadx = 150;
	    		frame2.add(empIdTextField, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 0;
	    		gbc.gridy = 1;
	    		frame2.add(empNameLabel, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 1;
	    		gbc.gridy = 1;
	    		gbc.insets = new Insets(0, 30, 0, 0);
	    		gbc.ipadx = 150;
	    		frame2.add(empNameTextField, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 0;
	    		gbc.gridy = 2;
	    		frame2.add(empTeleLabel, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 1;
	    		gbc.gridy = 2;
	    		gbc.insets = new Insets(0, 30, 0, 0);
	    		gbc.ipadx = 150;
	    		frame2.add(empTeleTextField, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 0;
	    		gbc.gridy = 3;
	    		frame2.add(empEmailLabel, gbc);

	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 1;
	    		gbc.gridy = 3;
	    		gbc.insets = new Insets(0, 30, 0, 0);
	    		gbc.ipadx = 150;
	    		frame2.add(empEmailTextField, gbc);
	    		
	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 0;
	    		gbc.gridy = 4;
	    		//frame2.add(empDepLabel, gbc);
	    		
	    		gbc = new GridBagConstraints();
	    		gbc.gridx = 1;
	    		gbc.gridy = 4;
	    		gbc.insets = new Insets(0, 30, 0, 0);
	    		gbc.ipadx = 150;   
	    		//frame2.add(empDepTextField, gbc);
			
	    		JButton back1 = new JButton("Back");
	    	    
	    		gbc = new GridBagConstraints();
	            gbc.gridx = 0;
	            gbc.gridy = 5;
	            gbc.ipadx = 50;
	            gbc.insets = new Insets(30, 0, 0, 0);
	            frame.add(back1, gbc);
			

	    	    back1.addActionListener(actionListener -> {
	    	        frame.dispose();
	    	        frame2.setVisible(true);
	    	    });
	    	    
	    	    


    	}
 }
    



public static void main(String[] args) {
	
	new EmployeeSystem();
	
}
    
}

