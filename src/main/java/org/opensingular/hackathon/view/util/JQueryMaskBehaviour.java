package org.opensingular.hackathon.view.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

public class JQueryMaskBehaviour extends JQueryPluginBehavior {

	private FeedbackMessagesModel feedbackModel;

	private static final long serialVersionUID = 1L;

	private String mask;

	public JQueryMaskBehaviour(String mask) {

		this.mask = mask;
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(JavaScriptHeaderItem
				.forUrl("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"));
		response.getResponse();

	}

	// https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html
	// $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
	@Override
	protected List<String> onDomReadyScript(Component component) {
		List<String> list = new ArrayList<>();
		list.add("$('#" + component.getMarkupId() + "')" + ".mask('" + mask + "')");
		return list;
	}

	@Override
	protected List<String> getPluginScripts() {
		return List.of("https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js");
	}
}
