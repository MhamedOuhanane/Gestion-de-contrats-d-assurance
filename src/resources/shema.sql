CREATE TABLE IF NOT EXISTS person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS conseiller (
    id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS client(
    id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    conseiller_id INT NOT NULL,
    FOREIGN KEY (conseiller_id) REFERENCES conseiller(id)
);

CREATE TABLE IF NOT EXISTS contrat(
    id INT AUTO_INCREMENT PRIMARY KEY,
    typeContrat ENUM("Automobile", "Immobilier", "Maladie"),
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL,
    client_id INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS sinistre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    typeSinistre ENUM("accident de voiture", "accident de maison", 'maladie'),
    date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    montant DECIMAL(10,2) NOT NULL,
    description TEXT NOT NULL,
    contrat_id INT NOT NULL,
    FOREIGN KEY (contrat_id) REFERENCES contrat(id)
);