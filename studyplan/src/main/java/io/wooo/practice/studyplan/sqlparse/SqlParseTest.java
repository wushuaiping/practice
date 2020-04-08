package io.wooo.practice.studyplan.sqlparse;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

/**
 * @author wb-wsp312690
 * @version 1.0.0
 * @date 2020-02-04 13:14:34
 **/
public class SqlParseTest {

    public static void main(String[] args) {
        String sql = "select id, name from user; insert into user values(1, '张三');";
        String dbType = JdbcConstants.MYSQL;
        List<SQLStatement> statementList = SQLUtils.parseStatements(sql, dbType);
        statementList.forEach(sqlStatement -> {

            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            sqlStatement.accept(visitor);
        });
    }

    public static Object exec(String sql, String jdbcType){
        return SQLUtils.parseStatements(sql, jdbcType);
    }
}
