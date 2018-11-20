package com.tesnik.flume.sink;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.flume.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOClass
{
    private static final Logger logger = LoggerFactory.getLogger(DAOClass.class);
    private static Map<String, String> columnsMap = new HashMap();

    private Connection connection;

    public void insertData(Event event, Map<String, String> params)
    {
        String INSERT_QUERY="";
        String fileName = "";
        try
        {
            String body = new String(event.getBody())+" ";
            Map headers = event.getHeaders();

             fileName = (String)headers.get("fileName");
            String databaseName = (String)params.get("databaseName");

            String tableName = (String)params.get("tableName");

            String partition = (String)params.get("partition");

            String iscustom = (String)params.get("iscustom");

            if ("false".equals(iscustom)) {
                String columns = "";
                Statement st = this.connection.createStatement();

                if (columnsMap.get(tableName) == null) {
                    String sqlGetColumns = "select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='" + tableName + "' and  table_schema='" + databaseName + "'";
                    ResultSet resultSet = st.executeQuery(sqlGetColumns);
                    while (resultSet.next()) {
                        columns = columns + resultSet.getString("COLUMN_NAME") + ",";
                    }

                    columns = columns.substring(columns.indexOf(",") + 1, columns.length() - 1);
                    columnsMap.put(tableName, columns);
                } else {
                    columns = (String)columnsMap.get(tableName);
                }

                String nowDate = getNowDate();

                String[] datas = body.split(partition);
                List dataList = new ArrayList();
                for (String data : datas) {
                    dataList.add(data.trim());
                }
                dataList.add(fileName);
                dataList.add(nowDate);

                String indexs = "";
                for (int i1 = 0; i1 < dataList.size(); i1++) {
                    String ind = "";
                    if (((String)dataList.get(i1)).equals("")) {
                        ind = "null,";
                    } else {
                        ind = "'" + (String)dataList.get(i1) + "',";
                    }
                    indexs = indexs + ind;
                }
                indexs = indexs.substring(0, indexs.length() - 1);

                INSERT_QUERY = "INSERT INTO " + tableName + "(" + columns + ") values (" + indexs + ")";
            }
            PreparedStatement insertStmnt = this.connection.prepareStatement(INSERT_QUERY);
            insertStmnt.execute();
        }
        catch (SQLException e)
        {
            logger.error("发生错误的sql是"+INSERT_QUERY);
            logger.error("发生错误的文件是"+fileName);
            e.printStackTrace();
        }
    }

    public void createConnection(String driver, String db_url, String user, String password) throws IOException {
        if (this.connection == null)
            try {
                Class.forName(driver);

                this.connection = DriverManager.getConnection(db_url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void destroyConnection(String db_url, String user)
    {
        if (this.connection != null) {
            logger.debug("Destroying connection to: {}:{}", db_url, user);
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.connection = null;
    }

    public static String escapeSQL(String s) {
        return s.replaceAll("'", "\\'");
    }

    public Connection getConnection() {
        return this.connection;
    }

    private static String getNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String INSERT_DATE = df.format(new Date());
        return INSERT_DATE;
    }
}