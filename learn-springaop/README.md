# AOP


#### EnableAspectJAutoProxy 默认开启

#### CGLIB来实现AOP的时候，需要配置spring.aop.proxy-target-class=true，不然默认使用的是标准Java的实现

#### @Before：在执行连接点方法之前运行。我们可以使用@Before注释将建议类型标记为Before。

#### @After：在连接点方法完成执行之后（无论是正常还是引发异常）执行的建议。我们可以使用@After注释创建事后通知。

#### @AfterReturning：有时我们希望建议方法仅在联接点方法正常执行时才执行。我们可以使用@AfterReturning批注将方法标记为返回建议之后。

#### @AfterThrowing：仅在连接点方法抛出异常时才执行此建议，我们可以使用它以声明方式回滚事务。对于此类建议，我们使用@AfterThrowing批注。

#### @Around：这是最重要和最有力的建议。该建议围绕着连接点方法，我们还可以选择是否执行连接点方法。我们可以编写在执行连接点方法之前和之后执行的建议代码。周围建议的责任是调用连接点方法并在该方法返回某些值时返回值。我们使用@Around批注创建围绕建议的方法




#### 在@Before中优先执行@Order(1)的内容，再执行@Order(2)的内容
#### 在@After和@AfterReturning中优先执行@Order(2)的内容，再执行@Order(1)的内容