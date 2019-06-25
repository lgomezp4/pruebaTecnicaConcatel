package technical.test.model;

import java.util.Objects;

/**
 *
 * @author Luis Gómez
 */
public class Rebel {
    //attributes
    private String name;

    //constructors
    public Rebel() {
    }
   
    public Rebel(String name) {
        this.name = name;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Rebel other = (Rebel) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rebel{");
        sb.append("name=").append(name);
        sb.append('}');
        return sb.toString();
    }   
}
