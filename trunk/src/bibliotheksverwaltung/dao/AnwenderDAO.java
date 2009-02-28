package bibliotheksverwaltung.dao;

import java.util.ArrayList;

import bibliotheksverwaltung.domain.Anwender;


public interface AnwenderDAO
{
	public ArrayList<Anwender> retrieve();
	public ArrayList<Anwender> retrieveAll();
	public ArrayList<Anwender> find(Anwender derAnwender);
	public void add(Anwender derAnwender);
	public void update(Anwender derAnwender);
	public void delete(Anwender derAnwender);
	public void unDelete(Anwender derAnwender);
}
