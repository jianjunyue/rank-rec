package org.rank.predict;

import java.io.IOException;
import java.util.List;

import org.rank.predict.entity.Feature;
import org.rank.predict.model.XgboostModel;

import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
 
		Double re = XgboostModel.getInstance().doWeight(convertToFeature());
		System.out.println(re);
		System.out.println("Hello predict!");
	}

	// [('f14', 830.6752753788686), ('f1', 111.59905448684214), ('f0',
	// 102.64717723297979), ('f16', 33.41075071428572), ('f15', 32.18863038482758),
	// ('f13', 27.370293319587624)]
	private static List<Feature> convertToFeature() {
		List<Feature> list = Lists.newArrayList();

		Feature feature0 = new Feature();
		feature0.setIndex(0);
		feature0.setValue(102.64717723297979f);

		Feature feature1 = new Feature();
		feature1.setIndex(1);
		feature1.setValue(111.59905448684214f);

		Feature feature2 = new Feature();
		feature2.setIndex(14);
		feature2.setValue(830.6752753788686f);

		Feature feature3 = new Feature();
		feature3.setIndex(16);
		feature3.setValue(33.41075071428572f);

		Feature feature4 = new Feature();
		feature4.setIndex(15);
		feature4.setValue(32.18863038482758f);

		list.add(feature0);
		list.add(feature1);
		list.add(feature2);
		list.add(feature3);
		list.add(feature4);

		return list;

	}
}
