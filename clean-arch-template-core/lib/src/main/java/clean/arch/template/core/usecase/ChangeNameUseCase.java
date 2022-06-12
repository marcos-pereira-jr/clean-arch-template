package clean.arch.template.core.usecase;


import clean.arch.template.core.domain.Person;
import clean.arch.template.core.gateway.PersonGateway;

public record ChangeNameUseCase(PersonGateway personGateway) {

    public Person execute(Person person, String newName) {
        person.setName(newName);
        return personGateway.save(person);
    }

}