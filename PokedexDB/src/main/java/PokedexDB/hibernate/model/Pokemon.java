package PokedexDB.hibernate.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokeID", nullable = true)
    private Integer id;

    @Column(name = "pokename")
    private String pokename;

    @Column(name = "poketype")
    private String poketype;

    public String getPokename() {
        return pokename;
    }

    public void setPokename(String pokename) {
        this.pokename = pokename;
    }

    public String getPoketype() {
        return poketype;
    }

    public void setPoketype(String poketype) {
        this.poketype = poketype;
    }

    public Integer getPokeID() {
        return id;
    }

    public void setPokeID(int pokeID) {
        this.id = pokeID;
    }

    public String toString() {
        return Integer.toString(id) + " " + pokename + " " + poketype;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon that = (Pokemon) o;

        if (id != null ? !id.equals(that.id) : that.id !=null) return false;
        if (pokename != null ? !pokename.equals(that.pokename) : that.pokename != null) return false;
        if (poketype != null ? !poketype.equals(that.poketype) : that.poketype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pokename != null ? pokename.hashCode() : 0);
        result = 31 * result + (poketype != null ? poketype.hashCode() : 0);
        return result;
    }
}