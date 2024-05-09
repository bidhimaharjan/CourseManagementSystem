package Forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EditInstructor extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel formPanel;

	/**
	 * Create the panel.
	 */
	public EditInstructor() {
		setBounds(0, 0, 770, 234);
		setLayout(null);
		
		formPanel = new JPanel();
		formPanel.setBounds(265, 6, 456, 222);
		add(formPanel);
		formPanel.setLayout(null);
		
		JButton assignButton = new JButton("Assign a module");
		assignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFormPanel(new AssignModule());				
			}
		});
		assignButton.setForeground(new Color(70, 130, 180));
		assignButton.setBounds(42, 54, 173, 50);
		add(assignButton);
		
		JButton removeButton = new JButton("Remove from a module");
		removeButton.setForeground(new Color(70, 130, 180));
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFormPanel(new RemoveFromModule());
			}
		});
		removeButton.setBounds(42, 132, 173, 50);
		add(removeButton);							
	}
	
	/**
	 * Method to add view specific form to the formPanel 
	 * when specific button is pressed.
	 */
    private void viewFormPanel(JPanel panel) {
        // clear existing content
        formPanel.removeAll();
        formPanel.setVisible(true);
        // add new content
        formPanel.add(panel);       
        formPanel.revalidate();
        formPanel.repaint();
    }
}
