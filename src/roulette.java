import javax.swing.*;

public class roulette {
    private JPanel rouletteMainPanel;
    private JComboBox rouletteBetChoice;
    private JButton rouletteBetSubmit;
    private JPanel rouletteTopPanel;
    private JPanel rouletteCenterPanel;
    private JPanel rouletteBottomPanel;
    private JLabel rouletteTitleLabel;
    private JLabel rouletteImage;
    private JTextField rouletteBetEntry;
    private JButton rouletteReturnButton;

    public roulette(mainScreen screen) {
        rouletteReturnButton.addActionListener(e -> {
            screen.showHome();
        });
    }

    public JPanel getRouletteMainPanel() {
        return rouletteMainPanel;
    }
}
