package mypackage;

import java.util.*;

public class PaintStock {
    private final Map<String, ArrayList<Integer>> inStock;

    public PaintStock() {
        inStock = new HashMap<>();
    }

    public void addToStock(String brandName, int levelOfPaint) {
        List<Integer> paintLevels = inStock.get(brandName);

        if (paintLevels == null) {
            inStock.computeIfAbsent(brandName, i -> new ArrayList<>()).add(levelOfPaint);
        } else {
            paintLevels.add(levelOfPaint);
        }
    }

    public void printSummary() {
        Set<String> setOfKeys = inStock.keySet();
        System.out.println("\n");
        for (String key : setOfKeys) {
            ArrayList<Integer> values = inStock.get(key);
            System.out.println(key + ", " + values.size());
        }
    }

    public void printStock() {
        Set<String> setOfKeys = inStock.keySet();

        for (String key : setOfKeys) {
            System.out.println("\n" + key);
            ArrayList<Integer> values = inStock.get(key);
            for (int i : values) {
                System.out.println("\t" + i);
            }
        }
    }

    public boolean isEnough(PaintingProject project) {
        String paintNeeded = project.getPaintNeeded();
        int quantityNeeded = project.getQuantityNeeded();

        if (quantityNeeded > 100) {
            System.out.println("Invalid value");
        }

        Set<String> setOfKeys = inStock.keySet();

        for (String key : setOfKeys) {
            if (key.equals(paintNeeded)) {
                ArrayList<Integer> values = inStock.get(key);
                for (int value : values) {
                    if (value >= quantityNeeded) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public void useUpPaint(PaintingProject project) {
        String paintNeeded = project.getPaintNeeded();
        int quantityNeeded = project.getQuantityNeeded();

        if (isEnough(project)) {
            Set<String> setOfKeys = inStock.keySet();

            for (String key : setOfKeys) {
                if (key.equals(paintNeeded)) {
                    ArrayList<Integer> values = inStock.get(key);
                    int absoluteMinimum = Integer.MAX_VALUE;
                    for (int value : values) {
                        if (value >= quantityNeeded) {
                            if (value < absoluteMinimum) {
                                absoluteMinimum = value;
                            }
                        }
                    }
                    values.set(values.indexOf(absoluteMinimum), absoluteMinimum - quantityNeeded);
                }
            }
        } else {
            System.out.println("Paint levels are low");
        }
    }


}