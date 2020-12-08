package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length,width,lotLength,lotWidth);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        this(length,width,lotLength,lotWidth);
        mOwner = owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean
            pool) {
        this(length,width,lotLength,lotWidth,owner);
        mPool = pool;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setPool(boolean pool) {
        mPool = pool;
    }

    @Override
    public boolean equals(Object object) {
        boolean res = false;
        if (object instanceof House) {
            House another = (House) object;
            if (another.calcBuildingArea() == this.calcBuildingArea() && this.mPool == another.mPool) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        boolean isOpen = (this.calcLotArea() - this.calcBuildingArea()) > this.calcBuildingArea();
        return "Owner: " + (mOwner == null ? "n/a" : mOwner) + (mPool ? "; has a pool" : "") + (isOpen ? "; has a big open space" : "");
    }
}
