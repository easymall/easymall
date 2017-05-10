package com.zhu8fei.framework.test.jdk;

import com.zhu8fei.framework.core.lang.CollectionDiff;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cwx on 2017/5/10.
 */
@MarkTestTarget(MethodTest.class)
public class CollectionDiffTest extends BaseJunitTest {
    @Test
    public void listMapDiff() {
        List<Map<String, String>> resource = new ArrayList<>();
        Map<String, String> row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test");
        resource.add(row);
        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test");
        resource.add(row);

        List<Map<String, String>> target = new ArrayList<>();
        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test");
        target.add(row);

        List<Map<String, String>> diff1 = CollectionDiff.listDiff(resource, target);
        logger.info(diff1.toString());


        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test3");
        resource.add(row);

        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test1");
        target.add(row);

        List<Map<String, String>> diff2 = CollectionDiff.listDiff(resource, target);
        logger.info(diff2.toString());
    }

}
