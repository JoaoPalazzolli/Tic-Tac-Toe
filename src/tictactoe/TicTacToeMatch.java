package tictactoe;

import java.util.Scanner;

/**
 * TicTacToeMatch
 */
public class TicTacToeMatch {
    private Simbolos[][] campo;
    private Simbolos jogador;
    private final int linhas = 3;
    private final int colunas = 3;

    // Simbolos.S == Sem valor
    public TicTacToeMatch() {
        jogador = Simbolos.S;
        inicializarCampo();
    }

    public Simbolos getJogador() {
        return jogador;
    }

    // Inicializa todos os campos com null
    public void inicializarCampo() {
        verificarCampo(linhas, colunas);
        campo = new Simbolos[linhas][colunas];
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                campo[i][j] = null;
            }
        }
    }

    public Simbolos[][] pegarCampo() {
        return campo;
    }

    // Adiciona um simbolo na posição indicada
    public Simbolos[][] movimentar(Scanner sc) {
        String posicao = sc.nextLine();

        int linha = transformarLinha(posicao);
        int coluna = transformarColuna(posicao);

        verficarSeTemSimbolo(linha, coluna);
        campo[linha][coluna] = jogador;

        if (!fimDoJogo()) {
            mudarTurno();
        }

        return campo;
    }

    public boolean fimDoJogo() {
        if (temVencedor() || verificarVelha()) {
            return true;
        }
        return false;
    }

    public boolean temVencedor() {
        if (verificarVitoria()) {
            return true;
        }
        return false;
    }

    public void selecionarSimbolo(String simbolo) {
        if (simbolo.length() != 1) {
            throw new TicaTacToeException("Error: digite apenas 1 simbolo");
        }
        if (!simbolo.equals("X") && !simbolo.equals("O")) {
            throw new TicaTacToeException("Error: simbolo inválido");
        }
        if (simbolo.equals("X")) {
            jogador = Simbolos.X;
        } else {
            jogador = Simbolos.O;
        }
    }

    private boolean verificarVelha() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo.length; j++) {
                if (campo[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void verificarCampo(int linhas, int colunas) {
        if (linhas != 3 || colunas != 3) {
            throw new TicaTacToeException("Error: Não foi possivel inicializar o campo");
        }
    }

    private void verficarSeTemSimbolo(int linha, int coluna) {
        if (campo[linha][coluna] != null) {
            throw new TicaTacToeException("Error: Já existe um simbolo nesta posição");
        }
    }

    private int transformarLinha(String posicao) {
        String[] valor = posicao.split("");
        if (posicao.length() != 2) {
            throw new TicaTacToeException("Error: Posição inválida");
        }
        if (valor[0].matches("[^\\d]+") || valor[1].matches("[^\\d]+")) {
            throw new NumberFormatException("Error: O valor digitado é inválido");
        }
        return Integer.parseInt(valor[0]);
    }

    private int transformarColuna(String posicao) {
        String coluna = posicao.substring(1);
        return Integer.parseInt(coluna);
    }

    private void mudarTurno() {
        jogador = (jogador == Simbolos.X) ? Simbolos.O : Simbolos.X;
    }

    private boolean verificarVitoria() {
        // horizontal
        if (campo[0][0] == jogador && campo[0][1] == jogador && campo[0][2] == jogador) {
            return true;
        }
        if (campo[1][0] == jogador && campo[1][1] == jogador && campo[1][2] == jogador) {
            return true;
        }
        if (campo[2][0] == jogador && campo[2][1] == jogador && campo[2][2] == jogador) {
            return true;
        }

        // vertical
        if (campo[0][0] == jogador && campo[1][0] == jogador && campo[2][0] == jogador) {
            return true;
        }
        if (campo[0][1] == jogador && campo[1][1] == jogador && campo[2][1] == jogador) {
            return true;
        }
        if (campo[0][2] == jogador && campo[1][2] == jogador && campo[2][2] == jogador) {
            return true;
        }

        // diagonal
        if (campo[0][0] == jogador && campo[1][1] == jogador && campo[2][2] == jogador) {
            return true;
        }
        if (campo[2][0] == jogador && campo[1][1] == jogador && campo[0][2] == jogador) {
            return true;
        }

        return false;
    }

}