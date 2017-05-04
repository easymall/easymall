package com.zhu8fei.framework.common.mybatis.plugin;

import com.zhu8fei.framework.core.mybatis.model.BaseEntity;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import java.util.concurrent.Executor;

/**
 * Created by zhu8fei on 2017/3/28.
 */
@Intercepts({@Signature(type = Executor.class, method = "update",
        args = {BaseEntity.class, Object.class})})
public class UpdateSqlPlugin extends CommonSqlPlugin {

}
