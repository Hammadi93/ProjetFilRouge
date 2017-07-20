
/*==============================================================*/
/* Table : Competition                                          */
/*==============================================================*/

INSERT INTO competition (idCompetition, libelleCompetition) VALUES(1, 'CAN');
INSERT INTO competition (idCompetition, libelleCompetition) VALUES(2, 'EURO');

/*==============================================================*/
/* Table : Personne                                             */
/*==============================================================*/

INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(1,'HAMMADI','Mezin','hmezin@norsys.fr', 'b054109103162fa601d0d95465827069','ROLE_ADMIN,ROLE_SALARIE'); -- hammadi

INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(2,'AIT-TALEB','Youssef','yaittaleb@norsys.fr', '8ba97607a1485ccdbe19745ed80cd52d','ROLE_SALARIE'); -- zaza
            
INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(3,'Oudli','Ouijdane','ooudli@norsys.fr', 'ca0f3b9c304e765ac2ffac82c06b075c ','ROLE_SALARIE'); -- wijwij

/*==============================================================*/
/* Table : Poulle                                               */
/*==============================================================*/

INSERT INTO poulle(idPoulle,libellePoulle,competition) VALUES(1,'A', 1);
INSERT INTO poulle(idPoulle,libellePoulle,competition) VALUES(2,'B', 1);


/*==============================================================*/
/* Table : Equipe                                               */
/*==============================================================*/

INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(1,'Egypt','egypt.png',1);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(2,'Algerie','algerie320.jpg',1);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(3,'Equipe 3A',NULL,1);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(4,'Equipe 4A',NULL,1);

INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(5,'Equipe 1B',NULL,2);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(6,'Equipe 2B',NULL,2);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(7,'Equipe 3B',NULL,2);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe,poulle) VALUES(8,'Equipe 4B',NULL,2);


/*==============================================================*/
/* Table : Rencontre                                           */
/*==============================================================*/
INSERT INTO rencontre (idRencontre, idPoulle, idEquipe1, idEquipe2, idCompetition, datedebut, dateFin, butEquipe1, butEquipe2,status)values(1, 1, 1, 2, 1, NULL, NULL, 1, 1,0);
INSERT INTO rencontre (idRencontre, idPoulle, idEquipe1, idEquipe2, idCompetition, datedebut, dateFin, butEquipe1, butEquipe2,status)values(2, 1, 3, 4, 1, NULL, NULL, 3, 4,0);
INSERT INTO rencontre (idRencontre, idPoulle, idEquipe1, idEquipe2, idCompetition, datedebut, dateFin, butEquipe1, butEquipe2,status)values(3, 1, 1, 3, 1, NULL, NULL, 2, 1,0);
INSERT INTO rencontre (idRencontre, idPoulle, idEquipe1, idEquipe2, idCompetition, datedebut, dateFin, butEquipe1, butEquipe2,status)values(4, 1, 2, 4, 1, NULL, NULL, 0, 0,0);
INSERT INTO rencontre (idRencontre, idPoulle, idEquipe1, idEquipe2, idCompetition, datedebut, dateFin, butEquipe1, butEquipe2,status)values(5, 1, 1, 4, 1, NULL, NULL, 1, 0,0);

/*==============================================================*/
/* Table : Pronostic                                            */
/*==============================================================*/

INSERT INTO pronostic (idPronostic, idRencontre, idPersonne, butEquipe1, butEquipe2, score) VALUES(1, 1, 1, 10, 0, 0);
INSERT INTO pronostic (idPronostic, idRencontre, idPersonne, butEquipe1, butEquipe2, score) VALUES(2, 1, 1, 12, 232, 0);
INSERT INTO pronostic (idPronostic, idRencontre, idPersonne, butEquipe1, butEquipe2, score) VALUES(3, 5, 1, 0, 0, 0);
INSERT INTO pronostic (idPronostic, idRencontre, idPersonne, butEquipe1, butEquipe2, score) VALUES(4, 2, 2, 1, 3, 0);



