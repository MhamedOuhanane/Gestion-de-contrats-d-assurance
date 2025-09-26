package app.view;

import app.controller.ClientController;
import app.model.Client;
import app.utils.ValidationInputs;

public class ClientView {
    private final ClientController clientController;

    public ClientView(ClientController clientController) {
        this.clientController = clientController;
    }

    public void menuClient() {
        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Conseiller =====");
            System.out.println("1. Ajouter un Client");
            System.out.println("2. Supprimer un Client");
            System.out.println("3. Rechercher un Client par son ID");
            System.out.println("4. Rechercher un Client par son nom de famille");
            System.out.println("5. Afficher les Contrats d'un Client");
            System.out.println("6. Afficher les Sinistres d'un Client");
            System.out.println("7. Coût total des sinistres déclarés d’un client");
            System.out.println("8. Quitter");
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
                    this.findByIdView();
                    break;
                case 4:
                    this.findByNomView();
                    break;
                case 5:
                    this.getContratsView();
                    break;
                case 6:
                    this.getSinistresView();
                    break;
                case 7:
                    this.getTotalCoutView();
                    break;
                case 8:
                    connection = false;
                    break;
                default:
                    System.out.println("Choix Invalide!");
            }
        }
    }

    private void createView() {
        System.out.println("\n+--+--+ Ajouter un Client +--+--+");
        System.out.print("🔹Saisir le nom de Client: ");
        String nom = ValidationInputs.getInfoStringInput("nom");
        System.out.print("🔹Saisir le prenom de Client: ");
        String prenom = ValidationInputs.getInfoStringInput("prenom");
        System.out.print("🔹Saisir l'email de Client: ");
        String email = ValidationInputs.getInfoStringInput("email");
        System.out.print("🔹Saisir Id de conseiller: ");
        int conseiller_id = ValidationInputs.getIntegerInput();
        Client client = new Client(nom, prenom, email, conseiller_id);


        System.out.println(this.clientController.create(client));
    }

    private void deleteVeiw() {
        System.out.println("\n+--+--+ Supprimer un Client +--+--+");
        System.out.print("🔹Saisir Id de Client: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.clientController.delete(id));
    }

    private void findByIdView() {
        System.out.println("\n+--+--+ Rechercher un Client par son ID +--+--+");
        System.out.print("🔹Saisir Id de Client: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.clientController.findById(id));
    }

    private void findByNomView() {
        System.out.println("\n+--+--+ Rechercher un Client par son Nom +--+--+");
        System.out.print("🔹Saisir le nom de Client: ");
        String nom = ValidationInputs.getInfoStringInput("nom");

        System.out.println(this.clientController.findByNom(nom));
    }

    private void getContratsView() {
        System.out.println("\n+--+--+ Afficher les Contrats d'un Client +--+--+");
        System.out.print("🔹Saisir Id de Client: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.clientController.getContrats(id));
    }

    private void getSinistresView() {
        System.out.println("\n+--+--+ Afficher les Sinistres d'un Client +--+--+");
        System.out.print("🔹Saisir Id de Client: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.clientController.getSinistres(id));
    }

    private void getTotalCoutView() {
        System.out.println("\n+--+--+ Coût total des sinistres déclarés d’un client +--+--+");
        System.out.print("🔹Saisir Id de Client: ");
            Integer id = ValidationInputs.getIntegerInput();

                System.out.println(this.clientController.getTotalMontSini(id));
        }
}

