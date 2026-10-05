import javax.swing.*;

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


    public slots(mainScreen screen) {
        slotsReturnButtonlimit.addActionListener(e -> {
            screen.showHome();
        });
    }

    public JPanel getSlotsMainPanel() {
        return slotsMainPanel;
    }


}
