import javax.swing.*;
import java.awt.event.*;
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
    private final Game game;
    private final Random r = new Random();

    public diceRoll(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
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

        diceRollBetEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(diceRollBetEntry.getText().trim());
                diceRollBetEntry.setText(game.makeValid(bet));
            }
        });

        diceRollBetSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if bet amount is less than wallet
                int betAmount = Integer.parseInt(diceRollBetEntry.getText());
                int selectedIndex = diceRollBetChoice.getSelectedIndex();
                if(betAmount == wallet.getMoney()) {
                    game.allIns++;
                }
                game.creditsWagered+= betAmount;

                    if (roll(selectedIndex)) {
                        wallet.addMoney(betAmount * 5);
                        game.wins++;
                        game.moneyWon += betAmount * 5;
                    } else {
                        wallet.subtractMoney(betAmount);
                        game.losses++;
                    }
                    game.roundsPlayed++;
            }
        });
    }

    public boolean roll(int bet) {
        int r_roll = r.nextInt(6);

        if (bet == r_roll) {
            return true;
        } else return false;
    }

    public JPanel getDiceRollPanel() {
        return diceRollMainPanel;
    }
}
