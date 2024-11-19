package server;

public class QuizGame extends Thread {

    Player player1;
    Player player2;
    Player activePlayer;

    public QuizGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    @Override
    public void run() {

            System.out.println(player1.receive());
            System.out.println(player2.receive());

            activePlayer = player1;

            String input = "";

            while ((input = activePlayer.receive()) != null) {
                System.out.println(input);
            }

    }
}
