package org.rank.strategy.flow.phase;

import org.rank.data.service.UserPersonaDataService;
import org.rank.data.user.UserPersona;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.face.IRankPhase;

public class UserPersonaPhase implements IRankPhase {

	@Override
	public void execute(RankContext context){
		UserPersonaDataService userDataService = new UserPersonaDataService();
		UserPersona userPersona = userDataService.getUserProfile(context.getUserId());
		context.setUserPersona(userPersona);
	}

}
