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
		
		Cat cat1 = new Cat("Mjaos-FörMyckus",3,5);
		cat1.setFriendlyName("KattenMjao");
		
		Cat cat2 = new Cat("Nextus-Kungus",3,2);
		cat2.setFriendlyName("Simba");
		
		Snake snake1 = new Snake("Väsus-Myckus",false);
		snake1.setFriendlyName("SirVäs");
		
		Snake snake2 = new Snake("Förklädd-Maskus",true);
		snake2.setFriendlyName("Mask");
		
		djur.add(new Dog("Lovis", "Busus-Hungrus", 5, true));
		djur.add(new Dog("Lyra", "Sötus-extremus", 5, false));
		djur.add(cat1);
		djur.add(cat2);
		djur.add(snake1);
		djur.add(snake2);
		
			for(Animal i: djur){
				textArea.append(i.getInfo() + "\n");
			}
	}
}
