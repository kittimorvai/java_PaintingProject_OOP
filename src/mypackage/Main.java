package mypackage;

public class Main {

    public static void main(String[] args) {
	PaintStock inStock = new PaintStock();
	inStock.addToStock("Hera", 26);
	inStock.addToStock("Hera", 76);
	inStock.addToStock("Platinum", 98);
	inStock.addToStock("Dulux", 37);
	inStock.addToStock("Dulux", 85);
	inStock.addToStock("Dulux", 100);


	PaintingProject firstProject = new PaintingProject("Hera", 72);
	PaintingProject secondProject = new PaintingProject("Dulux", 86);
	PaintingProject thirdProject = new PaintingProject("Dulux", 12);
	inStock.useUpPaint(firstProject);
	inStock.useUpPaint(secondProject);
	inStock.useUpPaint(thirdProject);

	inStock.printStock();
	inStock.printSummary();
    }
}
