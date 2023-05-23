package au.edu.sydney.brawndo.erp.spfea.products;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductDataFactory {
    private static Map<String, ProductData> productDataCache = new HashMap<>();

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

    private static String generateKey(String productName, double cost) {
        // Generate a unique key based on the data values
        return productName + cost;
    }
}

