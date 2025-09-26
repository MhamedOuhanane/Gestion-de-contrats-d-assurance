package app.controller;

import app.model.Conseiller;
import app.service.interfaces.ConseillerService;

import java.util.Map;

public class ConseillerController {
    private ConseillerService conseillerService;

    public ConseillerController(ConseillerService conseillerService) {
        this.conseillerService = conseillerService;
    }

    public String create(Map<String, Object> conseillerInfo) {
        Conseiller conseiller = new Conseiller(conseillerInfo.get("nom").toString(), conseillerInfo.get("prenom").toString(), conseillerInfo.get("email").toString());
        try {
            Conseiller newConsseiller = this.conseillerService.ajouterConseiller(conseiller);
            return "✅ Le conseiller est ajouter avec success avec l'id: " + newConsseiller.getId();
        } catch (RuntimeException e) {
            return "❌ " + e.getMessage();
        }
    }
}
