package fr.norsys.filrouge.entities;

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
public class Pronostic {

	private int idPronostic;
	private int butEquipe1;
	private int butEquipe2;
	private int score;
	Rencontre rencontre;
	Personne personne;
}
