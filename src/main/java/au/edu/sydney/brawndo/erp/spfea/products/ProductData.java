package au.edu.sydney.brawndo.erp.spfea.products;

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
}
