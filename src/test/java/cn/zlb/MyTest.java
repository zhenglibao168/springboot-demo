package cn.zlb;

import org.testng.annotations.Test;

import java.io.File;

/**
 * 测试类
 *
 * @author libao.zheng
 * @date 2020/8/26 10:42 上午
 */
public class MyTest {
    private static int fileCount = 0;

    @Test
    public void test() {
        File rootDir = new File("/Users/zlb/Downloads");
        listFile(rootDir.listFiles());
        System.out.println("file count=" + fileCount);
    }

    private void listFile(File[] files) {
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
                fileCount++;
                continue;
            }
            File[] fs = f.listFiles();
            if (fs != null && fs.length > 0) {
                listFile(fs);
            }
        }
    }
}
