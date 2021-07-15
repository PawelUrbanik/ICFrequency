package pl.pawel.icfreq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class TrainFrequency {

    public TrainFrequency() {
    }

    public TrainFrequency(String fromStation, String toStation, String frequency, int number, Date dateOfRunning, Date dataDownload) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.frequency = frequency;
        this.number = number;
        this.dateOfRunning = dateOfRunning;
        this.dataDownload = dataDownload;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String fromStation;
    String toStation;
    String frequency;
    int number;
    String category;
    Date dateOfRunning;
    Date dataDownload;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String from) {
        this.fromStation = from;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String to) {
        this.toStation = to;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateOfRunning() {
        return dateOfRunning;
    }

    public void setDateOfRunning(Date dateOfRunning) {
        this.dateOfRunning = dateOfRunning;
    }

    public Date getDataDownload() {
        return dataDownload;
    }

    public void setDataDownload(Date dataDownload) {
        this.dataDownload = dataDownload;
    }

    @Override
    public String toString() {
        return "Frekwencja{" +
                "stacja początkowa='" + fromStation + '\'' +
                ", stacja końcowa='" + toStation + '\'' +
                ", numer pociągu=" + number +
                ", kategoria='" + category + '\'' +
                ", frekwencja='" + frequency + '\'' +
                ", data kursowania=" + dateOfRunning +
                ", data pobrania danych=" + dataDownload +
                '}';
    }
}
