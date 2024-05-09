package Instructor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.Database;
import Messages.MessageBox;

public class PrepareResult extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> moduleComboBox;
	private JComboBox<String> idComboBox;
	private JTextField marksTextField;

	/**
	 * Create the panel.
	 */
	public PrepareResult(String email) {
		setBounds(0, 0, 1048, 720);
        setLayout(null);
        
        /* Header */
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(32, 73, 434, 58);
        add(headerPanel);
        
        JLabel headerLabel = new JLabel("Assign Marks");
        headerLabel.setForeground(new Color(70, 130, 180));
        headerLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        headerLabel.setBounds(6, 6, 119, 46);
        headerPanel.add(headerLabel);
        
        /* Student ID */
        JPanel idPanel = new JPanel();
        idPanel.setBounds(32, 133, 434, 58);
        add(idPanel);
        idPanel.setLayout(null);
        
        JLabel idLabel = new JLabel("Student ID");
        idLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        idLabel.setBounds(6, 6, 103, 46);
        idPanel.add(idLabel);
        
        idComboBox = new JComboBox<>();
        idComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        idComboBox.setBounds(121, 17, 300, 27);
        idPanel.add(idComboBox);
        viewStudents(email);
        
        JPanel modulePanel = new JPanel();
        modulePanel.setLayout(null);
        modulePanel.setBounds(32, 194, 434, 58);
        add(modulePanel);
        
        /* Modules */
        JLabel moduleLabel = new JLabel("Module");
        moduleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        moduleLabel.setBounds(6, 6, 103, 46);
        modulePanel.add(moduleLabel);
        
        moduleComboBox = new JComboBox<>();
        moduleComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        moduleComboBox.setBounds(121, 17, 300, 27);
        modulePanel.add(moduleComboBox);
        viewModuleOptions(email);        
        
        JPanel marksPanel = new JPanel();
        marksPanel.setLayout(null);
        marksPanel.setBounds(32, 255, 434, 58);
        add(marksPanel);
        
        JLabel marksLabel = new JLabel("Marks");
        marksLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        marksLabel.setBounds(6, 6, 103, 46);
        marksPanel.add(marksLabel);
        
        marksTextField = new JTextField();
        marksTextField.setBounds(125, 12, 289, 37);
        marksPanel.add(marksTextField);
        marksTextField.setColumns(10);
        
        JButton assignBtn = new JButton("Assign");
        assignBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String marksText = marksTextField.getText().trim();
                    if (marksText.isEmpty()) {
                    	openMessageBox("Please complete all the fields.");
                        System.out.println("Please enter marks.");
                        return; // exit the method if marks field is empty
                    }
                    
        		    int marks = Integer.parseInt(marksText);
        		    if (marks < 0 || marks > 100) {
        		    	openMessageBox("Invalid input.");
                        System.out.println("Marks should be between 0 and 100.");
                        return; // exit the method if marks are out of range
                    }
        		    
        		    String selectedStudent = (String) idComboBox.getSelectedItem();
        		    String selectedModule = (String) moduleComboBox.getSelectedItem();
        		    
        		    int studentID;
					String moduleCode;
        		    String[] parts1 = selectedStudent.split(" ");
        		    studentID = Integer.parseInt(parts1[0]);        		    
        		    String[] parts2 = selectedModule.split(" ");
        		    moduleCode = parts2[0];
        		    
       		    
        		    if (!selectedStudent.equals("Choose a student") && !selectedModule.equals("Choose a module")) {
        		    	Database database = new Database();
        				try (Connection connection = database.getConnection()) {
        					if (connection != null) {
        						String sql1 = "SELECT Email FROM Student WHERE ID = ?";
        						PreparedStatement statement1 = connection.prepareStatement(sql1);
        						statement1.setInt(1, studentID);
        						ResultSet rs1 = statement1.executeQuery();
        						
        						// check if there is a result
        						if(rs1.next()) {
        							String studentEmail = rs1.getString("Email");
        							String sql2 = "SELECT Marks FROM Enrollment WHERE Student_Email = ? AND ModuleCode = ?";
        							PreparedStatement statement2 = connection.prepareStatement(sql2);
        							statement2.setString(1, studentEmail);
        							statement2.setString(2, moduleCode);
        							ResultSet rs2 = statement2.executeQuery();
        			
        			                if (rs2.next()) {  
        			                	rs2.getInt("Marks");
        			                	if (rs2.wasNull()) {
	        								String sql3 = "UPDATE Enrollment SET Marks = ? WHERE Student_Email = ? AND ModuleCode = ?";
	        					            PreparedStatement statement3 = connection.prepareStatement(sql3);
	        					            statement3.setInt(1, marks);
	        					            statement3.setString(2, studentEmail);
	            							statement3.setString(3, moduleCode);
	        					            int rows = statement3.executeUpdate();
	        					            
	        					            if (rows > 0) {
	        					            	openMessageBox("Marks assigned successfully.");
	        					            }
        			                	} else {
        			                		openMessageBox("Marks is already assigned for this student.");
        			                	}
        			                }
        					    }
        					}
        				} catch (SQLException e1) {
							e1.printStackTrace();
						}
                    } else {
                    	openMessageBox("Please choose the options.");
                    }

        		} catch (NumberFormatException error) {       			
        		    System.err.println("Invalid input: " + error.getMessage());
        		    openMessageBox("Invalid input.");
        		}
        	}
        });
        assignBtn.setForeground(new Color(70, 130, 180));
        assignBtn.setBounds(352, 330, 97, 46);
        add(assignBtn);
	}
	
	// method to view student options
	private void viewStudents(String email) {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		comboBoxModel.addElement("Choose a student");
		
		Set<String> studentSet = new HashSet<>(); // Set to keep track of unique students

		Database database = new Database();
		try (Connection connection = database.getConnection()) {
			if (connection != null) {
				String sql1 = "SELECT ID FROM Instructor WHERE Email = ?";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setString(1, email);
				ResultSet rs1 = statement1.executeQuery();
				
				if(rs1.next()) {
					String instructorID = rs1.getString("ID");
					String sql2 = "SELECT ModuleCode FROM Assignment WHERE InstructorID = ?";
					PreparedStatement statement2 = connection.prepareStatement(sql2);
					statement2.setString(1, instructorID);
					ResultSet rs2 = statement2.executeQuery();
					
					while (rs2.next()) {
						String moduleCode = rs2.getString("ModuleCode");
						String sql3 = "SELECT Student_Email FROM Enrollment WHERE ModuleCode = ?";
			            PreparedStatement statement3 = connection.prepareStatement(sql3);
			            statement3.setString(1, moduleCode);
			            ResultSet rs3 = statement3.executeQuery();
		
		                while (rs3.next()) {
		                	String studentEmail = rs3.getString("Student_Email");		                	
		                	if (!studentSet.contains(studentEmail)) { // check if student already added
	                            String sql4 = "SELECT ID, Name FROM Student WHERE Email = ?";
	                            PreparedStatement statement4 = connection.prepareStatement(sql4);
	                            statement4.setString(1, studentEmail);
	                            ResultSet rs4 = statement4.executeQuery();

	                            // loop through the result set and add course panels
	                            while (rs4.next()) {
	                                String studentID = rs4.getString("ID");
	                                String studentName = rs4.getString("Name");
	                                comboBoxModel.addElement(studentID + " " + studentName);
	                                studentSet.add(studentEmail); // add student to the set
	                            }
					        }
		                }
	            	}
	            }
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		idComboBox.setModel(comboBoxModel);
	}	
	
	// method to view module options
	private void viewModuleOptions(String email) {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		comboBoxModel.addElement("Choose a module");
		
		Database database = new Database();
		try (Connection connection = database.getConnection()) {
			if (connection != null) {
				String sql1 = "SELECT ID FROM Instructor WHERE Email = ?";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setString(1, email);
				ResultSet rs1 = statement1.executeQuery();
				
				// check if there is a result
				if(rs1.next()) {
					String instructorID = rs1.getString("ID");
					String sql2 = "SELECT ModuleCode FROM Assignment WHERE InstructorID = ?";
					PreparedStatement statement2 = connection.prepareStatement(sql2);
					statement2.setString(1, instructorID);
					ResultSet rs2 = statement2.executeQuery();
	
	                while (rs2.next()) {
	                	String moduleCode = rs2.getString("ModuleCode");		                
						String sql3 = "SELECT ModuleName FROM Module WHERE ModuleCode = ?";
			            PreparedStatement statement3 = connection.prepareStatement(sql3);
			            statement3.setString(1, moduleCode);
			            ResultSet rs3 = statement3.executeQuery();
		
		                while (rs3.next()) {
		                		String moduleName = rs3.getString("ModuleName");		                	
		                		comboBoxModel.addElement(moduleCode + " " + moduleName);
		                }            
			        }
	            }
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		moduleComboBox.setModel(comboBoxModel);
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
