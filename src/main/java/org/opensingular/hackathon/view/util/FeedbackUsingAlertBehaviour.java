package org.opensingular.hackathon.view.util;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.intellij.lang.annotations.Language;

public class FeedbackUsingAlertBehaviour extends Behavior {

    public static final String SWEETALERT_JS = "https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.all.min.js";
    public static final String SWEETALERT_CSS = "https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.min.css";

    private FeedbackMessagesModel feedbackModel;

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        response.render(JavaScriptReferenceHeaderItem.forUrl(SWEETALERT_JS));
        response.render(CssReferenceHeaderItem.forUrl(SWEETALERT_CSS));

        for (FeedbackMessage feedback : feedbackModel.getObject()) {
            response.render(OnDomReadyHeaderItem.forScript(getSwalScript(feedback.getMessage().toString(), feedback.getLevelAsString())));
        }

        component.getFeedbackMessages().clear();
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
