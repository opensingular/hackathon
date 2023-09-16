import org.apache.wicket.Component;

import java.util.List;

public abstract class JQueryMaskBehavior {
    protected abstract List<String> onDomReadyScript(Component component);

    protected abstract List<String> getPluginScripts();

    public abstract void bind(Component component);

    public abstract void detach(Component component);
}
