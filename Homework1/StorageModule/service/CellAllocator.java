package Homework1.StorageModule.service;

import Homework1.StorageModule.model.Cell;
import Homework1.StorageModule.model.Storage;

import java.util.List;

//  Responsible for finding and allocating empty cells in the warehouse.
public class CellAllocator {

    private Storage storage;

    public CellAllocator(Storage storage) {
        this.storage = storage;
    }

    //  Find the first available empty cell (default strategy: first-fit)
    public Cell findFirstAvailableCell() {
        List<Cell> cells = storage.getCells();
        for (Cell cell : cells) {
            if (cell.isAvailable()) {
                return cell;
            }
        }
        return null; 
    }

    // Find an empty cell near a specific position (kept optional for future use)
    // public Cell findNearestAvailableCell(int x, int y, int level) {
    //     List<Cell> cells = storage.getCells();
    //     Cell nearest = null;
    //     double minDistance = Double.MAX_VALUE;

    //     for (Cell cell : cells) {
    //         if (cell.isAvailable()) {
    //             int dx = cell.getPosition().getX() - x;
    //             int dy = cell.getPosition().getY() - y;
    //             int dz = cell.getPosition().getLevel() - level;
    //             double distance = Math.sqrt(dx*dx + dy*dy + dz*dz);

    //             if (distance < minDistance) {
    //                 minDistance = distance;
    //                 nearest = cell;
    //             }
    //         }
    //     }

    //     return nearest; // Could be null if no empty cell
    // }

    //  Count all available cells in the storage
    public int countAvailableCells() {
        int count = 0;
        for (Cell cell : storage.getCells()) {
            if (cell.isAvailable()) count++;
        }
        return count;
    }

}
