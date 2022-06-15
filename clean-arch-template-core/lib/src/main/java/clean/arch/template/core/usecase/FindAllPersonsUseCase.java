package clean.arch.template.core.usecase;

import clean.arch.template.core.domain.person.Person;
import clean.arch.template.core.gateway.PersonGateway;

import java.util.ArrayList;
import java.util.List;

public record FindAllPersonsUseCase(PersonGateway personGateway) {

    public List<Person> execute() {
        return new ArrayList<>(personGateway.findAll());
    }

}
