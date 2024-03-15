import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;


public class TextFieldValidator {
    
    private String regExp = "\\w";
    private Color errorColor;
    private JTextField fieldToTest;
    

    
    // -----------------------------constructor methods
    public TextFieldValidator (JTextField targetField, Color myErrorColor){
        this.fieldToTest = targetField;
        this.errorColor = myErrorColor;
    };

    public TextFieldValidator (JTextField targetField){
        this.fieldToTest = targetField;
        this.errorColor = Color.RED;
    };
    // --------------------------------------------------------------public methods
    public Boolean check(){
        String textToTest = fieldToTest.getText();
        if (textToTest.matches(regExp)){
            return true;
        } else {
            return false;
        }
    };
    
    public void reset(){
        fieldToTest.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    };




    // ----------------------------------------------------------------Gets/Sets
    public void setRegExp(String myRegEx){
        this.regExp = myRegEx;

    }
    
    public void setErrorColor(Color myColor){
        this.errorColor = myColor;
    };

    public Color getErrorColor(){
        return errorColor;
    }
    public JTextField getJTextField(){
        return fieldToTest;
    }

}