package org.rank.predict.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.rank.predict.entity.Feature; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import biz.k11i.xgboost.Predictor;
import biz.k11i.xgboost.util.FVec;

public class XgboostModel {

	private static Logger logger = LoggerFactory.getLogger(XgboostModel.class);
	private static XgboostModel instance = null;
	
	private static Predictor predictorOrder;

	public static XgboostModel getInstance() {
		if (instance == null) {
			instance = new XgboostModel();
			instance.init();
		}
		return instance;
	}


	public void init() {
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			// [('f14', 830.6752753788686), ('f1', 111.59905448684214), ('f0',
			// 102.64717723297979), ('f16', 33.41075071428572), ('f15', 32.18863038482758),
			// ('f13', 27.370293319587624)]
			predictorOrder = new Predictor(cl.getResourceAsStream("banner_model/xg.model.out.txt20180205161100"));
		} catch (IOException e) {
			logger.error("XgboostModel init is error", e);
		}
	}

	public Double doWeight(List<Feature> features) {
		Double re = 0.0;
		if (features != null && features.size() > 0) {
			Map<Integer, Float> map = Maps.newHashMap();
			features.forEach(r -> map.put(r.getIndex(), r.getValue()));
			re = predictorOrder.predictSingle(FVec.Transformer.fromMap(map));
		}
		return re;
	}

}
