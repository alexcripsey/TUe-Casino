import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class roulette extends JFrame {
    private JPanel rouletteMainPanel;
    private JComboBox betChoice;
    private JButton rouletteBetSubmit;
    private JPanel rouletteTopPanel;
    private JPanel rouletteCenterPanel;
    private JPanel rouletteBottomPanel;
    private JLabel rouletteTitleLabel;
    private JLabel rouletteImage;
    private JTextField betEntry;
    private JButton rouletteReturnButton;
    private final Random r = new Random();
    private final Game game;

    public roulette(mainScreen screen, Wallet wallet) {
        this.game = new Game(wallet);
        rouletteReturnButton.addActionListener(e -> {
            screen.showHome();
        });
        betEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bet = Integer.parseInt(betEntry.getText().trim());
                betEntry.setText(game.makeValid(bet));
            }
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


    }
    public boolean spin() {
        int r_spin = r.nextInt(33);
        String[] color = new String[33];
        for (int i = 0; i < color.length; i++) {
            if (i == 0){
                color[i] = "green";
            } else if((i % 2 != 0 || i = 18) && i != 29) {
                    color[i] = "red";
            } else if ((i % 2 == 0 || i = 29) && i != 18){
                color[i] = "black";
            }
        }
    }

    public JPanel getRouletteMainPanel() {
        return rouletteMainPanel;
    }
}
