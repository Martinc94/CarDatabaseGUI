package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ListForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListForm window = new ListForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListAllCars = new JLabel("List all Cars");
		lblListAllCars.setHorizontalAlignment(SwingConstants.CENTER);
		lblListAllCars.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblListAllCars.setBackground(Color.WHITE);
		lblListAllCars.setBounds(0, 0, 682, 36);
		frame.getContentPane().add(lblListAllCars);
	}
	
	public void open() {
		frame.setVisible(true);
		
	}

}
