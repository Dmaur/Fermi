import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;



public class Window extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField numOne;
    private JTextField numTwo;
    private JTextField numThree;
    private JButton okay;
    private String gameRegEx = "[0-9]";
    TextFieldValidator numEntered;
    Border startBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK,1);


    public Window(){
        // ----------window constuctor
        this.setTitle("Fermi Guessing Game");
        this.setSize(550,400);  
        this.setLocation(600,200);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create main panel and place it in window
        mainPanel = new JPanel( );
        this.add(mainPanel);
        // ----------------------mig layout for main panel
        mainPanel.setLayout(new MigLayout("",
                                              "[250][250]",
                                              "[525]"));
        // setting up the left pannel with the buttons and text fields. 
        leftPanel = new JPanel();
        JLabel enterMsg = new JLabel("Enter your three guesses (0-9)");
        // setting up JText Area and event listeners for when user enters input
        numOne = new JTextField(8);
        numOne.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                onUserInput(numOne);
            }
        });
        numTwo = new JTextField(8);
        numTwo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                onUserInput(numTwo);
        
            }
        });
        numThree = new JTextField(8);
        numThree.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                onUserInput(numThree);
            }
        });
        numOne.setBorder(startBorder);
        numTwo.setBorder(startBorder);
        numThree.setBorder(startBorder);
        okay = new JButton("OK");
        okay.setPreferredSize(new Dimension(100,0));
        okay.setEnabled(false);
        //hooking up ervent listener foir okay buttonhhhnb 
        okay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                okClicked(e);
            }
        });
        JButton reset = new JButton("reset");
        reset.setPreferredSize(new Dimension(100,0));
        // hooking up event listener
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resetClicked(e);
            }
        });
        leftPanel.setSize(200,400);
        // mig layout for left panel. 
        leftPanel.setLayout(new MigLayout("",
                                            "[240]",
                                            "30[]10[]10[]10[]10[30]140[30]"));
        //adding all the contents to the left panel.  
        leftPanel.add(enterMsg,"wrap");
        leftPanel.add(numOne, "wrap");
        leftPanel.add(numTwo,"wrap");
        leftPanel.add(numThree,"wrap");
        leftPanel.add(okay,"wrap");
        leftPanel.add(reset,"wrap");

        // setting up the right panel with text area and lable. 
        rightPanel = new JPanel();
        JLabel hints = new JLabel("Hints:");
        JTextArea gameOutput = new JTextArea();
        gameOutput.setPreferredSize(new Dimension(240,280));
        gameOutput.setBorder(blackBorder);
        rightPanel.setSize(200,400);
         // setting mig layout
        rightPanel.setLayout(new MigLayout("",
                                                "[]",
                                                "[]10[]120"));
        // adding contents to the rightPanel. 
        rightPanel.add(hints,"wrap");
        rightPanel.add(gameOutput);
       

        // 
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
    }

    // ---------------------------------------------texField event handler
    public void onUserInput (JTextField userInput){
        // use the field passed to make new TextFieldValidatorObject
        numEntered = new TextFieldValidator(userInput);
        numEntered.setRegExp(gameRegEx);
        JTextField thisOne = numEntered.getJTextField(); 
        boolean checked = numEntered.check();
        // checks to see if input is valid against regEx and changes border color accordingly
        if(checked == false){
            thisOne.setBorder(BorderFactory.createLineBorder(numEntered.getErrorColor()));
        }else {
            numEntered.reset();
        }

        // checks to see if the border colors of all three inputs is black and enables the ok button. if not, the button remains disabled. 
        if ((numOne.getBorder()instanceof LineBorder && ((LineBorder) numOne.getBorder()).getLineColor().equals(Color.BLACK)) &&
        (numTwo.getBorder()instanceof LineBorder && ((LineBorder) numTwo.getBorder()).getLineColor().equals(Color.BLACK))&&
        (numThree.getBorder()instanceof LineBorder && ((LineBorder) numThree.getBorder()).getLineColor().equals(Color.BLACK))){
            okay.setEnabled(true);
        }else{
            okay.setEnabled(false);
        }
      

    }
    // --------------------------------------------button event handlers
    public void okClicked(ActionEvent e ){
        System.out.println("ok clicked");
    }

    public void resetClicked(ActionEvent e ){
        numOne.setText("");
        numTwo.setText("");
        numThree.setText("");
    }
    







    
    public static void main(String[] args){
        Window window = new Window();
		window.setVisible(true);
    }
}

