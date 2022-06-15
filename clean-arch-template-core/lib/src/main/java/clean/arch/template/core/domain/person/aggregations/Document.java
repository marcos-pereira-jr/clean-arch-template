package clean.arch.template.core.domain.person.aggregations;

import clean.arch.template.core.domain.person.exception.InvalidDocument;
import lombok.Data;
import org.checkerframework.checker.regex.qual.Regex;

@Data
public abstract class Document {

    private String value;

    public Document(String value) throws InvalidDocument {
        this.setValue(value);
    }

    protected boolean check(String value){
        return false;
    }

    private void setValue(String value) throws InvalidDocument {
        if(check(value)){
            this.value = value;
        }else{
            throw new InvalidDocument();
        }
    }

    @Override
    public String toString() {
        return this.value;
    }



}
