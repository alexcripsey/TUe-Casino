import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {
    private JPanel panel1;
    private JButton diceRollButton;
    private JButton slotsButton;
    private JButton rouletteButton;
    private JButton coinTossButton;


    public MainScreen() {
        setContentPane(panel1);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coinTossButton.addActionListener(e -> {
            System.out.println("Dice button clicked!");
            TossFrame toss = new TossFrame();
            toss.setVisible(true);
        });

        diceRollButton.addActionListener(e -> {
            RollFrame roll = new RollFrame();
            roll.setVisible(true);
        });

        slotsButton.addActionListener(e -> {
            SlotsFrame slots = new SlotsFrame();
            slots.setVisible(true);
        });

        rouletteButton.addActionListener(e -> {
            RouletteFrame roulette = new RouletteFrame();
            roulette.setVisible(true);
        });    }
}
