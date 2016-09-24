/*
 * Copyright (c) 2013-2015 Charkey. All rights reserved.
 *
 * This software is the confidential and proprietary information of Charkey.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Charkey.
 *
 * Charkey MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 *
 * Charkey SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package cn.simastudio.charkey.test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Qikai on 2016/8/8.
 */
public class Loader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(className);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        System.out.println("Loader loaded by: " + Loader.class.getClassLoader());
        Object loader1 = new Loader();
        System.out.println("new loader1 loaded by " + loader1.getClass().getClassLoader() + "-" + loader1.getClass());
        Object objectLoaded1 = classLoader.loadClass(Loader.class.getName()).newInstance();
        System.out.println("objectLoaded1 loaded by classLoader " + objectLoaded1.getClass().getClassLoader() + "-" + objectLoaded1.getClass());

        System.out.println(objectLoaded1 instanceof cn.simastudio.charkey.test.Loader);

        Object loader2 = new Loader();
        System.out.println("new loader1 loaded by " + loader2.getClass().getClassLoader() + "-" + loader2.getClass());
        System.out.println(loader2 instanceof cn.simastudio.charkey.test.Loader);
    }
}
