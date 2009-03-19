package bibliotheksverwaltung.model.logic;

import java.util.Observer;

public interface Verwaltbar extends Observer{

	public void update(Object objekt);

	void add(Object objekt);

	void delete(Object objekt);

}
