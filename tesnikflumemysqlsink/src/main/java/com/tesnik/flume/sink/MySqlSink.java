//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tesnik.flume.sink;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import org.apache.flume.Channel;
import org.apache.flume.ChannelException;
import org.apache.flume.Context;
import org.apache.flume.CounterGroup;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Transaction;
import org.apache.flume.Sink.Status;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlSink extends AbstractSink implements Configurable {
    private static final Logger logger = LoggerFactory.getLogger(MySqlSink.class);
    private String databaseName;
    private String tableName;
    private String partition;
    private String iscustom;
    private String password;
    private String user;
    private String driver;
    private String db_url;
    private CounterGroup counterGroup = new CounterGroup();
    DAOClass daoClass = new DAOClass();

    public MySqlSink() {
    }

    @Override
    public void configure(Context context) {
        this.db_url = context.getString("url");
        this.password = context.getString("password");
        this.user = context.getString("user");
        this.driver = context.getString("driver");
        this.tableName = context.getString("tableName");
        this.partition = context.getString("partition");
        this.iscustom = context.getString("iscustom");
        this.databaseName = context.getString("databaseName");

        Preconditions.checkState(this.password != null, "No password specified");
        Preconditions.checkState(this.user != null, "No user specified");
    }

    @Override
    public void start() {
        logger.info("Mysql sink starting");
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        try {
            this.daoClass.createConnection(this.driver, this.db_url, this.user, this.password);
        } catch (Exception var2) {
            logger.error("Unable to create MySQL client using url:" + this.db_url + " username:" + this.user + ". Exception follows.", var2);
            this.daoClass.destroyConnection(this.db_url, this.user);
            return;
        }
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        logger.info("Mysql sink configure"+db_url+"."+password+"."+user+"."+driver+"."+tableName+"."+partition+".");
        super.start();
        logger.debug("MySQL sink {} started", this.getName());
    }

    @Override
    public void stop() {
        logger.info("MySQL sink {} stopping", this.getName());
        this.daoClass.destroyConnection(this.db_url, this.user);
        super.stop();
        logger.debug("MySQL sink {} stopped. Metrics:{}", this.getName(), this.counterGroup);
    }

    @Override
    public Status process() throws EventDeliveryException {
        Status status = Status.READY;
        Channel channel = this.getChannel();
        Transaction transaction = channel.getTransaction();

        try {
            transaction.begin();
            this.daoClass.createConnection(this.driver, this.db_url, this.user, this.password);
            Event event = channel.take();

            if (event == null) {
                this.counterGroup.incrementAndGet("event.empty");
                status = Status.BACKOFF;
            } else {
                Map<String, String> params = new HashMap();
                params.put("tableName", this.tableName);
                params.put("partition", this.partition);
                params.put("iscustom", this.iscustom);
                params.put("databaseName", this.databaseName);
                this.daoClass.insertData(event, params);
                this.counterGroup.incrementAndGet("event.mysql");
            }

            transaction.commit();
        } catch (ChannelException var10) {
            transaction.rollback();
            logger.error("Unable to get event from channel. Exception follows.", var10);
            status = Status.BACKOFF;
        } catch (Exception var11) {
            transaction.rollback();
            logger.error("Unable to communicate with MySQL server. Exception follows.", var11);
            status = Status.BACKOFF;
            this.daoClass.destroyConnection(this.db_url, this.user);
        } finally {
            transaction.close();
        }

        return status;
    }
}
