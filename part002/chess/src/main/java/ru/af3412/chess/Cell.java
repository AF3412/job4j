package ru.af3412.chess;

/**
 * @author Filatov Alexander
 * @since 24.08.2016
 */
public class Cell {

    /**
     * @param isFree
     * Free or occupied position
     */
    private boolean isFree;

    /**
     * @param hor
     * Horizontal pozition
     */
    private int hor;

    /**
     * @param ver
     * Vertical pozition
     */
    private int ver;

    String nameFigure;


    public Cell(int ver, int hor) {
        this.ver = ver;
        this.hor = hor;
        this.isFree = true;
    }

    protected int getHor(){
        return this.hor;
    }

    protected int getVer(){
        return this.ver;
    }

    protected boolean getIsFree() {
        return this.isFree;
    }

    protected void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    @Override public String toString(){
        return String.format("%s", nameFigure);
    }




}
