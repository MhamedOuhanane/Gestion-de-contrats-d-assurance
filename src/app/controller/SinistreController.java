package app.controller;

import app.model.Sinistre;
import app.service.interfaces.SinistreService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class SinistreController {
    private final SinistreService sinistreService;

    public SinistreController(SinistreService sinistreService) {
        this.sinistreService = sinistreService;
    }

    public String create(Sinistre sinistre) {
        try {
            sinistre = this.sinistreService.ajouterSinistre(sinistre);
            return "✅ Le Sinistre est ajouter avec success avec l'id: " + sinistre.getId();
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String delete(Integer id) {
        try {
            Boolean delete = this.sinistreService.deleteSinistre(id);
            if (delete) {
                return "🗑️ Sinistre avec ID " + id + " supprimé avec succès.";
            } else {
                return "⚠️ Aucun Sinistre trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String find(Integer id) {
        try {
            Sinistre sinistre = this.sinistreService.findSinistre(id);
            if (sinistre != null) {
                return "💥 Sinistre trouvé: " + sinistre.toString();
            } else {
                return "⚠️ Aucun sinistre trouvé avec ID " + id;
            }
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String getTriSinistres() {
        try {
            List<Sinistre> sinistres = this.sinistreService.getSinistresTriMontantDec();
            return sinistres.isEmpty()
                    ? "➤ Aucun Sinistre existe."
                   : sinistres.stream()
                    .map(sinistre -> " 💥 " + sinistre.toString())
                    .collect(Collectors.joining(
                            "\n",
                            "📋 La liste des Sinistres triés par montant decroissant: ",
                            ""
                    ));
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String filterSinistreDateAv(LocalDateTime date) {
        try {
            List<Sinistre> sinistres = this.sinistreService.filtreSinistreDateAv(date);
            return sinistres.isEmpty()
                    ? "➤ Aucun Sinistre existe."
                    :sinistres.stream()
                    .map(sinistre -> " 💥 " + sinistre.toString())
                    .collect(Collectors.joining(
                            "\n",
                            "📋 La liste des Sinistres qui se sont produits avant '" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "' : ",
                            ""
                    ));
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }

    public String filtreSinistreCautSup(Double montent) {
        try {
            List<Sinistre> sinistres = this.sinistreService.filtreSinistreCautSup(montent);
            return sinistres.isEmpty()
                    ? "➤ Aucun Sinistre existe."
                    :sinistres.stream()
                    .map(sinistre -> " 💥 " + sinistre.toString())
                    .collect(Collectors.joining(
                            "\n",
                            "📋 La liste des Sinistres dont le cout est superieur a '" + montent + " MAD' : ",
                            ""
                    ));
        } catch (RuntimeException e) {
            return "❌ Erreur: " + e.getMessage();
        }
    }
}
