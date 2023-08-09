package io.superloader;

import org.bukkit.craftbukkit.CraftServer;

public class MetaData {
    public static final String server_name = "CraftSuperLoader";
    public static final String version = "Alpha-R0.3-SNAPSHOT";
    public static final String NMS_VERSION = CraftServer.class.getPackage().getName().substring(23);
    public static final String LUA_SCRIPT_ENGINE = "LuaJ-v3.0.1";
    public static final String JS_SCRIPT_ENGINE = "Nashorn-v1.8.0_301";
    public static final String PY_SDK_NETWORK = "Py4j-v0.10.9.7 + JEP-v4.1.1";
    public static int py4j_port = 25333;
}
