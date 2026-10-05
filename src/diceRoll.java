import javax.swing.*;
import java.util.*;

public class diceRoll extends JFrame{
    private JPanel diceRollMainPanel;
    private JTextField diceRollBetEntry;
    private JComboBox diceRollBetChoice;
    private JButton diceRollBetSubmit;
    private JPanel diceRollTopPanel;
    private JPanel diceRollCenterPanel;
    private JPanel diceRollBottomPanel;
    private JLabel diceRollTitleLabel;
    private JLabel diceRollImage;
    private JButton diceRollReturnButton;

    public diceRoll(mainScreen screen) {
        diceRollReturnButton.addActionListener(e -> {
            screen.showHome();
        });

    }

    public boolean roll(int n) {
        Random r = new Random(67);
        int roll = 6;

        if (n == roll) {
            return true;
        } else return false;
    }



    public JPanel getDiceRollPanel() {
        return diceRollMainPanel;
    }
}
