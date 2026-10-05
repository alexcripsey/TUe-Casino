import javax.swing.*;
import javax.swing.text.DocumentFilter;
import java.awt.event.*;
import java.util.*;

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

        diceRollBetEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });
        diceRollBetSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if bet amount if less than wallet
                int betAmount = Integer.parseInt(diceRollBetEntry.getText());
                int wallet = 100;
                String selectedText = diceRollBetChoice.getSelectedItem().toString();
                int bet = Integer.parseInt(selectedText);

                //TODO add correct wallet methods and also add correct wallet payouts etc and remove balance as bet is placed then give user the reward
                if  (betAmount >= 0 && betAmount < wallet) {
                    if (roll(bet)) {
                        wallet += (betAmount * 2);
                    } else {
                        wallet -= betAmount;
                    }
                }
                System.out.println(wallet);
            }
        });
    }

    public boolean roll(int bet) {
        Random r = new Random(67);

        if (bet == r.nextInt(6)) {
            return true;
        } else return false;
    }

    public JPanel getDiceRollPanel() {
        return diceRollMainPanel;
    }
}
