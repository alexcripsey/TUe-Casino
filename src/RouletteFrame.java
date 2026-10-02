import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouletteFrame extends JFrame {
    private JPanel panel1;
    private JButton EXITROULETTEButton;

    public RouletteFrame() {
        setContentPane(panel1);
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EXITROULETTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RouletteFrame.this.dispose();
            }
        });
    }
}