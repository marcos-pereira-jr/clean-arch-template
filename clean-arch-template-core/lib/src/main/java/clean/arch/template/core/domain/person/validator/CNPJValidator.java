package clean.arch.template.core.domain.person.validator;

import clean.arch.template.core.domain.person.exception.InvalidDocument;

import java.util.regex.Pattern;

public class CNPJValidator implements Validator{
    public CNPJValidator(){}

    public static final Pattern FORMATED = Pattern.compile("(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})");

    public boolean assertValid(String value) {
        return FORMATED.matcher(value).matches();
    }

}
