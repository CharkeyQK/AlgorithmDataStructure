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

package cn.simastudio.charkey.programming;

import java.io.*;

/**
 * Created by Charkey on 2/27/2017.
 */
public class ObjectSerTest1 {

    public static void main(String args[]) {
        try {

            FileOutputStream fos = new FileOutputStream("test.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Student s1 = new Student("张三", "12345");
            Student s2 = new Student("王五", "54321");
            System.out.println(s1);
            System.out.println(s2);

            oos.writeObject(s1);
            oos.writeObject(s2);

            oos.close();

            new Student("xyq", "i love you");

            FileInputStream fis = new FileInputStream("test.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);


            Student s3 = (Student) ois.readObject();
            Student s4 = (Student) ois.readObject();


            System.out.println(s3);
            System.out.println(s4);


            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
