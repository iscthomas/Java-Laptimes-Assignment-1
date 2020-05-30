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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LapGUI extends JFrame implements ActionListener {

	// data fields
	private static ArrayList<Lap> laptimes;
	private DefaultTableModel tm = new DefaultTableModel(new Object[][] {},
			new String[] { "Length", "Time", "Type", "Manufacturer", "Model", "Driver", "Date" });

	// count is used to pick which record in record view to display.
	private int count = 0;

	private JPanel contentPane;
	private JTextPane tLength;
	private JTextPane tTime;
	private JTextPane tType;
	private JTextPane tMan;
	private JTextPane tModel;
	private JTable table;
	private JScrollPane scrollPane;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextPane tDriver;
	private JTextPane tDate;
	private JPanel panel_1;
	private final ButtonGroup tableSortButtonGroup = new ButtonGroup();

	// constructor
	public LapGUI(ArrayList<Lap> laptimes) {
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

		JPanel tableSortPanel = new JPanel();
		tableSortPanel.setToolTipText("tableSortPanel");
		tableSortPanel.setBackground(Color.LIGHT_GRAY);
		tableSortPanel.setBounds(15, 218, 205, 235);
		tableSortPanel.setBounds(15, 218, 300, 235);
		contentPane.add(tableSortPanel);
		tableSortPanel.setLayout(null);

		JRadioButton rdbtnLength = new JRadioButton("Length");
		tableSortButtonGroup.add(rdbtnLength);
		rdbtnLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new LengthCompare());
				drawTable();
			}
		});
		rdbtnLength.setToolTipText("Length");
		rdbtnLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLength.setBounds(39, 48, 131, 23);
		rdbtnLength.setBounds(6, 49, 131, 23);
		tableSortPanel.add(rdbtnLength);

		JRadioButton rdbtnType = new JRadioButton("Type");
		tableSortButtonGroup.add(rdbtnType);
		rdbtnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new TypeCompare());
				drawTable();
			}
		});
		rdbtnType.setToolTipText("Type");
		rdbtnType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnType.setBounds(39, 99, 131, 23);
		rdbtnType.setBounds(6, 100, 131, 23);
		tableSortPanel.add(rdbtnType);

		JRadioButton rdbtnTime = new JRadioButton("Time");
		tableSortButtonGroup.add(rdbtnTime);
		rdbtnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes);
				drawTable();
			}
		});
		rdbtnTime.setSelected(true);
		rdbtnTime.setToolTipText("Time");
		rdbtnTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTime.setBounds(39, 73, 131, 23);
		rdbtnTime.setBounds(6, 74, 131, 23);
		tableSortPanel.add(rdbtnTime);

		JRadioButton rdbtnManufacturer = new JRadioButton("Manufacturer");
		tableSortButtonGroup.add(rdbtnManufacturer);
		rdbtnManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new ManufacturerCompare());
				drawTable();
			}
		});
		rdbtnManufacturer.setToolTipText("Manufacturer");
		rdbtnManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnManufacturer.setBounds(39, 125, 131, 23);
		rdbtnManufacturer.setBounds(6, 126, 131, 23);
		tableSortPanel.add(rdbtnManufacturer);

		JRadioButton rdbtnDate = new JRadioButton("Date");
		tableSortButtonGroup.add(rdbtnDate);
		rdbtnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new DateCompare());
				drawTable();
			}
		});
		rdbtnDate.setToolTipText("Date");
		rdbtnDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDate.setBounds(39, 203, 131, 23);
		rdbtnDate.setBounds(6, 204, 131, 23);
		tableSortPanel.add(rdbtnDate);

		JRadioButton rdbtnModel = new JRadioButton("Model");
		tableSortButtonGroup.add(rdbtnModel);
		rdbtnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new ModelCompare());
				drawTable();
			}
		});
		rdbtnModel.setToolTipText("Model");
		rdbtnModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnModel.setBounds(39, 151, 131, 23);
		rdbtnModel.setBounds(6, 152, 131, 23);
		tableSortPanel.add(rdbtnModel);

		JRadioButton rdbtnDriver = new JRadioButton("Driver");
		tableSortButtonGroup.add(rdbtnDriver);
		rdbtnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new DriverCompare());
				drawTable();
			}
		});
		rdbtnDriver.setToolTipText("Driver");
		rdbtnDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDriver.setBounds(39, 177, 131, 23);
		rdbtnDriver.setBounds(6, 178, 131, 23);
		tableSortPanel.add(rdbtnDriver);

		JTextPane txtpnTableSortingOptions = new JTextPane();
		txtpnTableSortingOptions.setBounds(new Rectangle(10, 10, 0, 0));
		txtpnTableSortingOptions.setBackground(Color.GRAY);
		txtpnTableSortingOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnTableSortingOptions.setText("Table Sorting Options");
		txtpnTableSortingOptions.setBounds(0, 0, 204, 41);
		tableSortPanel.add(txtpnTableSortingOptions);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(15, 544, 300, 186);
		contentPane.add(panel_1);

		JPanel logopanel = new JPanel();
		logopanel.setBounds(305, 113, -284, -99);
		contentPane.add(logopanel);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setIcon(new ImageIcon("logo.png"));
		lblLogo.setBounds(10, 23, 305, 196);
		lblLogo.setBounds(10, 11, 305, 196);
		contentPane.add(lblLogo);
		Collections.sort(laptimes);
		drawTable();
		manufacturerPie();
		timeLine();
		recordView();
	}

	public void drawTable() {
		tm.setRowCount(0);
		for (int i = 0; i < laptimes.size(); i++) {
			Object[] object = new Object[7];
			object[0] = laptimes.get(i).getLength();
			object[1] = laptimes.get(i).getTime();
			object[2] = laptimes.get(i).getType();
			object[3] = laptimes.get(i).getManufacturer();
			object[4] = laptimes.get(i).getModel();
			object[5] = laptimes.get(i).getDriver();
			object[6] = laptimes.get(i).getDate();
			tm.addRow(object);
		}
	}

	public void manufacturerPie() {
		DefaultPieDataset data = new DefaultPieDataset();
		// category data
		for (Manufacturer manufacturer : Manufacturer.values()) {
			int manCount = 0;
			for (int i = 0; i < laptimes.size(); i++) {
				if (manufacturer == laptimes.get(i).getManufacturer()) {
					manCount++;
				}
			}
			// int manCount = Collections.frequency(laptimes, manufacturer);
			data.setValue(manufacturer, manCount);
		}
		// create the chart
		JFreeChart chart = ChartFactory.createPieChart("Number of Laptimes by Manufacturer", data, true, true,
				Locale.ENGLISH);

		// create and display a frame
		ChartPanel piepanel = new ChartPanel(chart);
		piepanel.setVisible(true);

		JPanel panel_record = new JPanel();
		panel_record.setToolTipText("Record View");
		panel_record.setBackground(Color.GRAY);
		tabbedPane.addTab("Record View", null, panel_record, "Record View");
		panel_record.setLayout(null);

		tLength = new JTextPane();
		tLength.setBounds(5, 24, 150, 25);
		panel_record.add(tLength);

		tTime = new JTextPane();
		tTime.setBounds(165, 24, 150, 25);
		panel_record.add(tTime);

		tType = new JTextPane();
		tType.setBounds(325, 24, 150, 25);
		panel_record.add(tType);

		tMan = new JTextPane();
		tMan.setBounds(485, 24, 150, 25);
		panel_record.add(tMan);

		tModel = new JTextPane();
		tModel.setBounds(645, 24, 150, 25);
		panel_record.add(tModel);

		tDriver = new JTextPane();
		tDriver.setBounds(805, 24, 150, 25);
		panel_record.add(tDriver);

		tDate = new JTextPane();
		tDate.setBounds(965, 24, 150, 25);
		panel_record.add(tDate);

		JLabel lblLength = new JLabel("Length");
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLength.setForeground(Color.WHITE);
		lblLength.setBackground(Color.WHITE);
		lblLength.setToolTipText("Length");
		lblLength.setBounds(5, 0, 150, 25);
		panel_record.add(lblLength);

		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTime.setForeground(Color.WHITE);
		lblTime.setToolTipText("Time");
		lblTime.setBackground(Color.WHITE);
		lblTime.setBounds(165, 0, 150, 25);
		panel_record.add(lblTime);

		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblType.setForeground(Color.WHITE);
		lblType.setToolTipText("Type");
		lblType.setBackground(Color.WHITE);
		lblType.setBounds(325, 0, 150, 25);
		panel_record.add(lblType);

		JLabel lblMan = new JLabel("Manufacturer");
		lblMan.setHorizontalAlignment(SwingConstants.CENTER);
		lblMan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMan.setForeground(Color.WHITE);
		lblMan.setToolTipText("Manufacturer");
		lblMan.setBackground(Color.WHITE);
		lblMan.setBounds(485, 0, 150, 25);
		panel_record.add(lblMan);

		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setForeground(Color.WHITE);
		lblDate.setToolTipText("Date");
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(965, 0, 150, 25);
		panel_record.add(lblDate);

		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriver.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDriver.setForeground(Color.WHITE);
		lblDriver.setToolTipText("Driver");
		lblDriver.setBackground(Color.WHITE);
		lblDriver.setBounds(805, 0, 150, 25);
		panel_record.add(lblDriver);

		JLabel lblModel = new JLabel("Model");
		lblModel.setHorizontalAlignment(SwingConstants.CENTER);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModel.setForeground(Color.WHITE);
		lblModel.setToolTipText("Model");
		lblModel.setBackground(Color.WHITE);
		lblModel.setBounds(646, 0, 149, 25);
		panel_record.add(lblModel);
		
		//Buttons for Record View

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (count == laptimes.size()-laptimes.size()) {
					count = count; //prevents error from count going outside of array total
				}
				else {
				count--;
				}
				recordView();
			}
		});
		btnPrevious.setToolTipText("Previous");
		btnPrevious.setBounds(66, 133, 89, 23);
		panel_record.add(btnPrevious);

		JButton btnFirst = new JButton("First");
		btnFirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				count = 0;
				recordView();
			}
		});
		btnFirst.setToolTipText("First");
		btnFirst.setBounds(66, 99, 89, 23);
		panel_record.add(btnFirst);

		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (count == laptimes.size()-1) {
					count = count; //prevents error from count going outside of array total
				}
				else {
				count++;
				}
				recordView();
			}
		});
		btnNext.setToolTipText("Next");
		btnNext.setBounds(165, 133, 89, 23);
		panel_record.add(btnNext);

		JButton btnLast = new JButton("Last");
		btnLast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				count = laptimes.size()-1;
				recordView();
			}
		});
		btnLast.setToolTipText("Last");
		btnLast.setBounds(165, 99, 89, 23);
		panel_record.add(btnLast);

		// add to my Tabbed Panel
		tabbedPane.add("Manufacturer Graph", piepanel);
	}
	
	//set data to be displayed in record view
	private void recordView() { 
		tLength.setText(laptimes.get(count).getLength());
		tTime.setText(laptimes.get(count).getTime());
		tType.setText(laptimes.get(count).getType().toString());
		tMan.setText(laptimes.get(count).getManufacturer().toString());
		tModel.setText(laptimes.get(count).getModel());
		tDriver.setText(laptimes.get(count).getDriver());
		tDate.setText(laptimes.get(count).getDate().toString());
	}
	
	//create timeline graph
	private void timeLine() {
		XYSeries data = new XYSeries("Times by Year Set");
		// category data
		for (int year = 1930; year < 2021; year++) {
			int yearCount = 0;
			for (int i = 0; i < laptimes.size(); i++) {
				if (year == laptimes.get(i).getDate().getYear()) {
					yearCount++;
				}
			}
			// System.out.println(yearCount);
			data.add(yearCount, year);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(data);

		// create the chart
		JFreeChart chart = ChartFactory.createXYLineChart("Times by Year Set", "Number of Times", "Year", dataset,
				PlotOrientation.HORIZONTAL, true, true, true);
		XYPlot plot = chart.getXYPlot();

		// y axis
		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		domain.setRange(0, 50);
		domain.setTickUnit(new NumberTickUnit(5));
		domain.setVerticalTickLabels(true);
		// x axis
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		range.setRange(1930, 2020);
		range.setTickUnit(new NumberTickUnit(10));

		// create and display a frame
		ChartPanel linepanel = new ChartPanel(chart);
		linepanel.setVisible(true);

		// add to my Tabbed Panel
		tabbedPane.add("Times Graph", linepanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
