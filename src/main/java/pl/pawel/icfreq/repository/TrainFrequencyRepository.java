package pl.pawel.icfreq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.icfreq.model.TrainFrequency;

import java.sql.Date;

@Repository
public interface TrainFrequencyRepository extends JpaRepository<TrainFrequency, Integer> {

    TrainFrequency findTrainFrequencyByNumberAndDataDownloadAndDateOfRunning(Integer number, Date date, Date dateOfRunning);
}
