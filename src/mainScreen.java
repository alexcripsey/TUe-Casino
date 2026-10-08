import javax.swing.*;
import java.awt.*;


public class mainScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel coinToss;
    private JButton diceRollButton;
    private JButton slotsButton;
    private JButton rouletteButton;
    private JButton coinTossButton;
    private JPanel contentPanel;
    private JPanel buttonSelectPanel;
    private coinToss coinTossForm;
    private diceRoll diceRollForm;
    private roulette rouletteForm;
    private slots slotsForm;
    private final Wallet wallet = new Wallet();


    public mainScreen() {
        setVisible(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);

        coinTossForm = new coinToss(this, wallet);
        diceRollForm = new diceRoll(this, wallet);
        rouletteForm = new roulette(this, wallet);
        slotsForm = new slots(this);

        diceRollButton.addActionListener(e -> {
            showPanel(diceRollForm.getDiceRollPanel());
        });

        coinTossButton.addActionListener( e -> {
            showPanel(coinTossForm.getCoinTossPanel());
        });

        slotsButton.addActionListener( e -> {
            showPanel((slotsForm.getSlotsMainPanel()));
        });

        rouletteButton.addActionListener(e -> {
            showPanel(rouletteForm.getRouletteMainPanel());
        });


    }

    public void showHome() {
        showPanel(buttonSelectPanel);
    }

    private void showPanel(JPanel newPanel) {
        if (newPanel == null) {
            return;
        }

        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(newPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
