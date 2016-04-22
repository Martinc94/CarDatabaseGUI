package ie.gmit.sw;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainForm {

	private JFrame frame;

	/**
	 * Launch the Main page
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Form
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.RED);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarManagementSoftware = new JLabel("Car Management");
		lblCarManagementSoftware.setBounds(260, 0, 255, 146);
		lblCarManagementSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarManagementSoftware.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblCarManagementSoftware.setBackground(Color.WHITE);
		frame.getContentPane().add(lblCarManagementSoftware);
		
		//Button for search form
		JButton btnSearch = new JButton("Search for Car");
		btnSearch.setBounds(236, 261, 126, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm search = new SearchForm();
				search.open();
			}
		});
		
		//Button for Add form
		JButton btnAdd = new JButton("Add Car");
		btnAdd.setBounds(91, 261, 87, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddForm add = new AddForm();
				add.open();
			}
		});
		frame.getContentPane().add(btnAdd);
		frame.getContentPane().add(btnSearch);
		
		//Button for List form
		JButton btnListAllCars = new JButton("List All Cars");
		btnListAllCars.setBounds(553, 261, 126, 23);
		btnListAllCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListForm list = new ListForm();
				list.open();
			}
		});
		frame.getContentPane().add(btnListAllCars);
		
		//Button for Update form
		JButton btnUpdateCar = new JButton("Update Car");
		btnUpdateCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateForm update = new UpdateForm();
				update.open();
			}
		});
		btnUpdateCar.setBounds(410, 261, 105, 23);
		frame.getContentPane().add(btnUpdateCar);
	}
}
