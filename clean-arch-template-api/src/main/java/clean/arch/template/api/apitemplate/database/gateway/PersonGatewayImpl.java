package clean.arch.template.api.apitemplate.database.gateway;


import clean.arch.template.api.apitemplate.database.mapper.PersonPresentationMapper;
import clean.arch.template.api.apitemplate.database.presentation.PersonPresentation;
import clean.arch.template.api.apitemplate.database.repository.PersonMongoDBRepository;
import clean.arch.template.core.domain.Person;
import clean.arch.template.core.exception.PersonNotFound;
import clean.arch.template.core.gateway.PersonGateway;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record PersonGatewayImpl(PersonMongoDBRepository personMongoDBRepository) implements PersonGateway {

    @Override
    public List<Person> findAll() {
        return personMongoDBRepository
            .findAll()
            .stream()
            .map(PersonPresentationMapper::presentationToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Person save(final Person person) {
        final PersonPresentation personPresentation = PersonPresentationMapper.domainToPresentation(person);
        return PersonPresentationMapper.presentationToDomain(personMongoDBRepository.save(personPresentation));
    }

    @Override
    public Person changeName(final String id, final String newName) {
        final Optional<PersonPresentation> presentationOptional = personMongoDBRepository.findById(id);

        if (presentationOptional.isPresent()) {
            final PersonPresentation presentation = presentationOptional.get();
            presentation.setName(newName);
            return PersonPresentationMapper.presentationToDomain(personMongoDBRepository.save(presentation));
        }

        throw new PersonNotFound("No has Person with this id: " + id);
    }

}
