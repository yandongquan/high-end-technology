package com.javakz.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *  .--,       .--,
 * ( (  \.---./  ) )
 *  '.__/o   o\__.'
 *     {=  ^  =}
 *      >  -  <
 *     /       \
 *    //       \\
 *   //|   .   |\\
 *   "'\       /'"_.-~^`'-.
 *      \  _  /--'         `
 *    ___)( )(___
 *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * @Author: yandq
 * @Description: 
 * @Date: Create in 9:03 2018/7/24
 * @Modified By: 
 */
public class TopicProducer {

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.129:61616");
        // 获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 获取 session
        // 第一个参数：是否开启事务。true：开启事务，第二个参数忽略。
        // 第二个参数：当第一个参数为false时，才有意义。消息的应答模式。1、自动确认；2、客户端手动确认；3、自动批量确认；0、事务提交并确认。一般是自动确认。
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // 创建一个订阅
        Topic topic = session.createTopic("first-topic");
        // 创建消息生产者对象
        MessageProducer producer = session.createProducer(topic);
        // 创建消息
        TextMessage textMessage = session.createTextMessage("这是我的第一个 topic 消息，请查收。");
        // 使用生产者发送消息
        producer.send(textMessage);
        // 关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
