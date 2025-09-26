package app.view;

import app.controller.ConseillerController;
import app.model.Conseiller;
import app.utils.ValidationInputs;

public class ConseillerView {
    private final ConseillerController conseillerController;

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
                    this.deleteVeiw();
                    break;
                case 3:
                    this.findView();
                    break;
                case 4:
                    this.getClients();
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
        Conseiller conseiller = new Conseiller(nom, prenom, email);

        System.out.println(this.conseillerController.create(conseiller));
    }

    public void deleteVeiw() {
        System.out.println("\n+--+--+ Supprimer un Conseiller +--+--+");
        System.out.print("🔹Saisir Id de Conseiller: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.conseillerController.delete(id));
    }

    public void findView() {
        System.out.println("\n+--+--+ Rechercher un Conseiller +--+--+");
        System.out.print("🔹Saisir Id de Conseiller: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.conseillerController.find(id));
    }

    public void getClients() {
        System.out.println("\n+--+--+ Afficher les clients d'un conseiller +--+--+");
        System.out.print("🔹Saisir Id de Conseiller: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.conseillerController.getClients(id));
    }
}
