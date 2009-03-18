/**
 * 
 */
package bibliotheksverwaltung.util;

public class UpdateInfo
{
	private boolean updateSperre;
	private String wasGeaendert;
	private boolean aenderungOk;
	public UpdateInfo()
	{
		updateSperre = false;
		wasGeaendert = "";
		aenderungOk = true;
	}
	public boolean holeUpdateSperre()
	{
		return updateSperre;
	}
	public void setzeUpdateSperre(boolean sperre)
	{
		updateSperre = sperre;
	}
	public String holeAenderung()
	{
		return wasGeaendert;
	}
	public void setzeAenderung(String name)
	{
		wasGeaendert = name;
	}
	public boolean holeAenderungOk()
	{
		return aenderungOk;
	}
	public void setzeAenderungOk(boolean wert)
	{
		aenderungOk = wert;
	}
}
