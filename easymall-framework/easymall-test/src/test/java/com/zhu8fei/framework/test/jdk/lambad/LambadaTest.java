package com.zhu8fei.framework.test.jdk.lambad;

import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhu8fei on 2017/5/11.
 */
@MarkTestTarget
public class LambadaTest extends BaseJunitTest {
    @Test

    public void lambada() {
        String[] a = {"a", "x", "c", "d"};
        Arrays.sort(a, (s1, s2) -> s1.compareTo(s2));

        for (String str : a) {
            logger.info(str);
        }
    }


}
