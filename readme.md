 a.异步IO，告知内核启动某个操作，并让内核在整个操作完成后（包括将数据从内核复制到用户自己的缓冲区）通知我们。信号驱动io由内核通知我们何时开始一个io操作，
 异步io由内核通知我们操作已完成。
 
 b. 同步阻塞IO
    伪异步IO
    非阻塞IO
    异步Io
    
    
 c. TCP粘包问题
    
    netty 提供了很多API解决tcp粘包拆包导致的读写问题
    LineBasedFrameDecoder
    StringDecoder
    
d. java 序列化
   无法跨语言
   序列化后的码流太大
   序列效率低
    
 
e. HTTP
   1XX 服务器接收到请求，继续处理
   2xx 请求已被接收，处理
   3xx 重定向，完成请求需进一步处理
   4xx 客户端错误
   5xx 服务端错误
    

=====================
* netty portion
=====================
  . discard
  . echo
  . pojo


=====================
* hessian portion
=====================
hessian remote on http base style
hessian 服务以servlet方式，二进制方式提供输出

1. cd project

   execute mvn clean install
   
   mvn jetty:run
   
2. then run exc  java main class which named ApplicationHessianTest.java


3. hessian 序列化 serialize 化HessianTest.java



============
Netty 心跳例子
============
module/heartbeat
