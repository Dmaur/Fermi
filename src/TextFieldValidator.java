import java.awt.Color;
import javax.swing.JTextField;

public class TextFieldValidator {
    
    private String regExp;
    private Color errorColor;
    

    public TextFieldValidator (JTextField myTarget, Color myErrorColor){
        this.targetTextField = myTarget;
        this.errorColor = myErrorColor;
    };

}
