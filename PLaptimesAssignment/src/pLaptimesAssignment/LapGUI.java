package pLaptimesAssignment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;

public class LapGUI extends JFrame implements ActionListener {

	//data fields
	private static ArrayList<Lap>laptimes;
	private JButton bNext = new JButton("Next");
	private JButton bPrev = new JButton("Previous");
	private JLabel lLength = new JLabel("Length");
	private JLabel lTime = new JLabel("Time");
	private JLabel lType = new JLabel("Type");
	private JLabel lManufacturer = new JLabel("Manufacturer");
	private JLabel lModel = new JLabel("Model");
	private JLabel lDriver = new JLabel("Driver");
	private JLabel lDate = new JLabel("Date");
	private JTextField tLength = new JTextField(20);
	private JTextField tTime = new JTextField(20);
	private JTextField tType = new JTextField(20);
	private JTextField tManufacturer = new JTextField(20);
	private JTextField tModel = new JTextField(20);
	private JTextField tDriver = new JTextField(20);
	private JTextField tDate = new JTextField(20);
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Length", "Time", "Type", "Manufacturer", "Model", "Driver", "Date"
			}
		);
	
	private int count=0;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JScrollPane scrollPane;
	
	//constructor
	public LapGUI(ArrayList<Lap>laptimes) {
		super("Laptimes");
		setBackground(Color.WHITE);
		
		this.laptimes = laptimes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(330, 30, 1130, 700);
		contentPane.add(tabbedPane);
		
		JPanel panel_record = new JPanel();
		panel_record.setToolTipText("Record View");
		panel_record.setBackground(Color.GRAY);
		tabbedPane.addTab("Record View", null, panel_record, "Record View");
		panel_record.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		panel_record.add(textField);
		textField.setColumns(10);
		
		JPanel panel_graph = new JPanel();
		panel_graph.setToolTipText("Graph");
		panel_graph.setBackground(Color.GRAY);
		tabbedPane.addTab("Graph", null, panel_graph, "Graph");
		panel_graph.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 11, 86, 20);
		panel_record.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 11, 86, 20);
		panel_record.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(298, 11, 86, 20);
		panel_record.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(394, 11, 86, 20);
		panel_record.add(textField_4);
		textField_4.setColumns(10);
		
		textField.setText(laptimes.get(0).getLength());
		textField_1.setText(laptimes.get(0).getTime());
		//textField_2.setText(laptimes.get(0).getType());
		//textField_3.setText(laptimes.get(0).getManufacturer());
		textField_4.setText(laptimes.get(0).getModel());
		
		JPanel panel_table = new JPanel();
		panel_table.setToolTipText("Table");
		panel_table.setBackground(Color.GRAY);
		tabbedPane.addTab("Table", null, panel_table, "Table");
		panel_table.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1075, 650);
		panel_table.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setModel(tm);
		scrollPane.setViewportView(table);
		drawTable();
	}
	
	public void drawTable() {
		tm.setRowCount(0);
		for (int i = 0; i < 531; i++) {
			Object[] object = new Object[7];
			object[0]= laptimes.get(i).getLength();
			object[1]= laptimes.get(i).getTime();
			object[2]= laptimes.get(i).getType();
			object[3]= laptimes.get(i).getManufacturer();
			object[4]= laptimes.get(i).getModel();
			object[5]= laptimes.get(i).getDriver();
			object[6]= laptimes.get(i).getDate();
			tm.addRow(object);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
