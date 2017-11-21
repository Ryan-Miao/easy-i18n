
/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.miao.easyi18n.support;

import com.miao.easyi18n.NoSuchMessageException;
import org.junit.After;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Juergen Hoeller
 * @since 03.02.2004
 */
public class ResourceBundleMessageSourceTests {

    @Test
    public void testResourceBundleMessageSourceStandalone() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("messages");
        assertEquals("message1", ms.getMessage("code1", null, Locale.ENGLISH));
        assertEquals("nachricht2", ms.getMessage("code2", null, Locale.GERMAN));
    }

    @Test
    public void testResourceBundleMessageSourceWithWhitespaceInBasename() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("  messages  ");
        assertEquals("message1", ms.getMessage("code1", null, Locale.ENGLISH));
        assertEquals("nachricht2", ms.getMessage("code2", null, Locale.GERMAN));
    }

    @Test
    public void testResourceBundleMessageSourceWithDefaultCharset() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("messages");
        ms.setDefaultEncoding("ISO-8859-1");
        assertEquals("message1", ms.getMessage("code1", null, Locale.ENGLISH));
        assertEquals("nachricht2", ms.getMessage("code2", null, Locale.GERMAN));
    }

    @Test
    public void testResourceBundleMessageSourceWithInappropriateDefaultCharset() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("messages");
        ms.setDefaultEncoding("argh");
        ms.setFallbackToSystemLocale(false);
        try {
            ms.getMessage("code1", null, Locale.ENGLISH);
            fail("Should have thrown NoSuchMessageException");
        } catch (NoSuchMessageException ex) {
            // expected
        }
    }

    @After
    public void tearDown() {
        ResourceBundle.clearCache();
    }

}
