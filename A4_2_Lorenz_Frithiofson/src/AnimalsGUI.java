import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;


public class AnimalsGUI extends JFrame {

	ArrayList<Animal>djur = new ArrayList<Animal>();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 239);
		contentPane.add(textArea);
		
		djur.add(new Dog("Lovis", "Busus-Hungrus", 5, true));
		djur.add(new Dog("Lyra", "Sötus-extremus", 5, false));
		djur.add(new Cat("Katten Mjao", "Mjaous-Förmyckus", 100, 9));
		djur.add(new Cat("Simba", "Nextus-Kungus", 0, 3));
		djur.add(new Snake("SirVäs", "Väsus-Iritationus", true));
		djur.add(new Snake("Mask", "Mask-I-förklädus", false));
		
			for(Animal i: djur){
				textArea.append(i.getInfo() + "\n");
			}
	}
}
