package daos;

import java.sql.*;
import java.util.*;

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
        String query = "SELECT * FROM car WHERE id = ?";
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
        String query = "INSERT INTO car (make,year,color,vin,model) VALUES (?,?,?,?,?)";
        try {Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            pstm.setInt(1,dto.getId());// dont need to worry about id's because it's auto incremented
            pstm.setString(1, dto.getMake());
            pstm.setInt(2,dto.getYear());
            pstm.setString(3,dto.getColor());
            pstm.setInt(4,dto.getVin());
            pstm.setString(5,dto.getModel());
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public Cars update(Cars dto) {
        String query = "UPDATE car SET  make = ?,year = ?,color = ?,vin = ?,model = ? WHERE id = ?";
        try {Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//            pstm.setInt(1,dto.getId());
            pstm.setString(1, dto.getMake());
            pstm.setInt(2,dto.getYear());
            pstm.setString(3,dto.getColor());
            pstm.setInt(4,dto.getVin());
            pstm.setString(5,dto.getModel());
            pstm.setInt(6,dto.getId());
            pstm.executeUpdate();


        return dto;
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public List<Cars> findAll() {
        List<Cars> cars = new ArrayList<>();
        String query = "SELECT * FROM car)";
        try {Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while(rs.next())
            {
            cars.add(new Cars(rs.getInt("id"),rs.getString("make"),rs.getInt("year"),rs.getString("color"),rs.getInt("vin"),rs.getString("model")));
            }


        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return cars;
    }

    @Override
    public void deleteID(int id) {
        String query = "DELETE FROM car WHERE id =?";
        try {
            Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public static void main(String[] args) {
        DAOInterface daoInterface = new DAOConcrete();

//         Create a new car
//        Cars newCar = new Cars(6, "BMW", 2024, "Blue", 1029476201, "i10");
//        newCar = daoInterface.create(newCar);
//        System.out.println("Created Car: " + newCar);


        Cars car = daoInterface.findById(3);
        System.out.println("Found Car: " + car);

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
