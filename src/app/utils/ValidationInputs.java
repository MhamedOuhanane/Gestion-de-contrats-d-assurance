package app.utils;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationInputs {
    private static final Scanner scanner = new Scanner(System.in);

    public static double getMontantInput() {
        Double input = null;
        while (input == null) {
            try {
                input = scanner.nextDouble();
                if (input < 0) throw new InputMismatchException("Le montant ne peut pas être saisi sous forme de valeur négative.");
            } catch (InputMismatchException exc) {
                System.out.println("🚫 Erreur : veuillez entrer un nombre entier positif.");
                scanner.nextLine();
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez le montant: ");
        }

        return input;
    }

    public static int getIntegerInput() {
        Integer input = null;
        while (input == null) {
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input < 0) throw new InputMismatchException("Le choix est negative.");
            } catch (InputMismatchException exc) {
                System.out.println("🚫 Erreur : veuillez entrer un nombre entier positif.");
                scanner.nextLine();
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez votre choix: ");
        }
        return input;
    }

    public static String getInfoStringInput(String type) {
        String input = null;
        while (input == null) {
            try {
                input = scanner.nextLine();
                String regexName = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s'-]{2,50}$";
                String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                boolean pattern = Pattern.matches(Objects.equals(type, "email") ? regexEmail : regexName, input);
                if (!pattern) throw new InputMismatchException("⚠️ Le " + type + " saisi est invalide. ");
            } catch (InputMismatchException exc) {
                System.out.println("🚫 Le " + type + " saisi est invalide." );
                input = null;
            }
            if (input == null) System.out.print("Ré-entrez votre choix: ");
        }
        return input;
    }
}
