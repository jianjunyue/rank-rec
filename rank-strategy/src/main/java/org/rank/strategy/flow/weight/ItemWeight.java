package org.rank.strategy.flow.weight;

import org.rank.strategy.context.RankContext;
import org.rank.strategy.face.IRankWeight;
import org.rank.strategy.flow.phase.ItemListPhase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemWeight implements IRankWeight {

	private static Logger logger = LoggerFactory.getLogger(ItemWeight.class);

	@Override
	public void doWeight(RankContext context){
		try {
			context.getItemInfoList().forEach(action -> {
				action.setScore(action.getItemAttribute().getSaleQuantity());
			});
		} catch (Exception e) {
			logger.error("ItemWeight doWeight is error", e);
		}
	}

}
