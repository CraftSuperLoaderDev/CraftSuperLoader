package io.superloader.plugin;

public interface CSLBasePlugin {
    public String getName();
    public Type getType();
    public boolean isEnabled();

    public enum Type{
        LUA,
        PYTHON,
        JS
    }
}
