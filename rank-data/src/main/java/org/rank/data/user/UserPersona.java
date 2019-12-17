package org.rank.data.user;

import java.util.List;
import java.util.Map;

/**
 * 用户画像
 */
public class UserPersona {

    private long userId;

    private Map<String, String> realtimeOrderInfo;

    private Map<String, String> realtimeShopCartInfo;

    private Map<String, String> realtimeClickInfo;

    private String realtimeRecExpoInfo;

    private Map<String, String> realTimeShopRateInfo;

    private Map<String, String> realTimeSearchInfo;

    private Map<Long, Float> realtimeOrderInfoShopEmbedding;

    private Map<Long, Float> realtimeShopCartInfoShopEmbedding;

    private Map<Long, Float> realtimeClickInfoShopEmbedding;

    private Map<Long, Float> allRealTimeClickInfo;

    private List<String> realtimeSearchInfoShopEmbedding;

    private Map realTimeExpNumInfo;

    private List<Float> userEmbeddingCalculateOnline;
}
