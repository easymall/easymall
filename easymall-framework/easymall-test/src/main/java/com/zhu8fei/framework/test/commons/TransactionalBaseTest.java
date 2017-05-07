package com.zhu8fei.framework.test.commons;


import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhu8fei on 2017/5/4.
 */
@Transactional
@Rollback
@MarkTestTarget({MarkTestTarget.class})
public class TransactionalBaseTest extends BaseTest {

}
