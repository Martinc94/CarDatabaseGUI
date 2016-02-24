package ie.gmit.sw;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class MainForm {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add Car");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddForm add = new AddForm();
				add.open();
			}
		});
		btnAdd.setBounds(70, 222, 150, 64);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSearch = new JButton("Search for Car");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm search = new SearchForm();
				search.open();
			}
		});
		btnSearch.setBounds(275, 222, 150, 64);
		frame.getContentPane().add(btnSearch);
		
		JButton btnListAllCars = new JButton("List All Cars");
		btnListAllCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListForm list = new ListForm();
				list.open();
			}
		});
		btnListAllCars.setBounds(482, 222, 150, 64);
		frame.getContentPane().add(btnListAllCars);
		
		table = new JTable();
		table.setBounds(112, 198, 437, -64);
		frame.getContentPane().add(table);
		
		JLabel lblCarManagementSoftware = new JLabel("Car Management Software");
		lblCarManagementSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarManagementSoftware.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblCarManagementSoftware.setBackground(Color.WHITE);
		lblCarManagementSoftware.setBounds(0, 0, 682, 36);
		frame.getContentPane().add(lblCarManagementSoftware);
	}
}
