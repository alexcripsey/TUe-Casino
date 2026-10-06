import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public coinToss(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        coinTossReturnButton.addActionListener(e -> {
            screen.showHome();
        });

        betEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.isInteger(betEntry.getText())) {
                    int bet = Integer.parseInt(betEntry.getText().trim());
                    betEntry.setText(game.makeValid(bet));
                }
            }
        });

        betSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound();
            }
        });
    }
    private void playRound(){


    }

    public JPanel getCoinTossPanel() {
        return coinTossMainPanel;
    }

}
