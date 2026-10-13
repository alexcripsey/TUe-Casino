import javax.swing.*;

public class debtScreen {
    private JPanel panel1;
    private JPanel debtScreenTopPanel;
    private JPanel debtScreenBottomPanel;
    private JPanel debtScreenMainPanel;
    private JLabel debtMainLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton returnButton;
    private JButton statScreenReturnButton;
    private final Game game;

    public debtScreen(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        returnButton.addActionListener(e -> {
            screen.showHome();
        });
    }

    public JPanel getDebtMainPanel() {
        return panel1;
    }
}
