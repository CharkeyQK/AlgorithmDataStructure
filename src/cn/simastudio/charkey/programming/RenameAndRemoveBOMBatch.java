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
 * <p>Created by Charkey on 9/24/2016.</p>
 */
public class RenameAndRemoveBOMBatch {

    private static final String PROPS_DIR_PATH = "C:\\Users\\Charkey\\Desktop\\Properties_dir";

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
