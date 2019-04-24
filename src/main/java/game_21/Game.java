package game_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> gameTeam = new ArrayList<Player>();

    public void startGame() {
        System.out.println("You join to 21 game");
        System.out.println(" \n" + "How many players will participate ? ");
        System.out.println("Enter number :");
        Scanner sc = new Scanner(System.in);
        int numOfPl = sc.nextInt();

        for (int i = 1, n = numOfPl; i <= n; i++) {
            gameTeam.add(new Player(i));
        }
        System.out.println("New game for " + numOfPl + " people");
        System.out.println();
        System.out.println();
        firstRound();
        setOfCards();
        winnerChoise();

    }

    public void firstRound() {
        System.out.println("All players take one card ");
        System.out.println();
        for (Player i : gameTeam) {
            i.getOneMoreCard();
            System.out.println(i.toString() + " you get a card");
            System.out.println(i.showCards());
            System.out.println();
            System.out.println();
        }
    }

    public void setOfCards() {
        int check = gameTeam.size();
        while (check != 0) {
            for (Player i : gameTeam) {
                System.out.println();
                System.out.println(i.toString() + "you have " + i.getPointSumm() + " points");
                System.out.println("Do you want to get a card ?");
                System.out.println("If YES, enter Y, if not, enter any other character");
                Scanner sc = new Scanner(System.in);
                String answer = sc.nextLine();
                if (answer.toUpperCase().equals("Y")) {
                    i.getOneMoreCard();
                    System.out.println(i.showCards());
                    if (i.getPointSumm() >= 22) {
                        System.out.println(i.toString() + " you scored more than 22 points and lost");
                        check = check - 1;
                        gameTeam.remove(i);
                        break;
                    }
                    if (i.getPointSumm() == 21) {
                        System.out.println(i.toString() + " you scored 21 points and won!");
                        System.exit(0);
                    } else {
                        System.out.println();
                    }
                } else {
                    check = check - 1;
                    System.out.println();
                }
            }
        }
    }

    public void winnerChoise(){

        Collections.sort(gameTeam, Player.pointComparator);
        int j = 1;
        for (Player i : gameTeam){

            System.out.println(j+" take place "+i.toString()+"with score " + i.getPointSumm());
            j=j+1;
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
