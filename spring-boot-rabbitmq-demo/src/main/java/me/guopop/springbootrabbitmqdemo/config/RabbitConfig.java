package me.guopop.springbootrabbitmqdemo.config;

import me.guopop.springbootrabbitmqdemo.message.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guopop
 * @date 2020/12/26 9:10
 */
@Configuration
public class RabbitConfig {

    //----------------------------------------Direct Exchange---------------------------------------------------

    @Bean
    public Queue directQueue() {
        return new Queue(DirectExchangeMessage.QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DirectExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DirectExchangeMessage.ROUTING_KEY);
    }

    //------------------------------------------Topic Exchange----------------------------------------------------

    @Bean
    public Queue topicQueue() {
        return new Queue(TopicExchangeMessage.QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TopicExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(TopicExchangeMessage.ROUTING_KEY);
    }

    //-----------------------------------------Fanout Exchange-------------------------------------------------------

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(FanoutExchangeMessage.QUEUE_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(FanoutExchangeMessage.QUEUE_B);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding fanoutBindingA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    //-----------------------------------------batch model-----------------------------------------------------

    @Bean
    public Queue batchQueue() {
        return new Queue(BatchMessage.QUEUE);
    }

    @Bean
    public DirectExchange batchExchange() {
        return new DirectExchange(BatchMessage.EXCHANGE);
    }

    @Bean
    public Binding batchBinding() {
        return BindingBuilder.bind(batchQueue()).to(batchExchange()).with(BatchMessage.ROUTING_KEY);
    }

    @Bean
    public BatchingRabbitTemplate batchingRabbitTemplate(ConnectionFactory connectionFactory) {
        // ???????????????????????????
        int batchSize = 16384;
        // ?????????????????????????????????
        int bufferLimit = 33554432;
        // ????????????????????????
        int timeout = 30000;
        // BatchingStrategy ????????????
        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);

        TaskScheduler taskScheduler = new ConcurrentTaskScheduler();

        BatchingRabbitTemplate batchingRabbitTemplate = new BatchingRabbitTemplate(batchingStrategy, taskScheduler);
        batchingRabbitTemplate.setConnectionFactory(connectionFactory);
        return batchingRabbitTemplate;
    }

    //-----------------------------------------????????????-------------------------------------------------------

    @Bean
    public Queue deadQueue() {
        return QueueBuilder
                .durable(DeadQueueMessage.QUEUE)
                .autoDelete()
                .deadLetterExchange(DeadQueueMessage.EXCHANGE)
                .deadLetterRoutingKey(DeadQueueMessage.DEAD_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue deadQueueDead() {
        return new Queue(DeadQueueMessage.DEAD_QUEUE);
    }

    @Bean
    public DirectExchange deadQueueExchange() {
        return new DirectExchange(DeadQueueMessage.EXCHANGE);
    }

    @Bean
    public Binding deadQueueBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadQueueExchange()).with(DeadQueueMessage.ROUTING_KEY);
    }

    @Bean
    public Binding deadQueueDeadBinding() {
        return BindingBuilder.bind(deadQueueDead()).to(deadQueueExchange()).with(DeadQueueMessage.DEAD_ROUTING_KEY);
    }

    //------------------------------------------????????????---------------------------------------------

    @Bean
    public Queue timingQueue() {
        return QueueBuilder
                .durable(TimingMessage.QUEUE)
                .exclusive()
                .autoDelete()
                .ttl(10 * 1000)
                .deadLetterExchange(TimingMessage.EXCHANGE)
                .deadLetterRoutingKey(TimingMessage.DELAY_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue timingQueueDelay() {
        return new Queue(TimingMessage.DELAY_QUEUE);
    }

    @Bean
    public DirectExchange timingExchange() {
        return new DirectExchange(TimingMessage.EXCHANGE);
    }

    @Bean
    public Binding timingBinding() {
        return BindingBuilder.bind(timingQueue()).to(timingExchange()).with(TimingMessage.ROUTING_KEY);
    }

    @Bean
    public Binding timingBindingDelay() {
        return BindingBuilder.bind(timingQueueDelay()).to(timingExchange()).with(TimingMessage.DELAY_ROUTING_KEY);
    }

    //----------------------------------------????????????????????????----------------------------------------

    @Bean
    public Queue timingPluginQueue() {
        return new Queue(TimingPluginMessage.QUEUE);
    }

    @Bean
    public CustomExchange timingPluginExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(TimingPluginMessage.EXCHANGE, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding timingPluginBinding() {
        return BindingBuilder.bind(timingPluginQueue()).to(timingPluginExchange()).with(TimingPluginMessage.ROUTING_KEY).noargs();
    }

    //--------------------------------------------????????????---------------------------------------------------

    @Bean
    public TopicExchange clusteringExchange() {
        return new TopicExchange(ClusteringMessage.EXCHANGE);
    }

    //---------------------------------------------????????????---------------------------------------------------

    @Bean
    public TopicExchange broadcastingExchange() {
        return new TopicExchange(BroadcastMessage.EXCHANGE);
    }

    //------------------------------------------------????????????-----------------------------------------------

    @Bean
    public Queue concurrencyQueue() {
        return new Queue(ConcurrencyMessage.QUEUE);
    }

    @Bean
    public DirectExchange concurrencyExchange() {
        return new DirectExchange(ConcurrencyMessage.EXCHANGE);
    }

    @Bean
    public Binding concurrencyBinding() {
        return BindingBuilder.bind(concurrencyQueue()).to(concurrencyExchange()).with(ConcurrencyMessage.ROUTING_KEY);
    }

    //------------------------------------------------??????????????????-----------------------------------------------------

    @Bean
    public Queue acknowledgeQueue() {
        return new Queue(AcknowledgeMessage.QUEUE);
    }

    @Bean
    public DirectExchange acknowledgeExchange() {
        return new DirectExchange(AcknowledgeMessage.EXCHANGE);
    }

    @Bean
    public Binding AcknowledgeBinding() {
        return BindingBuilder.bind(acknowledgeQueue()).to(acknowledgeExchange()).with(AcknowledgeMessage.ROUTING_KEY);
    }

}
