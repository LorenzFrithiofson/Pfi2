import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;


public class SearchGUI extends JFrame {

	private JPanel Resultat;
	private JTextField s�kStr�ng;
	private JTextField fr�n;
	private JTextField till;
	ArrayList<Station> searchStations = new ArrayList<Station>(); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI frame = new SearchGUI();
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
	public SearchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 501);
		Resultat = new JPanel();
		Resultat.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Resultat);
		Resultat.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 240, 393);
		Resultat.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 151, 230, 242);
		panel.add(textArea);
		
		s�kStr�ng = new JTextField();
		s�kStr�ng.setBounds(47, 21, 154, 31);
		panel.add(s�kStr�ng);
		s�kStr�ng.setColumns(10);
		
		JButton s�k = new JButton("S\u00F6k");
		s�k.setBounds(76, 87, 86, 23);
		panel.add(s�k);
		s�k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				searchStations.addAll(Parser.getStationsFromURL(s�kStr�ng.getText()));
				for (Station s: searchStations){
					
					textArea.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 33, 234, 393);
		Resultat.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
	
		fr�n = new JTextField();
		fr�n.setBounds(10, 237, 91, 20);
		panel_1.add(fr�n);
		fr�n.setColumns(10);
		
		till = new JTextField();
		till.setBounds(131, 237, 91, 20);
		panel_1.add(till);
		till.setColumns(10);
		
		final JTextArea s�kresultatet = new JTextArea();
		s�kresultatet.setBounds(0, 0, 232, 206);
		panel_1.add(s�kresultatet);
		
		
	
		JButton s�kResa = new JButton("S\u00F6k Resa");
		s�kResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchURL = Constants.getURL(fr�n.getText() + "",till.getText(),1);
				Journeys journeys = Parser.getJourneys(searchURL);
				for (Journey journey : journeys.getJourneys()) {
					s�kresultatet.setText(journey.getStartStation()+" - ");
					s�kresultatet.append(journey.getEndStation()+ "");
					String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
					s�kresultatet.append("\nDeparts " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. \nAnd it is "+journey.getDepTimeDeviation()+" min late");
				} 
				
			}
		});
		s�kResa.setBounds(71, 280, 89, 23);
		panel_1.add(s�kResa);
		
		JLabel lblNewLabel = new JLabel("Fr\u00E5n");
		lblNewLabel.setBounds(31, 217, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Till");
		lblNewLabel_1.setBounds(151, 217, 46, 14);
		panel_1.add(lblNewLabel_1);
		
	}
}
