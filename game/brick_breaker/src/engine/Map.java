package engine;

import objects.Unit;
import java.util.HashMap;

public class Map {
    private int width;
    private int height;
    private HashMap<String, Unit> unitMap;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        unitMap = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCenterX() {
        return width / 2;
    }

    public int getCenterY() {
        return height / 2;
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
        return unitMap.get(key);
    }

    public void moveUnit(Unit unit, int direction) {
        String oldKey = unit.getPositionX() + "_" + unit.getPositionY();
        if (unitMap.containsKey(oldKey)) {
            unitMap.remove(oldKey);
        }
        unit.move(direction);
        String newKey = unit.getPositionX() + "_" + unit.getPositionY();
        unitMap.put(newKey, unit);
    }

    public void moveUnit(Unit unit) {
        moveUnit(unit, 0);
    }
}
