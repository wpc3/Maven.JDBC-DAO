package daos;

public class RunApp {

    public static void main(String[] args) {
        DAOInterface daoInterface = new DAOConcrete();

//         Create a new car
//        Cars newCar = new Cars(6, "BMW", 2024, "Blue", 1029476201, "i10");
//        newCar = daoInterface.create(newCar);
//        System.out.println("Created Car: " + newCar);


        Cars car = daoInterface.findById(2);
        System.out.println("Found Car: " + car);

    }
}

