package clean.arch.template.core.usecase;

import clean.arch.template.core.domain.person.Person;
import clean.arch.template.core.gateway.PersonGateway;

public record SavePersonUseCase(PersonGateway personGateway) {

    public Person execute(Person person) {
        return personGateway.save(person);
    }

}