package daos;

public class Cars {

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

public String getMake(String make){
    return make;
}

public void setMake(String make){
 this.make = make;
}

public int getVin(int vin){
    return vin;
}

public void setVin(int vin){
    this.vin = vin;
}

public int getYear(int year){
    return year;
}

public void setYear(int year){
    this.year = year;
}

public String getColor(String color){
    return color;
}

public void setColor(String color){
    this.color = color;
}

public String getModel(String model){
    return model;
}

public void setModel(String model){
    this.model = model;
}
}
