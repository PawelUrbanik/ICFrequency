package pl.pawel.icfreq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.icfreq.model.TrainFrequency;

@Repository
public interface TrainFrequencyRepository extends CrudRepository<TrainFrequency, Integer> {
}
