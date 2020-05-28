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
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class LapGUI extends JFrame implements ActionListener {

	//data fields
	private static ArrayList<Lap>laptimes;
//	private JButton bNext = new JButton("Next");
//	private JButton bPrev = new JButton("Previous");
//	private JLabel lLength = new JLabel("Length");
//	private JLabel lTime = new JLabel("Time");
//	private JLabel lType = new JLabel("Type");
//	private JLabel lManufacturer = new JLabel("Manufacturer");
//	private JLabel lModel = new JLabel("Model");
//	private JLabel lDriver = new JLabel("Driver");
//	private JLabel lDate = new JLabel("Date");
//	private JTextField tLength = new JTextField(20);
//	private JTextField tTime = new JTextField(20);
//	private JTextField tType = new JTextField(20);
//	private JTextField tManufacturer = new JTextField(20);
//	private JTextField tModel = new JTextField(20);
//	private JTextField tDriver = new JTextField(20);
//	private JTextField tDate = new JTextField(20);
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Length", "Time", "Type", "Manufacturer", "Model", "Driver", "Date"
			}
		);
	
//	private int count=0;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JScrollPane scrollPane;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_5;
	private JTextField textField_6;
	
	//constructor
	public LapGUI(ArrayList<Lap>laptimes) {
		super("Laptimes");
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.ico"));
		setTitle("Nurburgring Laptimes");
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
		panel.setBounds(64, 250, 201, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnLength = new JRadioButton("Length");
		buttonGroup.add(rdbtnLength);
		rdbtnLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new LengthCompare());
				drawTable(); 
			}
		});
		rdbtnLength.setToolTipText("Length");
		rdbtnLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLength.setBounds(31, 48, 131, 23);
		panel.add(rdbtnLength);
		
		JRadioButton rdbtnType = new JRadioButton("Type");
		buttonGroup.add(rdbtnType);
		rdbtnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new TypeCompare());
				drawTable();
			}
		});
		rdbtnType.setToolTipText("Type");
		rdbtnType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnType.setBounds(31, 99, 131, 23);
		panel.add(rdbtnType);
		
		JRadioButton rdbtnTime = new JRadioButton("Time");
		buttonGroup.add(rdbtnTime);
		rdbtnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes);
				drawTable();
			}
		});
		rdbtnTime.setSelected(true);
		rdbtnTime.setToolTipText("Time");
		rdbtnTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTime.setBounds(31, 73, 131, 23);
		panel.add(rdbtnTime);
		
		JRadioButton rdbtnManufacturer = new JRadioButton("Manufacturer");
		buttonGroup.add(rdbtnManufacturer);
		rdbtnManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new ManufacturerCompare());
				drawTable();
			}
		});
		rdbtnManufacturer.setToolTipText("Manufacturer");
		rdbtnManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnManufacturer.setBounds(31, 125, 131, 23);
		panel.add(rdbtnManufacturer);
		
		JRadioButton rdbtnDate = new JRadioButton("Date");
		buttonGroup.add(rdbtnDate);
		rdbtnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new DateCompare());
				drawTable();
			}
		});
		rdbtnDate.setToolTipText("Date");
		rdbtnDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDate.setBounds(31, 203, 131, 23);
		panel.add(rdbtnDate);
		
		JRadioButton rdbtnModel = new JRadioButton("Model");
		buttonGroup.add(rdbtnModel);
		rdbtnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new ModelCompare());
				drawTable();
			}
		});
		rdbtnModel.setToolTipText("Model");
		rdbtnModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnModel.setBounds(31, 151, 131, 23);
		panel.add(rdbtnModel);
		
		JRadioButton rdbtnDriver = new JRadioButton("Driver");
		buttonGroup.add(rdbtnDriver);
		rdbtnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes,new DriverCompare());
				drawTable();
			}
		});
		rdbtnDriver.setToolTipText("Driver");
		rdbtnDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDriver.setBounds(31, 177, 131, 23);
		panel.add(rdbtnDriver);
		
		JTextPane txtpnTableSortingOptions = new JTextPane();
		txtpnTableSortingOptions.setBounds(new Rectangle(10, 10, 0, 0));
		txtpnTableSortingOptions.setBackground(Color.GRAY);
		txtpnTableSortingOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnTableSortingOptions.setText("Table Sorting Options");
		txtpnTableSortingOptions.setBounds(0, 0, 204, 41);
		panel.add(txtpnTableSortingOptions);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(305, 113, -284, -99);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Logo");
		lblNewLabel.setIcon(new ImageIcon("logo.png"));
		lblNewLabel.setBounds(10, 23, 305, 196);
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
		
		JPanel panel_record = new JPanel();
		panel_record.setToolTipText("Record View");
		panel_record.setBackground(Color.GRAY);
		tabbedPane.addTab("Record View", null, panel_record, "Record View");
		panel_record.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 24, 150, 25);
		panel_record.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 24, 150, 25);
		panel_record.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 24, 150, 25);
		panel_record.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(485, 24, 150, 25);
		panel_record.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(645, 24, 150, 25);
		panel_record.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(805, 24, 150, 25);
		panel_record.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(965, 24, 150, 25);
		panel_record.add(textField_6);
		textField_6.setColumns(10);
		
		textField.setText(laptimes.get(1).getLength());
		textField_1.setText(laptimes.get(1).getTime());
		textField_2.setText(laptimes.get(1).getType().toString());
		textField_3.setText(laptimes.get(1).getManufacturer().toString());
		textField_4.setText(laptimes.get(1).getModel());
		textField_5.setText(laptimes.get(1).getDriver());
		textField_6.setText(laptimes.get(1).getDate().toString());
		
		JLabel lblNewLabel_1 = new JLabel("Length");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setToolTipText("Length");
		lblNewLabel_1.setBounds(5, 0, 150, 25);
		panel_record.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setToolTipText("Time");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(165, 0, 150, 25);
		panel_record.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setToolTipText("Type");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(325, 0, 150, 25);
		panel_record.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Manufacturer");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setToolTipText("Manufacturer");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(485, 0, 150, 25);
		panel_record.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Date");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setToolTipText("Date");
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(965, 0, 150, 25);
		panel_record.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Driver");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setToolTipText("Driver");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(805, 0, 150, 25);
		panel_record.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Model");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setToolTipText("Model");
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(646, 0, 149, 25);
		panel_record.add(lblNewLabel_5);
		
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
