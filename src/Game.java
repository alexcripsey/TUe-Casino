public class Game {
    private final Wallet wallet;

    public Game (Wallet wallet) {
        this.wallet = wallet;
    }
    public String makeValid(int bet) {
        if (bet <= 0){
            return "1";
        } else if (bet > wallet.money) {
            StringBuilder str = new StringBuilder();
            bet = wallet.money;
            str.append(bet);
            return str.toString();
        }else {
            StringBuilder str = new StringBuilder();
            str.append(bet);
            return str.toString();
        }
    }
    public void isValid(){

    }
}
