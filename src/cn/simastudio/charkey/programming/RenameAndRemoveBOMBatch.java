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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by Qikai on 9/24/2016.
 */
public class RenameAndRemoveBOMBatch {

    private static final String PROPS_DIR_PATH = "C:\\Users\\Qikai\\Desktop\\Properties_dir";

    private static final String NEW_FILE_SUFFIX = "_en.properties";

    private static boolean BOM_HEADER_READ = false;

    public static void main(String[] args) throws IOException {

        File propsDir = new File(PROPS_DIR_PATH);
        if (propsDir.isDirectory()) {
            File[] propsFileList = propsDir.listFiles();

            if (propsFileList == null) return;

            for (File aFile : propsFileList) {
                String oldName = aFile.getName();
                // skip files processed
                if (oldName.endsWith(NEW_FILE_SUFFIX)) {
                    continue;
                }
                // concat new file name
                String newName = oldName.substring(0, oldName.indexOf(".")).concat(NEW_FILE_SUFFIX);

                FileInputStream fin = new FileInputStream(PROPS_DIR_PATH + File.separator + oldName);
                FileOutputStream fout = new FileOutputStream(PROPS_DIR_PATH + File.separator + newName);
                FileChannel fcin = fin.getChannel();
                FileChannel fcout = fout.getChannel();
                // fast copy
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

                while (true) {
                    buffer.clear();
                    // read
                    int r = fcin.read(buffer);
                    // read end
                    if (r == -1) {
                        break;
                    }

                    // flips this buffer
                    buffer.flip();

                    // deal with BOM
                    if (!BOM_HEADER_READ) {
                        BOM_HEADER_READ = true;
                        // the first three bytes of encoding UTF-8 with BOM
                        if (buffer.get(0) == -17 && buffer.get(1) == -69 && buffer.get(2) == -65) {
                            // skip first three bytes
                            buffer.position(3);
                        }
                    }

                    // UTF-8 output
                    Charset utf8 = Charset.forName("UTF-8");
                    CharsetDecoder decoder = utf8.newDecoder();
                    CharsetEncoder encoder = utf8.newEncoder();
                    CharBuffer cb = decoder.decode(buffer);
                    ByteBuffer outputData = encoder.encode(cb);
                    fcout.write(outputData);
                }
                // reset flag
                BOM_HEADER_READ = false;

                // wind up
                fin.close();
                fout.close();
            }
        }
    }

}
