package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.List;

/**
 * Exemplo de integração com plugin javascript
 * <p>
 * Alertas utilizando <a href="https://sweetalert2.github.io/">sweetalert2.github.io</a>
 */
public class SweetAlertFeedbackBehaviour extends JQueryPluginBehavior {

    private FeedbackMessagesModel feedbackModel;

    @Override
    protected List<String> onDomReadyScript(Component component) {
        List<String> scripts = new ArrayList<>();
        for (FeedbackMessage feedback : feedbackModel.getObject()) {
            scripts.add(getSwalScript(feedback.getMessage().toString(), feedback.getLevelAsString()));
        }
        component.getFeedbackMessages().clear();
        return scripts;
    }

    @Override
    protected List<String> getPluginScripts() {
        return List.of("https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.all.min.js");
    }

    @Override
    protected List<String> getPluginStyles() {
        return List.of("https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.min.css");
    }

    @Language("js")
    public String getSwalScript(@Language("js") String message, String level) {
        return "Swal.fire({" +
                "  title: '" + message + "'," +
                "  toast: true," +
                "  position: 'top-end'," +
                "  timer: 5000," +
                "  timerProgressBar: true," +
                "  showConfirmButton: false," +
                "  icon: '" + level.toLowerCase() + "'" +
                "});";
    }

    @Override
    public void bind(Component component) {
        feedbackModel = new FeedbackMessagesModel(component);
    }

    @Override
    public void detach(Component component) {
        feedbackModel.detach();
    }
}
