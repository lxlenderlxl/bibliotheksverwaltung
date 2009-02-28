package bibliotheksverwaltung.model.daos.domain;

import java.sql.Date;

public class Exemplar
{
	private int id = 0;
	private Zustand zustand = null;
	private Ausleiher ausleiher = null;
	private Medium medium = null;
	private Date rueckgabeDatum = null;
	private int verlaengerung = 0;
	private boolean aktiv;
	
}
