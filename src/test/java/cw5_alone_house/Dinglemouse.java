package cw5_alone_house;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dinglemouse {

    static CellValue convertChar(char toConvert) {
        switch (toConvert) {
            case '#':
                return CellValue.WALL;
            case 'o':
                return CellValue.ELVE;
            case 'X':
                return CellValue.POTUS;
            case ' ':
            default:
                return CellValue.EMPTY;
        }
    }

    public enum Direction {
        TOP, DOWN, RIGHT, LEFT;
    }

    public enum CellValue {
        WALL('#', '+'),
        ELVE('o', 'O'),
        POTUS('X', 'x'),
        EMPTY(' ', '.');
        private char cellValue;
        private char openedValue;

        CellValue(char cellValue, char openedValue) {
            this.cellValue = cellValue;
            this.openedValue = openedValue;
        }
    }

    private static class HouseCell {
        private CellValue cellValue;
        private boolean opened;
        private int coordX;
        private int coordY;

        CellValue getCellValue() {
            return cellValue;
        }

        boolean isOpened() {
            return opened;
        }

        int getCoordX() {
            return coordX;
        }

        int getCoordY() {
            return coordY;
        }

        void setOpened(boolean openParam) {
            opened = openParam;
        }

        void openNearby(List<HouseCell> result, HouseCell[][] houseCells, Direction direction) {
            int ox = this.coordX;
            int oy = this.coordY;
            switch (direction) {

                case TOP:
                    if (!houseCells[ox + 1][oy].getCellValue().equals(CellValue.WALL) &&
                            !houseCells[ox + 1][oy].isOpened()) {
                        houseCells[ox + 1][oy].setOpened(true);
                        result.add(houseCells[ox + 1][oy]);
                    }
                    break;

                case RIGHT:
                    if (!houseCells[ox][oy + 1].getCellValue().equals(CellValue.WALL) &&
                            !houseCells[ox][oy + 1].isOpened()) {
                        houseCells[ox][oy + 1].setOpened(true);
                        result.add(houseCells[ox][oy + 1]);
                    }
                    break;

                case DOWN:
                    if (!houseCells[ox - 1][oy].getCellValue().equals(CellValue.WALL) &&
                            !houseCells[ox - 1][oy].isOpened()) {
                        houseCells[ox - 1][oy].setOpened(true);
                        result.add(houseCells[ox - 1][oy]);
                    }
                    break;

                case LEFT:
                    if (!houseCells[ox][oy - 1].getCellValue().equals(CellValue.WALL) &&
                            !houseCells[ox][oy - 1].isOpened()) {
                        houseCells[ox][oy - 1].setOpened(true);
                        result.add(houseCells[ox][oy - 1]);
                    }
                    break;

                default:
                    break;
            }
        }

        HouseCell(CellValue cellValue, int coordX, int coordY) {
            this.cellValue = cellValue;
            this.opened = false;
            this.coordX = coordX;
            this.coordY = coordY;
        }

        @Override
        public String toString() {
            return String.format("H[%s,%s,%s,%s]", cellValue, opened, coordX, coordY);
        }
    }

    private static class HouseMap {
        private HouseCell[][] houseCells;
        private int width;
        private int height;

        HouseMap(char[][] house) {
            this.width = house.length;
            this.height = house[0].length;
            this.houseCells = new HouseCell[width][height];
            for (int i = 0; i < width; i++)
                for (int j = 0; j < height; j++)
                    houseCells[i][j] = new HouseCell(convertChar(house[i][j]), i, j);
        }

        HouseCell findPotus() {
            for (int i = 0; i < this.width; i++)
                for (int j = 0; j < this.height; j++)
                    if (this.houseCells[i][j].getCellValue().equals(CellValue.POTUS)) {
                        this.houseCells[i][j].setOpened(true);
                        return this.houseCells[i][j];
                    }
            throw new RuntimeException("there is no POTUS");
        }

        List<HouseCell> searchHouse(List<HouseCell> cellSearchFrom) {
            List<HouseCell> result = new ArrayList<>();
            for (HouseCell houseCell : cellSearchFrom) {
                int ox = houseCell.getCoordX();
                int oy = houseCell.getCoordY();
                if ((ox + 1) < width) houseCell.openNearby(result, this.houseCells, Direction.TOP);
                if ((oy + 1) < height) houseCell.openNearby(result, this.houseCells, Direction.RIGHT);
                if ((ox - 1) < height) houseCell.openNearby(result, this.houseCells, Direction.DOWN);
                if ((oy - 1) < height) houseCell.openNearby(result, this.houseCells, Direction.LEFT);
            }
            return result;
        }

        boolean elveFound(List<HouseCell> houseCells) {
            for (HouseCell houseCell : houseCells)
                if (houseCell.getCellValue().equals(CellValue.ELVE)) return true;
            return false;
        }
    }

    static boolean allAlone(char[][] house) {
        HouseMap houseMap = new HouseMap(house);
        HouseCell potusCell = houseMap.findPotus();
        List<HouseCell> openedCells = new ArrayList<>(Collections.singletonList(potusCell));
        while (openedCells.size() > 0) {
            openedCells = houseMap.searchHouse(openedCells);
            if (houseMap.elveFound(openedCells)) return false;
        }
        return true;
    }

}