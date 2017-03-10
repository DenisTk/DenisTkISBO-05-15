package pr3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class mainTest {
    public static void main(String[] arg) throws IOException {
        Path dir = Paths.get("C:\\Archi");
      /*  boolean isDir = Files.isDirectory(div);
        long size = Files.size(div);
        FileTime T = Files.getLastModifiedTime(div);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(div)) {
            for (Path child : ds) {
                PathInfo childInfo = scan(child);

            }
        }

    }*/
      PathInfo info=scan(dir);
        System.out.println(info);
    }

    public static PathInfo scan(Path path) throws IOException {
        long size = Files.size(path);
        if (Files.isDirectory(path)) {
            List<PathInfo> children = new ArrayList<>();
            long sumSize = 0;
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
                for (Path child : ds) {
                    PathInfo childInfo = scan(child);
                    children.add(childInfo);
                    sumSize+=childInfo.size;


                }

            }
            return new PathInfo(path,sumSize,children);


        } else {
            List<PathInfo> empty = Collections.emptyList();
            return new PathInfo(path, size, empty);

        }
    }
    public static void print (PathInfo pi, int level){

    }


}
