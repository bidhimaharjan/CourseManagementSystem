package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.Database;
import Messages.MessageBox;

public class AddModule extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField moduleCodeTextField;
    private JTextField moduleTitleTextField;
    private JTextField courseCodeTextField;

	/**
	 * Create the panel.
	 */
	public AddModule() {
		setBounds(0, 0, 628, 273);
		setLayout(null);
		
		JLabel addModuleLabel = new JLabel("Add module to a course");
		addModuleLabel.setForeground(new Color(70, 130, 180));
		addModuleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		addModuleLabel.setBounds(27, 6, 204, 42);
		add(addModuleLabel);
		
		JLabel addModuleCourse = new JLabel("Course Code:");
		addModuleCourse.setForeground(new Color(0, 0, 0));
		addModuleCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		addModuleCourse.setBounds(27, 55, 100, 42);
		add(addModuleCourse);
		
		courseCodeTextField = new JTextField();
		courseCodeTextField.setColumns(10);
		courseCodeTextField.setBounds(151, 59, 452, 36);
		add(courseCodeTextField);
		
		JLabel addModuleCode = new JLabel("Module Code:");
		addModuleCode.setForeground(Color.BLACK);
		addModuleCode.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		addModuleCode.setBounds(27, 101, 100, 42);
		add(addModuleCode);
		
		moduleCodeTextField = new JTextField();
		moduleCodeTextField.setBounds(151, 105, 452, 36);
		add(moduleCodeTextField);
		moduleCodeTextField.setColumns(10);
		
		JLabel addModuleTitle = new JLabel("Module Title:");
		addModuleTitle.setForeground(Color.BLACK);
		addModuleTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		addModuleTitle.setBounds(27, 149, 100, 42);
		add(addModuleTitle);
		
		moduleTitleTextField = new JTextField();
		moduleTitleTextField.setColumns(10);
		moduleTitleTextField.setBounds(151, 153, 452, 36);
		add(moduleTitleTextField);

		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setForeground(new Color(70, 130, 180));
		confirmBtn.setBounds(390, 211, 95, 42);
		add(confirmBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(new Color(70, 130, 180));
		cancelBtn.setBounds(508, 211, 95, 42);
		add(cancelBtn);
		
		// action listener for Confirm button
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = courseCodeTextField.getText();
				String moduleCode = moduleCodeTextField.getText();
				String moduleName = moduleTitleTextField.getText();
				
				if (courseCode.isEmpty() == true || moduleCode.isEmpty() == true || moduleName.isEmpty() == true) {
				    openMessageBox("Please complete all the fields.");
				} else {				
					Database database = new Database();
					try (Connection connection = database.getConnection()) {
						if (connection != null) {
							String sql =  "INSERT INTO Module (ModuleCode, ModuleName, CourseCode) VALUES (?, ?, ?)" ;
			                    	
							PreparedStatement statement = connection.prepareStatement(sql);
							statement.setString(1, moduleCode);
							statement.setString(2, moduleName);
		                    statement.setString(3, courseCode);    				                    	
		
				            int rows = statement.executeUpdate();
				            if (rows > 0) {
				            	openMessageBox("Module added successfully.");
		                    } else {
		                    	openMessageBox("Cannot add module.");
		                    }        
			                connection.close();
			            }
						
					} catch (SQLException e1) {
			            e1.printStackTrace();
			        }
					
					setVisible(false);
				}
		    }
		});
		
		// action listener for Cancel button
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		    }
		});
	}
	
	/**
	 * Direct to the Message Box frame.
	 */
	private void openMessageBox(String message) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MessageBox frame = new MessageBox(message);
					frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

