import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class coinToss extends JFrame {
    private static final Color CABINET = new Color(18, 24, 46);
    private static final Color PANEL = new Color(29, 39, 68);
    private static final Color GOLD = new Color(255, 204, 70);
    private static final Color MINT = new Color(91, 231, 190);
    private static final Color INK = new Color(19, 25, 44);
    private JPanel coinTossMainPanel;
    private JTextField betEntry;
    private JComboBox betChoice;
    private JButton betSubmit;
    private JPanel coinTossCenterPanel;
    private JPanel coinTossTopPanel;
    private JPanel coinTossBottomPanel;
    private JLabel coinTossTitleLabel;
    private JLabel coinTossImage;
    private JButton coinTossReturnButton;
    private final Game game;
    private final Random r = new Random();
    private String lastFace = "Heads";

    public coinToss(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        applyRetroStyle();
        coinTossReturnButton.addActionListener(e -> {
            screen.showHome();
        });
        betEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });

        betEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(betEntry.getText().trim());
                betEntry.setText(game.makeValid(bet));
            }
        });

        betSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = 0;
                try {
                    bet = Integer.parseInt(betEntry.getText().trim());
                } catch (NullPointerException | NumberFormatException ex) {
                    bet = 0;
                } finally {
                    betEntry.setText(game.makeValid(bet));
                }
                int betAmount = Integer.parseInt(betEntry.getText());
                game.creditsWagered += betAmount;
                if (betAmount == wallet.getMoney()) {
                    game.allIns++;
                }

                int selectedIndex = betChoice.getSelectedIndex();

                boolean won = toss(selectedIndex);
                coinTossImage.setText("◉  " + lastFace.toUpperCase() + (won ? " - WIN!  ◉" : " - LOSE  ◉"));
                coinTossImage.setForeground(won ? MINT : new Color(255, 111, 126));
                if (won) {
                    wallet.addMoney(betAmount);
                    game.wins++;
                    game.moneyWon += betAmount;
                } else {
                    wallet.subtractMoney(betAmount);
                    game.losses++;
                }

                game.roundsPlayed++;
            }
        });
    }

    private void applyRetroStyle() {
        Font pixelFont = new Font(Font.MONOSPACED, Font.BOLD, 15);
        Font smallFont = new Font(Font.MONOSPACED, Font.BOLD, 13);

        coinTossMainPanel.setBackground(CABINET);
        coinTossMainPanel.setBorder(new CompoundBorder(
                new LineBorder(GOLD, 3), new EmptyBorder(16, 20, 16, 20)));
        coinTossTopPanel.setBackground(CABINET);
        coinTossCenterPanel.setBackground(PANEL);
        coinTossCenterPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(75, 96, 140), 2), new EmptyBorder(42, 28, 42, 28)));
        coinTossBottomPanel.setBackground(CABINET);
        coinTossBottomPanel.setBorder(new EmptyBorder(16, 0, 0, 0));

        coinTossTitleLabel.setText("★  COIN TOSS  ★");
        coinTossTitleLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        coinTossTitleLabel.setForeground(GOLD);
        coinTossTitleLabel.setBorder(new EmptyBorder(0, 0, 16, 0));

        coinTossImage.setText("◉  FLIP THE COIN  ◉");
        coinTossImage.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        coinTossImage.setForeground(GOLD);
        coinTossImage.setPreferredSize(new Dimension(400, 145));

        for (Component component : coinTossBottomPanel.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setFont(smallFont);
                label.setForeground(MINT);
            }
        }
        betEntry.setFont(pixelFont);
        betEntry.setForeground(GOLD);
        betEntry.setCaretColor(GOLD);
        betEntry.setBackground(INK);
        betEntry.setBorder(new CompoundBorder(new LineBorder(GOLD, 2), new EmptyBorder(7, 9, 7, 9)));
        betChoice.setFont(smallFont);
        betChoice.setForeground(GOLD);
        betChoice.setBackground(INK);
        betChoice.setBorder(new LineBorder(new Color(75, 96, 140), 2));

        styleButton(betSubmit, "TOSS!");
        styleButton(coinTossReturnButton, "← RETURN");
    }

    private void styleButton(JButton button, String text) {
        button.setText(text);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        button.setForeground(INK);
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(new CompoundBorder(new LineBorder(new Color(255, 231, 151), 2),
                new EmptyBorder(8, 12, 8, 12)));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            button.setBackground(model.isPressed() ? MINT : model.isRollover() ? new Color(255, 222, 112) : GOLD);
        });
    }

    public boolean toss(int selectedIndex) {
        int r_toss = r.nextInt(2);
        lastFace = r_toss == 0 ? "Heads" : "Tails";
        if (selectedIndex == r_toss) {
            return true;
        } else return false;
    }

    public JPanel getCoinTossPanel() {
        return coinTossMainPanel;
    }
}
