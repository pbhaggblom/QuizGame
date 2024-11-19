package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public Server() {
        try (ServerSocket ss =new ServerSocket(55555)) {
            while (true) {
                Player player1 = new Player(ss.accept(), "Player1");
                Player player2 = new Player(ss.accept(), "Player 2");
                QuizGame newGame = new QuizGame(player1, player2);
                newGame.start();
                newGame.setPlayer2(player2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
