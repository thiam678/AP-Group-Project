package view;

import java.awt.Color;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
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
import java.awt.Insets;
//import net.proteanit.sql.DbUtils;
//import java.awt.Event.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//import com.mysql.cj.xdevapi.Result;

import controller.ProductController;
import controller.StaffController;
import domain.Connector;
import domain.Employee;
import domain.Product;


public class NewEmployeeSystem {
	//private static Connection dbConn = Connector.getDatabaseConnection();
    private JFrame frame;
    private JFrame frame1;
    //employee data
    private JLabel empIdLabel;
    private JLabel empNameLabel;
    private JLabel empTeleLabel;
    private JLabel empEmailLabel;
    private JLabel empDepLabel;
    private JLabel empCodeLabel;

    private JTextField empIdTextField;
    private JTextField empNameTextField;
    private JTextField empTeleTextField;
    private JTextField empEmailTextField;
    private JComboBox<String> empDepComboBox;
    private JTextField empCodeTextField;
    
    
    private JButton create;
    private JButton view;
    private JButton update;
    private JButton delete;
    private GridBagConstraints gbc;
    private ImageIcon EMS;
    private JLabel mylabel;

    public NewEmployeeSystem()
    {
    	EMS = new ImageIcon(this.getClass().getResource("EMS.jpeg"));
    	
    	
    	
        frame1 = new JFrame();
       // frame1.add(mylabel);
        frame1.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ojayp\\eclipse-workspace\\EMS.jpeg")));
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
        String departmentCodes[] = {"Account&Sales3333","Invent2222","Man1001"};
        empDepComboBox = new JComboBox<>(departmentCodes);

        
        empCodeLabel = new JLabel("Employee Type Code:");
        empCodeTextField = new JTextField();
        
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
                	new Create();
                	}
                
            }
        });  
        
        view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 StaffController control = new StaffController();
                Employee emp = new Employee();
				if(e.getSource() == view) {
					frame1.setVisible(false);
						 new View();
						
					
					
					//((Employee) control).viewEmployeeRecord(emp);
					//control.retrieveEmployeeRecord(emp);
					
					
				}
				
			}
			
			
        	
        	
        });
        
        update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new StaffController();
               // new Employee();
                if(e.getSource() == update) {
                	new UpdateView();
                	
                	
                
                }
				
				
			}
        	
        });
        
        delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== delete) {
					new Delete();
				}
								
				
			}
        	
        });
        
        
        
        


    }
    public class Delete extends JFrame  {    	
    	JTable table;
    	Choice cempId;
    	JButton search, back, all, Del;
    	
    	Delete() {
    		getContentPane().setBackground(Color.WHITE);
    	    setLayout(null);
    		
    	    JLabel Search = new JLabel("Search by Employee ID");
    	    Search.setBounds(20, 20, 150, 20);
    	    add(Search);
    	    
    	    cempId = new Choice();
    	    cempId.setBounds(180, 20, 150, 20);
    	    add(cempId);
	try {
    			
    			ResultSet result = dbConn.createStatement().executeQuery("SELECT * FROM employee");
    			    			
    			while(result.next()) {
    				cempId.add(result.getString("empId"));
    			}
		 }catch (Exception e) {
    			e.printStackTrace();
    		}
    	    
    	    
    		table = new JTable();
    		
    		
    		try {
    			
    			ResultSet result = dbConn.createStatement().executeQuery("SELECT * FROM employee");
    			table.setModel(DbUtils.resultSetToTableModel(result));
    			
		 }catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		JScrollPane jsp = new JScrollPane(table);
    		jsp.setBounds(0, 100, 900, 600);;
    		add(jsp); 
    		search = new JButton("Search");
    		search.setBounds(20,70,80,20);
    		
    		add(search);
    		back = new JButton("Back");
    		back.setBounds(320, 70, 80, 20);
    		add(back);
    		
    		all = new JButton("View All");
    		all.setBounds(180, 70, 80, 20);
    		add(all);
    		
    		Del = new JButton("Delete");
    		Del.setBounds(450, 70, 80, 20);
    		add(Del);
    	
    		setSize(900,700);
    		setLocation(300, 100);
    		setVisible(true);
    		
    		
    		all.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource()== all) {
						String query = "SELECT * FROM employee ";
						try {
						ResultSet result = dbConn.createStatement().executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(result));
						}catch (Exception e1){
							e1.printStackTrace();
							
						}
					}
					// TODO Auto-generated method stub
					
				}
    			
    		});
    		
    		search.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    			if(e.getSource() == search) {
    				//String x = String.format(empIdTextField.getText());
					String query = "SELECT * FROM employee WHERE empId =" +cempId.getSelectedItem();
					try {
						
						ResultSet result = dbConn.createStatement().executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(result));
						
		    			 
					}catch (Exception e1) {
						e1.printStackTrace();
					}
						
					}
    			}
    			
    		});
    		Del.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()== Del) {
						int choice = JOptionPane.showConfirmDialog(null, "Delete Record", "Delete", JOptionPane.YES_NO_OPTION);
					    if(choice==0) {
						try {
 	                    	String query = "DELETE FROM  employee WHERE empId = '"+cempId.getSelectedItem()+"'";
 	        				 dbConn.createStatement().executeUpdate(query);
 	        				 JOptionPane.showMessageDialog(null, "Information Deleted Successfully");
 	        				 frame.setVisible(false);
						}catch (Exception e1) {
							e1.getStackTrace();
						}
						
					    }
						
						
						
					}
				
					
				}
    			
    		});
    		
    		
    	}
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
    		gbc.toString();
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
    		frame.add(empDepLabel, gbc);
    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 4;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 16;   
    		frame.add(empDepComboBox, gbc);
    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 0;
    		gbc.gridy = 5;
    		frame.add(empCodeLabel, gbc);
    		
    		gbc = new GridBagConstraints();
    		gbc.gridx = 1;
    		gbc.gridy = 5;
    		gbc.insets = new Insets(0, 30, 0, 0);
    		gbc.ipadx = 150;   
    		frame.add(empCodeTextField, gbc);
    		
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
     	                    emp.setDepCode((String) (empDepComboBox).getSelectedItem());
     	                    emp.setEmpCode(empCodeTextField.getText());
     	                    control.sendAction("Create Employee");
     	            		System.out.println("Message sent to server");
    	                }
    	                control.sendEmployee(emp);
    	            }
    	        });    	
            }
          
    }
    
 public class View extends JFrame  {    	
    	JTable table;
    	Choice cempId;
    	JButton search, back, all;
    	
    	View() {
    		getContentPane().setBackground(Color.WHITE);
    	    setLayout(null);
    		
    	    JLabel Search = new JLabel("Search by Employee ID");
    	    Search.setBounds(20, 20, 150, 20);
    	    add(Search);
    	    
    	    cempId = new Choice();
    	    cempId.setBounds(180, 20, 150, 20);
    	    add(cempId);
    	    StaffController control = new StaffController();
    	    
    	    cempId.add(control.retrieveEmployeeIDs());
    	       	    
    	    
	 table = new JTable();
	    Object columns[] =  {"EmployeeID", "Name", "Email", "Telephone", "DepartmentCode", "EmployeeCode"};
    	DefaultTableModel model = new DefaultTableModel();
    	model.setColumnIdentifiers(columns);
    	table.setModel(model);
    		
    	Object[] row = new Object[6];
    	
    	
    	Employee employee = new Employee();
    	row[1] = control.recieveResponse();
    	
    	model.addRow(row);
    		
    		JScrollPane jsp = new JScrollPane(table);
    		jsp.setBounds(0, 100, 900, 600);;
    		add(jsp); 
    		search = new JButton("Search");
    		search.setBounds(20,70,80,20);
    		
    		add(search);
    		back = new JButton("Back");
    		back.setBounds(320, 70, 80, 20);
    		add(back);
    		
    		all = new JButton("View All");
    		all.setBounds(180, 70, 80, 20);
    		add(all);
    	
    		setSize(900,700);
    		setLocation(300, 100);
    		setVisible(true);
    		
    		
    		all.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource()== all) {
						String query = "SELECT * FROM employee ";
						try {
						ResultSet result = dbConn.createStatement().executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(result));
						table.ad
						}catch (Exception e1){
							e1.printStackTrace();
							
						}
					}
					// TODO Auto-generated method stub
					
				}
    			
    		});
    		
    		search.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    			if(e.getSource() == search) {
    				//String x = String.format(empIdTextField.getText());
					String query = "SELECT * FROM employee WHERE empId =" +cempId.getSelectedItem();
					try {
						
						ResultSet result = dbConn.createStatement().executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(result));
						
		    			 
					}catch (Exception e1) {
						e1.printStackTrace();
					}
						
					}
    			}
    			
    		});
    		
    		
    	}
 }
 public class Update {
 	
 	
 	
 	JFrame frame2 = new JFrame("Update Employee");
 	JPanel panel=new JPanel();

 	
 	Update(String empId){
 		
 
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
 		empIdTextField.setEnabled(false);
 		frame2.add(empIdTextField, gbc);
 		
 		
 		
 		gbc = new GridBagConstraints();
 		gbc.gridx = 1;
 		gbc.gridy = 1;
 		gbc.insets = new Insets(0, 30, 0, 0);
 		gbc.ipadx = 150;
 		frame2.add(empNameTextField, gbc);
 		
 		

 		gbc = new GridBagConstraints();
 		gbc.gridx = 0;
 		gbc.gridy = 1;
 		frame2.add(empNameLabel, gbc);

 		

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
         frame2.add(back, gbc);
         
         try {
  			String query = "SELECT * FROM employee WHERE empId = '"+ empId+"'";
 				
 				ResultSet result = dbConn.createStatement().executeQuery(query);
 				while(result.next()){
 					
 					empIdTextField.setText(result.getString("empID"));
 					empNameTextField.setText(result.getString("Name"));
 					empEmailTextField.setText(result.getString("empEmail"));
 					empTeleTextField.setText(result.getString("empTele"));	
 					
 					
 				}
  			
  		}catch (Exception e) {
  			e.printStackTrace();
  		}

 	    back.addActionListener(actionListener -> {
 	        frame2.dispose();
 	        
 	    });
 	    
 	    JButton submit1 = new JButton("Update Record");
 	  
 	    gbc = new GridBagConstraints();
         gbc.gridx = 1;
         gbc.gridy = 5;
         gbc.ipadx = 50;
         gbc.insets = new Insets(30, 0, 0, 0);
         frame2.add(submit1, gbc);
         
         submit1.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 	                    if(e.getSource() == submit1) {
 	                	
 	                    String name = empNameTextField.getText();
 	                    String tele = empTeleTextField.getText();
 	                   String email = empEmailTextField.getText();
 	                    try {
 	                    	String query = "UPDATE  employee SET  Name = '"+ name +"', empTele = '"+ tele +"', empEmail = '"+email+"' WHERE empId = '"+empIdTextField.getText()+"'";
 	        				
 	        				 dbConn.createStatement().executeUpdate(query);
 	        				 JOptionPane.showMessageDialog(null, "Information Updated Successfully");
 	        				 frame2.setVisible(false);
 	                    	
 	                    }catch(Exception e1) {
 	                    	e1.printStackTrace();
 	                    }
 	                   
 	                }
 	               
 	            }
 	        });    	
         }
       
 }
 public class UpdateView extends JFrame  {    	
 	JTable table;
 	Choice cempId;
 	JButton search, back;
 	
 	UpdateView() {
 		getContentPane().setBackground(Color.WHITE);
 	    setLayout(null);
 		
 	    JLabel Search = new JLabel("Search by Employee ID");
 	    Search.setBounds(20, 20, 150, 20);
 	    add(Search);
 	    
 	    cempId = new Choice();
 	    cempId.setBounds(180, 20, 150, 20);
 	    add(cempId);
	try {
 			
 			ResultSet result = dbConn.createStatement().executeQuery("SELECT * FROM employee");
 			    			
 			while(result.next()) {
 				cempId.add(result.getString("empId"));
 			}
		 }catch (Exception e) {
 			e.printStackTrace();
 		}
 	    
 	    
 		table = new JTable();
 		
 		
 		try {
 			
 			ResultSet result = dbConn.createStatement().executeQuery("SELECT * FROM employee");
 			table.setModel(DbUtils.resultSetToTableModel(result));
		 }catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		JScrollPane jsp = new JScrollPane(table);
 		jsp.setBounds(0, 100, 900, 600);;
 		add(jsp); 
 		search = new JButton("Search");
 		search.setBounds(20,70,80,20);
 		
 		add(search);
 		back = new JButton("Back");
 		back.setBounds(320, 70, 80, 20);
 		add(back);
 		
 		update = new JButton("Update");
 		update.setBounds(180, 70, 80, 20);
 		add(update);
 	
 		setSize(900,700);
 		setLocation(300, 100);
 		setVisible(true);
 		
 		search.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 			if(e.getSource() == search) {
 				//String x = String.format(empIdTextField.getText());
					String query = "SELECT * FROM employee WHERE empId =" +cempId.getSelectedItem();
					try {
						
						ResultSet result = dbConn.createStatement().executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(result));
						
		    			 
					}catch (Exception e1) {
						e1.printStackTrace();
					}
						
					}
 			}
 			
 		});
 		
 		update.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource() ==update ) {
						new Update(cempId.getSelectedItem());
					}
					
				}
 			
 		});
 	}
}


public static void main(String[] args) {
	
	new EmployeeSystem();
	
}
 
}

