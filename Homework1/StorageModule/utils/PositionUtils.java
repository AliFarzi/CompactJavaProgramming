package Homework1.StorageModule.utils;

import Homework1.StorageModule.model.Position;

public class PositionUtils {

    //  Check if a position is valid within the warehouse bounds
    public static boolean isValid(Position position, int maxRows, int maxColumns, int maxLevels) {
        return position.getX() >= 0 && position.getX() < maxRows
            && position.getY() >= 0 && position.getY() < maxColumns
            && position.getLevel() >= 0 && position.getLevel() < maxLevels;
    }

    //  Calculate the 3D distance between two positions
    public static double distance(Position p1, Position p2) {
        int dx = p1.getX() - p2.getX();
        int dy = p1.getY() - p2.getY();
        int dz = p1.getLevel() - p2.getLevel();
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    //  Convert a position to a readable string (optional)
    public static String toReadableString(Position position) {
        return "(" + position.getX() + ", " + position.getY() + ", " + position.getLevel() + ")";
    }
}
