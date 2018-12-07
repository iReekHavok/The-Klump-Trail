/*

                        The Klump Trail

Created by Brendan Cagampang, Andrea Ecarma, Edgar Flores, and Mike Palermo.



These were the tasks assigned:

Brendan - 

Andrea - 

Edgar - 

Mike - 



The purpose of this project is to make Dr. Klump either laugh or cry. That is all.



This is a clicking game, so the user just needs to click Next and sometimes select an option.





*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class KlumpFrame extends JFrame implements ActionListener{
	private SitPan1 sp1;
	private SitPan2 sp2;
	private SitPan3 sp3;
	private SitPan4 sp4;
	
    public void configureMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        bar.add(mnuFile);
        setJMenuBar(bar);
    }
   
    public void configureUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(10,10,1000,500);
        setTitle("The Klump Trail V0.1");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        sp1 = new SitPan1();
        JPanel center = new JPanel();
        center.setBackground(Color.BLACK);
        c.add(center,BorderLayout.CENTER);
		JButton btnOne = new JButton("AC/DC tank top, really short jorts, and flip flops ");
		btnOne.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//c.add(newPanS,BorderLayout.SOUTH);
						repaint();
					}
				});
		JButton btnTwo = new JButton("AC/DC t-shirt, jeans, and sneakers");
		btnTwo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//c.add(newPanS,BorderLayout.SOUTH);
						repaint();
					}
				});
		JButton btnThree = new JButton("His usual office clothes and shoes");
		btnThree.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//c.add(newPanS,BorderLayout.SOUTH);
						repaint();
					}
				});
		JPanel panEast = new JPanel();
        panEast.setLayout(new GridLayout(3,1));
        panEast.add(btnOne);
        panEast.add(btnTwo);
        panEast.add(btnThree);
        c.add(panEast,BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        Dimension d = new Dimension(300, 150);
        sp1.setPreferredSize(d);
        c.add(sp1,BorderLayout.SOUTH);
        configureMenu();
    }

    public KlumpFrame() {
        configureUI();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

class SitPan1 extends JPanel{
	
  public SitPan1() {
    }
  public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        Font f = new Font("Helvetica", Font.PLAIN,22);
        g.setFont(f);
        g.drawString("The year is 2020 and summer vacation ha\ns just started. ",250,25);
        g.drawString("Despite that, Dr. Klump has woken up at 7:00 am and exclaimed",250,50);
        g.drawString(" “I can’t wait to go to this ACDC concert at 10 in the morning!",250,75);
        g.drawString(" I wonder what I should wear…”",250,100);
    }

}

class SitPan2{}

class SitPan3{}

class SitPan4{}



public class KlumpRa {

    public static void main(String[] args) {
		KlumpFrame frm = new KlumpFrame();
		frm.setVisible(true);
        

    }

}