package Admin;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Components.Dashboard;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel centerPanel;
    private JLabel headerLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1468, 917);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		/* Logo */
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(new Color(70, 130, 180));
		logoPanel.setBounds(0, 0, 320, 204);
		contentPane.add(logoPanel);
		logoPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/logo.jpg")));
		logoLabel.setBounds(92, 62, 120, 136);
		logoPanel.add(logoLabel);
		
		/* Header (Current Button) */
		JPanel headerPanel = new JPanel();
        headerPanel.setBounds(378, 50, 1048, 60);
        contentPane.add(headerPanel);
        headerPanel.setLayout(null);

        headerLabel = new JLabel("DASHBOARD");
        headerLabel.setBounds(6, 12, 361, 31);
        headerLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        headerLabel.setForeground(new Color(70, 130, 180));
        headerPanel.add(headerLabel);
        
        /* Navigation */
        JPanel navigationPanel = new JPanel();
        navigationPanel.setBackground(new Color(70, 130, 180));
        navigationPanel.setBounds(0, 203, 320, 686);
        contentPane.add(navigationPanel);
        navigationPanel.setLayout(null);
        
        // Dashboard Button
        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.setForeground(new Color(70, 130, 180));
        dashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                headerLabel.setText("DASHBOARD");
                addCenterPanelContent(new Dashboard());
            }
        });
        dashboardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        dashboardButton.setBounds(60, 40, 195, 55);
        navigationPanel.add(dashboardButton);
        
        // Manage Courses Button
        JButton coursesButton = new JButton("Manage Courses");
        coursesButton.setForeground(new Color(70, 130, 180));
        coursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                headerLabel.setText("MANAGE COURSES");
                addCenterPanelContent(new ManageCourse());
            }
        });
        coursesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        coursesButton.setBounds(60, 140, 195, 55);
        navigationPanel.add(coursesButton);
        
        // Manage Students Button
        JButton studentsButton = new JButton("Manage Students");
        studentsButton.setForeground(new Color(70, 130, 180));
        studentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                headerLabel.setText("MANAGE STUDENTS");
                addCenterPanelContent(new ManageStudent());
            }
        });
        studentsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        studentsButton.setBounds(60, 240, 195, 55);
        navigationPanel.add(studentsButton);
        
        // Manage Instructors Button
        JButton instructorsButton = new JButton("Manage Instructors");
        instructorsButton.setForeground(new Color(70, 130, 180));
        instructorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                headerLabel.setText("MANAGE INSTRUCTORS");
                addCenterPanelContent(new ManageInstructor());
            }
        });
        instructorsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        instructorsButton.setBounds(60, 340, 195, 55);
        navigationPanel.add(instructorsButton);
        
        // Publish Results Button
        JButton resultsButton = new JButton("Publish Results");
        resultsButton.setForeground(new Color(70, 130, 180));
        resultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                headerLabel.setText("PUBLISH RESULTS");
                addCenterPanelContent(new PublishResult());
            }
        });
        resultsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        resultsButton.setBounds(60, 440, 195, 55);
        navigationPanel.add(resultsButton);
        
        // Settings Button
        JButton logOutButton = new JButton("Log Out");
        logOutButton.setForeground(new Color(70, 130, 180));
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        logOutButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        logOutButton.setBounds(60, 540, 195, 55);
        navigationPanel.add(logOutButton);

        centerPanel = new JPanel();
        centerPanel.setBounds(378, 122, 1048, 720);
        contentPane.add(centerPanel);
        centerPanel.setLayout(null);
        
        addCenterPanelContent(new Dashboard());
        
        // Horizontal Separator between header and contents
        JSeparator horizontalSeparator = new JSeparator();
        horizontalSeparator.setForeground(SystemColor.windowBorder);
        horizontalSeparator.setBounds(385, 108, 1010, 12);
        contentPane.add(horizontalSeparator);
    }
	
	/**
	 * Method to add specific content to the center panel 
	 * when each button is pressed.
	 */
    // 
    private void addCenterPanelContent(JPanel panel) {
        // Clear existing content
        centerPanel.removeAll();
        // Add new content
        centerPanel.add(panel);
        // Repaint
        centerPanel.repaint();
    }
}
