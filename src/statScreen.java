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
    private JLabel moneyLost;
    private final Game game;

    public statScreen(mainScreen screen, Wallet wallet, Debt debt) {
        this.game = new Game(wallet);
        RetroStyle.styleScreen(statScreenMainPanel);
        RetroStyle.styleTitle(statScreenMainLabel, "★  PLAYER STATS  ★");
        statScreenCenterPanel.setBackground(RetroStyle.PANEL);
        statScreenCenterPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(75, 96, 140), 2),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        for (JLabel value : new JLabel[]{walletBalance, roundsPlayed, wins, losses, winRate,
                creditsWagered, creditsWon, allIns, balance, moneyLost}) {
            value.setForeground(RetroStyle.GOLD);
            value.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.BOLD, 12));
        }
        hideSpacers(statScreenCenterPanel);
        statScreenReturnButton.addActionListener(e -> {
            screen.showHome();
        });
        javax.swing.Timer statsTimer = new javax.swing.Timer(100, e -> {
            walletBalance.setText(wallet.moneyToString() + "$");
            roundsPlayed.setText(String.valueOf(game.roundsPlayed));
            wins.setText(String.valueOf(game.wins));
            losses.setText(String.valueOf(game.losses));

            winRate.setText(String.format("%.1f%%", game.getWinRate() * 100));

            creditsWagered.setText(game.creditsWagered + "$");
            creditsWon.setText(game.moneyWon + "$");
            allIns.setText(String.valueOf(game.allIns));
            balance.setText((wallet.getMoney() + debt.getDebt()) + "$");
            moneyLost.setText(String.valueOf(game.moneyLost) + "$");
        });
        statsTimer.start();
    }

    public JPanel getStatMainPanel() {
        return statScreenMainPanel;
    }

    private void hideSpacers(java.awt.Container container) {
        for (java.awt.Component component : container.getComponents()) {
            if (component.getClass().getSimpleName().equals("Spacer")) {
                component.setVisible(false);
            } else if (component instanceof java.awt.Container) {
                hideSpacers((java.awt.Container) component);
            }
        }
    }
}
