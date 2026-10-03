import javax.swing.*;

public class diceRoll {
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



    public JPanel getDiceRollPanel() {
        return diceRollMainPanel;
    }
}
