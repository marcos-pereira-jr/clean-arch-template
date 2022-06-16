package clean.arch.template.core.domain.person;

import clean.arch.template.core.domain.person.aggregations.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Document document;
}
