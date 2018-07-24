package com.javakz.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

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
 * @Date: Create in 18:10 2018/7/23
 * @Modified By: 
 */
public class TopicConsumer {

    public static void main(String[] args) throws JMSException, IOException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.129:61616");
        // 获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 获取 session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个订阅
        Topic topic = session.createTopic("first-topic");
        // 创建消息消费者
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                // 获取文本消息对象
                TextMessage textMessage = (TextMessage)message;
                try {
                    String text  = textMessage.getText();
                    System.out.println("消费者收到消息，内容："+text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        // 等待键盘输入
        System.in.read();
        // 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
