import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TossFrame extends JFrame {
    private JPanel panel1;
    private JButton EXITCOINTOSSButton;

    public TossFrame() {
        setContentPane(panel1);
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EXITCOINTOSSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TossFrame.this.dispose();
            }
        });
    }
}
