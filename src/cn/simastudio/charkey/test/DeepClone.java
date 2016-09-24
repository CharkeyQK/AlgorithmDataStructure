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

import java.io.*;

/**
 * Created by Qikai on 2016/8/13.
 */
public class DeepClone {

    static class People implements Serializable {

        private static final long serialVersionUID = 2996414325173782653L;

        String name;
        int age;

        People(String nameVal, int ageVal) {
            name = nameVal;
            age = ageVal;
        }

        public Object deepClone() throws IOException, ClassNotFoundException {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bo);
            os.writeObject(this);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject();
        }

    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeepClone.People people = new People("Charkey", 26);
        People people1 = (People) people.deepClone();
        System.out.println(people.toString());
        System.out.println(people1.toString());
        System.out.println(people == people1);
        System.out.println(people.equals(people1));
    }

}
