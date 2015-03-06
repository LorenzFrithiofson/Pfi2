package se.mah.k3lara.skaneAPI.view;
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
import se.mah.k3lara.skaneAPI.model.JourneysThread;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.model.StationsThread;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;


public class SearchGUI extends JFrame {

	public JPanel Resultat;
	public JTextArea textArea;
	public JTextArea searchresult;
	public JTextField sökSträng;
	public JTextField från;
	public JTextField till;
	public ArrayList<Station> searchStations;
	
	SearchGUI g = this;
	public Parser p = new Parser();
	Thread t1 = new JourneysThread(p, this);
	Thread t2 = new StationsThread(p, this);
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
		
		textArea = new JTextArea();
		textArea.setBounds(10, 151, 230, 242);
		panel.add(textArea);
		
		sökSträng = new JTextField();
		sökSträng.setBounds(47, 21, 154, 31);
		panel.add(sökSträng);
		sökSträng.setColumns(10);
		
		JButton search = new JButton("S\u00F6k");
		search.setBounds(76, 87, 86, 23);
		panel.add(search);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			textArea.setText("Searching...");
			StationsThread t2 = new StationsThread(p,g);
			t2.start();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 33, 234, 393);
		Resultat.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
	
		från = new JTextField();
		från.setBounds(10, 237, 91, 20);
		panel_1.add(från);
		från.setColumns(10);
		
		till = new JTextField();
		till.setBounds(131, 237, 91, 20);
		panel_1.add(till);
		till.setColumns(10);
		
		searchresult = new JTextArea();
		searchresult.setBounds(0, 0, 232, 206);
		panel_1.add(searchresult);
		
		
	
		JButton searchTravel = new JButton("S\u00F6k Resa");
		searchTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JourneysThread t1 = new JourneysThread(p,g);
				t1.start();
			}
		});
		searchTravel.setBounds(71, 280, 89, 23);
		panel_1.add(searchTravel);
		
		JLabel lblNewLabel = new JLabel("Fr\u00E5n");
		lblNewLabel.setBounds(31, 217, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Till");
		lblNewLabel_1.setBounds(151, 217, 46, 14);
		panel_1.add(lblNewLabel_1);
		
	}
}
