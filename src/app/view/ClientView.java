package app.view;

import app.controller.ClientController;

public class ClientView {
    private ClientController clientController;

    public ClientView(ClientController clientController) {
        this.clientController = clientController;
    }

    public void menuClient() {
        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Client =====");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Affichier les Clients");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Rechercher un client");
            System.out.println("5. Afficher les contrats souscrits d’un client");
            System.out.println("6. Afficher la liste des sinistres d'un client");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");
        }

    }
}
