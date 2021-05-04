-----------------------------------------------------------------------
--                            GARAGE                                 --
-- Fichier création base de données, tables, et ajout de contraintes --
--                                                                   --
-----------------------------------------------------------------------


-- Création de la base de données
CREATE DATABASE garage COLLATE utf8_general_ci;

-- Utilisation de la base de données
USE garage;

-- Vérification de la liste des tables
SHOW tables;

---------------------
-- CREATION TABLES --
---------------------

-- Table client
DROP TABLE IF EXISTS client;
CREATE TABLE client(
    CLI_ID INT NOT NULL AUTO_INCREMENT,
    CLI_NOM VARCHAR(40) NULL,
    CLI_PRENOM VARCHAR(40) NULL,
    CLI_RAISON_SOCIALE VARCHAR(40) NULL,
    CLI_TYPE ENUM('PARTICULIER', 'PROFESSIONNEL') NOT NULL DEFAULT 'PARTICULIER',
    CLI_FIDELITE ENUM('CLASSIQUE','PREMIUM') NOT NULL DEFAULT 'CLASSIQUE',
    CLI_VEHICULE_ID INT, 
    PRIMARY KEY (CLI_ID)
) ENGINE = InnoDb;

-- Table véhicule
DROP TABLE IF EXISTS vehicule;
CREATE TABLE vehicule(
    VEH_ID INT NOT NULL AUTO_INCREMENT,
    VEH_NOM VARCHAR(40) NOT NULL,
    VEH_MARQUE VARCHAR(40) NOT NULL,
    VEH_IMMATRICULATION VARCHAR(40) NULL,
    VEH_TYPE ENUM('VOITURE', 'MOTO', 'CAMION') NOT NULL DEFAULT 'VOITURE',
    PRIMARY KEY (VEH_ID)
) ENGINE = InnoDb;

-- Table Commande
DROP TABLE IF EXISTS commande;
CREATE TABLE commande(
    CMD_ID INT NOT NULL AUTO_INCREMENT,
    CMD_DATE DATETIME DEFAULT NOW(),
    CMD_ETAT ENUM('NONCOMMENCEE', 'ENCOURS','TERMINEE'),
    CMD_PRIX_TOTAL DECIMAL(10,2),
    CMD_CLIENT_ID INT,
    CMD_GARAGISTE_ID INT,
    CMD_VEHICULE_ID INT,
    PRIMARY KEY (CMD_ID)
) ENGINE = InnoDb;

-- Table Garagiste
DROP TABLE IF EXISTS garagiste;
CREATE TABLE garagiste(
    GAR_ID INT NOT NULL AUTO_INCREMENT,
    GAR_NOM VARCHAR(40) NOT NULL,
    GAR_PRENOM VARCHAR(40) NULL,
    PRIMARY KEY (GAR_ID)
) ENGINE = InnoDb;

-- Table Operation
DROP TABLE IF EXISTS operation;
CREATE TABLE operation(
    OPE_ID INT NOT NULL AUTO_INCREMENT,
    OPE_LIBELLE VARCHAR(100) NOT NULL,
    OPE_DESCRIPTION TEXT,
    OPE_PRIX_UNITAIRE DECIMAL(10,2),
    PRIMARY KEY (OPE_ID)
) ENGINE = InnoDb;

-- Table Commande Detail
DROP TABLE IF EXISTS commande_detail;
CREATE TABLE commande_detail(
    CMDE_OPERATION_ID INT NOT NULL,
    CMDE_COMMANDE_ID INT NOT NULL,
    CMDE_QUANTITE INT NOT NULL,
    CMDE_PRIX_UNITAIRE DECIMAL(10,2),
    PRIMARY KEY (CMDE_OPERATION_ID, CMDE_COMMANDE_ID)
) ENGINE = InnoDb;

---------------------------
-- AJOUT DES CONTRAINTES --
---------------------------

-- Contrainte client vers véhicule
ALTER TABLE client
	ADD CONSTRAINT FK_ClientVéhicule
	FOREIGN KEY (CLI_VEHICULE_ID)
	REFERENCES vehicule (VEH_ID);

-- Contraintes commande_detail vers operation, commande_detail vers commande
ALTER TABLE commande_detail
	ADD CONSTRAINT FK_CommandeDetailOperation
	FOREIGN KEY (CMDE_OPERATION_ID)
	REFERENCES operation (OPE_ID)
	,
	ADD CONSTRAINT FK_CommandeDetailCommande
	FOREIGN KEY (CMDE_COMMANDE_ID)
	REFERENCES commande (CMD_ID)
	ON DELETE CASCADE;

-- Contraintes commande vers client, commande vers garagiste, et commande vers véhicule
ALTER TABLE commande
	ADD CONSTRAINT FK_CommandeClient
	FOREIGN KEY (CMD_CLIENT_ID)
	REFERENCES client (CLI_ID)
	,
	ADD CONSTRAINT FK_CommandeGaragiste
	FOREIGN KEY (CMD_GARAGISTE_ID)
	REFERENCES garagiste (GAR_ID)
    ,
    ADD CONSTRAINT FK_CommandeVehicule
	FOREIGN KEY (CMD_VEHICULE_ID)
	REFERENCES vehicule (VEH_ID)
    ;