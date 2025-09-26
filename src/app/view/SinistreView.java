package app.view;

import app.controller.SinistreController;
import app.model.EnumSinistre;
import app.model.Sinistre;
import app.utils.ValidationInputs;
import java.time.LocalDateTime;

public class SinistreView {
    private final SinistreController sinistreController;

    public SinistreView(SinistreController sinistreController) {
        this.sinistreController = sinistreController;
    }

    public void menuSinistre() {
        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Sinistre =====");
            System.out.println("1. Ajouter un Sinistre");
            System.out.println("2. Supprimer un Sinistre");
            System.out.println("3. Rechercher un Sinistre par son ID");
            System.out.println("4. Afficher les Sinistres d'un Sinistre");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choix = ValidationInputs.getIntegerInput();
            switch (choix) {
                case 1:
                    this.createView();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    connection = false;
                    break;
                default:
                    System.out.println("Choix Invalide!");
            }
        }
    }

    private void createView() {
        System.out.println("\n+--+--+ Ajouter un Sinistre +--+--+");

        System.out.println("🔹Choisi le type de Sinistre: ");
        EnumSinistre typeSinistre = null;
        while (typeSinistre == null) {
            System.out.println("1. 🏠 MAISON");
            System.out.println("2. 🩺 MALADIE");
            System.out.println("3. 🚗 VOITURE");
            System.out.print("Choix : ");
            int choix = ValidationInputs.getIntegerInput();
            switch (choix) {
                case 1:
                    typeSinistre = EnumSinistre.MAISON;
                    break;
                case 2:
                    typeSinistre = EnumSinistre.MALADIE;
                    break;
                case 3:
                    typeSinistre = EnumSinistre.VOITURE;
                    break;
                default:
                    System.out.println("Choix Invalide!");
            }
        }

        LocalDateTime date = LocalDateTime.now();
        System.out.print("🔹Saisir le montant de Sinistre: ");
        Double montant = ValidationInputs.getMontantInput();
        System.out.print("🔹Saisir la description de Sinistre: ");
        String description = ValidationInputs.getParagraphInput();
        System.out.print("🔹Saisir Id de Contrat: ");
        int contrat_id = ValidationInputs.getIntegerInput();
        Sinistre sinistre = new Sinistre(typeSinistre, date, montant, description, contrat_id);

        System.out.println(this.sinistreController.create(sinistre));
    }
}
