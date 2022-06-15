package clean.arch.template.core.domain.person.aggregations;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import clean.arch.template.core.domain.person.exception.InvalidDocument;

public class CPF extends Document {

    public CPF(String value) throws InvalidDocument {
        super(value);
    }

    @Override
    protected boolean check(String value){
        CPFValidator cpfValidator = new CPFValidator(true);
        try{
            cpfValidator.assertValid(value);
            return true;
        }catch(InvalidStateException e){
            return false;
        }
    }

}
