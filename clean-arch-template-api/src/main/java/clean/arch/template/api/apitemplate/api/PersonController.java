package clean.arch.template.api.apitemplate.api;

import clean.arch.template.api.apitemplate.api.mapper.PersonEntrypointMapper;
import clean.arch.template.api.apitemplate.api.payloads.PersonDTORequest;
import clean.arch.template.api.apitemplate.api.payloads.PersonDTOResponse;
import clean.arch.template.core.usecase.ChangeNameUseCase;
import clean.arch.template.core.usecase.FindAllPersonsUseCase;
import clean.arch.template.core.usecase.SavePersonUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public record PersonController(ChangeNameUseCase changeNameUseCase,
                               FindAllPersonsUseCase findAllPersonsUseCase,
                               SavePersonUseCase savePersonUseCase) {

    @GetMapping
    public ResponseEntity<List<PersonDTOResponse>> findAll() {
        return ResponseEntity.ok(
                findAllPersonsUseCase.execute()
                        .stream()
                        .map(PersonEntrypointMapper::domainToResponseDTO)
                        .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTOResponse> changeName(@PathVariable String id, @Valid @RequestBody PersonDTORequest personDTORequest) {
        return ResponseEntity.ok(
                PersonEntrypointMapper.domainToResponseDTO(
                    changeNameUseCase.execute(PersonEntrypointMapper.requestToDomain(personDTORequest),"Pedro")
                )
        );
    }

    @PostMapping
    public ResponseEntity<PersonDTOResponse> save(@RequestBody @Valid PersonDTORequest requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body((
                        PersonEntrypointMapper.domainToResponseDTO(
                            savePersonUseCase.execute(PersonEntrypointMapper.requestToDomain(requestDTO))
                        )
                    ));
    }

}
