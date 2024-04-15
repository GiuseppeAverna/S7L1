package Back.End.Esercizio.S7L1.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id) {
        super("elemento con id" + id + "non trovato");
    }
    public NotFoundException(String message){super(message);}

}
