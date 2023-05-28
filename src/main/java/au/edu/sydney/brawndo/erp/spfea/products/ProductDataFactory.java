package au.edu.sydney.brawndo.erp.spfea.products;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductDataFactory {
    private static Map<String, ProductData> productDataCache = new HashMap<>();

    /**
     * Gets product data using Flyweight pattern (i.e. get existing product data from cache),
     * creates a new Flyweight object and store it in the cache if it doesn't already exist.
     * @param productName the product's name
     * @param cost the product's cost
     * @param manufacturingData the product's manufacturingData
     * @param recipeData the product's recipeData
     * @param marketingData the product's marketingData
     * @param safetyData the product's safetyData
     * @param licensingData the product's licensingData
     * @return the wanted ProductData object.
     */
    public static ProductData getProductData(String productName, double cost, double[] manufacturingData, double[] recipeData,
                                             double[] marketingData, double[] safetyData, double[] licensingData) {

        String key = generateKey(productName, cost);

        // Check if the Flyweight object already exists in the cache
        ProductData productData = productDataCache.get(key);

        // If not, create a new Flyweight object and store it in the cache
        if (productData == null) {
            productData = new ProductData(manufacturingData, recipeData, marketingData, safetyData, licensingData);
            productDataCache.put(key, productData);
        }

        return productData;
    }

    /**
     * Generates the combination of product name and cost as the key for the flyweight object.
     * @param productName the product's name
     * @param cost the product's cost
     * @return productName + cost
     */
    private static String generateKey(String productName, double cost) {
        // Generate a unique key based on the data values
        return productName + cost;
    }
}

