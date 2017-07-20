package fr.norsys.filrouge.entities;

import java.util.List;

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
public class Poule {
	private int				idPoulle;
	private String			libellePoulle;
	private List<Equipe>	listEquipe;
	private Competition		competition;

	public Poule(int idPoulle, String libellePoulle, Competition competition) {
		this.idPoulle = idPoulle;
		this.libellePoulle = libellePoulle;
		this.competition = competition;
	}
}
