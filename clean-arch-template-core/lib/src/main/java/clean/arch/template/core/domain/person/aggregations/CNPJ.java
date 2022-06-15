package clean.arch.template.core.domain.person.aggregations;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import clean.arch.template.core.domain.person.exception.InvalidDocument;
import clean.arch.template.core.domain.person.validator.CNPJValidator;

public class CNPJ extends Document{

    public CNPJ(String value) throws InvalidDocument {
        super(value);
    }

    @Override
    protected boolean check(String value){
        CNPJValidator cnpjValidator = new CNPJValidator();
        return cnpjValidator.assertValid(value);
    }
}
