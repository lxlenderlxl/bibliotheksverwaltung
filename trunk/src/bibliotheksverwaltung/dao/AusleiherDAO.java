package bibliotheksverwaltung.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.domain.Ausleiher;


public interface AusleiherDAO
{
	public ArrayList<Ausleiher> retrieve();
	public ArrayList<Ausleiher> retrieveAll();
	public ArrayList<Ausleiher> find(Ausleiher derAusleiher);
	public void add(Ausleiher derAusleiher);
	public void update(Ausleiher derAusleiher);
	public void delete(Ausleiher derAusleiher);
	public void unDelete(Ausleiher derAusleiher);
}
