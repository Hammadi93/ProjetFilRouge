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
public class Equipe {
	private int		idEquipe;
	private String	libelleEquipe;
	private String	imgEquipe;
	private int		idPoulle;
}
