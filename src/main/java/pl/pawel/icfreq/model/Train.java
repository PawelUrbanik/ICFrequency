package pl.pawel.icfreq.model;

import java.sql.Date;

public class Train {

    public Train() {
    }

    public Train(String from, String to, String frequency, int number, Date dateOfRunning, Date dataDownload) {
        this.from = from;
        this.to = to;
        this.frequency = frequency;
        this.number = number;
        this.dateOfRunning = dateOfRunning;
        this.dataDownload = dataDownload;
    }

    String from;
    String to;
    String frequency;
    int number;
    Date dateOfRunning;
    Date dataDownload;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
}
