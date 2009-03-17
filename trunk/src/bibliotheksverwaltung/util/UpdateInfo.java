/**
 * 
 */
package bibliotheksverwaltung.util;

public class UpdateInfo
{
	private boolean updateSperre;
	private String wasGeändert;
	private boolean änderungOk;
	public UpdateInfo()
	{
		updateSperre = false;
		wasGeändert = "";
		änderungOk = true;
	}
	public boolean holeUpdateSperre()
	{
		return updateSperre;
	}
	public void setzeUpdateSperre(boolean sperre)
	{
		updateSperre = sperre;
	}
	public String holeÄnderung()
	{
		return wasGeändert;
	}
	public void setzeÄnderung(String name)
	{
		wasGeändert = name;
	}
	public boolean holeÄnderungOk()
	{
		return änderungOk;
	}
	public void setzeÄnderungOk(boolean wert)
	{
		änderungOk = wert;
	}
}
