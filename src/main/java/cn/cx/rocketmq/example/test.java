package cn.cx.rocketmq.example;

import com.alibaba.rocketmq.client.exception.MQClientException;

public class test {

    public static void main(String[] args) {
        RocketMQConsumer r = new RocketMQConsumer();
        RocketMQProducer c = new RocketMQProducer();
        try {
            r.subscribeMsg();
            c.sendMsg("wangjisi".getBytes());
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }   
}
