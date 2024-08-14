package daos;

public class Cars implements GetIDInterface {

private int id;
private String make;
private int year;
private String color;
private int vin;
private String model;

public Cars(int id, String make, int year, String color, int vin, String model){
    this.id = id;
    this.make = make;
    this.vin = vin;
    this.model = model;
    this.year = year;
    this.color = color;
}

public String getMake(){
    return make;
}

public void setMake(String make){
 this.make = make;
}

public int getVin(){
    return vin;
}

public void setVin(int vin){
    this.vin = vin;
}

public int getYear(){
    return year;
}

public void setYear(int year){
    this.year = year;
}

public String getColor(){
    return color;
}

public void setColor(String color){
    this.color = color;
}

public String getModel(){
    return model;
}

public void setModel(String model){
    this.model = model;
}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", model='" + model + '\'' +
                '}';
    }
}
