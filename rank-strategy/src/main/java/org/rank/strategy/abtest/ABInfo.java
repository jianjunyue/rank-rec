package org.rank.strategy.abtest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ABInfo {

    private final Map<String, Object> abMap;

    private final List<Integer> bucketValues;

    public ABInfo(Map<String, Object> abMap) {
        this.abMap = abMap;
        this.bucketValues = Collections.emptyList();
    }

    public ABInfo(Map<String, Object> abMap, List<Integer> bucketValues) {
        this.abMap = abMap;
        this.bucketValues = bucketValues;
    }

    public Map<String, Object> getAbMap() {
        return abMap;
    }

    public List<Integer> getBucketValues() {
        return bucketValues;
    }
}
