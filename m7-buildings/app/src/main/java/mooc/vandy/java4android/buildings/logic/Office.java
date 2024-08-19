package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = null;
        this.mParkingSpaces = 0;
        sTotalOffices += 1;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        sTotalOffices += 1;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
                    int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = parkingSpaces;
        sTotalOffices += 1;
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }

    public int getParkingSpaces() {
        return this.mParkingSpaces;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }

    public void setBusinessName(String businessName) {
        this.mBusinessName = businessName;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.mParkingSpaces = parkingSpaces;
    }

    @Override
    public String toString() {
        String res = "Business: ";
        if (this.getBusinessName() == null) {
            res += "unoccupied";
        } else {
            res += this.getBusinessName();
        }
        if (this.getParkingSpaces() > 0) {
            res += this.getParkingSpaces();
        }
        res += (" (total offices: " + getTotalOffices() + ")");
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        Office officeObj = (Office) obj;
        return (officeObj.calcBuildingArea() == this.calcBuildingArea()) && (officeObj.getParkingSpaces() == this.getParkingSpaces());
    }
}
