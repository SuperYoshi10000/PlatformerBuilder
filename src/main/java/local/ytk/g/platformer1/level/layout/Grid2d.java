package local.ytk.g.platformer1.level.layout;

import java.util.ArrayList;

import local.ytk.g.platformer1.math.GridPosition2d;
import local.ytk.g.platformer1.level.tile.GridTile;

public class Grid2d {
    public final int width;
    public final int height;
    public final ArrayList<ArrayList<GridTile>> tiles;

    public Grid2d(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new ArrayList<>();
    }

    public void addTile(GridPosition2d pos, GridTile tile) {
        ArrayList<GridTile> row = getOrCreateRow(tiles, pos.y);
        expandToFitTile(row, pos.x);
        row.set(pos.x, tile);
    }

    public GridTile getAt(GridPosition2d pos) {
        if (pos.x < 0 || pos.x > width || pos.y < 0 || pos.y > height) return null;
        return tiles.get(pos.y).get(pos.x);
    }

    protected static <T> void expandToFitTile(ArrayList<T> list, int index) {
        while (list.size() <= index) list.add(null);
    }

    protected static <T extends GridTile> ArrayList<T> getOrCreateRow(ArrayList<ArrayList<T>> list, int index) {
        if (list.size() > index && list.get(index) != null) return list.get(index);
        while (list.size() < index) list.add(null);
        ArrayList<T> row = new ArrayList<>();
        list.add(index, row);
        return row;
    }
    protected static <T extends GridTile> ArrayList<ArrayList<T>> getOrCreatePlane(ArrayList<ArrayList<ArrayList<T>>> list, int index) {
        if (list.size() > index && list.get(index) != null) return list.get(index);
        while (list.size() < index) list.add(null);
        ArrayList<ArrayList<T>> plane = new ArrayList<>();
        list.add(index, plane);
        return plane;
    }

}
