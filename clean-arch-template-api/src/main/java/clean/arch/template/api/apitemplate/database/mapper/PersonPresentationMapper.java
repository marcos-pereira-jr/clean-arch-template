package clean.arch.template.api.apitemplate.database.mapper;

import clean.arch.template.api.apitemplate.database.presentation.PersonPresentation;
import clean.arch.template.core.domain.Person;

public class PersonPresentationMapper {

    public static Person presentationToDomain(PersonPresentation presentation) {
        return Person.builder()
            .name(presentation.getName())
            .build();
    }

    public static PersonPresentation domainToPresentation(Person domain) {
        return PersonPresentation.builder()
            .name(domain.getName())
            .build();
    }

}
