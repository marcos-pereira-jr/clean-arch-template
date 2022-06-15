package clean.arch.template.core.domain.person.exception;

public class InvalidDocument extends Exception{
    @Override
    public String getMessage(){
        return "Inválido";
    }
}
