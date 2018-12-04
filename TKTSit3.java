/*
                        The Klump Trail
Created by Brendan Cagampang, Andrea Ecarma, Edgar Flores, and Mike Palermo.

These were the tasks assigned:
Brendan - Situation 3
Andrea - 
Edgar - 
Mike - Siatuation 1

The purpose of this project is to make Dr. Klump either laugh or cry. That is all.

This is a clicking game, so the user just needs to click Next and sometimes select an option.


*/

package tktsit3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Sit3 {
    private String sit3Text;
    public String getSit3Text() {
        return sit3Text;
    }
    public void setSit3Text(String sit3Text) {
        this.sit3Text = sit3Text;
    }
    public void paintComponent(Graphics g) {
        paintComponent(g);
        g.drawString(sit3Text, 50, 50);
    }
    public Sit3(String sit3Text) {
        setSit3Text(sit3Text);
    }
}

class KlumpFrame extends JFrame implements ActionListener{
    private JPanel panRight = new JPanel(new GridLayout(1,3));
    
    public void actionPerformed(ActionEvent e) {
        e.getSource();
    }
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
        JMenuItem miNG = new JMenuItem("New Game");
        mnuFile.add(miNG);
        bar.add(mnuFile);
        
    }
    public void configureUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,1000,1000);
        setTitle("The Klump Trail v0.1");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        configureMenu();
    }
}

public class TKTSit3 {
    public static void main(String[] args) {
        
    }
}
