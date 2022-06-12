package clean.arch.template.api.apitemplate.api.mapper;

import clean.arch.template.api.apitemplate.api.payloads.PersonDTORequest;
import clean.arch.template.api.apitemplate.api.payloads.PersonDTOResponse;
import clean.arch.template.core.domain.Person;

public class PersonEntrypointMapper {

    public static PersonDTOResponse domainToResponseDTO(Person person) {
        return PersonDTOResponse.builder().name(person.getName()).build();
    }

    public static Person requestToDomain(PersonDTORequest dto) {
        return Person.builder().name(dto.getName()).build();
    }

}
