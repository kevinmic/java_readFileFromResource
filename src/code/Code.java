package code;

import java.util.*;
import java.io.*;
import java.net.*;

public class Code {

    public java.net.URL getResource() throws java.io.IOException {
        String res = "udf" + java.io.File.separator + "list_functions.lua";
        System.out.println("RESOURCE - " + res + " TRY - 3");
        return Code.class.getClassLoader().getResource(res);
    }
}
