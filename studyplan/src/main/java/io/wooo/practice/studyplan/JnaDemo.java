package io.wooo.practice.studyplan;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import java.util.Objects;

/**
 * @author wb-wsp312690
 * @version 1.0.0
 * @date 2019-12-15 12:25:49
 **/
public class JnaDemo {

    public interface CLibrary extends Library{

        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                        CLibrary.class);

        void printf(String format, Object... args);

    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("hello world");
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s/n", i, args[i]);
        }
    }

}
