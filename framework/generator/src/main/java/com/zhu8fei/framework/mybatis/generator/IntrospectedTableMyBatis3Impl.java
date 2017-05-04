package com.zhu8fei.framework.mybatis.generator;


import org.apache.commons.lang.WordUtils;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public class IntrospectedTableMyBatis3Impl
        extends org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl {
    /**
     * Calculate my batis3 xml mapper file name.
     *
     * @return the string
     */
    protected String calculateMyBatis3XmlMapperFileName() {
        StringBuilder sb = new StringBuilder();
        String tableName = first(fullyQualifiedTable.getIntrospectedTableName());
        sb.append(tableName);
        sb.append("Mapper.xml"); //$NON-NLS-1$
        return sb.toString();
    }

    protected void calculateJavaClientAttributes() {
        if (context.getJavaClientGeneratorConfiguration() == null) {
            return;
        }
        String tableName = first(fullyQualifiedTable.getIntrospectedTableName());

        StringBuilder sb = new StringBuilder();
        sb.append(calculateJavaClientImplementationPackage());
        sb.append('.');
        sb.append(tableName);
        sb.append("DAOImpl"); //$NON-NLS-1$
        setDAOImplementationType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        sb.append(tableName);
        sb.append("DAO"); //$NON-NLS-1$
        setDAOInterfaceType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        if (stringHasValue(tableConfiguration.getMapperName())) {
            sb.append(tableConfiguration.getMapperName());
        } else {
            sb.append(tableName);
            sb.append("Mapper"); //$NON-NLS-1$
        }
        setMyBatis3JavaMapperType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        if (stringHasValue(tableConfiguration.getSqlProviderName())) {
            sb.append(tableConfiguration.getSqlProviderName());
        } else {
            sb.append(tableName);
            sb.append("SqlProvider"); //$NON-NLS-1$
        }
        setMyBatis3SqlProviderType(sb.toString());
    }

    protected void calculateModelAttributes() {
        String pakkage = calculateJavaModelPackage();
        String tableName = first(fullyQualifiedTable.getIntrospectedTableName());

        StringBuilder sb = new StringBuilder();
        sb.append(pakkage);
        sb.append('.');
        sb.append(tableName);
        sb.append("Key"); //$NON-NLS-1$
        setPrimaryKeyType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(tableName);
        setBaseRecordType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(tableName);
        sb.append("WithBLOBs"); //$NON-NLS-1$
        setRecordWithBLOBsType(sb.toString());

        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(tableName);
        sb.append("Example"); //$NON-NLS-1$
        setExampleType(sb.toString());
    }

    private String first(String tableName) {
        String[] names = tableName.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < names.length; i++) {
            sb.append(WordUtils.capitalize(names[i]));
        }
        return sb.toString();
    }

}
