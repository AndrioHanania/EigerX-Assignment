package com.example.eigerxassignment.PriceCheck;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldShop {
    /**
     * INPUT:
     * string products[n]:  each products[i] is the name of an item for sale.
     * float productPrices[n]:  each productPrices[i] is the price of products[i].
     * string productSold[m]:  each productSold[j] is the name of a product sold.
     * float soldPrice[m]:  each soldPrice[j] contains the sale price recorded for productSold[j].
     * RETURN:
     * int: the number of sale prices that were entered incorrectly.
     * IMPORTANT:
     * size of 'products' must have equal to size of 'productPrices'
     * size of 'productSold' must have equal to size of 'soldPrice'
     * productSold[j] have to be inside 'products'
     *
     * place complexities: O(n+m)
     * time complexities: O(2n)=O(n)
     *
     *
     **/
    public int priceCheck
    (List<String> products,
     List<Float> productPrices,
     List<String> productSold,
     List<Float> soldPrice)
    {
        int n = products.size(), sizePP = productPrices.size();
        int m = productSold.size(), sizeSP = soldPrice.size();
        if(n != sizePP)
            throw new IllegalArgumentException
                    (String.format("The size of products and " +
                                    "productPrices is not the same: %s!=%s",
                            n, sizePP));

        if(m != sizeSP)
            throw new IllegalArgumentException
                    (String.format("The size of productSold and soldPrice" +
                            " is not the same: %s!=%s", m, sizeSP));

        Map<String, Float> product2price = new HashMap<>();
        int result = 0;

        for(int i = 0;i < n;i++)
            product2price.put(products.get(i), productPrices.get(i));

        for(int j = 0;j < m;j++)
        {
            String currProduct = productSold.get(j);
            Float price = product2price.get(productSold.get(j));
            if (price == null)
                throw new IllegalArgumentException
                        ("sold product '" + currProduct +
                                "' not in products array");

            if(!price.equals(soldPrice.get(j)))
                result++;
        }

        return result;
    }
}