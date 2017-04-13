package cn.cx.rocketmq.example;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;



/**
 * RocketMQ的消费者
 * @author Administrator
 *
 */
//@Service
public class RocketMQConsumer {
	
//	@Resource
//	private static RocketMQProducer producer;
	
	   public void subscribeMsg() throws MQClientException {
	        
	        /**
	         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
	         * 注意：ConsumerGroupName需要由应用来保证唯一
	         */
	        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroup_huizhi");
	        consumer.setNamesrvAddr("192.168.100.126:9876");

	        /**
	         * 订阅指定topic下tags分别等于TagA或TagB
	         */
	        
	        consumer.subscribe("broker_huizhi", "TagB || TagA");

	        /**
	         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
	         * 如果非第一次启动，那么按照上次消费的位置继续消费
	         */
	        
	        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

	        consumer.registerMessageListener(new MessageListenerConcurrently() {

	            /**
	             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
	             */
	            @Override
	            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
	                
	                System.out.println("-----开始消费-----"+Thread.currentThread().getName() + " Receive New Messages: " + msgs);
	                
	                for(MessageExt msg :msgs){
	                    
	                  String message = new String(msg.getBody());
	                  System.err.println("----"+message);
	                }
	                System.err.println("--消费-----ok------ ");
	                // 消费者向mq服务器返回消费成功的消息
	                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	            }
	        });

        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */
        consumer.start();
        System.err.println("Consumer Started.");
    }

//	public static void mai(String[] args) throws MQClientException {
//		String str = "1111111";
//    	byte[] myByte = str.getBytes();
//    	System.out.println("1" + myByte);
//    	subscribeMsg();
//    	producer.sendMsg(myByte);
//    	System.out.println("OK");
//    }
    
}
