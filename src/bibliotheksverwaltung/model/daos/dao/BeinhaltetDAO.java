/**
 * 
 */
package bibliotheksverwaltung.model.daos.dao;

import java.util.ArrayList;

public interface BeinhaltetDAO
{
	public ArrayList<Integer> get(int medienID);
	public void add(int dieTagId, int dieMedienId);
	public void delete(int dieTagId, int dieMedienId);
}
