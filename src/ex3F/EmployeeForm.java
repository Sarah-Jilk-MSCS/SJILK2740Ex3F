package ex3F;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIDTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private DefaultListModel employeeListModel;
	private JComboBox deptComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
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
	public EmployeeForm() {
		setTitle("Ex 3F: Employee Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 408, 139);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel();
		employeeList = new JList(employeeListModel);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(12, 165, 115, 16);
		contentPane.add(lblEmployeeId);
		
		empIDTextField = new JTextField();
		lblEmployeeId.setLabelFor(empIDTextField);
		empIDTextField.setText("101");
		empIDTextField.setBounds(191, 162, 84, 22);
		contentPane.add(empIDTextField);
		empIDTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Employee Name:");
		lblNewLabel.setBounds(12, 210, 115, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department:");
		lblNewLabel_1.setBounds(12, 253, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setBounds(12, 296, 115, 16);
		contentPane.add(lblNewLabel_2);
		
		empNameTextField = new JTextField();
		lblNewLabel.setLabelFor(empNameTextField);
		empNameTextField.setText("Sarah Jilk");
		empNameTextField.setBounds(191, 207, 129, 22);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		positionTextField = new JTextField();
		lblNewLabel_2.setLabelFor(positionTextField);
		positionTextField.setText("Engineer");
		positionTextField.setBounds(191, 293, 129, 22);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		JToggleButton noArgConstructorButton = new JToggleButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(12, 340, 115, 25);
		contentPane.add(noArgConstructorButton);
		
		JToggleButton twoArgConstructorButton = new JToggleButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(161, 340, 104, 25);
		contentPane.add(twoArgConstructorButton);
		
		JToggleButton fourArgConstructorButton = new JToggleButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(291, 340, 110, 25);
		contentPane.add(fourArgConstructorButton);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		lblNewLabel_1.setLabelFor(deptComboBox);
		deptComboBox.setBounds(191, 250, 162, 22);
		contentPane.add(deptComboBox);
	}
	
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		Employee emp = new Employee();
		employeeListModel.addElement(emp);
	}
	
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		int idNumber = Integer.parseInt(empIDTextField.getText());
		Employee emp = new Employee(idNumber, empNameTextField.getText());
		employeeListModel.addElement(emp);
	}
	
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		int idNumber = Integer.parseInt(empIDTextField.getText());
		String dept = (String) deptComboBox.getSelectedItem();
		Employee emp = new Employee(idNumber, empNameTextField.getText(), dept, positionTextField.getText());
		employeeListModel.addElement(emp);
	}
}
