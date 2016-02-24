package ie.gmit.sw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm window = new AddForm();
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
	public AddForm() {
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
		
		JLabel lblAddACar = new JLabel("Add a Car");
		lblAddACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddACar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAddACar.setBackground(Color.WHITE);
		lblAddACar.setBounds(0, 0, 682, 36);
		frame.getContentPane().add(lblAddACar);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(77, 100, 56, 16);
		frame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(77, 143, 56, 16);
		frame.getContentPane().add(lblModel);
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setBounds(77, 186, 56, 16);
		frame.getContentPane().add(lblRegister);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(175, 94, 116, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(175, 137, 116, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 180, 116, 22);
		frame.getContentPane().add(textField_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(549, 380, 97, 25);
		frame.getContentPane().add(btnSubmit);
	}

	public void open() {
		frame.setVisible(true);
		
	}

}
