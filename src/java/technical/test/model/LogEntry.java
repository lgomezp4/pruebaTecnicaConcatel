package technical.test.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Luis Gómez
 */
public class LogEntry {
    
    private Rebel rebel;
    private Planet planet;
    private Date date;

    public LogEntry() {
    }

    public LogEntry(Rebel rebel, Planet planet, Date date) {
        this.rebel = rebel;
        this.planet = planet;
        this.date = date;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
