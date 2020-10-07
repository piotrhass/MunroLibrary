package hass.piotr;

public class Hill implements Comparable<Hill> {

    private double doBIHNumber;
    private String name;
    private double heightFeet;
    private String gridRef;
    private String type;


    public Hill(double doBIHNumber, String name, double heightFeet, String gridRef, String type) {
        doBIHNumber = doBIHNumber;
        this.name = name;
        this.heightFeet = heightFeet;
        gridRef = gridRef;
        this.type = type;
    }

    public double getDoBIHNumber() {
        return doBIHNumber;
    }

    public String getName() {
        return name;
    }

    public double getHeightFeet() {
        return heightFeet;
    }

    public String getType() {
        return type;
    }

    public String getGridRef() {
        return gridRef;
    }

    @Override
    public int compareTo(Hill o) {
        if(this.heightFeet == o.heightFeet){
            return this.name.compareTo(o.name);
        }else {
            return (o.heightFeet - this.heightFeet) > 0 ? 1 : -1;
        }
    }

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
