package clean.arch.template.core.domain.person.aggregations;

import clean.arch.template.core.domain.person.exception.InvalidDocument;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CNPJTest {

    @Test(expected = InvalidDocument.class)
    public void CNPJ_shouldInvalidDocument_whenInvalidCNPJ() throws InvalidDocument {
        CNPJ cpf = new CNPJ("74.111.314/00017");
    }

    @Test
    public void CNPJ_shouldSetCPF_whenValidCNPJ() throws InvalidDocument {
        CNPJ cpf = new CNPJ("74.111.314/0001-07");
        Assert.assertEquals(cpf.toString(),"74.111.314/0001-07");
    }

}