import javax.swing.*;

public class coinToss {
    private JPanel coinTossMainPanel;
    private JTextField coinTossBetEntry;
    private JComboBox coinTossBetChoice;
    private JButton coinTossBetSubmit;
    private JPanel coinTossCenterPanel;
    private JPanel coinTossTopPanel;
    private JPanel coinTossBottomPanel;
    private JLabel coinTossTitleLabel;
    private JLabel coinTossImage;
    private JButton coinTossReturnButton;

    public coinToss(mainScreen screen) {
        coinTossReturnButton.addActionListener(e -> {
            screen.showHome();
        });
    }

    public JPanel getCoinTossPanel() {
        return coinTossMainPanel;
    }

}
