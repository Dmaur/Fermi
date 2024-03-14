import java.awt.Dimension;

import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import java.awt.*;
// import java.awt.event.*;
import net.miginfocom.swing.MigLayout;



public class FermiWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField numOne;
    private JTextField numTwo;
    private JTextField numThree;


    public FermiWindow(){
        // ----------window constuctor
        this.setTitle("Fermi Guessing Game");
        this.setSize(550,550);  
        this.setLocation(600,200);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create main panel anf polace it in window
        mainPanel = new JPanel( );
        this.add(mainPanel);
        // ----------------------mig layout for main panel
        mainPanel.setLayout(new MigLayout("debug",
                                              "[275][275]",
                                              "[525]"));

        leftPanel = new JPanel();
        JLabel enterMsg = new JLabel("Enter your guesses (0-9)");
        numOne = new JTextField(5);
        numTwo = new JTextField(5);
        numThree = new JTextField(5);
        JButton okay = new JButton("OK");
        JButton reset = new JButton("reset");
        leftPanel.setSize(200,400);
        leftPanel.setLayout(new MigLayout("",
                                                "[240]",
                                                "30[]10[]10[]10[]10[30]280[30]"));

        leftPanel.add(enterMsg,"wrap");
        leftPanel.add(numOne, "wrap");
        leftPanel.add(numTwo,"wrap");
        leftPanel.add(numThree,"wrap");
        leftPanel.add(okay,"wrap");
        leftPanel.add(reset,"wrap");


        rightPanel = new JPanel();


        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);


        
    }
    
    public static void main(String[] args){
        FermiWindow window = new FermiWindow();
		window.setVisible(true);
    }
}

