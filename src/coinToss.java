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

    public coinToss(mainScreen screen) {
        Game game = null;
        Wallet wallet;
        coinTossReturnButton.addActionListener(e -> {
            screen.showHome();
        });
        betEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //have to find a way for parseInt not to crash if nothing gets put into betEntry or if it is a text.
                int bet = Integer.parseInt(betEntry.getText());
                betEntry.setText(game.makeValid(bet));
            }
        });
    }

    public JPanel getCoinTossPanel() {
        return coinTossMainPanel;
    }

}
