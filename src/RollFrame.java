import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RollFrame extends JFrame {
    private JPanel panel1;
    private JButton EXITDICEROLLButton;

    public RollFrame() {
        setContentPane(panel1);
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EXITDICEROLLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RollFrame.this.dispose();
            }
        });
    }
}
