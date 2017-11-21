Easy I18n
===

本项目的目的在于提供的简单的集成国际化的方案。
由于Spring Message的使用简洁好用，因此特别提取出相关代码。所有代码均摘自Spring-context-4.3.7.


# 如何使用
详细用法参见[ResourceBundleMessageSourceTest](src\test\java\com\miao\easyi18n\support\ResourceBundleMessageSourceTest.java)

简单使用如下
```java
private final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
messageSource.setBasenames("message", "another");
messageSource.setDefaultEncoding("UTF-8");
messageSource.setFallbackToSystemLocale(false);
messageSource.setAlwaysUseMessageFormat(true);

String english = messageSource.getMessage(USER_NAME, null, Locale.US);
String chinese = messageSource.getMessage(USER_NAME, null, Locale.SIMPLIFIED_CHINESE);
Assert.assertEquals("username-us", english);
Assert.assertEquals("用户名", chinese);
```


