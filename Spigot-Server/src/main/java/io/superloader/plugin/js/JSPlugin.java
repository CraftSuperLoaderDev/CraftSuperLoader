package io.superloader.plugin.js;

import io.superloader.plugin.CSLBasePlugin;
import io.superloader.plugin.api.Minecraft;
import io.superloader.plugin.api.SuperLoader;

import javax.script.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSPlugin implements CSLBasePlugin {
    Invocable invocable;
    ScriptEngine engine;
    File file;
    boolean enable = false;
    Minecraft minecraft_api;

    String name,description,version;

    public JSPlugin(ScriptEngine engine, File file){
        this.engine = engine;
        this.file = file;
    }

    public void load() throws ScriptException, NoSuchMethodException, FileNotFoundException {
        SuperLoader loader = new SuperLoader();
        minecraft_api = new Minecraft(this);
        engine.put("csl",loader);
        engine.put("mc",minecraft_api);
        engine.eval(new FileReader(file));
        invocable = (Invocable) engine;

        this.name = loader.getName();
        this.description = loader.getDescription();
        this.version = loader.getVersion();
        if(name==null)name = file.getName();
        if(description==null)description = "A CraftSuperLoader js script.";
        if(version==null)version = "0.0.1";
    }

    public boolean isEnabled() {

        return enable;
    }

    public void onEnable() throws ScriptException, NoSuchMethodException {
        invocable.invokeFunction("enable");
        enable = true;
    }

    public ScriptEngine getEngine() {
        return engine;
    }

    public Invocable getInvocable(){
        return invocable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return Type.JS;
    }
}
