/**
 * 
 */
package bibliotheksverwaltung.util;

public class UpdateInfo
{
	private boolean updateSperre;
	private String wasGe�ndert;
	private boolean �nderungOk;
	public UpdateInfo()
	{
		updateSperre = false;
		wasGe�ndert = "";
		�nderungOk = true;
	}
	public boolean holeUpdateSperre()
	{
		return updateSperre;
	}
	public void setzeUpdateSperre(boolean sperre)
	{
		updateSperre = sperre;
	}
	public String hole�nderung()
	{
		return wasGe�ndert;
	}
	public void setze�nderung(String name)
	{
		wasGe�ndert = name;
	}
	public boolean hole�nderungOk()
	{
		return �nderungOk;
	}
	public void setze�nderungOk(boolean wert)
	{
		�nderungOk = wert;
	}
}
