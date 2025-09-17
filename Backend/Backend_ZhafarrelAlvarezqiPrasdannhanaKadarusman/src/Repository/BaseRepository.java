package Repository;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class BaseRepository<T, ID> {
    HashMap<T, ID> Map;
    protected ArrayList<T> List;

    public BaseRepository(){
        Map = new HashMap<>();
        List = new ArrayList<>();

    }
    public HashMap findById(ID id){
        return getPlayerId();
    }

    public ArrayList findAll(){

    }

    public abstract void save(T entity);

    public abstract HashMap getId(T entity);

}
