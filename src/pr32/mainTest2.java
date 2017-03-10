package pr32;


import java.io.*;

public class mainTest2 {
    public static void main(String[] arg) throws IOException {

        /*try(InputStream is=new FileInputStream("")){
            byte[] buf=new byte[1024];
            int n=is.read(buf);
            while (true){
                n=is.read(buf);
            }

        }*/
        try (InputStream is = new BufferedInputStream(new FileInputStream("C:\\Archi\\ReadMe.txt"));
             OutputStream os = new BufferedOutputStream(new FileOutputStream("random.txt"))) {
            while (true)

            {
                int c = is.read();
                if (c < 0) break;
                os.write(c);
            }
        }
    }
}


