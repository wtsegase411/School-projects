
public class UnmatchedException extends RuntimeException {
	public UnmatchedException() {
		super("Passwords don't match!");
	}
	public UnmatchedException(String message) {
		super(message);
	}

}
