package PokedexDB.hibernate.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokeID", nullable = false)
    private int id;

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

    public int getPokeID(){return id;}

    public void setPokeID(int pokeID){this.id = pokeID;}

    public String toString() {
        return Integer.toString(id) + " " + pokename + " " + poketype;
    }
}
