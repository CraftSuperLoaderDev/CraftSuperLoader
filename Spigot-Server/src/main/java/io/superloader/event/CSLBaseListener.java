package io.superloader.event;

import io.superloader.plugin.CSLBasePlugin;

public interface CSLBaseListener {
    public CSLBasePlugin getPlugin();
    public void eventHandle();
}
