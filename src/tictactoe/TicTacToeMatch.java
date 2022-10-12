package tictactoe;

import java.util.Scanner;

/**
 * TicTacToeMatch
 */
public class TicTacToeMatch {
    private Character[][] campo;
    private final int linhas = 3;
    private final int colunas = 3;

    public TicTacToeMatch() {
        inicializarCampo();
    }

    // Inicializa todos os campos com null
    public Character[][] inicializarCampo() {
        verificarCampo(linhas, colunas);
        campo = new Character[linhas][colunas];
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                campo[i][j] = null;
            }
        }
        return campo;
    }

    // Adiciona um simbolo na posição indicada
    public Character[][] movimentar(Scanner sc) {
        String posicao = sc.nextLine();
        int linha = transformarLinha(posicao);
        int coluna = transformarColuna(posicao);

        verficarSeTemSimbolo(linha, coluna);
        campo[linha][coluna] = 'X';

        return campo;
    }

    private void verificarCampo(int linhas, int colunas) {
        if (linhas != 3 && colunas != 3) {
            throw new TicaTacToeException("Error: Não foi possivel inicializar o campo");
        }
    }

    private void verficarSeTemSimbolo(int linha, int coluna) {
        if (campo[linha][coluna] != null) {
            throw new TicaTacToeException("Error: Já existe um simbolo nesta posição");
        }
    }

    private int transformarLinha(String posicao) {
        String[] vetor = posicao.split("");
        if (vetor.length != 2) {
            throw new TicaTacToeException("Error: Posição inválida");
        }
        return Integer.parseInt(vetor[0]);
    }

    private int transformarColuna(String posicao) {
        String coluna = posicao.substring(1);
        return Integer.parseInt(coluna);
    }
}