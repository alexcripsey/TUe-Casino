import javax.swing.*;
import java.awt.*;


public class mainScreen extends JFrame {
    private final String imagePath = "casino_bg.png";
    private JPanel mainPanel;
    private JPanel coinToss;
    private JButton diceRollButton;
    private JButton slotsButton;
    private JButton rouletteButton;
    private JButton coinTossButton;
    private JPanel contentPanel;
    private JPanel buttonSelectPanel;
    private coinToss coinTossForm;
    private diceRoll diceRollForm;
    private roulette rouletteForm;
    private slots slotsForm;
    private statScreen statForm;
    private debtScreen debtForm;
    private final Wallet wallet = new Wallet();
    private final Debt debt = new Debt(wallet);
    private JLabel popUp;
    private JLabel amountOfMoney;
    private JButton statButton;
    private JButton debtButton;
    private JLabel amountOfDebt;
    private final Quotes quotes = new Quotes();


    public mainScreen() {
        setVisible(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);

        coinTossForm = new coinToss(this, wallet);
        diceRollForm = new diceRoll(this, wallet);
        rouletteForm = new roulette(this, wallet);
        slotsForm = new slots(this, wallet);
        statForm = new statScreen(this, wallet, debt);
        debtForm = new debtScreen(this, wallet, debt);


        showHome();

        diceRollButton.addActionListener(e -> {
            showPanel(diceRollForm.getDiceRollPanel());
        });

        coinTossButton.addActionListener( e -> {
            showPanel(coinTossForm.getCoinTossPanel());
        });

        slotsButton.addActionListener( e -> {
            showPanel((slotsForm.getSlotsMainPanel()));
        });

        rouletteButton.addActionListener(e -> {
            showPanel(rouletteForm.getRouletteMainPanel());
        });

        statButton.addActionListener(e -> {
            showPanel(statForm.getStatMainPanel());
        });

        debtButton.addActionListener(e -> {
            showPanel(debtForm.getDebtMainPanel());
        });

        javax.swing.Timer timer = new javax.swing.Timer(20000, e -> {
            popUp.setText(quotes.getQuote());
        });
        timer.start();

        javax.swing.Timer timer1 = new javax.swing.Timer(100, e -> {
            amountOfMoney.setText(wallet.moneyToString() + "$");
            amountOfDebt.setText(debt.debtToString());

        });
        timer1.start();
    }

    public void showHome() {
        showPanel(buttonSelectPanel);
    }

    private void showPanel(JPanel newPanel) {
        if (newPanel == null) {
            return;
        }

        newPanel.setOpaque(false);
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(newPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void createUIComponents() {
        contentPanel = new ImagePanel(imagePath);
    }

    private static class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(String fileName) {
            setOpaque(false);
            try {
                java.net.URL imgUrl = getClass().getResource("/" + fileName);
                if (imgUrl == null) {
                    imgUrl = getClass().getResource(fileName);
                }

                if (imgUrl != null) {
                    image = javax.imageio.ImageIO.read(imgUrl);

                    if (image == null) {
                        image = Toolkit.getDefaultToolkit().createImage(imgUrl);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.setColor(Color.RED);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}
