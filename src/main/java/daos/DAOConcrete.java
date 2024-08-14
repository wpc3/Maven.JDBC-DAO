package daos;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class DAOConcrete implements DAOInterface {
//    private Connection connection;
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "Mightymac18!");
//    }
private static final String URL = "jdbc:mysql://localhost:3306/cars";
    private static final String USER = "root";
    private static final String PASSWORD = "Mightymac18!";

    // Use a connection method to avoid direct connection use
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//    public DAOConcrete(Connection connection){
//        this.connection = connection;
//    }

    @Override
    public Cars findById(int id) {
        String query = "SELECT * FOM car WHERE id = ?";
        try { Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet resultset = pstm.executeQuery();
            if(resultset.next()){
                return new Cars(
                        resultset.getInt("id"),
                        resultset.getString("make"),
                        resultset.getInt("year"),
                        resultset.getString("color"),
                        resultset.getInt("vin"),
                        resultset.getString("model")
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
    }
        return null;
    }

    @Override
    public Cars create(Cars dto) {
        String query = "INSERT INTO car (id,make,year,color,vin,model) VALUES (?,?,?,?,?,?)";
        try {Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1,dto.getId());
            pstm.setString(2, dto.getMake());
            pstm.setInt(3,dto.getYear());
            pstm.setString(4,dto.getColor());
            pstm.setInt(5,dto.getVin());
            pstm.setString(6,dto.getModel());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public Cars update(Cars dto) {
        return null;
    }

    @Override
    public List<Cars> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void deleteID() {

    }

    public static void main(String[] args) {
        DAOInterface daoInterface = new DAOConcrete();

//         Create a new car
        Cars newCar = new Cars(6, "BMW", 2024, "Blue", 1029476201, "i10");
        newCar = daoInterface.create(newCar);
        System.out.println("Created Car: " + newCar);
//        Cars car = daoInterface.findById(newCar.getId());
//        System.out.println("Found Car: " + car);

    }

//    @Override
//    public Cars findById(int id) {
//        String query = "SELECT * FOM car WHERE id = ? ";
//        try {
//            PreparedStatement pstm = connection.prepareStatement(query);
//            pstm.setInt(1,id);
//            ResultSet resultset = pstm.executeQuery();
//            if(resultset.next()){
//                return new Cars(
//                        resultset.getInt("id"),
//                        resultset.getString("make"),
//                        resultset.getInt("year"),
//                        resultset.getString("color"),
//                        resultset.getInt("vin"),
//                        resultset.getString("model")
//                );
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        return null;
//    }

//    @Override
//    public Cars create(Cars dto) {
//        String query = "INSERT INTO car (id,make,year,color,vin,model) VALUES (?,?,?,?,?,?)";
//        try {
//            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            pstm.setInt(1, dto.);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

//    @Override
//    public Object update(Object dto) {
//        return null;
//    }
//
//    @Override
//    public List findAll() {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public void deleteID() {
//
//    }
}
