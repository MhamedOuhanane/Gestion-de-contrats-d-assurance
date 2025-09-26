import app.controller.ClientController;
import app.controller.ConseillerController;
import app.controller.ContratController;
import app.controller.SinistreController;
import app.model.Person;
import app.repository.impl.*;
import app.repository.interfaces.*;
import app.service.impl.ClientServiceImpl;
import app.service.impl.ConseillerServiceImpl;
import app.service.impl.ContratServiceImpl;
import app.service.impl.SinistreServiceImpl;
import app.service.interfaces.ClientService;
import app.service.interfaces.ConseillerService;
import app.service.interfaces.ContratService;
import app.service.interfaces.SinistreService;
import app.utils.ValidationInputs;
import app.view.ClientView;
import app.view.ConseillerView;
import app.view.ContratView;
import app.view.SinistreView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Repository
        PersonRepository personRepository = new PersonRepositoryImpl();
        ConseillerRepository conseillerRepository = new ConseillerRepositoryImpl(personRepository);
        ClientRepository clientRepository = new ClientRepositoryImpl(personRepository);
        ContratRepository contratRepository = new ContratRepositoryImpl();
        SinistreRepository sinistreRepository = new SinistreRepositoryImpl();

//        Service
        ConseillerService conseillerService = new ConseillerServiceImpl(conseillerRepository, clientRepository);
        ContratService contratService = new ContratServiceImpl(contratRepository, sinistreRepository, clientRepository);
        ClientService clientService = new ClientServiceImpl(clientRepository, contratRepository, contratService);
        SinistreService sinistreService = new SinistreServiceImpl(sinistreRepository, contratService);

//        Controller
        ConseillerController conseillerController = new ConseillerController(conseillerService);
        ClientController clientController = new ClientController(clientService);
        ContratController contratController = new ContratController(contratService);
        SinistreController sinistreController = new SinistreController(sinistreService);

//        View
        ConseillerView conseillerView = new ConseillerView(conseillerController);
        ClientView clientView = new ClientView(clientController);
        ContratView contratView = new ContratView(contratController);
        SinistreView sinistreView = new SinistreView(sinistreController);

        boolean connection = true;
        while (connection) {
            System.out.println("\n===== MENU Application =====");
            System.out.println("1. Gerer les Conseiller");
            System.out.println("2. Gerer les Client");
            System.out.println("3. Gerer les Contrats");
            System.out.println("4. Gerer les Sinistres");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choix = ValidationInputs.getIntegerInput();

            switch (choix) {
                case 1:
                    conseillerView.menuConseiller();
                    break;
                case 2:
                    clientView.menuClient();
                    break;
                case 3:
                    contratView.menuContrat();
                    break;
                case 4:
                    sinistreView.menuSinistre();
                    break;

                case 5:
                    connection = false;

                    break;
                default:
                    System.out.println("Choix invalide!");

            }

        }
    }
}