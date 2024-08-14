package daos;

import java.util.List;

public interface DAOInterface {

//    public T findByID(int id){
//      for(T ids : )
//        return id;
//    }
    Cars findById(int id);
    Cars create(Cars dto);
    Cars update(Cars dto);
    List<Cars> findAll();
    void deleteID();



}
