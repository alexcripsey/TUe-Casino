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
    private int lastRoll;

    public diceRoll(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        RetroStyle.styleScreen(diceRollMainPanel);
        RetroStyle.styleTitle(diceRollTitleLabel, "★  DICE ROLL  ★");
        RetroStyle.styleDisplay(diceRollImage, "⚄  PICK A SIDE  ⚄");
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
                int bet = 0;
                try {
                    bet = Integer.parseInt(diceRollBetEntry.getText().trim());
                }  catch (NullPointerException | NumberFormatException ex) {
                    bet = 0;
                } finally {
                    diceRollBetEntry.setText(game.makeValid(bet));
                }
                int betAmount = Integer.parseInt(diceRollBetEntry.getText());
                int selectedIndex = diceRollBetChoice.getSelectedIndex();
                if(betAmount == wallet.getMoney()) {
                    game.allIns++;
                }
                game.creditsWagered+= betAmount;
                wallet.subtractMoney(betAmount);

                    boolean won = roll(selectedIndex);
                    diceRollImage.setText("ROLLED " + lastRoll + (won ? "  - WIN!" : "  - TRY AGAIN"));
                    diceRollImage.setForeground(won ? RetroStyle.MINT : new java.awt.Color(255, 111, 126));
                    if (won) {
                        wallet.addMoney(betAmount * 6);
                        game.wins++;
                        game.moneyWon += betAmount * 6;
                    } else {
                        game.losses++;
                        game.moneyLost += betAmount;
                    }
                    game.roundsPlayed++;
            }
        });
    }

    public boolean roll(int bet) {
        int r_roll = r.nextInt(6);
        lastRoll = r_roll + 1;

        if (bet == r_roll) {
            return true;
        } else return false;
    }

    public JPanel getDiceRollPanel() {
        return diceRollMainPanel;
    }
}
