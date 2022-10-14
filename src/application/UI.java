package application;

import tictactoe.Simbolos;

public class UI {

    public static void printCampo(Simbolos[][] campo) {
        System.out.print("\n  0  1  2");
        for (int i = 0; i < campo.length; i++) {
            System.out.printf("\n%d", i);
            for (int j = 0; j < campo.length; j++) {
                if (campo[i][j] == null) {
                    System.out.printf(" - ");
                }
                else{
                    System.out.print(" " + campo[i][j] + " ");
                }
            }
        }
    }

}
