package au.edu.sydney.brawndo.erp.spfea.products;

import au.edu.sydney.brawndo.erp.ordering.Product;

import java.util.Arrays;

public class ProductImpl implements Product {

    private final String name;
    private final double cost;
//    private final double[] manufacturingData;
//    private double[] recipeData;
//    private double[] marketingData;
//    private double[] safetyData;
//    private double[] licensingData;

    private final ProductData productData;

    public ProductImpl(String name,
                       double cost,
                       double[] manufacturingData,
                       double[] recipeData,
                       double[] marketingData,
                       double[] safetyData,
                       double[] licensingData) {
        this.name = name;
        this.cost = cost;
//        this.manufacturingData = manufacturingData;
//        this.recipeData = recipeData;
//        this.marketingData = marketingData;
//        this.safetyData = safetyData;
//        this.licensingData = licensingData;

        this.productData = ProductDataFactory.getProductData(name, cost, manufacturingData, recipeData, marketingData, safetyData, licensingData);
    }

    @Override
    public String getProductName() {
//        System.out.println(name);
        return this.name;
    }

    @Override
    public double getCost() {
//        System.out.println(cost);
        return this.cost;
    }

    @Override
    public double[] getManufacturingData() {
//        System.out.println(".........." + Arrays.toString(productData.getManufacturingData()));

        return productData.getManufacturingData();
    }

    @Override
    public double[] getRecipeData() {
//        System.out.println(".........." + Arrays.toString(productData.getRecipeData()));

        return productData.getRecipeData();
    }

    @Override
    public double[] getMarketingData() {
        return productData.getMarketingData();
    }

    @Override
    public double[] getSafetyData() {
        return productData.getSafetyData();
    }

    @Override
    public double[] getLicensingData() {
        return productData.getLicensingData();
    }

    @Override
    public String toString() {

        return String.format("%s", name);
    }

//    @Override
//    public String toString() {
//        return String.format("Product: %s, Cost: %.2f, ManufacturingData: %s, RecipeData: %s, MarketingData: %s, SafetyData: %s, LicensingData: %s",
//                name,
//                cost,
//                Arrays.toString(productData.getManufacturingData()),
//                Arrays.toString(productData.getRecipeData()),
//                Arrays.toString(productData.getMarketingData()),
//                Arrays.toString(productData.getSafetyData()),
//                Arrays.toString(productData.getLicensingData()));
//    }
}
