import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	
	GUI g = this;
	Parser p = new Parser();
	
	Thread uT = new UpdateThread(p,this);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ub\u00E5tshallen");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(127, 41, 276, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Linje");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(26, 102, 58, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destination");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(87, 99, 95, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Avg\u00E5r");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(212, 102, 84, 21);
		contentPane.add(lblNewLabel_3);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.ORANGE);
		textArea.setOpaque(false);
		textArea.setBounds(36, 141, 388, 351);
		contentPane.add(textArea);
		
		
		
		JLabel lblFrseningar = new JLabel("F\u00F6rseningar");
		lblFrseningar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFrseningar.setForeground(Color.WHITE);
		lblFrseningar.setBounds(306, 99, 107, 27);
		contentPane.add(lblFrseningar);
		
		Thread uT = new UpdateThread(p,this);
		uT.start();
}
	
	
	 public void updateTimes(){
		 System.out.println("// Busses departing from Ubåtshallen stationsnummer 80046 ");
			Lines lines = Parser.getStationResults(new Station("80046"));
			for (Line l : lines.getLines()) {
				if(l.getStopPoint().contains("Västra")){
					if(l.getDepTimeDeviation() != ""){
				textArea.append("" + l.getLine()+ "                 "+l.getStopPoint() + "            " + fixTime(l.getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + fixTime(l.getDepTime().get(Calendar.MINUTE))
						+ "                                     " + l.getDepTimeDeviation()+ " min " + "\n \n");
					} else{
						textArea.append("" + l.getLine()+ "                 "+l.getStopPoint() + "            " + fixTime(l.getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + fixTime(l.getDepTime().get(Calendar.MINUTE))
								+ "                                     " + "\n \n");
					}
				}
			}
	 }
	
	public String fixTime(int time){ 
		String zero = ""; if (time < 10) { zero = "0"; } 
		String fixTimeString = zero + Integer.toString(time); 
		zero = ""; 
		return fixTimeString; }
}


