package personas;

public class personaException extends Exception {

    public String errorMessage;

    public personaException() {
        this.errorMessage = "Error desconocido";
    }

    public personaException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
