
/*==============================================================*/
/* Table : Competition                                          */
/*==============================================================*/

INSERT INTO competition(idCompetition ,libelleCompetition) VALUES(1,'CAN 2017');

/*==============================================================*/
/* Table : Personne                                             */
/*==============================================================*/

INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(NULL,'HAMMADI','Mezin','hmezin@norsys.fr', 'b054109103162fa601d0d95465827069','ROLE_ADMIN,ROLE_SALARIE'); -- hammadi

INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(NULL,'AIT-TALEB','Youssef','yaittaleb@norsys.fr', '8ba97607a1485ccdbe19745ed80cd52d','ROLE_SALARIE'); -- zaza
            
INSERT INTO personne(idPersonne ,nomPersonne,prenomPersonne,email,passwd,role) 
			VALUES(NULL,'Oudli','Ouijdane','ooudli@norsys.fr', 'ca0f3b9c304e765ac2ffac82c06b075c ','ROLE_SALARIE'); -- wijwij

/*==============================================================*/
/* Table : Poulle                                               */
/*==============================================================*/

INSERT INTO poulle(idPoulle,libellePoulle) VALUES(NULL,'A');
INSERT INTO poulle(idPoulle,libellePoulle) VALUES(NULL,'B');


/*==============================================================*/
/* Table : Equipe                                               */
/*==============================================================*/

INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(1,'Equipe 1A',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(2,'Equipe 2A',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(3,'Equipe 3A',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(4,'Equipe 4A',NULL);

INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(5,'Equipe 1B',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(6,'Equipe 2B',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(7,'Equipe 3B',NULL);
INSERT INTO equipe(idEquipe,libelleEquipe,imgEquipe) VALUES(8,'Equipe 4B',NULL);


/*==============================================================*/
/* Table : Rencontre                                           */
/*==============================================================*/
-- POLLE A ( 1A, 4A ) 
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2)
			VALUES(1,1,1,2,1,NULL,NULL,1,1);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(2,1,3,4,1,NULL,NULL,3,4);

            
            
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2)
			VALUES(3,1,1,3,1,NULL,NULL,2,1);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(4,1,2,4,1,NULL,NULL,0,0);

            
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2)
			VALUES(5,1,1,4,1,NULL,NULL,1,0);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(6,1,2,3,1,NULL,NULL,2,3);

-- POLLE B (2B , 4B ) 
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(7,2,5,8,1,NULL,NULL,0,1);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(8,2,6,7,1,NULL,NULL,2,0);
            
            
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(9,2,5,6,1,NULL,NULL,1,1);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(10,2,7,8,1,NULL,NULL,0,1);
            
            
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(11,2,5,7,1,NULL,NULL,3,0);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(12,2,6,8,1,NULL,NULL,4,0);

-- 1/2  ( 1A#1 , 4B#8)  -- ( 2B#6 , 4A#4 )

INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(13,null,1,8,1,NULL,NULL,2,1);
INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(14,null,6,4,1,NULL,NULL,1,0);


-- Final (1A#1 , 2B#6)

INSERT INTO rencontre(idRencontre, idPoulle,idEquipe1,idEquipe2,idCompetition, datedebut,dateFin , butEquipe1 , butEquipe2) 
			VALUES(15,null,1,6,1,NULL,NULL,1,2);




/*==============================================================*/
/* Table : Pronostic                                            */
/*==============================================================*/

-- INSERT INTO Pronostic( idPronostic,idRencontre, idPersonne, butEquipe1,butEquipe2, score ) VALUES();

