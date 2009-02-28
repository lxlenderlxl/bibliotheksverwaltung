package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.domain.Ausleiher;


public interface AusleiherDAO
{
	public ArrayList<Ausleiher> retrieve();
	public ArrayList<Ausleiher> retrieveAll();
	public ArrayList<Ausleiher> find(Ausleiher derAusleiher);
	public void add(Ausleiher derAusleiher);
	public void update(Ausleiher derAusleiher);
	public void deactivate(Ausleiher derAusleiher);
	public void activate(Ausleiher derAusleiher);
}
