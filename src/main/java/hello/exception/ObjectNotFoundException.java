package hello.exception;

public class ObjectNotFoundException extends BaseException{

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message) {
		super(message);
	}

}
