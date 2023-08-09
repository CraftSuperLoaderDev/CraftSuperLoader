package io.superloader.plugin.api;

public class SuperLoader {
    String name,description,version;

    public void registerPlugin(String name,String description,String version){
        this.name = name;
        this.description = description;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }
}
