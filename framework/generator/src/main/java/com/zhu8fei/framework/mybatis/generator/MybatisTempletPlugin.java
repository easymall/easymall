package com.zhu8fei.framework.mybatis.generator;

import com.zhu8fei.framework.core.mybatis.model.BaseEntity;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public class MybatisTempletPlugin extends PluginAdapter {
    Logger logger = LoggerFactory.getLogger(MybatisTempletPlugin.class);
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<" + introspectedTable.getBaseRecordType() + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.zhu8fei.framework.core.mybatis.mapper.BaseMapper");

        interfaze.addSuperInterface(fqjt);// 添加 extends BaseDao<User>
        interfaze.addImportedType(imp);// 添加import common.BaseDao;
        interfaze.getMethods().clear();
        return true;
    }



    /**
     * 生成实体
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.setSuperClass(BaseEntity.class.toString());

        addSerialVersionUID(topLevelClass, introspectedTable);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    private void addSerialVersionUID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PRIVATE);
        field.setType(new FullyQualifiedJavaType("Long"));
        field.setStatic(true);
        field.setFinal(true);
        field.setName("serialVersionUID");
        field.setInitializationString("1L");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
    }

    /**
     * 生成mapping 添加自定义sql
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        XmlElement parentElement = document.getRootElement();

        // 添加sql——where
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "sql_where"));
        XmlElement where = new XmlElement("where");
        StringBuilder sb = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null"); //$NON-NLS-1$
            isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
            where.addElement(isNotNullElement);

            sb.setLength(0);
            sb.append(" and ");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            isNotNullElement.addElement(new TextElement(sb.toString()));
        }
        sql.addElement(where);
        parentElement.addElement(sql);

        //添加getList
        XmlElement select = new XmlElement("select");
        select.addAttribute(new Attribute("id", "getList"));
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        select.addElement(new TextElement(" select * from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));

        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "sql_where"));

        select.addElement(include);
        parentElement.addElement(select);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }


    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    public static void generate() {
        String config = MybatisTempletPlugin.class.getClassLoader().getResource("generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }

    public static void main(String[] args) {
        generate();
    }
}
