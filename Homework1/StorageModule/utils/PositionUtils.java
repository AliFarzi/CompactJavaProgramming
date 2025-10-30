package Homework1.StorageModule.utils;

import Homework1.StorageModule.model.Position;

public class PositionUtils {

    //  Check if a position is valid within the warehouse bounds
    public static boolean isValid(Position pos, int maxRows, int maxCols, int maxLevels) {
        return pos.getX() >= 1 && pos.getX() <= maxRows &&
               pos.getY() >= 1 && pos.getY() <= maxCols &&
               pos.getLevel() >= 1 && pos.getLevel() <= maxLevels;
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
