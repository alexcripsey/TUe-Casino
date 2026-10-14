import java.util.Map;
import java.util.Random;

public class Game {
    private final Wallet wallet;
    private final Random r = new Random();

    public Game (Wallet wallet) {
        this.wallet = wallet;
    }

    public String makeValid(int bet) {
        if (bet <= 0) {
            return "1";
        } else if (bet > wallet.getMoney()) {
            StringBuilder str = new StringBuilder();
            bet = wallet.getMoney();
            str.append(bet);
            return str.toString();
        } else {
            StringBuilder str = new StringBuilder();
            str.append(bet);
            return str.toString();
        }
    }

    public int weightedRandom(Map<Integer, Integer> weights) {
        int sum = 0;
        
        for (int value : weights.values()) {
            sum += value;
        }

        int r_int = r.nextInt(sum);
        int selectedItem = -1; // Declare it OUTSIDE the loop so it's accessible at the return statement

        // 2. Loop and subtract
        for (Map.Entry<Integer, Integer> entry : weights.entrySet()) {
            r_int -= entry.getValue();

            if (r_int < 0) {
                selectedItem = entry.getKey();
                break;
            }
        }
        return selectedItem;
    }
}
