package engine;
import objects.Unit;
import java.util.HashMap;

public class Map {
    private int width;
    private int height;

    private HashMap<String, Unit> unitMap;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    Map(int width, int height) {
        this.width = width;
        this.height = height;
        unitMap = new HashMap<>();
    }

    public int getCenterX() {
        return this.getWidth()/2;
    }

    public int getCenterY() {
        return this.getHeight()/2;
    }

    public void addUnit(Unit unit) {
        String key = unit.getPositionX() + "_" + unit.getPositionY();
        unitMap.put(key, unit);
    }

    public void removeUnitAt(int x, int y) {
        String key = x + "_" + y;
        unitMap.remove(key);
    }

    public Unit getUnitAt(int x, int y) {
        String key = x + "_" + y;
        return unitMap.getOrDefault(key, null);
    }

    public void moveUnit(Unit unit) {
        String oldKey = unit.getPositionX() + "_" + unit.getPositionY();
        unit.move(0);
        String newKey = unit.getPositionX() + "_" + unit.getPositionY();

        unitMap.remove(oldKey);
        unitMap.put(newKey, unit);
    }
}
