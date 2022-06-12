package clean.arch.template.core.usecase;

import clean.arch.template.core.domain.Person;
import clean.arch.template.core.gateway.PersonGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record FindAllPersonsUseCase(PersonGateway personGateway) {

    public List<Person> execute() {
        return new ArrayList<>(personGateway.findAll());
    }

}
