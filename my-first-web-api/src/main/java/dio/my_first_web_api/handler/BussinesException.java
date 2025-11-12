package dio.my_first_web_api.handler;

public class BussinesException extends Exception {
    public BussinesException(String message) {
        super(message);
    }
    public BussinesException(String message, Object ... params) {
        super(String.format(message, params));
    }
}
