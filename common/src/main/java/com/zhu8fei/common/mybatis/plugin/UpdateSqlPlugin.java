package com.zhu8fei.common.mybatis.plugin;

import com.zhu8fei.common.base.ModelBase;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import java.util.concurrent.Executor;

/**
 * Created by zhu8fei on 2017/3/28.
 */
@Intercepts({@Signature(type = Executor.class, method = "update",
        args = {ModelBase.class, Object.class})})
public class UpdateSqlPlugin extends CommonSqlPlugin {

}
