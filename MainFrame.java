package calculator.gui;


import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
/**
 * 
 * @author Felipe
 * @version 1.0.0.0a
 * @serial KLMPF-59ABC-DK98-PK
 * 
 */
public class MainFrame {

	private JFrame frmCalculator;
	private final JTextField firstField = new JTextField();
	private final JLabel firstMember = new JLabel("1st Member");
	private final JTextField secondField = new JTextField();
	private final JLabel secondMember = new JLabel("2nd Member");
	private final JButton btSwitch = new JButton("");
	private final JComboBox operations = new JComboBox();
	private final JButton btnGo = new JButton("Go");
	private final JButton btnCopy = new JButton("Copy to Clipboard");
	private final JTextField result = new JTextField();
	private final JLabel appName = new JLabel("Calculator v1.0.0.0a");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setEditable(false);
		result.setColumns(10);
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmCalculator.setForeground(SystemColor.menu);
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		frmCalculator.setTitle("Calculator\r\n");
		frmCalculator.setBounds(100, 100, 450, 165);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCalculator.getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_operations = new GridBagConstraints();
		gbc_operations.gridheight = 2;
		gbc_operations.insets = new Insets(0, 0, 5, 5);
		gbc_operations.fill = GridBagConstraints.HORIZONTAL;
		gbc_operations.gridx = 1;
		gbc_operations.gridy = 1;
		operations.setModel(new DefaultComboBoxModel(new String[] {"Sum", "Division", "Multiply", "Subtraction"}));
		frmCalculator.getContentPane().add(operations, gbc_operations);

		GridBagConstraints gbc_appName = new GridBagConstraints();
		gbc_appName.gridheight = 2;
		gbc_appName.gridwidth = 2;
		gbc_appName.insets = new Insets(0, 0, 5, 5);
		gbc_appName.gridx = 3;
		gbc_appName.gridy = 1;
		appName.setFont(new Font("DialogInput", Font.PLAIN, 15));
		frmCalculator.getContentPane().add(appName, gbc_appName);

		GridBagConstraints gbc_firstMember = new GridBagConstraints();
		gbc_firstMember.insets = new Insets(0, 0, 5, 5);
		gbc_firstMember.gridx = 1;
		gbc_firstMember.gridy = 3;
		frmCalculator.getContentPane().add(firstMember, gbc_firstMember);

		GridBagConstraints gbc_secondMember = new GridBagConstraints();
		gbc_secondMember.insets = new Insets(0, 0, 5, 5);
		gbc_secondMember.gridx = 3;
		gbc_secondMember.gridy = 3;
		frmCalculator.getContentPane().add(secondMember, gbc_secondMember);
		firstField.setColumns(10);

		GridBagConstraints gbc_firstField = new GridBagConstraints();
		gbc_firstField.insets = new Insets(0, 0, 5, 5);
		gbc_firstField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstField.gridx = 1;
		gbc_firstField.gridy = 4;
		frmCalculator.getContentPane().add(firstField, gbc_firstField);

		GridBagConstraints gbc_btSwitch = new GridBagConstraints();
		gbc_btSwitch.insets = new Insets(0, 0, 5, 5);
		gbc_btSwitch.gridx = 2;
		gbc_btSwitch.gridy = 4;
		btSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMembers();
			}
		});
		btSwitch.setIcon(new ImageIcon("D:\\Java Projects\\Calculator\\src\\calculator\\gui\\switch.png"));
		frmCalculator.getContentPane().add(btSwitch, gbc_btSwitch);
		secondField.setColumns(10);

		GridBagConstraints gbc_secondField = new GridBagConstraints();
		gbc_secondField.insets = new Insets(0, 0, 5, 5);
		gbc_secondField.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondField.gridx = 3;
		gbc_secondField.gridy = 4;
		frmCalculator.getContentPane().add(secondField, gbc_secondField);

		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.gridwidth = 2;
		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo.gridx = 4;
		gbc_btnGo.gridy = 4;
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(operations.getSelectedItem() == "Sum" )
					sum(firstField.getText(),secondField.getText());
				else if(operations.getSelectedItem() == "Division")
					divide(firstField.getText(),secondField.getText());
				else if(operations.getSelectedItem() == "Multiply")
					multiply(firstField.getText(),secondField.getText());
				else 
					subtract(firstField.getText(),secondField.getText());

			}
		});




		frmCalculator.getContentPane().add(btnGo, gbc_btnGo);

		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.gridwidth = 2;
		gbc_result.insets = new Insets(0, 0, 0, 5);
		gbc_result.fill = GridBagConstraints.HORIZONTAL;
		gbc_result.gridx = 1;
		gbc_result.gridy = 8;
		frmCalculator.getContentPane().add(result, gbc_result);

		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.insets = new Insets(0, 0, 0, 5);
		gbc_btnCopy.gridx = 3;
		gbc_btnCopy.gridy = 8;
		btnCopy.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				copyToClipboard(result.getText());
			}
		});
		btnCopy.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		frmCalculator.getContentPane().add(btnCopy, gbc_btnCopy);


	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void changeMembers() {
		String temp1 = firstField.getText();
		String temp2 = secondField.getText();
		if( Valid(temp1, temp2) ){
			firstField.setText(temp2);
			secondField.setText(temp1);
		}
	}

	private boolean Valid(String temp1, String temp2) {
		boolean ok = false;	
		if( temp1.matches("\\d+") && temp2.matches("\\d+")) 
			ok=true;
		return ok;
	}

	private void copyToClipboard(String copy){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(copy);
		clipboard.setContents(strSel, null);
	}

	private void sum(String first, String second){
		double primeiro = Double.parseDouble(first);
		double segundo = Double.parseDouble(second);

		double resultado = primeiro + segundo;
		String resultadoFinal = String.valueOf(resultado);

		result.setText(resultadoFinal);
	}

	private void subtract(String first, String second){
		double primeiro = Double.parseDouble(first);
		double segundo = Double.parseDouble(second);

		double resultado = primeiro - segundo;
		String resultadoFinal = String.valueOf(resultado);

		result.setText(resultadoFinal);
	}

	private void multiply(String first, String second){
		double primeiro = Double.parseDouble(first);
		double segundo = Double.parseDouble(second);

		double resultado = primeiro * segundo;
		String resultadoFinal = String.valueOf(resultado);

		result.setText(resultadoFinal);
	}
	private void divide(String first, String second){
		double primeiro = Double.parseDouble(first);
		double segundo = Double.parseDouble(second);

		double resultado = primeiro / segundo;
		String resultadoFinal = String.valueOf(resultado);

		result.setText(resultadoFinal);
	}

}
