import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class coinToss extends JFrame {
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

    public coinToss(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
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

    }

    public JPanel getCoinTossPanel () {
        return coinTossMainPanel;
    }
}
