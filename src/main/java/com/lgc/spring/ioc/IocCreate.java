package com.lgc.spring.ioc;

/**
 * spring容器的创建 刷新 refresh()
 * {@link org.springframework.context.support.AbstractApplicationContext} refresh()
 * // Prepare this context for refreshing.
 * 1.prepareRefresh() 刷新前的预处理
 *      1.初始化一些属性设置 initPropertySources(); 子类自定义实现
 *      2.校验 getEnvironment().validateRequiredProperties();
 *      3.this.earlyApplicationEvents = new LinkedHashSet<>();保存早期事件
 * // Tell the subclass to refresh the internal bean factory.
 * 2.obtainFreshBeanFactory();
 *      1.refreshBeanFactory() 创建 beanFactory()
 *      2.getBeanFactory{@link org.springframework.context.support.AbstractApplicationContext }
 *          return DefaultListableBeanFactory
 * // Prepare the bean factory for use in this context.
 * 3.prepareBeanFactory(beanFactory);
 *          设置 BeanFactory 类加载器 解析器
 *          添加部分 beanPostProcessor
 *          注册一些组件
 *          添加编译时的 Aspect
 *          系统属性 环境变量
 * // Allows post-processing of the bean factory in context subclasses.
 * 4.postProcessBeanFactory(beanFactory); 子类实现设置 beanFactory
 *  ------ beanFactory 创建以及准备工作
 * // Invoke factory processors registered as beans in the context.
 * 5.invokeBeanFactoryPostProcessors(beanFactory); beanFactory 后置处理器 在 beanFactory 初始化之后执行
 *      两个接口 BeanFactoryPostProcessor BeanDefinitionRegistryPostProcessor
 *      1。BeanDefinitionRegistryPostProcessor
 *      获取 所有的 BeanDefinitionRegistryPostProcessor
 *      首先执行实现了 PriorityOrdered 优先级接口的 BeanDefinitionRegistryPostProcessor
 *      执行实现了 Ordered 接口的 BeanDefinitionRegistry
 *      最后执行没有 优先级顺序 接口的 BeanDefinitionRegistry
 *      2。执行 BeanFactoryPostProcessor
 *      // 获取 所有的 BeanDefinitionRegistryPostProcessor
 *  *      首先执行实现了 PriorityOrdered 优先级接口的 BeanDefinitionRegistryPostProcessor
 *  *      执行实现了 Ordered 接口的 BeanDefinitionRegistry
 *  *      最后执行没有 优先级顺序 接口的 BeanDefinitionRegistry
 * //Register bean processors that intercept bean creation.
 * registerBeanPostProcessors(beanFactory);
 *  获取 beanPostProcessor
 * 6.beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
 *          BeanPostProcessor
 *          DestructionAwareBeanPostProcessor
 *          InstantiationAwareBeanPostProcessor
 *          SmartInstantiationAwareBeanPostProcessor
 *          MergedBeanDefinitionPostProcessor
 *       获取所有 beanPostProcessor postProcessorNames  后置处理器都有优先级
 *       先注册 PriorityOrdered 优先级的 在注册 ordered 没有顺序的
 *       把每一个BeanPostProcessor 添加到 beanFactory
 *       beanFactory.addBeanPostProcessor(postProcessor)
 *       最后注册 MergedBeanDefinitionPostProcessor
 *
 *       最最后 检查 bean 创建完成后检查是否是 applicationListener
 *       beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(applicationContext));
 *  // Initialize message source for this context.
 * 	7.initMessageSource(); 初始化 MessageSource 组件 国际化 消息绑定 消息解析
 *      1。获取 BeanFactory
 *      2。看容器中是否有 id 为 messageSource，类型是 MessageSource 的组件
 *          如果有赋值给 messageSource 如果没有自己创建一个 DelegatingMessageSource
 *           MessageSource 取出国际化配置文件中的某个key的值 能按照 区域信息获取
 *       3。注入 beanFactory.registerSingleton(MESSAGE_SOURCE_BEAN_NAME, this.messageSource);
 *
 *  // Initialize event multicaster for this context.
 * 	8. initApplicationEventMulticaster(); 初始化事件派发器
 * 	    获取 beanFactory
 * 	    beanFactory 获取 applicationEventMulticaster 的 ApplicationEventMulticaster
 * 	    获取不到 new 一个注册进去
 * 	    beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
 * 	// Initialize other special beans in specific context subclasses.
 *  9. onRefresh(); 子容器刷新   // For subclasses: do nothing by default.
 *    子类重写 在容器刷新的时候可以自定义逻辑
 *  // Check for listener beans and register them.
 * 	10. registerListeners();
 * 	  拿到所有的 ApplicationListener  getApplicationListeners()
 * 	  将每个监听器添加到事件派发器
 * 	// Instantiate all remaining (non-lazy-init) singletons.
 * 	11. finishBeanFactoryInitialization(beanFactory); 初始化剩下的单实例 bean
 * 	    // Instantiate all remaining (non-lazy-init) singletons.
 * 		beanFactory.preInstantiateSingletons();
 * 	    // 获取容器中的所有bean 依次进行初始化和创建对象
 * 	       获取 bean 对象信息 RootBeanDefinition
 * 	   if (!bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()) {
 * 			if (isFactoryBean(beanName)) {
 * 		}else {
 * 		getBean(beanName); --> ioc.getBean() invoke doGetBean() -> 获取缓存的单实例 bean
 * 	        缓存中获取不到 开始穿件 标记当前 bean 已经创建 防止多线程
 * 	        获取 bean 的定义信息 获取当前 bean 依赖的 bean 创建出来
 * 	        启动创建单实例 bean
 * 	        // Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
 * 	        让 beanPostProcessor 先拦截 返回代理对象 InstantiationAwareBeanPostProcessor
 * 			Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
 * 	      -》if (bp instanceof InstantiationAwareBeanPostProcessor) {
 * 				InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
 * 				Object result = ibp.postProcessBeforeInstantiation(beanClass, beanName);
 * 		     }
 *
 * @author lgc
 **/
public class IocCreate {
}
