package org.rank.data.service;

import java.util.List;
import java.util.Map; 
import org.rank.data.cache.LocalCacheItemClient;
import org.rank.data.item.ItemFeature;
import org.rank.data.item.ItemInfo;

import com.google.common.collect.Lists; 

public class ItemDataService {

	public List<ItemInfo> getItems(List<ItemInfo> itemInfos){ 
		List<Long> itemIds=Lists.newArrayList();
		itemInfos.stream().forEach(action-> itemIds.add(action.getItemId()));
		Map<Long, ItemFeature> mapItem = LocalCacheItemClient.getInstance().getData(itemIds);
		itemInfos.stream().forEach(action-> action.setItemAttribute(mapItem.getOrDefault(action.getItemId(), new ItemFeature())) );
		return itemInfos;
		
	}
}
