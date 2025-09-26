package app.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationInputs {
    public static double getMontantInput() {
        Double input = null;
        while (input == null) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextDouble();
                if (input < 0) throw new InputMismatchException("Le montant ne peut pas être saisi sous forme de valeur négative.");
            } catch (InputMismatchException exc) {
                System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez le montant: ");
        }

        return input;
    }

    public static int getIntegerInput() {
        Integer input = null;
        while (input == null) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input < 0) throw new InputMismatchException("Le choix est negative.");
            } catch (InputMismatchException exc) {
                System.out.println("Erreur dans le type d'entrée: " + exc.getMessage());
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez votre choix: ");
        }
        return input;
    }
}
