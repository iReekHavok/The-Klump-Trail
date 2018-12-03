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

package theklumptrail;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class KlumpFrame extends JFrame implements ActionListener{

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
    }
    public void configureUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,500,500);
        setTitle("The Klump Trail V0.1");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        lpan = new LinePanel(points);
        c.add(lpan,BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel lblPointSize = new JLabel("Point Size");
        txtPointSize = new JTextField(5);
        txtPointSize.addKeyListener(this);
        panSouth.add(lblPointSize);
        panSouth.add(txtPointSize);
        c.add(panSouth,BorderLayout.SOUTH);
        configureMenu();
    }
    public LineFrame(ArrayList<Point> points) {
        this.points = points;
        pr = new PointRandomizer();
        configureUI();
    }
}
class SitPan1{
  
  public LinePanel(ArrayList<Point> points) {
        this.points = points;
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        message = "sup"; 
        pointSize = 10;
        color = Color.BLACK;
        lineEnable = true;
        noLine = false;
    }
  public void paintComponent(Graphics g) { // Drawing the points
        super.paintComponent(g);
        Font F = new Font("Helvetica", Font.REGULAR,16);
        g.setFont(f);
        g.drawString(
    }
}
class SitPan2{}
class SitPan3{}
class SitPan4{}

public class TheKlumpTrail {
    public static void main(String[] args) {
        
    }
}
