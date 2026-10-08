import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class slots extends JFrame {
    private JPanel slotsMainPanel;
    private JTextField slotsBetEntry;
    private JComboBox slotsBetChoice;
    private JButton slotsBetSubmit;
    private JPanel slotsTopPanel;
    private JPanel slotBottomPanel;
    private JPanel slotsCenterPanel;
    private JLabel slotsTitleLabel;
    private JButton slotsReturnButtonlimit;
    private final Game game;
    private final Random r = new Random();

    public slots(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
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
                //check if bet amount is less than wallet
                int betAmount = Integer.parseInt(slotsBetEntry.getText());
                int selectedIndex = slotsBetChoice.getSelectedIndex();

                int outcome = spin();

                if (outcome != 0) {
                    wallet.addMoney(betAmount * outcome);
                } else {
                    wallet.subtractMoney(betAmount);
                }

                System.out.println(wallet.getMoney());
            }
        });
    }

    public int spin() {
        int slot1 = r.nextInt(5);
        int slot2 = r.nextInt(5);
        int slot3 = r.nextInt(5);

        if (slot1 == 0 && slot2 == 0 && slot3 == 0) {
            return 25;
        } else if (slot1 == 1 && slot2 == 1 && slot3 == 1) {
            return 15;
        } else if (slot1 == 2 && slot2 == 2 && slot3 == 2) {
            return 10;
        } else if (slot1 == 3 && slot2 == 3 && slot3 == 3) {
            return 5;
        } else if (slot1 == 4 && slot2 == 4 && slot3 == 4) {
            return 3;
        } else if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3) {
            return 1;
        } else return 0;
    }

    public JPanel getSlotsMainPanel() {
        return slotsMainPanel;
    }


}
