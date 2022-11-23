package application;

import java.util.Scanner;
import tictactoe.Simbolos;
import tictactoe.TicTacToeMatch;
import tictactoe.TicaTacToeException;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToeMatch velha = new TicTacToeMatch();

        while (!velha.fimDoJogo()) {
            try {
                if (velha.getJogador().equals(Simbolos.S)) {
                    UI.clearScreen();
                    System.out.print("Selecione o simbolo que deseja jogar (X / O): ");
                    String simbolo = sc.nextLine().toUpperCase().substring(0);
                    velha.selecionarSimbolo(simbolo);
                }

                UI.clearScreen();
                UI.printCampo(velha.pegarCampo());
                System.out.print("\n\nDigite a cordenada: ");
                velha.movimentar(sc);

            } catch (TicaTacToeException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printCampo(velha.pegarCampo());
        UI.printVencedor(velha);
        sc.nextLine();
    }
}
