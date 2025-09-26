package app.view;

import app.controller.ConseillerController;
import app.utils.ValidationInputs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConseillerView {
    private ConseillerController conseillerController;

    public ConseillerView(ConseillerController conseillerController) {
        this.conseillerController = conseillerController;
    }

    public void menuConseiller() {
        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Conseiller =====");
            System.out.println("1. Ajouter un Conseiller");
            System.out.println("2. Supprimer un Conseiller");
            System.out.println("3. Rechercher un Conseiller");
            System.out.println("4. Afficher les clients d'un conseiller");
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
        System.out.println("\n+--+--+ Ajouter un Conseiller +--+--+");
        System.out.print("🔹Saisir le nom de Conseiller: ");
        String nom = ValidationInputs.getInfoStringInput("nom");
        System.out.print("🔹Saisir le prenom de Conseiller: ");
        String prenom = ValidationInputs.getInfoStringInput("prenom");
        System.out.print("🔹Saisir l'email de Conseiller: ");
        String email = ValidationInputs.getInfoStringInput("email");
        Map<String, Object> conseillerInfo = new HashMap<>();
        conseillerInfo.put("nom", nom);
        conseillerInfo.put("prenom", prenom);
        conseillerInfo.put("email", email);

        System.out.println(this.conseillerController.create(conseillerInfo));
    }
}
