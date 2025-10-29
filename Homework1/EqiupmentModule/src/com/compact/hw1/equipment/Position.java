package com.compact.hw1.equipment;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    private final int level;

    public Position(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int level() {
        return level;
    }

    public double manhattanDistanceTo(Position other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y) + Math.abs(this.level - other.level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;
        Position p = (Position) o;
        return x == p.x && y == p.y && level == p.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, level);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ",L" + level + ")";
    }
}
