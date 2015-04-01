import code.*;
import java.io.*;
import java.net.*;

public class TestIt {
    public static void main(String[] args) throws Exception {
        Code code = new Code();
        URL url = code.getResource();
        System.out.println("A - " + url);
        System.out.println("B - " + url.getFile());

        System.out.println("TRY AS STREAM - ");
        InputStream stream = url.openStream();
        try {
            System.out.println("VALUE - " + readStream(stream));
        }
        finally {
            stream.close();
        }

        System.out.println("TRY AS FILE STREAM - ");
        File file = new File(url.getFile());
        System.out.println(file.length());
        FileInputStream inStream = new FileInputStream(file);
        try {
            System.out.println("VALUE - " + readStream(inStream));
        }
        finally {
            inStream.close();
        }
    }

    public static String readStream(InputStream stream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        byte[] bytes = new byte[256];
        int length = 0;
        while ((length = stream.read(bytes)) > 0) {
            outStream.write(bytes, 0, length);
        }

        return new String(outStream.toByteArray());
    }
}
