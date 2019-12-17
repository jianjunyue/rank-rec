package org.rank.strategy.shop.phase;

import org.rank.strategy.context.RankContext;
import org.rank.strategy.shop.face.IShopPhase;
import org.springframework.stereotype.Service;

@Service
public class HongbaoPredictPhase  implements IShopPhase  {

	@Override
	public void execute(RankContext context) {
		 System.out.println(String.format("IShopPhase:%s", "HongbaoPredictPhase") );
	}

}
