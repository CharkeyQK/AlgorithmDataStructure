/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013-2017 Charkey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cn.simastudio.charkey.test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Created by Charkey on 2016/8/8.</p>
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
