package application;

import tictactoe.Simbolos;
import tictactoe.TicTacToeMatch;

public class UI {

    public static void printCampo(Simbolos[][] campo) {
        System.out.print("\n  0  1  2");
        for (int i = 0; i < campo.length; i++) {
            System.out.printf("\n%d", i);
            for (int j = 0; j < campo.length; j++) {
                if (campo[i][j] == null) {
                    System.out.printf(" - ");
                } else {
                    System.out.print(" " + campo[i][j] + " ");
                }
            }
        }
    }

    public static void printVencedor(TicTacToeMatch ticTacToeMatch) {
        if (ticTacToeMatch.temVencedor()) {
            System.out.println("\n\nO vencendor é o jogador com simbolo: " + ticTacToeMatch.getJogador());
        } else {
            System.out.println("\n\nDeu velha");
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
