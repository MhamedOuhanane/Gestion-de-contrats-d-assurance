package app.view;

import app.controller.ContratController;
import app.model.Client;
import app.model.Contrat;
import app.model.EnumContrat;
import app.utils.ValidationInputs;

import java.time.LocalDate;

public class ContratView {
    private ContratController contratController;

    public ContratView(ContratController contratController) {
        this.contratController = contratController;
    }

    public void menuContrat() {
        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Contrat =====");
            System.out.println("1. Ajouter un Contrat");
            System.out.println("2. Supprimer un Contrat");
            System.out.println("3. Rechercher un Contrat par son ID");
            System.out.println("4. Afficher les Sinistres d'un Contrat");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choix = ValidationInputs.getIntegerInput();
            switch (choix) {
                case 1:
                    this.createView();
                    break;
                case 2:
                    this.deleteView();
                    break;
                case 3:
                    this.findView();
                    break;
                case 4:
                    this.getSinistres();
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
        System.out.println("\n+--+--+ Ajouter un Contrat +--+--+");

        System.out.println("🔹Choisi le type de Contrat: ");
        EnumContrat typeContrat = null;
        while (typeContrat == null) {
            System.out.println("1. 🏠 IMMOBILIER");
            System.out.println("2. 🩺 MALADIE");
            System.out.println("3. 🚗 AUTOMOBILE");
            System.out.print("Choix : ");
            int choix = ValidationInputs.getIntegerInput();
            switch (choix) {
                case 1:
                    typeContrat = EnumContrat.IMMOBILIER;
                    break;
                case 2:
                    typeContrat = EnumContrat.MALADIE;
                    break;
                case 3:
                    typeContrat = EnumContrat.AUTOMOBILE;
                    break;
                default:
                    System.out.println("Choix Invalide!");
            }
        }

        LocalDate dateDebut = LocalDate.now();
        System.out.print("🔹Saisir la date du fin de Contrat (format yyyy-MM-dd): ");
        LocalDate dateFin = ValidationInputs.getDateInput();
        System.out.print("🔹Saisir Id de Client: ");
        int client_id = ValidationInputs.getIntegerInput();
        Contrat contrat = new Contrat(typeContrat, dateDebut, dateFin, client_id);

        System.out.println(contrat.toString());
        System.out.println(this.contratController.create(contrat));
    }

    private void deleteView() {
        System.out.println("\n+--+--+ Supprimer un Contrat +--+--+");
        System.out.print("🔹Saisir Id de Contrat: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.contratController.delete(id));
    }

    private void findView() {
        System.out.println("\n+--+--+ Rechercher un Contrat par son ID +--+--+");
        System.out.print("🔹Saisir Id de Contrat: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.contratController.find(id));
    }

    private void getSinistres() {
        System.out.println("\n+--+--+ Afficher les Sinistres d'un Contrat +--+--+");
        System.out.print("🔹Saisir Id de Contrat: ");
        Integer id = ValidationInputs.getIntegerInput();

        System.out.println(this.contratController.getSinistres(id));
    }
}
