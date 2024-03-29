package pLaptimesAssignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * @author Isaac Thomas
 * @date 1/6/2020 The LapGUI class contains all the parameters and methods
 *       related to the GUI that is displayed on the screen to the user. Here is
 *       where all the buttons, labels and other visual features and setup and
 *       defined.
 */
public class LapGUI extends JFrame implements ActionListener {

	/**
	 * declares all the fields needed to be used within methods in the GUI class
	 */
	private static ArrayList<Lap> laptimes;
	/**
	 * declares the table to be used on the table view
	 */
	private DefaultTableModel tm = new DefaultTableModel(new Object[][] {},
			new String[] { "Length", "Time", "Type", "Manufacturer", "Model", "Driver", "Date" });

	/**
	 * count is used to pick which record in record view to display.
	 */
	private int count = 0;

	private JPanel contentPane;
	private JTextPane tLength;
	private JTextPane tTime;
	private JTextPane tType;
	private JTextPane tMan;
	private JTextPane tModel;
	private JTextPane tAge;
	private JTextPane tTypeNum;
	private JTextPane tManNum;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblManPic;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextPane tDriver;
	private JTextPane tDate;
	private final ButtonGroup tableSortButtonGroup = new ButtonGroup();
	private JTextField tSearch;

	/**
	 * contructor for the GUI class, initilizes all the fields and objects on the
	 * GUI panel
	 */
	public LapGUI(ArrayList<Lap> laptimes) {
		super("Laptimes");
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.ico"));
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
		tabbedPane.setBounds(330, 20, 1130, 700);
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
		tableSortPanel.setBounds(58, 218, 204, 235);
		contentPane.add(tableSortPanel);
		/**
		 * when this radiobutton is clicked, the data will be sorted by track length,
		 * shortest to longest.
		 */
		JRadioButton rdbtnLength = new JRadioButton("Length");
		rdbtnLength.setBounds(6, 48, 131, 23);
		tableSortButtonGroup.add(rdbtnLength);
		rdbtnLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new LengthCompare());
				drawTable();
			}
		});
		tableSortPanel.setLayout(null);
		rdbtnLength.setToolTipText("Length");
		rdbtnLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnLength);
		/**
		 * when this radiobutton is clicked, the data will be sorted by vehicle Type
		 * alphabetically
		 */
		JRadioButton rdbtnType = new JRadioButton("Type");
		rdbtnType.setBounds(6, 100, 131, 23);
		tableSortButtonGroup.add(rdbtnType);
		rdbtnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new TypeCompare());
				drawTable();
			}
		});
		rdbtnType.setToolTipText("Type");
		rdbtnType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnType);
		/**
		 * when this radiobutton is clicked, the data will be sorted by record time,
		 * shortest to longest.
		 */
		JRadioButton rdbtnTime = new JRadioButton("Time");
		rdbtnTime.setBounds(6, 74, 131, 23);
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
		tableSortPanel.add(rdbtnTime);
		/**
		 * when this radiobutton is clicked, the data will be sorted alphabetically by
		 * Manufacturer
		 */
		JRadioButton rdbtnManufacturer = new JRadioButton("Manufacturer");
		rdbtnManufacturer.setBounds(6, 126, 131, 23);
		tableSortButtonGroup.add(rdbtnManufacturer);
		rdbtnManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new ManufacturerCompare());
				drawTable();
			}
		});
		rdbtnManufacturer.setToolTipText("Manufacturer");
		rdbtnManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnManufacturer);
		/**
		 * when this radiobutton is clicked, the data will be sorted by date, oldest to
		 * newest
		 */
		JRadioButton rdbtnDate = new JRadioButton("Date");
		rdbtnDate.setBounds(6, 204, 131, 23);
		tableSortButtonGroup.add(rdbtnDate);
		rdbtnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new DateCompare());
				drawTable();
			}
		});
		rdbtnDate.setToolTipText("Date");
		rdbtnDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnDate);
		/**
		 * when this radiobutton is clicked, the data will be sorted by car model
		 * alphabetically
		 */
		JRadioButton rdbtnModel = new JRadioButton("Model");
		rdbtnModel.setBounds(6, 152, 131, 23);
		tableSortButtonGroup.add(rdbtnModel);
		rdbtnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new ModelCompare());
				drawTable();
			}
		});
		rdbtnModel.setToolTipText("Model");
		rdbtnModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnModel);
		/**
		 * when this radiobutton is clicked, the data will be sorted alphabetically by
		 * Driver
		 */
		JRadioButton rdbtnDriver = new JRadioButton("Driver");
		rdbtnDriver.setBounds(6, 178, 131, 23);
		tableSortButtonGroup.add(rdbtnDriver);
		rdbtnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(laptimes, new DriverCompare());
				drawTable();
			}
		});
		rdbtnDriver.setToolTipText("Driver");
		rdbtnDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSortPanel.add(rdbtnDriver);

		JTextPane txtpnTableSortingOptions = new JTextPane();
		txtpnTableSortingOptions.setBounds(0, 0, 204, 41);
		txtpnTableSortingOptions.setBackground(Color.GRAY);
		txtpnTableSortingOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnTableSortingOptions.setText("Table Sorting Options");
		tableSortPanel.add(txtpnTableSortingOptions);

		JPanel logopanel = new JPanel();
		logopanel.setBounds(305, 113, -284, -99);
		contentPane.add(logopanel);
		/**
		 * loads the logo image in the top left of the GUI
		 */
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setIcon(new ImageIcon("image/logo.png"));
		lblLogo.setBounds(10, 23, 305, 196);
		lblLogo.setBounds(10, 11, 305, 196);
		contentPane.add(lblLogo);
		/**
		 * clicking this button will exit the program.
		 */
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
				;
			}
		});
		btnExit.setToolTipText("Exit the Application");
		btnExit.setBounds(1371, 731, 89, 23);
		contentPane.add(btnExit);
		/**
		 * Sorts the data by record time by default, draws the table, pie graph,
		 * timeline and recordview for the gui and execute calculations for record view
		 */
		Collections.sort(laptimes);
		drawTable();
		manufacturerPie();
		timeLine();
		recordView();
		execCalcs();
	}

	/**
	 * the drawTable method iterates through the dataset, loading each object per
	 * line to show the entire table on the GUI
	 */
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

	/**
	 * creates a pie graph based on the number of records per manufacturer
	 */
	public void manufacturerPie() {
		DefaultPieDataset data = new DefaultPieDataset();
		/**
		 * loops through the manufacturer enum, counting every occurance and storing the
		 * value in the dataset
		 */
		for (Manufacturer manufacturer : Manufacturer.values()) {
			int manCount = 0;
			for (int i = 0; i < laptimes.size(); i++) {
				if (manufacturer == laptimes.get(i).getManufacturer()) {
					manCount++;
				}
			}
			data.setValue(manufacturer, manCount);
		}
		/**
		 * creates the pie chart to be displayed on the gui
		 */
		JFreeChart chart = ChartFactory.createPieChart("Number of Laptimes by Manufacturer", data, true, true,
				Locale.ENGLISH);

		ChartPanel piepanel = new ChartPanel(chart);
		piepanel.setVisible(true);
		/**
		 * sets all the textpanes and labels for the recordview in the GUI
		 */
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
		tModel.setBounds(645, 24, 150, 40);
		panel_record.add(tModel);

		tDriver = new JTextPane();
		tDriver.setBounds(805, 24, 150, 25);
		panel_record.add(tDriver);

		tDate = new JTextPane();
		tDate.setBounds(965, 24, 150, 25);
		panel_record.add(tDate);

		tAge = new JTextPane();
		tAge.setToolTipText("Age of the Record");
		tAge.setBounds(965, 99, 150, 25);
		panel_record.add(tAge);

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

		/**
		 * When the previous button is clicked, the record view will go back one record.
		 * Then the recordview and calculations method will be re-executed.
		 */
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/**
				 * prevents error from count going outside of array bounds
				 */
				if (count == laptimes.size() - laptimes.size()) {
					count = count;
				} else {
					count--;
				}
				recordView();
				execCalcs();
			}
		});
		btnPrevious.setToolTipText("Previous");
		btnPrevious.setBounds(66, 133, 89, 23);
		panel_record.add(btnPrevious);
		/**
		 * When the first button is clicked, the record view will go to position 0 in
		 * the dataset. Then the recordview and calculations method will be re-executed.
		 */
		JButton btnFirst = new JButton("First");
		btnFirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				count = 0;
				recordView();
				execCalcs();
			}
		});
		btnFirst.setToolTipText("First");
		btnFirst.setBounds(66, 99, 89, 23);
		panel_record.add(btnFirst);
		/**
		 * When the next button is clicked, the record view will go back one record.
		 * Then the recordview and calculations method will be re-executed.
		 */
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/**
				 * prevents error from count going outside of array bounds
				 */
				if (count == laptimes.size() - 1) {
					count = count;
				} else {
					count++;
				}
				recordView();
				execCalcs();
			}
		});
		btnNext.setToolTipText("Next");
		btnNext.setBounds(165, 133, 89, 23);
		panel_record.add(btnNext);
		/**
		 * When the first button is clicked, the record view will go to the last
		 * position in the dataset (size - 1 as the first position is 0). Then the
		 * recordview and calculations method will be re-executed.
		 */
		JButton btnLast = new JButton("Last");
		btnLast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				count = laptimes.size() - 1;
				recordView();
				execCalcs();
			}
		});
		btnLast.setToolTipText("Last");
		btnLast.setBounds(165, 99, 89, 23);
		panel_record.add(btnLast);
		/**
		 * set textpanes and labels for calculations in record view
		 */
		tTypeNum = new JTextPane();
		tTypeNum.setToolTipText("Occurances of Type");
		tTypeNum.setText("Occurances");
		tTypeNum.setBounds(325, 99, 150, 25);
		panel_record.add(tTypeNum);

		tManNum = new JTextPane();
		tManNum.setToolTipText("Occurances of this Manufacturer");
		tManNum.setText("Ocurrances");
		tManNum.setBounds(485, 99, 150, 25);
		panel_record.add(tManNum);

		JLabel lblTypeNum = new JLabel("Occurances of Type");
		lblTypeNum.setToolTipText("Occurances of Type");
		lblTypeNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeNum.setForeground(Color.WHITE);
		lblTypeNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTypeNum.setBackground(Color.WHITE);
		lblTypeNum.setBounds(325, 68, 127, 32);
		panel_record.add(lblTypeNum);

		JLabel lblDateAge = new JLabel("Age of the Record");
		lblDateAge.setToolTipText("Age of this Record");
		lblDateAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateAge.setForeground(Color.WHITE);
		lblDateAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateAge.setBackground(Color.WHITE);
		lblDateAge.setBounds(965, 75, 150, 25);
		panel_record.add(lblDateAge);

		tSearch = new JTextField();
		tSearch.setBounds(325, 133, 211, 25);
		panel_record.add(tSearch);
		tSearch.setColumns(10);
		/**
		 * the search button, when clicked will execute the search result method as well
		 * as the calcualtion methods on the search result
		 */
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchResult();
				execCalcs();
			}
		});
		btnSearch.setToolTipText("Execute a Search");
		btnSearch.setBounds(546, 133, 89, 25);
		panel_record.add(btnSearch);

		lblManPic = new JLabel("ManPic");
		lblManPic.setToolTipText("Manufacturer Image");
		lblManPic.setBounds(343, 250, 400, 400);
		panel_record.add(lblManPic);

		JLabel lblOccurancesOfManufacturer = new JLabel("Occurances of Manufacturer");
		lblOccurancesOfManufacturer.setToolTipText("Occurances of Manufacturer");
		lblOccurancesOfManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
		lblOccurancesOfManufacturer.setForeground(Color.WHITE);
		lblOccurancesOfManufacturer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOccurancesOfManufacturer.setBackground(Color.WHITE);
		lblOccurancesOfManufacturer.setBounds(469, 68, 188, 32);
		panel_record.add(lblOccurancesOfManufacturer);

		// add to my Tabbed Panel
		tabbedPane.add("Manufacturer Graph", piepanel);
	}

	/**
	 * the search result method ingests a term from the tSearch text box and runs
	 * through each property of the laptimes collection to find if there are any
	 * records that contain that search result, then displays the record with the
	 * appropriate calculations.
	 */
	private void searchResult() {
		int i;
		for (i = 0; i < laptimes.size(); i++) {
			if (laptimes.get(i).getLength().contains(tSearch.getText())) {
				Collections.sort(laptimes, new LengthCompare());
				count = i;
			}
			if (laptimes.get(i).getTime().contains(tSearch.getText())) {
				Collections.sort(laptimes);
				count = i;
			}
			if (laptimes.get(i).getType().toString().contains(tSearch.getText())) {
				Collections.sort(laptimes, new TypeCompare());
				count = i;
			}
			if (laptimes.get(i).getManufacturer().toString().contains(tSearch.getText())) {
				Collections.sort(laptimes, new ManufacturerCompare());
				count = i;
			}
			if (laptimes.get(i).getModel().contains(tSearch.getText())) {
				Collections.sort(laptimes, new ModelCompare());
				count = i;
			}
			if (laptimes.get(i).getDriver().contains(tSearch.getText())) {
				Collections.sort(laptimes, new DriverCompare());
				count = i;
			}
			if (laptimes.get(i).getDate().toString().contains(tSearch.getText())) {
				Collections.sort(laptimes, new DateCompare());

				count = i;
			}
			recordView();
			execCalcs();
		}
	}

	/**
	 * the recordview method sets every textbox in the record panel to show the
	 * correct listing based on the count value. it also shows an associated
	 * manufacturer image stored in the image folder based on the string in the
	 * manufacturer enum.
	 */
	private void recordView() {
		tLength.setText(laptimes.get(count).getLength());
		tTime.setText(laptimes.get(count).getTime());
		tType.setText(laptimes.get(count).getType().toString());
		tMan.setText(laptimes.get(count).getManufacturer().toString());
		tModel.setText(laptimes.get(count).getModel());
		tDriver.setText(laptimes.get(count).getDriver());
		tDate.setText(laptimes.get(count).getDate().toString());

		lblManPic.setIcon(new ImageIcon("image/" + laptimes.get(count).getManufacturer().toString() + ".png"));
	}

	/**
	 * the execcalc method sends variables from the related textboxes through to the
	 * laputilities class to make calculations based on the data shown in the record
	 * view, after these calculations are made it is then sent back and displayed in
	 * the appropriate text boxes on the GUI.
	 */
	private void execCalcs() {
		tAge.setText(LapUtilities.calcAge(laptimes, laptimes.get(count).getDate()));
		tTypeNum.setText(LapUtilities.calcType(laptimes, laptimes.get(count).getType()));
		tManNum.setText(LapUtilities.calcManufacturer(laptimes, laptimes.get(count).getManufacturer()));
	}

	/**
	 * creates a timeline graph based on the amount of records set per year, uses
	 * the year value from the laptimes data and counts it against occurances to
	 * plot on a graph.
	 */
	private void timeLine() {
		XYSeries data = new XYSeries("Times by Year Set");
		// category data
		for (int year = 1935; year < 2021; year++) {
			int yearCount = 0;
			for (int i = 0; i < laptimes.size(); i++) {
				if (year == laptimes.get(i).getDate().getYear()) {
					yearCount++;
				}
			}
			data.add(year, yearCount);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(data);

		// create the chart
		JFreeChart chart = ChartFactory.createXYLineChart("Times by Year Set", "Number of Times", "Year", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		XYPlot plot = chart.getXYPlot();

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
