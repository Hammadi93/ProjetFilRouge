package fr.norsys.filrouge.entities;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rencontre {
	private int			idRencontre;
	private Timestamp	dateDebut;
	private Timestamp	dateFin;
	private int			butEquipe1;
	private int			butEquipe2;
	private int			status;
	private Equipe		equipe1;
	private Equipe		equipe2;
	private Poule		poulle;
	private Competition	competition;

}
