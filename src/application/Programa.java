package application;

import java.util.Scanner;

import tictactoe.TicTacToeMatch;
import tictactoe.TicaTacToeException;

public class Programa {
    public static void main(String[] args) {
        TicTacToeMatch velha = new TicTacToeMatch();
        UI.printCampo(velha.inicializarCampo());
        Scanner sc = new Scanner(System.in);

        while (true) {
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
