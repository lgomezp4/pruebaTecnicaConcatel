package technical.test.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Luis Gómez
 */
public class LogEntry {
    //attributes
    private Rebel rebel;
    private Planet planet;
    private Timestamp date;

    //constructors
    public LogEntry() {
    }

    public LogEntry(Rebel rebel, Planet planet) {
        this.rebel = rebel;
        this.planet = planet;
        //this.date = new DateTime
    }
    
    public LogEntry(Rebel rebel, Planet planet, Timestamp date) {
        this.rebel = rebel;
        this.planet = planet;
        this.date = date;
    }

    //getters and setters
    public Rebel getRebel() {
        return rebel;
    }

    public void setRebel(Rebel rebel) {
        this.rebel = rebel;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogEntry other = (LogEntry) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LogEntry{");
        sb.append("rebel=").append(rebel);
        sb.append(", planet=").append(planet);
        sb.append(", date=").append(date);
        sb.append('}');
        return  sb.toString();
    }
    
}
