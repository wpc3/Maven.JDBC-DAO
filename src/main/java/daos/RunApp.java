package daos;

public class RunApp {

    public static void main(String[] args) {
        DAOConcrete daoConcrete = new DAOConcrete();

//         Create a new car
//        Cars newCar = new Cars(6, "BMW", 2024, "Blue", 1029476201, "i10");
//        newCar = daoInterface.create(newCar);
//        System.out.println("Created Car: " + newCar);


//        Cars car = daoInterface.findById(3);
//        System.out.println("Found Car: " + car);

        daoConcrete.findAll();
//
//        daoInterface.deleteID(9);
//        System.out.println("Deleted Car");

//        Cars newCar = new Cars(0, "BMW", 2022, "Orange", 127476201, "i10");
//        daoInterface.create(newCar);
//        System.out.println(newCar);
    }
}

