package ninja.mustache.template;

import com.google.inject.Singleton;
import ninja.Result;
import ninja.Route;
import ninja.template.TemplateEngineHelper;

@Singleton
public class MustacheTemplateEngineHelper extends TemplateEngineHelper {

    public String getTemplateForResult(Route route, Result result, String suffix) {
        String templateForResult = super.getTemplateForResult(route, result, suffix);

        /**
         * When running the app in a .jar, the mustache library doesn't find templates
         * in a route starting with /
         */
        if (templateForResult.startsWith("/")) {
            return templateForResult.substring(1);
        } else {
            return templateForResult;
        }
    }

}
