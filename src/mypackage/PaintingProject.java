package mypackage;

public class PaintingProject {
    private final String paintNeeded;
    private final int quantityNeeded;

    public PaintingProject(String paintNeeded, int quantityNeeded) {
        this.paintNeeded = paintNeeded;
        this.quantityNeeded = quantityNeeded;
    }

    public String getPaintNeeded() {
        return paintNeeded;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }
}
