# Getting Started

## 使用场景
* 类属性自动赋值。
* 验证对象属性完整性。
* 代替配置文件功能，像spring基于注解的配置。
* 可以生成文档，像java代码注释中的@see,@param等

## 一、切面方式

### 1、参数校验 implements ConstraintValidator

### 2、HandlerInterceptorAdapter
* 切面类实现HandlerInterceptorAdapter，且纳入容器
* 需要registry切面类

### 3、aop

## 二、参数说明
### 1、@Target
##### @Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
##### 作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
##### 取值(ElementType)有：
* CONSTRUCTOR:用于描述构造器
* FIELD:用于描述域
* LOCAL_VARIABLE:用于描述局部变量
* METHOD:用于描述方法
* PACKAGE:用于描述包
* PARAMETER:用于描述参数
* TYPE:用于描述类、接口(包括注解类型) 或enum声明

### 2、@Documented 
#### 作用：@Documented 在生成javac时显示该注解的信息  

### 3、@Retention
#### 作用：定义被它所注解的注解保留多久，一共有三种策略，定义在RetentionPolicy枚举中。
* SOURCE：被编译器忽略。在编译阶段丢弃，这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。所以他们被称作源码级别注解。有过代码自动生成经验的开发者，譬如lombok，都知道它是通过注解在编译时自动生成一部分代码，让源码看起来更简洁，字节码却很强大。
* CLASS：注解将会被保留在Class文件中，但在运行时并不会被VM保留。这是默认行为，所有没有用Retention注解的注解，都会采用这种策略。
* RUNTIME：保留至运行时。所以我们可以通过反射去获取注解信息。

### 4、@Inherited 
#### 作用：允许子类继承父类的注解。该注解定义的annotation如果作用在A类上，如果B继承A，则B类同时也继承了A的annotation
