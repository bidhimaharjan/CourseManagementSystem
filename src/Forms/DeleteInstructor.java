package Forms;

import java.awt.EventQueue;
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

public class DeleteInstructor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField instructorIDTextField;

	/**
	 * Create the panel.
	 */
	public DeleteInstructor() {
		setBounds(0, 0, 456, 222);
		setLayout(null);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(0, 0, 456, 222);
		add(formPanel);
		formPanel.setLayout(null);
		
		JLabel instructorIDLabel = new JLabel("Instructor ID");
		instructorIDLabel.setBounds(30, 34, 93, 37);
		formPanel.add(instructorIDLabel);
		
		instructorIDTextField = new JTextField();
		instructorIDTextField.setBounds(130, 35, 305, 34);
		formPanel.add(instructorIDTextField);
		instructorIDTextField.setColumns(10);
		
		JButton confirmBtn = new JButton("Delete");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = instructorIDTextField.getText();
				
				if (id.isEmpty() == true) {
                	openMessageBox("Please complete all the fields.");
                } else {
	                Database database = new Database();
	        		try (Connection connection = database.getConnection()) {
	        			if (connection != null) {
	        				// insert into Course
	        				String sql1 = "DELETE FROM Instructor WHERE ID = ?";
	        	            try (PreparedStatement statement1 = connection.prepareStatement(sql1)) {
	        	                // set parameters for the prepared statement
	        	            	statement1.setString(1, id);		        	
	
	        	                // execute the query
	        	                int rows1 = statement1.executeUpdate();
	        	                if (rows1 > 0) {
	        	                	System.out.println("Instructor deleted.");
	        	                } else {
	        	                	System.out.println("Failed to delete.");
	        	                }
	        	            }
	        			}
	        		} catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
                }
				formPanel.setVisible(false);
            }		
		});		
		confirmBtn.setBounds(245, 150, 88, 37);
		formPanel.add(confirmBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formPanel.setVisible(false);
			}
		});
		cancelBtn.setBounds(347, 150, 88, 37);
		formPanel.add(cancelBtn);
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
