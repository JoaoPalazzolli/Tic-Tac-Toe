package application;

import java.util.Scanner;

import tictactoe.TicTacToeMatch;
import tictactoe.TicaTacToeException;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToeMatch velha = new TicTacToeMatch();
        UI.printCampo(velha.inicializarCampo());

        while (!velha.fimDoJogo()) {
            try {

                System.out.print("\n\nDigite a cordenada: ");
                UI.printCampo(velha.movimentar(sc));

            } catch (TicaTacToeException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

    }
}
