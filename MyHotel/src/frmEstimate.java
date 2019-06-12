import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class frmEstimate extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grpNights = new ButtonGroup();
	private JTextField txtExchangeRate;
	private JTextField txtCostPerNight1;
	private JTextField txtCostPerNight2;
	private JTextField txtCostPerNight3;
	private JTextField txtCostPerNight4;
	private final ButtonGroup grpRoom = new ButtonGroup();
	private JButton btnGo = new JButton("GO");
	private JTextField txtCostExVatGBP;
	private JTextField txtCostInclVatGBP;
	private JTextField txtCostExVatEuro;
	private JTextField txtCostInclVatEuro;
	private JTextField txtInfo;
	JLabel lblHotelBooking = new JLabel("Hotel Booking");
	JRadioButton rdbtnSingle = new JRadioButton("Single");
	JRadioButton rdbtnDouble = new JRadioButton("Double");
	JLabel lblRoom = new JLabel("Room");
	JPanel panel_1 = new JPanel();
	JLabel lblCostExcludingVat = new JLabel("Cost Excluding Vat");
	JLabel lblCostIncludingVat = new JLabel("Cost Including Vat");
	JLabel lblGbp = new JLabel("GBP");
	JLabel lblGbp_1 = new JLabel("GBP");
	JLabel lblEuro = new JLabel("Euro");
	JLabel lblEuro_1 = new JLabel("Euro");
	JLabel lblNights = new JLabel("Nights");
	JLabel lblExchangeRate = new JLabel("Exchange Rate \u00A31");
	JLabel lblEuros = new JLabel("Euro's");
	JLabel lblCostPerNight = new JLabel("Cost Per Night");
	private JButton btnClear = new JButton("Clear");
	private JButton btnCalculate = new JButton("Calculate");

	boolean isDoubleRoom = false;
	double totalExVatGBP;
	double totalExVatEuros;
	double totalInclVatGBP;
	double totalInclVatEuros;
	double exchangeRate;
	private final JMenuBar menuBar = new JMenuBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEstimate frame = new frmEstimate();
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
	public frmEstimate() {
		setResizable(false);
		setTitle("Hotel Estimate\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 561);

		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedOption = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to exit the program", "Choose",
						JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					System.exit(0); //Exits the program
				}
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblHotelBooking.setForeground(Color.RED);
		lblHotelBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelBooking.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHotelBooking.setBounds(315, 52, 169, 39);
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(657, 467, 89, 23);
		contentPane.add(btnExit);
		rdbtnSingle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setBackground(Color.yellow);
				txtInfo.setText("");
				txtCostExVatGBP.setText("");
				txtCostExVatEuro.setText("");
				txtCostInclVatGBP.setText("");
				txtCostInclVatEuro.setText("");
			}
		});

		rdbtnSingle.setVisible(false);
		grpRoom.add(rdbtnSingle);
		rdbtnSingle.setBounds(557, 219, 109, 23);
		contentPane.add(rdbtnSingle);
		grpRoom.add(rdbtnDouble);
		rdbtnDouble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setBackground(Color.yellow);
				txtInfo.setText("");
				txtCostExVatGBP.setText("");
				txtCostExVatEuro.setText("");
				txtCostInclVatGBP.setText("");
				txtCostInclVatEuro.setText("");
			}
		});

		rdbtnDouble.setVisible(false);
		rdbtnDouble.setBounds(557, 250, 109, 23);
		contentPane.add(rdbtnDouble);

		lblRoom.setVisible(false);
		lblRoom.setBounds(559, 193, 46, 14);
		contentPane.add(lblRoom);

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(544, 199, 144, 95);
		contentPane.add(panel_1);

		lblCostExcludingVat.setVisible(false);
		lblCostExcludingVat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostExcludingVat.setBounds(115, 371, 128, 14);
		contentPane.add(lblCostExcludingVat);

		lblCostIncludingVat.setVisible(false);
		lblCostIncludingVat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostIncludingVat.setBounds(115, 415, 128, 14);
		contentPane.add(lblCostIncludingVat);

		txtCostExVatGBP = new JTextField();
		txtCostExVatGBP.setEditable(false);
		txtCostExVatGBP.setVisible(false);
		txtCostExVatGBP.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostExVatGBP.setBounds(262, 368, 86, 20);
		contentPane.add(txtCostExVatGBP);
		txtCostExVatGBP.setColumns(10);

		txtCostInclVatGBP = new JTextField();
		txtCostInclVatGBP.setEditable(false);
		txtCostInclVatGBP.setVisible(false);
		txtCostInclVatGBP.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostInclVatGBP.setBounds(262, 412, 86, 20);
		contentPane.add(txtCostInclVatGBP);
		txtCostInclVatGBP.setColumns(10);

		lblGbp.setVisible(false);
		lblGbp.setBounds(358, 371, 46, 14);
		contentPane.add(lblGbp);

		lblGbp_1.setVisible(false);
		lblGbp_1.setBounds(358, 415, 46, 14);
		contentPane.add(lblGbp_1);

		txtCostExVatEuro = new JTextField();
		txtCostExVatEuro.setEditable(false);
		txtCostExVatEuro.setVisible(false);
		txtCostExVatEuro.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostExVatEuro.setBounds(426, 368, 86, 20);
		contentPane.add(txtCostExVatEuro);
		txtCostExVatEuro.setColumns(10);

		txtCostInclVatEuro = new JTextField();
		txtCostInclVatEuro.setEditable(false);
		txtCostInclVatEuro.setVisible(false);
		txtCostInclVatEuro.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostInclVatEuro.setBounds(426, 412, 86, 20);
		contentPane.add(txtCostInclVatEuro);
		txtCostInclVatEuro.setColumns(10);

		lblEuro.setVisible(false);
		lblEuro.setBounds(522, 371, 46, 14);
		contentPane.add(lblEuro);

		lblEuro_1.setVisible(false);
		lblEuro_1.setBounds(522, 415, 46, 14);
		contentPane.add(lblEuro_1);

		btnCalculate.setVisible(false);
		btnCalculate.setBounds(599, 367, 89, 23);
		contentPane.add(btnCalculate);

		btnClear.setVisible(false);
		btnClear.setBounds(599, 411, 89, 23);
		contentPane.add(btnClear);
		contentPane.add(lblHotelBooking);

		JRadioButton rdbtn1Night = new JRadioButton("1 Night");
		rdbtn1Night.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDisplay(false);
				lblHotelBooking.setForeground(Color.red);
			}
		});
		grpNights.add(rdbtn1Night);
		rdbtn1Night.setBounds(54, 219, 109, 23);
		contentPane.add(rdbtn1Night);

		JRadioButton rdbtn2Nights = new JRadioButton("2 Nights");
		rdbtn2Nights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDisplay(false);
				lblHotelBooking.setForeground(Color.red);
			}
		});
		grpNights.add(rdbtn2Nights);
		rdbtn2Nights.setBounds(54, 245, 109, 23);
		contentPane.add(rdbtn2Nights);

		JRadioButton rdbtn3Nights = new JRadioButton("3 Nights");
		rdbtn3Nights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDisplay(false);
				lblHotelBooking.setForeground(Color.red);
			}
		});
		grpNights.add(rdbtn3Nights);
		rdbtn3Nights.setBounds(54, 271, 109, 23);
		contentPane.add(rdbtn3Nights);

		JRadioButton rdbtn4Nights = new JRadioButton("4 Nights");
		rdbtn4Nights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDisplay(false);
				lblHotelBooking.setForeground(Color.red);
			}
		});
		grpNights.add(rdbtn4Nights);
		rdbtn4Nights.setBounds(54, 297, 109, 23);
		contentPane.add(rdbtn4Nights);

		lblNights.setBounds(54, 186, 46, 14);
		contentPane.add(lblNights);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBounds(30, 193, 178, 145);
		contentPane.add(panel);

		lblExchangeRate.setBounds(211, 113, 109, 14);
		contentPane.add(lblExchangeRate);

		txtExchangeRate = new JTextField();
		txtExchangeRate.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExchangeRate.setBounds(325, 110, 121, 20);
		contentPane.add(txtExchangeRate);
		txtExchangeRate.setColumns(10);

		lblEuros.setBounds(466, 113, 46, 14);
		contentPane.add(lblEuros);

		lblCostPerNight.setBounds(325, 195, 109, 14);
		contentPane.add(lblCostPerNight);

		txtCostPerNight1 = new JTextField();
		txtCostPerNight1.setEditable(false);
		txtCostPerNight1.setText("50.00");
		txtCostPerNight1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostPerNight1.setBounds(325, 220, 121, 20);
		contentPane.add(txtCostPerNight1);
		txtCostPerNight1.setColumns(10);

		txtCostPerNight2 = new JTextField();
		txtCostPerNight2.setEditable(false);
		txtCostPerNight2.setText("90.00");
		txtCostPerNight2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostPerNight2.setBounds(324, 251, 122, 20);
		contentPane.add(txtCostPerNight2);
		txtCostPerNight2.setColumns(10);

		txtCostPerNight3 = new JTextField();
		txtCostPerNight3.setEditable(false);
		txtCostPerNight3.setText("130.00");
		txtCostPerNight3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostPerNight3.setBounds(325, 282, 121, 20);
		contentPane.add(txtCostPerNight3);
		txtCostPerNight3.setColumns(10);

		txtCostPerNight4 = new JTextField();
		txtCostPerNight4.setEditable(false);
		txtCostPerNight4.setText("160.00");
		txtCostPerNight4.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCostPerNight4.setBounds(325, 313, 121, 20);
		contentPane.add(txtCostPerNight4);
		txtCostPerNight4.setColumns(10);

		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtExchangeRate.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Exchange rate or Prices not entered");
				} else {
					try {
						exchangeRate = Double.parseDouble(txtExchangeRate
								.getText());
						setDisplay(true);
						lblHotelBooking.setForeground(Color.blue);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Please enter a valid exchange rate");
					}

				}
			}
		});

		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberFormat nf = NumberFormat.getInstance(); // Formats to 2
				// decimal
				// points ALWAYS
				nf.setMaximumFractionDigits(2);
				nf.setMinimumFractionDigits(2);
				nf.setRoundingMode(RoundingMode.HALF_UP);

				txtInfo.setBackground(Color.white);

				if (rdbtn1Night.isSelected()) {
					totalExVatGBP = 50.00;
				} else if (rdbtn2Nights.isSelected()) {
					totalExVatGBP = 90.00;
				} else if (rdbtn3Nights.isSelected()) {
					totalExVatGBP = 130.00;
				} else if (rdbtn4Nights.isSelected()) {
					totalExVatGBP = 160.00;
				}

				if (rdbtnSingle.isSelected()) {
					isDoubleRoom = false;
				} else if (rdbtnDouble.isSelected()) {
					isDoubleRoom = true;
				}

				if (isDoubleRoom == true) {
					totalExVatGBP = totalExVatGBP * 1.30;
				}

				totalExVatEuros = totalExVatGBP * exchangeRate;

				txtCostExVatGBP.setText(String.valueOf(nf.format(totalExVatGBP)));
				txtCostExVatEuro.setText(String.valueOf(nf
						.format(totalExVatEuros)));

				totalInclVatGBP = totalExVatGBP * 1.23;
				totalInclVatEuros = totalExVatEuros * 1.23;

				txtCostInclVatGBP.setText(String.valueOf(nf
						.format(totalInclVatGBP)));
				txtCostInclVatEuro.setText(String.valueOf(nf
						.format(totalInclVatEuros)));

				if (rdbtn1Night.isSelected() && isDoubleRoom == false) {
					txtInfo.setText("Single room for 1 Night");
				} else if (rdbtn1Night.isSelected() && isDoubleRoom == true) {
					txtInfo.setText("Double room for 1 Night");
				} else if (rdbtn2Nights.isSelected() && isDoubleRoom == false) {
					txtInfo.setText("Single room for 2 Nights");
				} else if (rdbtn2Nights.isSelected() && isDoubleRoom == true) {
					txtInfo.setText("Double room for 2 Nights");
				} else if (rdbtn3Nights.isSelected() && isDoubleRoom == false) {
					txtInfo.setText("Single room for 3 Nights");
				} else if (rdbtn3Nights.isSelected() && isDoubleRoom == true) {
					txtInfo.setText("Double room for 3 Nights");
				} else if (rdbtn4Nights.isSelected() && isDoubleRoom == false) {
					txtInfo.setText("Single room for 4 Nights");
				} else if (rdbtn4Nights.isSelected() && isDoubleRoom == true) {
					txtInfo.setText("Double room for 4 Nights");
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setBackground(Color.yellow);
				txtInfo.setText("");
				txtCostExVatGBP.setText("");
				txtCostExVatEuro.setText("");
				txtCostInclVatGBP.setText("");
				txtCostInclVatEuro.setText("");
			}
		});

		btnGo.setBounds(325, 467, 89, 23);
		contentPane.add(btnGo);

		txtInfo = new JTextField();
		txtInfo.setVisible(false);
		txtInfo.setBackground(Color.YELLOW);
		txtInfo.setBounds(262, 440, 250, 20);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
		rdbtn1Night.setSelected(true);
		rdbtnSingle.setSelected(true);

		setDisplay(false);
	}

	public void setDisplay(boolean onOff) {

		lblExchangeRate.setVisible(!onOff);
		txtExchangeRate.setVisible(!onOff);
		lblEuros.setVisible(!onOff);
		lblCostPerNight.setVisible(!onOff);
		txtCostPerNight1.setVisible(!onOff);
		txtCostPerNight2.setVisible(!onOff);
		txtCostPerNight3.setVisible(!onOff);
		txtCostPerNight4.setVisible(!onOff);
		lblRoom.setVisible(onOff);
		panel_1.setVisible(onOff);
		rdbtnSingle.setVisible(onOff);
		rdbtnDouble.setVisible(onOff);
		lblCostExcludingVat.setVisible(onOff);
		txtCostExVatGBP.setVisible(onOff);
		lblGbp.setVisible(onOff);
		txtCostExVatEuro.setVisible(onOff);
		lblEuro.setVisible(onOff);
		btnCalculate.setVisible(onOff);
		lblCostIncludingVat.setVisible(onOff);
		txtCostInclVatGBP.setVisible(onOff);
		lblGbp_1.setVisible(onOff);
		txtCostInclVatEuro.setVisible(onOff);
		lblEuro_1.setVisible(onOff);
		btnClear.setVisible(onOff);
		txtInfo.setVisible(onOff);
		btnGo.setVisible(!onOff);
	}
}
