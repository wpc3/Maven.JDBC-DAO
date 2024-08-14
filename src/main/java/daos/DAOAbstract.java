package daos;

import java.util.List;

public interface DAOAbstract<T> {

//    public T findByID(int id){
//      for(T ids : )
//        return id;
//    }
    T fidnById(int id);
    T create(T dto);
    T update(T dto);
    List<T> findAll();
    void deleteID();



}
