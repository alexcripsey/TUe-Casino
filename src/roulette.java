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
    private JComboBox evenOrOdd;
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


        rouletteBetSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //probably have some problems when nothing is put in betAmount
                int bet = Integer.parseInt(betEntry.getText());
                betEntry.setText(game.makeValid(bet));
                int betAmount = Integer.parseInt(betEntry.getText());
                String redBlackGreen = betChoice.getSelectedItem().toString();
                //cant bet on even or odd if green is selected
                if (redBlackGreen.equals("Green")){
                    evenOrOdd.setSelectedIndex(0);
                }
                String evenOdd = evenOrOdd.getSelectedItem().toString();

                if(spin(redBlackGreen, evenOdd)) {
                    wallet.money -= betAmount;
                    int moneyWon = won(redBlackGreen, evenOdd, betAmount);
                    wallet.money += moneyWon;
                } else {
                    wallet.money -= betAmount;
                }
                System.out.println(wallet.getMoney());

            }
        });
    }
    public boolean spin(String redBlackGreen, String evenOdd) {

        int r_spin = r.nextInt(37);
        String[] color = {
                "Green", "Red", "Black", "Red", "Black", "Red",
                "Black", "Red", "Black", "Red", "Black", "Black",
                "Red", "Black", "Red", "Black", "Red", "Red",
                "Black", "Red", "Black", "Red", "Black", "Red",
                "Black", "Red", "Black", "Red", "Black", "Black",
                "Red", "Black", "Red", "Black", "Red", "Black",
                "Red"
        };
        System.out.println(r_spin);
        System.out.println(color[r_spin]);

        if(color[r_spin].equals(redBlackGreen) &&
          ((redBlackGreen.equals("Red") || redBlackGreen.equals("Black")) &&
          evenOdd.equals("-"))) {
            //won red or black(2x)
            return true;
        } else if (color[r_spin].equals(redBlackGreen) && redBlackGreen.equals("Green")) {
            //won green(36x)
            return true;
        }else if ((evenOdd.equals("Even") && r_spin % 2 == 0) &&
                  color[r_spin].equals(redBlackGreen) &&
                  (redBlackGreen.equals("Red") || redBlackGreen.equals("Black"))) {
            //won color and even\odd(4x)
            return true;
        } else if ((evenOdd.equals("Odd") && r_spin % 2 != 0) &&
                color[r_spin].equals(redBlackGreen) &&
                (redBlackGreen.equals("Red") || redBlackGreen.equals("Black"))) {
                    //won color and even\odd(4x)
                    return true;
        } else return false;
    }

    public int won(String redBlackGreen, String evenOdd, int betAmount) {
        int n = 0;
        if ((redBlackGreen.equals("Red") || redBlackGreen.equals("Black")) && evenOdd.equals("-")) {
            //won color
             n += betAmount * 2;
        } else if (redBlackGreen.equals("Green")) {
            //won green
             n += betAmount * 36;
        } else if ((redBlackGreen.equals("Red") || redBlackGreen.equals("Black")) &&
                (evenOdd.equals("Even") || evenOdd.equals("Odd"))) {
            //won color and even\odd
             n += betAmount * 4;
        }
        return n;
    }

    public JPanel getRouletteMainPanel() {
        return rouletteMainPanel;
    }
}
