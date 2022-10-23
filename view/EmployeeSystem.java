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
import controller.StaffController;
import model.Customer;
import model.Employee;

public class EmployeeSystem {
    private JFrame frame;
    //employee data
    private JLabel empIdLabel;
    private JLabel empNameLabel;
    private JLabel empTeleLabel;
    private JLabel empEmailLabel;

    private JTextField empIdTextField;
    private JTextField empNameTextField;
    private JTextField empTeleTextField;
    private JTextField empEmailTextField;

    private JButton create;
    private JButton view;
    private JButton update;
    private JButton delete;
    private GridBagConstraints gbc;

    public EmployeeSystem()
    {
        frame = new JFrame();
        frame.setLayout(new GridBagLayout());
/*
        empIdLabel = new JLabel("Employee ID");
        empIdTextField = new JTextField();

        empNameLabel = new JLabel("Employee Name");
        empNameTextField = new JTextField();

        empTeleLabel = new JLabel("Employee Telephone");
        empTeleTextField = new JTextField();

        empEmailLabel = new JLabel("Employee Email:");
        empEmailTextField = new JTextField();
*/
        create= new JButton("Create");
        update= new JButton("Update");
        view= new JButton("View");
        delete= new JButton("Delete");
        /*
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
 */
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame.add(create, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame.add(view, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame.add(update, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 50;
        gbc.insets = new Insets(30, 0, 0, 0);
        frame.add(delete, gbc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
/*
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StaffController control = new StaffController();
                Employee emp = new Employee();

                if(e.getSource() == create) {
                    emp.setEmpID(empIdTextField.getText());
                    emp.setName(empNameTextField.getText());
                    emp.setEmpTele(empTeleTextField.getText());
                    emp.setEmpEmail(empEmailTextField.getText());

                }
                control.createEmployeeRecord(emp);
            }
        });

*/
    }
    public static void main(String[] args) {
        new EmployeeSystem();

    }
}
