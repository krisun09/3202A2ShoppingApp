package au.edu.sydney.brawndo.erp.spfea.products;

import java.util.Arrays;

public class ProductData {

    private final double[] manufacturingData;
    private final double[] recipeData;
    private final double[] marketingData;
    private final double[] safetyData;
    private final double[] licensingData;

    public ProductData(double[] manufacturingData,
                       double[] recipeData,
                       double[] marketingData,
                       double[] safetyData,
                       double[] licensingData) {
        this.manufacturingData = manufacturingData;
        this.recipeData = recipeData;
        this.marketingData = marketingData;
        this.safetyData = safetyData;
        this.licensingData = licensingData;
    }

    public double[] getRecipeData() {
        return recipeData;
    }

    public double[] getMarketingData() {
        return marketingData;
    }

    public double[] getSafetyData() {
        return safetyData;
    }

    public double[] getLicensingData() {
        return licensingData;
    }

    public double[] getManufacturingData() {
        return manufacturingData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Arrays.equals(manufacturingData, that.manufacturingData) &&
                Arrays.equals(recipeData, that.recipeData) &&
                Arrays.equals(marketingData, that.marketingData) &&
                Arrays.equals(safetyData, that.safetyData) &&
                Arrays.equals(licensingData, that.licensingData);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(manufacturingData);
        result = 31 * result + Arrays.hashCode(recipeData);
        result = 31 * result + Arrays.hashCode(marketingData);
        result = 31 * result + Arrays.hashCode(safetyData);
        result = 31 * result + Arrays.hashCode(licensingData);
        return result;
    }
}
