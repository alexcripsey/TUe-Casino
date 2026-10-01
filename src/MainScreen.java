import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen {
    private JPanel panel1;
    private JButton diceRollButton;
    private JButton slotsButton;
    private JButton rouletteButton;
    private JButton coinTossButton;


    public MainScreen() {
        coinTossButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
}
