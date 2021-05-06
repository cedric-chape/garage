-------------------------
-- Quelques garagistes --
-------------------------

-- insert values to garagiste
INSERT INTO garagiste (gar_id, gar_nom, gar_prenom)
Values (1, 'Smith','Will');

INSERT INTO garagiste (gar_id, gar_nom, gar_prenom)
VALUES (4,'JON-un','Kim');

INSERT INTO garagiste (gar_id, gar_nom, gar_prenom)
VALUES
(2,'Beckham','David');

INSERT INTO garagiste (gar_id, gar_nom, gar_prenom)
VALUES (3,'Musk','Elon');

SELECT * from garagiste;

------------------------    
-- Quelques véhicules --
------------------------

INSERT INTO vehicule (VEH_NOM, VEH_MARQUE, VEH_IMMATRICULATION, VEH_TYPE)
    VALUES 
    ('IBIZA IV', 'SEAT', 'AB194GJ', 'VOITURE'),
    ('FIESTA', 'FORD', '6515SZ62', 'VOITURE'),
    ('STREET BOB', 'HARLEY DAVIDSON', 'DD258AZ', 'MOTO'),
    ('T HIGH', 'RENAULT TRUCKS', 'RT258TH', 'CAMION'),
    ('T B100', 'RENAULT TRUCKS', 'AT878DH', 'CAMION');

-- insert values t vehicule
INSERT INTO vehicule
Values (6, 'Mustang', 'ford','AB-737-AT','VOITURE');

INSERT INTO vehicule
Values (7, 'CLIO', 'Renault','CB-654-CT','VOITURE');

INSERT INTO vehicule
Values (8, 'Z650', 'Kawasaki ','LF-803-PO','MOTO');

INSERT INTO vehicule
Values (9, 'v8', 'SCANIA','TY-612-LM','CAMION');

INSERT INTO vehicule
Values (10, 'a5', 'audi','FG-645-AR','VOITURE');

----------------------
-- Quelques clients -- /!\ il faut impérativement que la table véhicule soit bien remplie
----------------------

-- Clients particuliers avec fidélité classique
INSERT INTO client (CLI_NOM, CLI_PRENOM, CLI_VEHICULE_ID)
	VALUES
	('DUPONT', 'Jean', 1);
-- Clients particuliers avec fidélité premium
INSERT INTO client (CLI_NOM, CLI_PRENOM, CLI_FIDELITE, CLI_VEHICULE_ID)
	VALUES
	('PRUVOT', 'Robert', 'PREMIUM', 2),
	('DESCHAMPS', 'Didier', 'PREMIUM', 3);
-- Clients professionnels avec fidélité classique
INSERT INTO client (CLI_RAISON_SOCIALE, CLI_TYPE, CLI_VEHICULE_ID)
    VALUES
	('DURIEUX SA', 'PROFESSIONNEL', 4);
-- Clients professionnels avec fidélité premium
INSERT INTO client (CLI_RAISON_SOCIALE, CLI_TYPE, CLI_FIDELITE, CLI_VEHICULE_ID)
    VALUES
    ('BOULANGER SA', 'PROFESSIONNEL', 'PREMIUM', 5);

-- insert to client
INSERT INTO client
Values (6, 'Brossard','Fabien', 'Entreprise ads','PARTICULIER','CLASSIQUE',6);

INSERT INTO client
Values (7, 'Turo','Elian', ' Dupon ESE','PARTICULIER','CLASSIQUE',7);

INSERT INTO client
Values (8, 'Mitass','THeo', 'Accenture','PARTICULIER','PREMIUM',8);

INSERT INTO client
Values (9, 'Duriel','Eva', 'EURO TRANSPORT','PROFESSIONNEL','CLASSIQUE',9);

INSERT INTO client
Values (10, 'Faleh','Ali', 'EURO TRANSPORT','PARTICULIER','CLASSIQUE',10);

