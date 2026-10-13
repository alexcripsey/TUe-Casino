import javax.swing.*;

public class statScreen {
    private JPanel statScreenMainPanel;
    private JPanel statScreenTopPanel;
    private JPanel statScreenCenterPanel;
    private JLabel statScreenMainLabel;
    private JPanel statScreenBottomPanel;
    private JButton statScreenReturnButton;
    private final Game game;

    public statScreen(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        statScreenReturnButton.addActionListener(e -> {
            screen.showHome();
        });
    }

    public JPanel getStatMainPanel() {
        return statScreenMainPanel;
    }
}
