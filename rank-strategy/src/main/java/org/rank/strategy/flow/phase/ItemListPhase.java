package org.rank.strategy.flow.phase;

import java.util.List;

import org.rank.data.item.ItemInfo;
import org.rank.data.service.ItemDataService;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.face.IRankPhase;
import org.rank.strategy.flow.RankManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemListPhase implements IRankPhase {

	private static Logger logger = LoggerFactory.getLogger(ItemListPhase.class);

	@Override
	public void execute(RankContext context){
		try {
			ItemDataService itemDataService = new ItemDataService();
			List<ItemInfo> itemInfoList = itemDataService.getItems(context.getItemInfoList());
			context.setItemInfoList(itemInfoList);

		} catch (Exception e) {
			logger.error("ItemListPhase execute is error", e);
		}
	}

}
