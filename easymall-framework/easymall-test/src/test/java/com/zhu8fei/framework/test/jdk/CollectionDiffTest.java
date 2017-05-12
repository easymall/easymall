package com.zhu8fei.framework.test.jdk;

import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import com.zhu8fei.framework.test.method.MethodTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhu8fei on 2017/5/10.
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

        List<Map<String, String>> diff1 = diff(resource, target);
        logger.info(diff1.toString());

        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test3");
        resource.add(row);

        row = new HashMap<>();
        row.put("name", "test");
        row.put("name2", "test1");
        target.add(row);

        List<Map<String, String>> diff2 = diff(resource, target);
        logger.info(diff2.toString());
    }

    private List<Map<String, String>> diff(List<Map<String, String>> resource, List<Map<String, String>> target) {
        return resource.stream()
                // 过滤当前元素如果存在 则不拿取
                .filter(x -> target.stream().noneMatch(y -> x.equals(y)))
                // 返回过滤后的集合
                .collect(Collectors.toList());
    }
}
