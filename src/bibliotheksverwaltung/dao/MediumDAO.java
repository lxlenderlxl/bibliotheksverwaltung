package bibliotheksverwaltung.dao;
import java.util.ArrayList;

import bibliotheksverwaltung.domain.Medium;



public interface MediumDAO
{
	public ArrayList<Medium> retrieve();
	public ArrayList<Medium> retrieveAll();
	public ArrayList<Medium> find(Medium dasMedium);
	public void add(Medium dasMedium);
	public void update(Medium dasMedium);
	public void delete(Medium dasMedium);
	public void unDelete(Medium dasMedium);
}
