
/*==============================================================*/
/* Equipe  : Wijdane & AIT-TALEB & HAMMADI                                     */
/* Date de création :  2017/02/28 04:03:52 PM                   */
/*==============================================================*/


drop table if exists competition;

drop table if exists equipe;

drop table if exists rencontre;

drop table if exists personne;

drop table if exists poulle;

drop table if exists pronostic;

/*==============================================================*/
/* Table : Competition                                          */
/*==============================================================*/
CREATE TABLE competition (
    idCompetition INT NOT NULL AUTO_INCREMENT,
    libelleCompetition VARCHAR(40) NOT NULL,
    PRIMARY KEY (idCompetition)
);

/*==============================================================*/
/* Table : Equipe                                               */
/*==============================================================*/
CREATE TABLE equipe (
    idEquipe INT NOT NULL AUTO_INCREMENT,
    libelleEquipe VARCHAR(40) NOT NULL,
    imgEquipe VARCHAR(30) NULL,
    poulle int(11) NOT NULL,
    PRIMARY KEY (idEquipe)
);

/*==============================================================*/
/* Table : Rencontre                                           */
/*==============================================================*/
CREATE TABLE rencontre (
    idRencontre INT NOT NULL AUTO_INCREMENT,
    idPoulle INT NULL,
    idEquipe1 INT NOT NULL,
	idEquipe2 INT NOT NULL,
    idCompetition INT NOT NULL,
    datedebut DATETIME NULL  ,
    dateFin DATETIME NULL,
    butEquipe1 TINYINT ,
    butEquipe2 TINYINT,
    status INT,
    PRIMARY KEY (idRencontre)
);


/*==============================================================*/
/* Table : Personne                                             */
/*==============================================================*/
CREATE TABLE personne (
    idPersonne INT NOT NULL AUTO_INCREMENT,
    nomPersonne VARCHAR(40) NOT NULL,
    prenomPersonne VARCHAR(40) NOT NULL,
    email VARCHAR(40) NOT NULL,
    passwd CHAR(32) NOT NULL,
    role VARCHAR(40) NOT NULL,
    scoreGlobal INT NULL,
    PRIMARY KEY (idPersonne)
);

/*==============================================================*/
/* Table : Poulle                                               */
/*==============================================================*/
CREATE TABLE poulle (
    idPoulle INT NOT NULL AUTO_INCREMENT,
    libellePoulle VARCHAR(20),
    competition int(11) NOT NULL,
    PRIMARY KEY (idPoulle)
);

/*==============================================================*/
/* Table : Pronostic                                            */
/*==============================================================*/
CREATE TABLE pronostic (
    idPronostic INT NOT NULL AUTO_INCREMENT,
    idRencontre INT NOT NULL,
    idPersonne INT NOT NULL,
    butEquipe1 INT NOT NULL,
    butEquipe2 INT NOT NULL,
    score INT,
    PRIMARY KEY (idPronostic)
);
/*==============================================================*/
/* FOREIGN KEY's                */
/*==============================================================*/


ALTER TABLE rencontre add CONSTRAINT fk_RencontrePoulle FOREIGN KEY (idPoulle)
        REFERENCES poulle (idPoulle);
ALTER TABLE rencontre add CONSTRAINT fk_RencontreEquipe1 FOREIGN KEY (idEquipe1)
        REFERENCES equipe (idEquipe);
ALTER TABLE rencontre add CONSTRAINT fk_RencontreEquipe2 FOREIGN KEY (idEquipe2)
        REFERENCES equipe (idEquipe);
ALTER TABLE rencontre add CONSTRAINT fk_RencontreCompetition FOREIGN KEY (idCompetition)
        REFERENCES competition(idCompetition);


ALTER TABLE pronostic add CONSTRAINT fk_PronosticPersonne FOREIGN KEY (idPersonne)
        REFERENCES personne (idPersonne);
ALTER TABLE pronostic add CONSTRAINT fk_PronosticRencontre FOREIGN KEY (idRencontre )
        REFERENCES rencontre  (idRencontre );
        
        ALTER TABLE poulle add CONSTRAINT fk_PouleCompetition FOREIGN KEY (competition)
        REFERENCES competition  (idCompetition );