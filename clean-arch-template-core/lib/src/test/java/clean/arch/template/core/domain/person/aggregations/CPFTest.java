package clean.arch.template.core.domain.person.aggregations;

import clean.arch.template.core.domain.person.exception.InvalidDocument;
import org.junit.Assert;
import org.junit.Test;

public class CPFTest {

    @Test(expected = InvalidDocument.class)
    public void CPF_shouldInvalidDocument_whenInvalidCPF() throws InvalidDocument {
        CPF cpf = new CPF("192.111.02-11");
    }

    @Test
    public void CPF_shouldSetCPF_whenValidCPF() throws InvalidDocument {
        CPF cpf = new CPF("184.196.967-22");
        Assert.assertEquals(cpf.toString(),"184.196.967-22");
    }


}