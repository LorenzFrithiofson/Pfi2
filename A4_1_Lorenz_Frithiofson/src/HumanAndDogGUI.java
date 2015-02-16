import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HumanAndDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtLorenz;
	private JTextField txtLovis;
	private Human human;
	private Dog dog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanAndDogGUI frame = new HumanAndDogGUI();
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
	public HumanAndDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 146, 323, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JTextArea txtInfo = new JTextArea();
		txtInfo.setBounds(6, 16, 311, 43);
		panel.add(txtInfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ErrorMessage", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(4, 212, 323, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 16, 311, 49);
		panel_1.add(textArea);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtLorenz.getText().length() < 3){
					textArea.setText("Namnet måste innehålla minst 3 bokstäver");
				}else {
					human = new Human(txtLorenz.getText());
					textArea.setText("");
				}
			}
		});
		btnNewHuman.setBounds(127, 55, 89, 23);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human == null){
					textArea.setText("ägare måste anges!");
				} else { 
					dog = new Dog(txtLovis.getText());
					human.buyDog(dog);
				}
			}
		});
		btnBuyDog.setBounds(127, 82, 89, 23);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setText(human.getInfo());
				
			}
		});
		btnPrintInfo.setBounds(127, 109, 89, 23);
		contentPane.add(btnPrintInfo);
		
		txtLorenz = new JTextField();
		txtLorenz.setBounds(10, 56, 86, 20);
		contentPane.add(txtLorenz);
		txtLorenz.setColumns(10);
		
		txtLovis = new JTextField();
		txtLovis.setBounds(10, 83, 86, 20);
		contentPane.add(txtLovis);
		txtLovis.setColumns(10);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setBounds(127, 11, 109, 24);
		contentPane.add(lblHumansAndDogs);
		
	
	}
}
