package pLaptimesAssignment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

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
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panel_1;
	
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(15, 218, 300, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Length");
		rdbtnNewRadioButton_1.setToolTipText("Length");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(6, 48, 131, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Type");
		rdbtnNewRadioButton.setToolTipText("Type");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(6, 100, 131, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Time");
		rdbtnNewRadioButton_2.setToolTipText("Time");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_2.setBounds(6, 74, 131, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Manufacturer");
		rdbtnNewRadioButton_3.setToolTipText("Manufacturer");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_3.setBounds(6, 126, 131, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnTime = new JRadioButton("Time");
		rdbtnTime.setToolTipText("Time");
		rdbtnTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTime.setBounds(151, 100, 131, 23);
		panel.add(rdbtnTime);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Model");
		rdbtnNewRadioButton_1_1.setToolTipText("Model");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1_1.setBounds(151, 48, 131, 23);
		panel.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Driver");
		rdbtnNewRadioButton_2_1.setToolTipText("Driver");
		rdbtnNewRadioButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_2_1.setBounds(151, 74, 131, 23);
		panel.add(rdbtnNewRadioButton_2_1);
		
		JTextPane txtpnTableSortingOptions = new JTextPane();
		txtpnTableSortingOptions.setBounds(new Rectangle(10, 10, 0, 0));
		txtpnTableSortingOptions.setBackground(Color.GRAY);
		txtpnTableSortingOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnTableSortingOptions.setText("Table Sorting Options");
		txtpnTableSortingOptions.setBounds(0, 0, 300, 41);
		panel.add(txtpnTableSortingOptions);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(15, 393, 300, 186);
		contentPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(305, 113, -284, -99);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\OneDrive\\OneDrive - Otago Polytechnic\\BITY2\\IN610001 Programming 3\\Laptimes Assignment\\Java-Laptimes-Assignment-1\\image\\logo.png"));
		lblNewLabel.setBounds(10, 11, 305, 196);
		contentPane.add(lblNewLabel);
		drawTable();
		manufacturerPie();
		timeLine();
	}
	
	public void drawTable() {
		tm.setRowCount(0);
		for (int i = 0; i < 511; i++) {
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
	
	public void manufacturerPie() {
		DefaultPieDataset data = new DefaultPieDataset();
		//category data
		for (Manufacturer manufacturer : Manufacturer.values()) {
			int manCount = 0;
			for (int i = 0; i < 511; i++) {
				if (manufacturer == laptimes.get(i).getManufacturer()) {
					manCount++;
				}
			}
			//int manCount = Collections.frequency(laptimes, manufacturer);
			data.setValue(manufacturer, manCount);
		}
		//create the chart
		JFreeChart chart = ChartFactory.createPieChart("Number of Laptimes by Manufacturer", data, true, true, Locale.ENGLISH);
		
		//create and display a frame
		ChartPanel piepanel = new ChartPanel(chart);
		piepanel.setVisible(true);
		
		//add to my Tabbed Panel
		tabbedPane.add("Manufacturer Graph", piepanel);
	}
	
	private void timeLine() {
		XYSeries data = new XYSeries("Times by Year Set");
		//category data
		for (int year = 1930; year < 2021; year++) {
			int yearCount = 0;
			for (int i = 0; i < 511; i++) {
				if (year == laptimes.get(i).getDate().getYear()) {
					yearCount++;
				}
			}
			//System.out.println(yearCount);
			data.add(yearCount, year);
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(data);
		
		//create the chart
		JFreeChart chart = ChartFactory.createXYLineChart("Times by Year Set", "Number of Times", "Year", dataset, PlotOrientation.HORIZONTAL, true, true, true);
		XYPlot plot = chart.getXYPlot();
		
		//y axis
		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		domain.setRange(0, 50);
		domain.setTickUnit(new NumberTickUnit(5));
		domain.setVerticalTickLabels(true);
		//x axis
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		range.setRange(1930, 2020);
		range.setTickUnit(new NumberTickUnit(10));
		
		//create and display a frame
		ChartPanel linepanel = new ChartPanel(chart);
		linepanel.setVisible(true);
		
		//add to my Tabbed Panel
		tabbedPane.add("Times Graph", linepanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
