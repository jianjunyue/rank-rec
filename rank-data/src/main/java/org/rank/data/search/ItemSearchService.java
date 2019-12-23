package org.rank.data.search;

import java.util.List;

import org.rank.data.item.ItemInfo;

import com.google.common.collect.Lists;

/**
 * 商品搜索召回
 */
public class ItemSearchService {

	public static List<ItemInfo> search(){
		List<ItemInfo> list = Lists.newArrayList();
		ItemInfo itemInfo = new ItemInfo();
		for (int i = 0; i < 10; i++) {
			itemInfo = new ItemInfo();
			itemInfo.setItemId(i);
//			itemInfo.setSaleQuantity(i * 5);
//			itemInfo.setTagId(i % 3);
			list.add(itemInfo);
		}
		return list;
	}
}
