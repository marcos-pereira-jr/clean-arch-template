package clean.arch.template.core.gateway;



import clean.arch.template.core.domain.Person;

import java.util.List;

public interface PersonGateway {

    List<Person> findAll();
    Person save(Person person);
    Person changeName(String id, String newName);

}
