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

public class DeleteCourse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField codeTextField;

	/**
	 * Create the panel.
	 */
	public DeleteCourse() {
		setBounds(0, 0, 628, 273);
		setLayout(null);
		
		JLabel deleteModuleLabel = new JLabel("Delete a course");
		deleteModuleLabel.setForeground(new Color(70, 130, 180));
		deleteModuleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		deleteModuleLabel.setBounds(47, 20, 142, 42);
		add(deleteModuleLabel);
		
		JLabel courseCode = new JLabel("Course Code:");
		courseCode.setBounds(47, 84, 113, 30);
		add(courseCode);
		
		codeTextField = new JTextField();
		codeTextField.setBounds(156, 84, 413, 30);
		add(codeTextField);
		codeTextField.setColumns(10);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setForeground(new Color(70, 130, 180));
		confirmBtn.setBounds(356, 175, 95, 42);
		add(confirmBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(new Color(70, 130, 180));
		cancelBtn.setBounds(474, 175, 95, 42);
		add(cancelBtn);
		
		// action listener for Confirm button
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = codeTextField.getText();
				if (code.isEmpty() == true) {
					openMessageBox("Please complete all the fields.");
				} else {
					Database database = new Database();
	        		try (Connection connection = database.getConnection()) {
	        			if (connection != null) {
	        				// first delete the modules of the course
	        				String sql = "DELETE FROM Module WHERE CourseCode = ?";
	        				try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        	            	statement.setString(1, code);
	        	                int rows = statement.executeUpdate();
	        	                
	        	                if (rows > 0) {
	        	                	// then delete course
	        	                	sql = "DELETE FROM Course WHERE CourseCode = ?";
	        	                	try (PreparedStatement statement1 = connection.prepareStatement(sql)) {
	    	        	            	statement1.setString(1, code);
	    	        	            	rows = statement1.executeUpdate();
	    	        	            	
	    	        	            	if (rows > 0) {
	    	        	            		openMessageBox("Course Deleted Successfully.");
	    	        	            	}
	        	                	}		        	                	
		        	            } else {
		        	            	openMessageBox("Failed to delete the course.");
		        	            }  
	        				}        	                	
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
