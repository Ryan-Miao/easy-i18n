Easy I18n
===
![](https://img.shields.io/badge/Java-1.8-orange.svg)
[![Build Status](https://travis-ci.org/Ryan-Miao/easy-i18n.svg?branch=master)](https://travis-ci.org/Ryan-Miao/easy-i18n)
[![codecov](https://codecov.io/gh/Ryan-Miao/easy-i18n/branch/master/graph/badge.svg)](https://codecov.io/gh/Ryan-Miao/easy-i18n)
[![license](https://img.shields.io/badge/license-Apache--2.0-green.svg)](https://github.com/Ryan-Miao/easy-i18n/blob/master/LICENSE-2.0)

![](https://make.wordpress.org/polyglots/files/2016/01/i8n-v2.png)

easy-i18n provides a simple i18n integration for Java project. It is just a copy of Spring Message from spring-context.



# How to use
See [ResourceBundleMessageSourceTest](https://github.com/Ryan-Miao/easy-i18n/blob/master/src/test/java/com/miao/easyi18n/support/ResourceBundleMessageSourceTest.java)

A simple usage:

Maven for instance.
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

For the latest release code:
```xml
<dependency>
    <groupId>com.github.Ryan-Miao</groupId>
    <artifactId>easy-i18n</artifactId>
    <version>1.0</version>
</dependency>
```

For the latest code:
```xml
<dependency>
    <groupId>com.github.Ryan-Miao</groupId>
    <artifactId>easy-i18n</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```


接下来就可以愉快的玩耍了。
```java
private final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
messageSource.setBasenames("message", "another");
messageSource.setDefaultEncoding("UTF-8");
messageSource.setFallbackToSystemLocale(false);

String english = messageSource.getMessage(USER_NAME, null, Locale.US);
String chinese = messageSource.getMessage(USER_NAME, null, Locale.SIMPLIFIED_CHINESE);
Assert.assertEquals("username-us", english);
Assert.assertEquals("用户名", chinese);
```


