import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String input;
        System.out.println("2048 game.");
        PlayGround playGround = new PlayGround();
        playGround.generate();
        playGround.print();
        do {
            System.out.println("Please enter a direction: up, down, left, right");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if ("u".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.UP);
                playGround.generate();
                playGround.print();
            } else if ("d".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.DOWN);
                playGround.generate();
                playGround.print();
            } else if ("r".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.RIGHT);
                playGround.generate();
                playGround.print();
            } else if ("l".equalsIgnoreCase(input)) {
                playGround.move(PlayGround.LEFT);
                playGround.generate();
                playGround.print();
            } else if ("reset".equalsIgnoreCase(input)) {
                System.out.println("Game reset!");
//                playGround.reset();
//                playGround.print();
            } else {
                System.out.println("Input not recognized");
            }
        } while (!playGround.gameFinished());
    }
}

