package mooc.vandy.java4android.buildings.logic;

import androidx.annotation.Nullable;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = null;
        this.mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = pool;
    }

    public String getOwner() {
        return this.mOwner;
    }

    public boolean hasPool() {
        return this.mPool;
    }

    public void setOwner(String owner) {
        this.mOwner = owner;
    }

    public void setPool(boolean hasPool) {
        this.mPool = hasPool;
    }

    @Override
    public String toString() {
        String res = "Owner: ";
        if (this.mOwner!=null) {
            res += this.mOwner;
        } else {
            res = "n/a";
        }
        if (this.mPool) {
            res += "; has a pool";
        }
        if (super.calcLotArea() > super.calcBuildingArea()) {
            res += "; has a big open space";
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        House houseObj = (House) obj;
        return (this.calcBuildingArea() == houseObj.calcBuildingArea()) && (this.hasPool() == houseObj.hasPool());
    }
}
