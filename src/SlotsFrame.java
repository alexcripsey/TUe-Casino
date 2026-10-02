import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SlotsFrame extends JFrame {
    private JPanel panel1;
    private JButton EXITSLOTSButton;

    public SlotsFrame() {
        setContentPane(panel1);
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EXITSLOTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SlotsFrame.this.dispose();
            }
        });
    }
}
