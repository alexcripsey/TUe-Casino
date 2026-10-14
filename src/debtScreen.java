import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class debtScreen {
    private JPanel panel1;
    private JPanel debtScreenTopPanel;
    private JPanel debtScreenBottomPanel;
    private JPanel debtScreenMainPanel;
    private JLabel debtMainLabel;
    private JTextField loanEntry;
    private JTextField paymentEntry;
    private JButton loanButton;
    private JButton debtButton;
    private JButton returnButton;
    private JLabel debtAmount;
    private JButton statScreenReturnButton;
    private final Game game;

    public debtScreen(mainScreen screen, Wallet wallet, Debt debt) {
        this.game = new Game(wallet);
        returnButton.addActionListener(e -> {
            screen.showHome();
        });

        javax.swing.Timer timer = new javax.swing.Timer(20000, e -> {
            debtAmount.setText(debt.debtToString());
        });
        timer.start();

        loanEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });

        loanEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(loanEntry.getText().trim());
                loanEntry.setText(game.makeValid(bet));
            }
        });
        loanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int loan = Integer.parseInt(loanEntry.getText());
                debt.getLoan(loan);

            }
        });

        paymentEntry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });

        paymentEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(paymentEntry.getText().trim());
                paymentEntry.setText(game.makeValid(bet));
            }
        });
        debtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int payment = Integer.parseInt(paymentEntry.getText());
                debt.payDebt(payment);

            }
        });
    }

    public JPanel getDebtMainPanel() {
        return panel1;
    }
}
