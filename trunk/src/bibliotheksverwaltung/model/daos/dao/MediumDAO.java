package bibliotheksverwaltung.model.daos.dao;
import java.util.ArrayList;

import bibliotheksverwaltung.model.daos.domain.Medium;



public interface MediumDAO
{
	public ArrayList<Medium> retrieve();
	public ArrayList<Medium> retrieveAll();
	public ArrayList<Medium> find(Medium dasMedium);
	public void add(Medium dasMedium);
	public void update(Medium dasMedium);
	public void deactivate(Medium dasMedium);
	public void activate(Medium dasMedium);
}
