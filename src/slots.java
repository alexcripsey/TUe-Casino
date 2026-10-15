import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Random;

public class slots extends JFrame {
    private JPanel slotsMainPanel;
    private JTextField slotsBetEntry;
    private JButton slotsBetSubmit;
    private JPanel slotsTopPanel;
    private JPanel slotBottomPanel;
    private JPanel slotsCenterPanel;
    private JLabel slotsTitleLabel;
    private JLabel slotsDisplay;
    private JButton slotsReturnButtonlimit;
    private final Game game;
    private final Random r = new Random();
    private static final Map<Integer, Integer> weights = Map.of(
            0, 40,
            1, 25,
            2, 18,
            3, 12,
            4, 5
    );
    private static final String[] SLOT_SYMBOLS = {"🍒", "🍋", "🔔", "💎", "7️⃣"};
    private static final String[] SLOT_NAMES = {"CHERRY", "LEMON", "BELL", "DIAMOND", "SEVEN"};
    private final int[] lastSlots = new int[3];

    public slots(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        RetroStyle.styleScreen(slotsMainPanel);
        RetroStyle.styleTitle(slotsTitleLabel, "★  SLOT MACHINE  ★");
        RetroStyle.styleDisplay(slotsDisplay, "<html><center>" + SLOT_SYMBOLS[0] + " 0 &nbsp; "
                + SLOT_SYMBOLS[1] + " 1 &nbsp; " + SLOT_SYMBOLS[2] + " 2<br>"
                + SLOT_SYMBOLS[3] + " 3 &nbsp; " + SLOT_SYMBOLS[4] + " 4<br><br>SPIN TO PLAY</center></html>");
        slotsDisplay.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.BOLD, 18));
        slotsDisplay.setPreferredSize(new java.awt.Dimension(340, 145));
        slotsReturnButtonlimit.addActionListener(e -> {
            screen.showHome();
        });

        slotsBetEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });

        slotsBetEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(slotsBetEntry.getText().trim());
                slotsBetEntry.setText(game.makeValid(bet));
            }
        });

        slotsBetSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = 0;
                try {
                    bet = Integer.parseInt(slotsBetEntry.getText().trim());
                }  catch (NullPointerException | NumberFormatException ex) {
                    bet = 0;
                } finally {
                    slotsBetEntry.setText(game.makeValid(bet));
                }
                int betAmount = Integer.parseInt(slotsBetEntry.getText());

                game.creditsWagered+= betAmount;

                if (betAmount == wallet.getMoney()) {
                    game.allIns++;
                }

                int outcome = spin();
                slotsDisplay.setText("<html><center>" + slotResult(0) + " &nbsp; " + slotResult(1)
                        + " &nbsp; " + slotResult(2) + "<br><br>"
                        + (outcome == 0 ? "NO MATCH - TRY AGAIN" : "PAYOUT x" + outcome)
                        + "</center></html>");
                slotsDisplay.setForeground(outcome == 0 ? new java.awt.Color(255, 111, 126) : RetroStyle.MINT);

                if (outcome != 0) {
                    wallet.addMoney(betAmount * outcome);
                    game.wins++;
                    game.moneyWon+= betAmount * outcome;

                } else {
                    wallet.subtractMoney(betAmount);
                    game.losses++;
                    game.moneyLost+= betAmount;
                }
                game.roundsPlayed++;

            }
        });
    }

    public int spin() {
        int slot1 = lastSlots[0] = game.weightedRandom(weights);
        int slot2 = lastSlots[1] = game.weightedRandom(weights);
        int slot3 = lastSlots[2] = game.weightedRandom(weights);

        if (slot1 == 4 && slot2 == 4 && slot3 == 4) {
            return 25;
        } else if (slot1 == 3 && slot2 == 3 && slot3 == 3) {
            return 15;
        } else if (slot1 == 2 && slot2 == 2 && slot3 == 2) {
            return 10;
        } else if (slot1 == 1 && slot2 == 1 && slot3 == 1) {
            return 5;
        } else if (slot1 == 0 && slot2 == 0 && slot3 == 0) {
            return 3;
        } else if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3) {
            return 1;
        } else return 0;
    }

    private String slotResult(int reel) {
        int value = lastSlots[reel];
        return SLOT_SYMBOLS[value] + "<br>" + SLOT_NAMES[value] + " [" + value + "]";
    }

    public JPanel getSlotsMainPanel() {
        return slotsMainPanel;
    }


}
