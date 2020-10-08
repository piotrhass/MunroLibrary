package hass.piotr;

public class Hill {

    //Fields
    private double doBIHNumber;
    private String name;
    private double heightFeet;
    private String gridRef;
    private String type;

    //Constructor
    public Hill(double doBIHNumber, String name, double heightFeet, String gridRef, String type) {
        this.doBIHNumber = doBIHNumber;
        this.name = name;
        this.heightFeet = heightFeet;
        this.gridRef = gridRef;
        this.type = type;
    }
    //Returns doBIHNumber variable
    public double getDoBIHNumber() {
        return doBIHNumber;
    }
    //Returns name variable
    public String getName() {
        return name;
    }
    //Returns heightFeet variable
    public double getHeightFeet() {
        return heightFeet;
    }
    //Returns type variable
    public String getType() {
        return type;
    }
    //Returns gridRef variable
    public String getGridRef() {
        return gridRef;
    }
    //Returns a Hill Object with parameters
    @Override
    public String toString() {
        return "Hill{" +
                "DoBIHNumber=" + doBIHNumber +
                ", name='" + name + '\'' +
                ", heightFeet=" + heightFeet +
                ", GridRef='" + gridRef + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