-------------------------    
-- Quelques opérations --
-------------------------
insert into operation (OPE_LIBELLE, OPE_DESCRIPTION, OPE_PRIX_UNITAIRE)
values ('vidange_voiture', 'Vidanger une automobile', 50),
    ('vidange_moto', 'Vidanger une moto', 40),
    ('vidange_camion', 'Vidanger un camion', 100),
    ('Pneus_voiture', 'Les pneumatiques se changent toujours par paire', 60),
    ('Pneus_moto', 'Les pneumatiques se changent toujours par paire', 70),
    ('Pneus_camion', 'Les pneumatiques se changent toujours par paire', 120),
    ('Freins_voiture', 'Changement des plaquettes de frein', 100 ),
    ('Freins_moto', 'Changement des plaquettes de frein', 100 ),
    ('Freins_camion', 'Changement des plaquettes de frein', 300 ),
    ('Distribution_voiture', 'Changement du kit de distribution ', 500),
    ('Distribution_moto', 'Changement du kit de distribution ', 300),
    ('Distribution_camion', 'Changement du kit de distribution ', 1000),
    ('Amortisseur_voiture', 'Changement d''un amortisseur', 100),
    ('Amortisseur_moto', 'Changement d''un amortisseur', 100),
    ('Amortisseur_camion', 'Changement d''un amortisseur', 200);


------------------------
-- Quelques commandes --
------------------------

INSERT INTO commande (CMD_DATE, CMD_ETAT, CMD_VEHICULE_ID, CMD_CLIENT_ID, CMD_GARAGISTE_ID, CMD_PRIX_TOTAL)
    VALUES 
        ('2021-04-29 07:42', 'TERMINEE', 1, 1, 1, 170), -- voiture opé id=1 quantité 1 + id=4 quantité 2
        ('2021-04-29 09:31', 'TERMINEE', 2, 2, 2, 500), -- voiture opé id=10 quantité 1
        ('2021-04-29 11:07', 'TERMINEE', 3, 3, 1, 200), -- moto opé id=8 quantité 2
        ('2021-04-29 15:09', 'TERMINEE', 4, 4, 3, 400), -- camion opé id=15 quantité 2
        ('2021-04-29 17:22', 'TERMINEE', 5, 5, 4, 480), -- camion opé id=6 quantité 4
        ('2021-04-30 07:36', 'TERMINEE', 6, 6, 2, 700), -- voiture opé id=10 quantité=1 + id=13 quantité 2
        ('2021-04-30 08:47', 'TERMINEE', 7, 7, 3, 250), -- voiture opé id=1 quantité=1 + id=7 quantité 2
        ('2021-04-30 13:04', 'TERMINEE', 8, 8, 4, 340), -- moto opé id = 2 quantité 1 + id=11 quantité 1
        ('2021-04-30 15:52', 'ENCOURS', 9, 9, 1, 400), -- camion opé id=15 quantité 2
        ('2021-05-03 14:15', 'NONCOMMENCEE', 10, 10, 2, 700); -- voiture opé id=10 quantité=1 + id=13 quantité 2
        
-----------------------------------
-- Quelques commandes détaillées --
-----------------------------------
INSERT INTO commande_detail (CMDE_OPERATION_ID, CMDE_COMMANDE_ID, CMDE_QUANTITE, CMDE_PRIX_UNITAIRE)
	VALUES
	(1, 1, 1, 50),
    (4, 1, 2, 60),
    (10, 2, 1, 500),
    (8, 3, 2, 100),
    (15, 4, 2, 200),
    (6, 5, 4, 120),
    (10, 6, 1, 500),
    (13, 6, 2, 100),
    (1, 7, 1, 50),
    (7, 7, 2, 100),
    (2, 8, 1, 40),
    (11, 8, 1, 300),
    (15, 9, 2, 200),
    (10, 10, 1, 500),
    (13, 10, 2, 100)
    ;