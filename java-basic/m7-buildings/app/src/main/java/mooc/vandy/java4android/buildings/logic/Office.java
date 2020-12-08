package mooc.vandy.java4android.buildings.logic;

import androidx.annotation.Nullable;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    private String mBusinessName;

    private int mParkingSpaces;

    private static int sTotalOffices;
    static {
        sTotalOffices = 0;
    }
    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length,width,lotLength,lotWidth);
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length,width,lotLength,lotWidth);
        mBusinessName = businessName;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
                   int parkingSpaces) {
        this(length,width,lotLength,lotWidth,businessName);
        mParkingSpaces = parkingSpaces;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        mParkingSpaces = parkingSpaces;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        boolean res = false;
        if (obj instanceof Office) {
            Office another = (Office) obj;
            res = (another.calcBuildingArea() == this.calcBuildingArea() && this.mParkingSpaces == another.mParkingSpaces);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Business:");
        sb.append(mBusinessName == null ? " unoccupied" : "" + mBusinessName);
        sb.append(mParkingSpaces == 0 ? " " : " has " + mParkingSpaces + " parking spaces");
        sb.append("(total offices: " + sTotalOffices + ")");
        return sb.toString();
    }
}
