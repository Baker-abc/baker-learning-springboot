# Getting Started

## 全局异常 globalexception 处理

###一般在做api开发时我们希望将所有业务层抛到controller异常都集中处理一下。比如对异常差异化报警、转发不同页面、封装不同http状态码、集中存储打印。。。

 

#### 一、实现方式
* 封装类注解 @ControllerAdvice
* 在实现方法上 @ExceptionHandler(Throwable.class)，处理所有Throwable及其子类的异常
* 我们处理所有controller抛出的异常再加一个@ResponseBody  通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）
 

