/**
 * Un jeu de morpion sur un plateau 3x3
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Morpion extends Applet implements ActionListener {
    Button cases[];
    Button boutonNouvellePartie;
    Label score;
    int casesLibresRestantes = 9;

    /**
     * La méthode init est comme un constructeur pour l'applet
     */
    public void init() 
    {
        // Affecte le gestionnaire de disposition et la couleur de l'applet
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        // Passe la police de l'applet en style gras et taille 20
        Font policeApplet = new Font("Monospaced", Font.BOLD, 20);
        this.setFont(policeApplet);
        // Crée le bouton Nouvelle partie et enregistre le récepteur d'actions auprès de lui
        boutonNouvellePartie = new Button("Nouvelle partie");
        boutonNouvellePartie.addActionListener(this);
        // Crée deux panneaux et un label et les agence en utilisant le border layout
        Panel panneauSupérieur = new Panel();
        panneauSupérieur.add(boutonNouvellePartie);
        this.add(panneauSupérieur, "North");

        Panel panneauCentral = new Panel();
        panneauCentral.setLayout(new GridLayout(3, 3));
        this.add(panneauCentral, "Center");

        score = new Label("A vous de jouer !");
        this.add(score, "South");

        cases = new Button[9];
        for(int i = 0; i < 9; i++) {
            cases[i]= new Button();
            cases[i].addActionListener(this);
            cases[i].setBackground(Color.darkGray);
            panneauCentral.add(cases[i]);
        }
    }

    public void stop()
    {
    }

    /**
     * Cette méthode traite tous les événements d'action
     * @param événement l'événement à traiter
     */
    public void actionPerformed(ActionEvent événement) 
    {
        Button leBouton = (Button) événement.getSource();
        // S'agit-il du bouton Nouvelle partie ?
        if (leBouton == boutonNouvellePartie) {
            for(int i = 0; i < 9; i++) {
                cases[i].setEnabled(true);
                cases[i].setLabel("");
                cases[i].setBackground(Color.darkGray);
            }
            casesLibresRestantes = 9;
            score.setText("A vous de jouer !");
            boutonNouvellePartie.setEnabled(false);
            return;
        }

        String gagnant = "";

        // S'agit-il de l'une des cases ?
        for (int i = 0; i < 9; i++) {
            if (leBouton == cases[i]) {
                cases[i].setLabel("X");
                gagnant = chercherUnGagnant();
                if(!"".equals(gagnant)) {
                    terminerLaPartie();
                } else {
                    //coupOrdinateur();
                    gagnant = chercherUnGagnant();
                    if (!"".equals(gagnant)) {
                        terminerLaPartie();
                    }
                }
                break;
            }
        } 
        if (gagnant.equals("X")) {
            score.setText("Vous avez gagné !");
        } else if (gagnant.equals("O")) {
            score.setText("Vous avez perdu !");
        } 
        else if (gagnant.equals("T")) {
            score.setText("Partie nulle !");
        }
    }

    /**
     * Cette méthode est appelée après chaque coup joué pour
     * voir s'il y a un gagnant. Elle vérifie pour chaque ligne,
     * colonne et diagonale, s'il y a trois symboles identiques
     * @return "X", "O", "T" (terminé, partie nulle) ou "" (pas
     * fini)
     */
     String chercherUnGagnant() {
        String leGagnant = "";
        casesLibresRestantes--;

        // Vérifie la ligne 1 - éléments 0, 1 et 2 du tableau
        if (!cases[0].getLabel().equals("") &&
                cases[0].getLabel().equals(cases[1].getLabel()) &&
                cases[0].getLabel().equals(cases[2].getLabel())) {
            leGagnant = cases[0].getLabel();
            montrerGagnant(0, 1, 2);

            // Vérifie la ligne 2 - éléments 3, 4 et 5 du tableau
        } else if (!cases[3].getLabel().equals("") &&
                cases[3].getLabel().equals(cases[4].getLabel()) &&
                cases[3].getLabel().equals(cases[5].getLabel())) {
            leGagnant = cases[3].getLabel();
            montrerGagnant(3, 4, 5);

            // Vérifie la ligne 3 - éléments 6, 7 et 8 du tableau
        } else if (!cases[6].getLabel().equals("") &&
                cases[6].getLabel().equals(cases[7].getLabel()) &&
                cases[6].getLabel().equals(cases[8].getLabel())) {
            leGagnant = cases[6].getLabel();
            montrerGagnant(6, 7, 8);

            // Vérifie la colonne 1 - éléments 0, 3 et 6 du tableau
        } else if (!cases[0].getLabel().equals("") &&
                cases[0].getLabel().equals(cases[3].getLabel()) &&
                cases[0].getLabel().equals(cases[6].getLabel())) {
            leGagnant = cases[0].getLabel();
            montrerGagnant(0, 3, 6);

            // Vérifie la colonne 2 - éléments 1, 4 et 7 du tableau
        } else if (!cases[1].getLabel().equals("") &&
                cases[1].getLabel().equals(cases[4].getLabel()) &&
                cases[1].getLabel().equals(cases[7].getLabel())) {
            leGagnant = cases[1].getLabel();
            montrerGagnant(1, 4, 7);

            // Vérifie la colonne 3 - éléments 2, 5 et 8 du tableau
        } else if (!cases[2].getLabel().equals("") &&
                cases[2].getLabel().equals(cases[5].getLabel()) &&
                cases[2].getLabel().equals(cases[8].getLabel())) {
            leGagnant = cases[2].getLabel();
            montrerGagnant(2, 5, 8);

            // Vérifie la première diagonale - éléments 0, 4 et 8
        } else if (!cases[0].getLabel().equals("") &&
                cases[0].getLabel().equals(cases[4].getLabel()) &&
                cases[0].getLabel().equals(cases[8].getLabel())) {
            leGagnant = cases[0].getLabel();
            montrerGagnant(0, 4, 8);

            // Vérifie la seconde diagonale - éléments 2, 4 et 6
        } else if (!cases[2].getLabel().equals("") &&
                cases[2].getLabel().equals(cases[4].getLabel()) &&
                cases[2].getLabel().equals(cases[6].getLabel())) {
            leGagnant = cases[2].getLabel();
            montrerGagnant(2, 4, 6);
        } else if (casesLibresRestantes == 0) {
            return "T"; // Partie nulle
        }
        return leGagnant;
    }
    
    /**
     * Cette méthode affiche la ligne gagnante en surbrillance.
     * @param gagnante1 première case à montrer.
     * @param gagnante2 deuxième case à montrer.
     * @param gagnante3 troisième case à montrer.
     */
    void montrerGagnant(int gagnante1, int gagnante2, int gagnante3) {
        cases[gagnante1].setBackground(Color.gray);
        cases[gagnante2].setBackground(Color.gray);
        cases[gagnante3].setBackground(Color.gray);
    }

    // Désactive les cases et active le bouton Nouvelle partie
    void terminerLaPartie() {
        boutonNouvellePartie.setEnabled(true);
        for (int i = 0; i < 9; i++) {
            cases[i].setEnabled(false);
        }
    }
}
