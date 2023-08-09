package io.superloader.plugin.api;

import io.superloader.plugin.CSLBasePlugin;

public class Minecraft {
    CSLBasePlugin plugin;
    public Minecraft(CSLBasePlugin plugin){
        this.plugin = plugin;
    }

    public void listener(String name,Object function){

    }
}
