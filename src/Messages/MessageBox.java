package Messages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class MessageBox extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MessageBox(String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 70, 370, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(6, 0, 358, 166);
		contentPane.add(centerPanel);
		centerPanel.setLayout(null);
		
		JLabel messageLabel = new JLabel(message);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setForeground(new Color(70, 130, 180));
		messageLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		messageLabel.setBounds(0, 57, 358, 40);
		centerPanel.add(messageLabel);
		
		JButton okButton = new JButton("OK");
		okButton.setForeground(new Color(70, 130, 180));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close the current frame
				dispose();
			}
		});
		okButton.setBounds(270, 125, 82, 29);
		centerPanel.add(okButton);
		
		// timer to remove the frame after 5 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close the current frame
                dispose();
            }
        });
        timer.start();
	}

}
