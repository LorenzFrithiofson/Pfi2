import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private ClockLogic clocklogic;
	private JTextField txtHours;
	private JTextField txtMinutes;
	private JTextField Alarm;
	private JTextField Clock;
	
	public boolean alarm = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setTitle("My Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(txtHours != null ){
			
				//}
				
				int hourCheck = Integer.parseInt(txtHours.getText());
				int minuteCheck = Integer.parseInt(txtMinutes.getText());
				
				if(hourCheck < 0 || hourCheck > 23 || minuteCheck < 0 || minuteCheck > 59){
					Alarm.setText("Enter valid time baby");
					
				} else {
					Alarm.setText("Alarm: " + txtHours.getText() + ":" + txtMinutes.getText());
					clocklogic.setAlarm(hourCheck,minuteCheck);
				}
				
				
				
				
			}
		});
		btnSetAlarm.setBounds(501, 301, 126, 81);
		contentPane.add(btnSetAlarm);
		
		
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					clocklogic.clearAlarm();
					txtHours.setText("");
					txtMinutes.setText("");
					Alarm.setText("");
					
			}
		});
		btnClearAlarm.setBounds(667, 301, 126, 81);
		contentPane.add(btnClearAlarm);
		
		txtHours = new JTextField();
		txtHours.setBounds(199, 331, 86, 20);
		contentPane.add(txtHours);
		txtHours.setColumns(10);
		
		txtMinutes = new JTextField();
		txtMinutes.setBounds(354, 331, 86, 20);
		contentPane.add(txtMinutes);
		txtMinutes.setColumns(10);
		
	JLabel LableHours = new JLabel("Hours");
		LableHours.setBounds(199, 306, 46, 14);
		contentPane.add(LableHours);
		
		JLabel LableMinutes = new JLabel("Minutes");
		LableMinutes.setBounds(354, 306, 46, 14);
		contentPane.add(LableMinutes);
		
		Alarm = new JTextField();
		Alarm.setBounds(501, 243, 158, 30);
		contentPane.add(Alarm);
		Alarm.setColumns(10);
		
		Clock = new JTextField();
		Clock.setHorizontalAlignment(SwingConstants.CENTER);
		Clock.setFont(new Font("Trajan Pro", Font.PLAIN, 34));
		Clock.setBounds(501, 78, 191, 71);
		contentPane.add(Clock);
		Clock.setColumns(10);
		
		JLabel ClockImg = new JLabel("New label");
		ClockImg.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/Img/Clock-Small.png")));
		ClockImg.setBounds(733, 87, 46, 40);
		contentPane.add(ClockImg);
		
		clocklogic = new ClockLogic(this);
	}
	
	public void setTimeOnLabel(String time){
		Clock.setText(time);
	}
	public void setAlarmText(String alarmText){
		
	}
	public void alarm(boolean activate){
		if (activate == true){
			System.out.println("Alarm is ringing");
			contentPane.setBackground(Color.BLUE);
			
		} else {
			contentPane.setBackground(Color.GRAY);
		}
	}
}
