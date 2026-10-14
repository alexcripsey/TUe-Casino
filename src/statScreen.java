import javax.swing.*;

public class statScreen {
    private JPanel statScreenMainPanel;
    private JPanel statScreenTopPanel;
    private JPanel statScreenCenterPanel;
    private JLabel statScreenMainLabel;
    private JPanel statScreenBottomPanel;
    private JButton statScreenReturnButton;
    private JLabel walletBalance;
    private JLabel roundsPlayed;
    private JLabel wins;
    private JLabel losses;
    private JLabel winRate;
    private JLabel creditsWagered;
    private JLabel creditsWon;
    private JLabel allIns;
    private JLabel balance;
    private final Game game;

    public statScreen(mainScreen screen, Wallet wallet, Debt debt) {
        this.game = new Game(wallet);
        statScreenReturnButton.addActionListener(e -> {
            screen.showHome();
        });


        javax.swing.Timer timer = new javax.swing.Timer(100, e -> {
            walletBalance.setText(wallet.moneyToString() + "$");
        });
        timer.start();

        javax.swing.Timer timer1 = new javax.swing.Timer(100, e -> {
            roundsPlayed.setText(String.valueOf(game.roundsPlayed));
        });
        timer1.start();

        javax.swing.Timer timer2 = new javax.swing.Timer(100, e -> {
            wins.setText(String.valueOf(game.wins));
        });
        timer2.start();

        javax.swing.Timer timer3 = new javax.swing.Timer(100, e -> {
            losses.setText(String.valueOf(game.losses));
        });
        timer3.start();

        javax.swing.Timer timer4 = new javax.swing.Timer(100, e -> {
            winRate.setText(String.valueOf(game.winRate));
        });
        timer4.start();

        javax.swing.Timer timer5 = new javax.swing.Timer(100, e -> {
            creditsWagered.setText(String.valueOf(game.creditsWagered) + "$");
        });
        timer5.start();

        javax.swing.Timer timer6 = new javax.swing.Timer(100, e -> {
           creditsWon.setText(String.valueOf(game.moneyWon) + "$");
        });
        timer6.start();

        javax.swing.Timer timer7 = new javax.swing.Timer(100, e -> {
            allIns.setText(String.valueOf(game.allIns));
        });
        timer7.start();

        javax.swing.Timer timer8 = new javax.swing.Timer(100, e -> {
            balance.setText(String.valueOf( wallet.getMoney() + debt.getDebt()) + "$");
        });
        timer8.start();
    }

    public JPanel getStatMainPanel() {
        return statScreenMainPanel;
    }
}
