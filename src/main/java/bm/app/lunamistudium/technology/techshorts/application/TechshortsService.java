package bm.app.lunamistudium.technology.techshorts.application;

import bm.app.lunamistudium.technology.techshorts.application.port.TechshortsUseCase;
import bm.app.lunamistudium.technology.techshorts.domain.Techshort;
import bm.app.lunamistudium.technology.techshorts.domain.TechshortsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
class TechshortsService implements TechshortsUseCase {

    private final TechshortsRepository techshortsRepository;

    @Override
    public List<Techshort> findAll() {
        return techshortsRepository.findAll();
    }

    @Override
    public Techshort addTechshort(CreateTechshortCommand command) {
        Techshort techshort = command.toTechshort();
        return techshortsRepository.save(techshort);
    }

    @Override
    public void removeById(Long id) {
        techshortsRepository.deleteById(id);
    }

    @Override
    public UpdateTechshortResponse updateTechshort(UpdateTechshortCommand command) {
        return techshortsRepository.findById(command.getId())
                .map(techshort -> {
                    Techshort updatedTechshort = command.updateFields(techshort);
                    techshortsRepository.save(updatedTechshort);
                    return UpdateTechshortResponse.SUCCESS;
                })
                .orElseGet(() -> new UpdateTechshortResponse(false, Collections.singletonList("Techshort not found with the id of: " + command.getId())));
    }
}
