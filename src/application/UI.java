package application;

public class UI {

    public static void printCampo(Character[][] campo) {
        System.out.print("  0  1  2");
        for (int i = 0; i < campo.length; i++) {
            System.out.printf("\n%d", i);
            for (int j = 0; j < campo.length; j++) {
                if (campo[i][j] == null) {
                    System.out.printf(" - ");
                }
                else{
                    System.out.printf(" %c ", campo[i][j]);
                }
            }
        }
    }

}
