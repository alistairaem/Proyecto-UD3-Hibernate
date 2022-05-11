package view;

import java.util.Scanner;

public class Teclado {
    Scanner scan = new Scanner(System.in);

    public String pideString(String mensaje) {
        String texto = "";
        scan.useDelimiter("\n");
        System.out.print(mensaje);
        texto = scan.next();

        return texto;
    }

    public int pideInt(String mensaje) {
        int num = 0;
        boolean ok = false;
        do {
            try {
                System.out.print(mensaje);
                num = scan.nextInt();
                ok = true;
            } catch (java.util.InputMismatchException e) {
                ok = false;
                scan.useDelimiter("\n");
                scan.next();
            }
        } while (!ok);

        return num;
    }
}
