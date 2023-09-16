import org.apache.wicket.Component;

import java.util.List;

public class Behavior {
    public static class SweetAlertFeedbackBehaviour extends JQueryMaskBehavior {

        private Object onKeyPress;
        var options =  {
                onKeyPress: <options> void function(cep, options) {
            var masks = ["00000-000", '0-00-00-00'];
            var mask = (cep.length>7) ? masks.get(1) : masks.get(0);
            $('cep').mask(mask, options);
        }

        @Override
        protected List<String> onDomReadyScript(Component component) {
            return null;
        }

        @Override
        protected List<String> getPluginScripts() {
            return null;
        }

        @Override
        public void bind(Component component) {

        }

        @Override
        public void detach(Component component) {

        }
    };
}
