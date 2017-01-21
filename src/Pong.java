
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pong extends JFrame 
{
	private JPanel pane1 =new JPanel();
	private JPanel pane2 =new JPanel();
	private JPanel pane3 =new JPanel();

    private final static int WIDTH = 700, HEIGHT = 450;
    private PongPanel panel;

    public Pong() {
    	super("Pong");
    	   panel = new PongPanel(this);	
    	pane1.setBackground(Color.BLACK);
		pane1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		ImageIcon image = new ImageIcon("C:/Users/Admin/Desktop/wifi.jpg");
		JLabel label = new JLabel(image);
		c.weightx = 0.5;
		c.ipadx=1;
		c.gridx = 0;
		c.gridy = 0;
	
		pane1.add(label, c);

		Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	     JLabel label1 =new JLabel(sdf.format(cal.getTime()));
	     label1.setForeground(Color.WHITE);
		c.gridx = 1;
		c.gridy = 0;
		pane1.add(label1, c);

		ImageIcon battery = new ImageIcon("C:/Users/Admin/Desktop/battery.jpg");
		JLabel label2 = new JLabel(battery);
		c.gridx = 2;
		c.gridy = 0;
		pane1.add(label2, c);
		
		pane2.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridheight = 1;
		c1.gridwidth = 1;
		

		ImageIcon messaging = new ImageIcon("Images/message.jpg");
		JButton messg = new JButton(messaging);
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.gridx = 1;
		c1.gridy = 0;
	
		pane2.add(messg, c1);

		ImageIcon Pong = new ImageIcon("Images/pong.jpg");
		Pong.setDescription("Messaging");
		JButton pong = new JButton(Pong);
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.gridx = 2;
		c1.gridy = 0;
		pane2.add(pong, c1);

		ImageIcon Notes = new ImageIcon("Images/notes.jpg");
		JButton notes = new JButton(Notes);
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.gridx = 3;
		c1.gridy = 0;
		pane2.add(notes, c1);
		
		ImageIcon Photos = new ImageIcon("Images/photo.jpg");
		JButton photos = new JButton(Photos);
		pong.addActionListener(new ActionListener() {
		
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				getContentPane().removeAll();
			        getContentPane().add(panel);
			        getContentPane().validate();
				
			}
		});
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.gridx = 4;
		c1.gridy = 0;
		pane2.add(photos, c1);
		
		JLabel select = new JLabel("Please Select");
		select.setFont(new Font("Calibri",Font.BOLD,50));
		
		select.setForeground(Color.WHITE);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().add(pane1,BorderLayout.NORTH);
		pane2.setBackground(Color.BLACK);
		this.getContentPane().add(pane2,BorderLayout.CENTER);
		this.getContentPane().add(select,BorderLayout.SOUTH);
    }

    public PongPanel getPanel()
    {
        return panel;
    }

    public static void main(String[] args) {
       Pong pong= new Pong();
       pong.setSize(WIDTH, HEIGHT);
       pong.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pong.setBackground(Color.WHITE);
       pong.setResizable(false);
       pong.setVisible(true);
       
    }
}
