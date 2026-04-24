-- =========================
-- TABLE SPECIES
-- =========================
CREATE TABLE species (
  id INT PRIMARY KEY AUTO_INCREMENT,
  common_name VARCHAR(50) NOT NULL,
  latin_name VARCHAR(200) NOT NULL
);

INSERT INTO species (id, common_name, latin_name) VALUES
(1, 'Chat', 'Felis silvestris catus'),
(2, 'Chien', 'Canis lupus familiaris'),
(3, 'Lapin', 'Oryctolagus cuniculus');

-- =========================
-- TABLE ANIMAL
-- =========================
CREATE TABLE animal (
  id INT PRIMARY KEY AUTO_INCREMENT,
  color VARCHAR(50),
  name VARCHAR(50) NOT NULL,
  sex VARCHAR(10) NOT NULL,
  species_id INT NOT NULL,
  FOREIGN KEY (species_id) REFERENCES species(id)
);

INSERT INTO animal (id, color, name, sex, species_id) VALUES
(1, 'Gris tacheté', 'Max', 'M', 1),
(2, 'Blanc', 'Médor', 'M', 2),
(3, 'Noir', 'Loulou', 'F', 1),
(4, 'Brun', 'Zia', 'F', 2),
(5, 'Blanc', 'Lou', 'F', 3),
(6, 'Roux', 'Minouchette', 'M', 1);

-- =========================
-- TABLE PERSON
-- =========================
CREATE TABLE person (
  id INT PRIMARY KEY AUTO_INCREMENT,
  age INT,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  login VARCHAR(50) NOT NULL UNIQUE,
  mdp VARCHAR(100) NOT NULL,
  active BOOLEAN DEFAULT TRUE
);

INSERT INTO person (id, age, firstname, lastname, login, mdp, active) VALUES
(1, 22, 'Henri', 'Lamarque', 'hla', '*****', TRUE),
(2, 24, 'Sylvie', 'Lamarque', 'sla', '*****', TRUE),
(3, 55, 'Jean', 'Vintroi', 'jvi', '*****', TRUE),
(4, 80, 'Paul', 'Demaine', 'pde', '*****', TRUE),
(5, 45, 'Sophie', 'Nero', 'sne', '*****', TRUE),
(6, 17, 'Pierre', 'Sansane', 'sva', '*****', TRUE),
(7, 33, 'John', 'Mangolo', 'jma', '*****', TRUE),
(8, 26, 'Bill', 'Wagner', 'bwa', '*****', TRUE);

-- =========================
-- TABLE PERSON_ANIMALS
-- =========================
CREATE TABLE person_animals (
  person_id INT NOT NULL,
  animals_id INT NOT NULL,
  PRIMARY KEY (person_id, animals_id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (animals_id) REFERENCES animal(id)
);

INSERT INTO person_animals (person_id, animals_id) VALUES
(2, 1),
(7, 1),
(4, 2),
(3, 3),
(5, 4),
(2, 5),
(8, 6);

-- =========================
-- TABLE ROLE
-- =========================
CREATE TABLE role (
  id INT PRIMARY KEY AUTO_INCREMENT,
  label VARCHAR(50) NOT NULL
);

INSERT INTO role (id, label) VALUES
(1, 'ROLE_EMPLOYE'),
(2, 'ROLE_USER'),
(3, 'ROLE_ADMIN');

-- =========================
-- TABLE PERSON_ROLE
-- =========================
CREATE TABLE person_role (
  person_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (person_id, role_id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
);