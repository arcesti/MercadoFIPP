package unoeste.fipp.mercadofipp.entities;

public class Erro {
    private String message;

    public Erro(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
