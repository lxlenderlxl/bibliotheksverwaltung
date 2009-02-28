package bibliotheksverwaltung.model.daos.exceptions;

public class DataAccessException extends DaoException 
{
	/**
	 *
	 */
	private static final long serialVersionUID = -1969880956740273464L;

	public DataAccessException() 
	{
	}
	
	public DataAccessException(Throwable t) 
	{
		super(t);
	}
}
