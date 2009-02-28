package bibliotheksverwaltung.exceptions;

public class DaoException extends RuntimeException 
{
	/**
	 *
	 */
	private static final long serialVersionUID = -7130988429113933339L;

	public DaoException() 
	{
	}
	public DaoException(Throwable t) 
	{
		super(t);
	}
}
