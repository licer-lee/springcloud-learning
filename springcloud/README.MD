
### Spring Cloud Stream 
1. 绑定器 Binder
- 应用程序和消息中间件通过binder来绑定
- Spring Cloud Stream 目前提供了RabbitMQ、kafka的绑定器

2. 发布-订阅模式
- Spring Cloud Stream中的消息通信方式遵循了发布-订阅模式
- Topic主题是Spring Cloud Stream中的一个抽象概念
- 在RabbitMQ中的它对应了Exchange、而在Kakfa中则对应了Topic

3. 消费组
- 在Spring Cloud Stream中提供了消费组的概念，解决消息出现了被重复消费两次的情况
- spring.cloud.stream.bindings.input.group指定一个组名，多个实例在接收到消息的时候，只有一个成员真正的收到消息并进行处理
- 默认情况下，当我们没有为应用指定消费组的时候，Spring Cloud Stream会为其分配一个独立的匿名消费组，所有的应用都会对其进行消费

4. 消息分区
- 消费组解决重复消费问题， 并无法控制消息具体被哪个实例消费
- 引入分区概念就是为了解决这样的问题：当生产者将消息数据发送给多个消费者实例时，保证拥有共同特征的消息数据始终是由同一个消费者实例接收和处理。
- Spring Cloud Stream为分区提供了通用的抽象实现，用来在消息中间件的上层实现分区处理，所以它对于消息中间件自身是否实现了消息分区并不关心，这使得Spring Cloud Stream为不具备分区功能的消息中间件也增加了分区功能扩展。