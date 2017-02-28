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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>Created by Charkey on 2016/8/12.</p>
 */
public class EncodeDecode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "service_code=queryEnterpriseInfo&op_id=1038&app_id=app_o2p&sign=8f16616b158d857e68e3282a47a15c55&call_pk=123&time_stamp=2016-08-10+15%3A00%3A00&WEB_HUB_PARAMS=%7B%22operId%22%3A24%2C%22queryCondition%22%3A%7B%22conditionType%22%3A%5B%7B%22condType%22%3A%22enterpriseId%22%2C%22condValue%22%3A%5B%2210351%22%5D%7D%2C%7B%22condType%22%3A%22enterpriseName%22%2C%22condValue%22%3A%5B%22BAT%22%5D%7D%5D%2C%22pageNumber%22%3A1%2C%22pageSize%22%3A10%7D%7D],service_code=[queryEnterpriseInfo],op_id=[1038],app_id=[app_o2p],sign=[8f16616b158d857e68e3282a47a15c55],call_pk=[123],time_stamp=[2016-08-10+15%3A00%3A00],web_hub_params=[%7B%22operId%22%3A24%2C%22queryCondition%22%3A%7B%22conditionType%22%3A%5B%7B%22condType%22%3A%22enterpriseId%22%2C%22condValue%22%3A%5B%2210351%22%5D%7D%2C%7B%22condType%22%3A%22enterpriseName%22%2C%22condValue%22%3A%5B%22BAT%22%5D%7D%5D%2C%22pageNumber%22%3A1%2C%22pageSize%22%3A10%7D%7D";
        System.out.println(URLDecoder.decode(url, "UTF-8"));
    }

}
