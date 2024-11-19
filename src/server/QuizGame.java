package server;

public class QuizGame extends Thread {

    private Player player1;
    private Player player2;
    private Player activePlayer;

    public QuizGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void run() {

        System.out.println(player1.getName() + " " + player1.receive());
        System.out.println(player2.getName() + " " + player2.receive());

        activePlayer = player1;
        player2.send("inaktiv");

        String input;
        while (true) {

            try {
                if ((input = activePlayer.receive()) != null) {
                    System.out.println(activePlayer.getName() + " " + input);
                    activePlayer.send("inaktiv");
                    activePlayer = activePlayer.getOpponent();
                    activePlayer.send("aktiv");
                }
            } catch (RuntimeException e) {
                System.out.println("Active player disconnected");
                break;
            }


        }

    }
}
