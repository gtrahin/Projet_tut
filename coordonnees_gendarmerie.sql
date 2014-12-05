DROP TABLE IF EXISTS Coordonnees_Gendarmerie;

CREATE TABLE IF NOT EXISTS Coordonnees_Gendarmerie (
id_gendarmerie serial, 
nom varchar(255), 
adresse varchar(255), 
ville varchar(255),
id_departement int, 
latitude float,
longitude float,
PRIMARY KEY (id_gendarmerie)
); 

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Vesoul', '1 Rue du Marechal Juin', 'Vesoul', 70000, 47.644028, 6.163056);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Port-sur-saone', '11 Avenue de la Gare', 'Port-sur-saone', 70170, 47.689044, 6.050178);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Noroy-le-bourg', '2 Faubourg de Cour', 'Noroy-le-bourg', 70000, 47.612964, 6.308509);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Saulx', '2 Rue de la Grande-Cote', 'Saulx', 70240, 47.697663, 6.285037);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Scey-sur-Saone-et-Saint-Albin', '2 Rue du Bourg', 'Scey-sur-Saone-et-Saint-Albin', 70360, 47.664202, 5.972191);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Hericourt', '7 Faubourg de Besancon', 'Hericourt', 70400, 47.572883, 6.75116);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BTA Lure', '12 Rue Pasteur', 'Lure', 70204, 47.684653, 6.497184);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Melisey', 'Route de Lure', 'Melisey', 70270, 47.745024, 6.560603);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Champagney', '6 Avenue de la Gare', 'Champagney', 70290, 47.704574, 6.688561);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Villersexel', '147 Rue du 13 Septembre 1944', 'Villersexel', 70110, 47.549753, 6.433814);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Luxeuil-les-Bains', '2 Rue du Maréchal Leclerc', 'Luxeuil-les-Bains', 70306, 47.819485, 6.36448);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Saint-Loup-sur-Semouse', '47 Avenue Albert Thomas', 'Saint-Loup-sur-Semouse', 70800, 47.882318, 6.289264);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Faucogney-et-la-Mer', '13 Rue des Chars', 'Faucogney-et-la-Mer', 70310, 47.837653, 6.562144);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BTA Gray', '17 Rue Maurice Signard', 'Gray', 70140, 47.445617, 5.594605);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Dampierre-sur-Salon', '37 Rue Carnot', 'Dampierre-sur-Salon', 70180, 47.558056, 5.681848);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Gy', '100 Grande Rue', 'Gy', 70700, 47.404151, 5.809493);

INSERT INTO Coordonnees_Gendarmerie VALUES 
(DEFAULT, 'BP Pesmes', 'Route de Chaumercenne', 'Pesmes', 70140, 47.27989, 5.563187);
