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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * Created by Qikai on 2016/8/12.
 */
public class EncodeDecode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "service_code=queryEnterpriseInfo&op_id=1038&app_id=app_o2p&sign=8f16616b158d857e68e3282a47a15c55&call_pk=123&time_stamp=2016-08-10+15%3A00%3A00&WEB_HUB_PARAMS=%7B%22operId%22%3A24%2C%22queryCondition%22%3A%7B%22conditionType%22%3A%5B%7B%22condType%22%3A%22enterpriseId%22%2C%22condValue%22%3A%5B%2210351%22%5D%7D%2C%7B%22condType%22%3A%22enterpriseName%22%2C%22condValue%22%3A%5B%22BAT%22%5D%7D%5D%2C%22pageNumber%22%3A1%2C%22pageSize%22%3A10%7D%7D],service_code=[queryEnterpriseInfo],op_id=[1038],app_id=[app_o2p],sign=[8f16616b158d857e68e3282a47a15c55],call_pk=[123],time_stamp=[2016-08-10+15%3A00%3A00],web_hub_params=[%7B%22operId%22%3A24%2C%22queryCondition%22%3A%7B%22conditionType%22%3A%5B%7B%22condType%22%3A%22enterpriseId%22%2C%22condValue%22%3A%5B%2210351%22%5D%7D%2C%7B%22condType%22%3A%22enterpriseName%22%2C%22condValue%22%3A%5B%22BAT%22%5D%7D%5D%2C%22pageNumber%22%3A1%2C%22pageSize%22%3A10%7D%7D";
        System.out.println(URLDecoder.decode(url, "UTF-8"));
    }

}
