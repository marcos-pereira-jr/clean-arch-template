package clean.arch.template.api.apitemplate.beans;

import clean.arch.template.api.apitemplate.database.gateway.PersonGatewayImpl;
import clean.arch.template.api.apitemplate.database.repository.PersonMongoDBRepository;
import clean.arch.template.core.gateway.PersonGateway;
import clean.arch.template.core.usecase.ChangeNameUseCase;
import clean.arch.template.core.usecase.FindAllPersonsUseCase;
import clean.arch.template.core.usecase.SavePersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PersonGateway personGateway(PersonMongoDBRepository personMongoDBRepository) {
        return new PersonGatewayImpl(personMongoDBRepository);
    }

    @Bean
    public ChangeNameUseCase changeNameUseCase(PersonGateway personGateway) {
        return new ChangeNameUseCase(personGateway);
    }

    @Bean
    public FindAllPersonsUseCase findAllPersonsUseCase(PersonGateway personGateway) {
        return new FindAllPersonsUseCase(personGateway);
    }

    @Bean
    public SavePersonUseCase savePersonUseCase(PersonGateway personGateway) {
        return new SavePersonUseCase(personGateway);
    }

}
