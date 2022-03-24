package com.matej.learn;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.matej.learn.Asset.AssetType;

public class AssetUtil {
    public static int totalAssetValues(final List<Asset> assets,
    final Predicate<Asset> assetSelector) {
        return assets
            .stream()
            .filter(assetSelector)
            .mapToInt(Asset::getValue)
            .sum();
    }

    public static int totalBondValues(final List<Asset> assets) {
        return assets.stream()
            .mapToInt(asset -> 
                    asset.getType() == AssetType.BOND ? asset.getValue() : 0)
                    .sum();       
    }

    public static int totalStockValues(final List<Asset> assets) {
        return assets.stream()
            .mapToInt(asset -> 
                    asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
                    .sum();       
    }
    
}
