package PokedexDB.hibernate.dao;

import PokedexDB.hibernate.HibernateUtility;
import PokedexDB.hibernate.model.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PokedexDao {

    SessionFactory factory = null;
    Session ses1 = null;

    private static PokedexDao single_instance=null;

    public PokedexDao(){
        factory = HibernateUtility.getSessionFactory();
    }

    public static PokedexDao getInstance(){
        {
            if (single_instance == null){
                single_instance = new PokedexDao();
            }
            return single_instance;
        }
    }

    public List<Pokemon> getPokemon() {

        try{
            ses1 = factory.openSession();
            ses1.getTransaction().begin();
            String sql = "from PokedexDB.hibernate.model.Pokemon";
            List<Pokemon> pk = (List<Pokemon>)ses1.createQuery(sql).getResultList();
            ses1.getTransaction().commit();
            return pk;
        }catch (Exception e){
            e.printStackTrace();
            //Session rollback
            ses1.getTransaction().rollback();
            return null;
        } finally{
            ses1.close();
        }
    }

    public Pokemon getPokemon(int pokeID){

        try{
            ses1 = factory.openSession();
            ses1.getTransaction().begin();
            String sql = "from PokedexDB.hibernate.model.Pokemon where id=" + Integer.toString(pokeID);
            Pokemon p = (Pokemon)ses1.createQuery(sql).getSingleResult();
            ses1.getTransaction().commit();
            return p;
        }catch (Exception e){
            e.printStackTrace();
            //Rollback
            ses1.getTransaction().rollback();
            return null;
        }finally{
            ses1.close();
        }
    }
    
    public void savePokemon(Pokemon p){
        try{
            ses1 = factory.openSession();
            ses1.getTransaction().begin();
            System.out.println("Saving Pokemon Number: " + p.getPokeID() + " PokemonName: " + p.getPokename());
            ses1.saveOrUpdate(p);
            ses1.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            //Rollback
            ses1.getTransaction().rollback();
        }finally{
            ses1.close();
        }
    }

}
