package org.jenkinsci.plugins.appetize;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.EnvironmentContributingAction;

/** Exports the message text associated with a git tag used for a build. */
public class AppetizeEnvironmentContributingAction implements EnvironmentContributingAction {

    /** The name of the environment variable this plugin exports. */
    static final String ENV_VAR_NAME_PUBLIC = "APPETIZE_PUBLIC_URL";
    static final String ENV_VAR_NAME_MANAGE = "APPETIZE_MANAGE_URL";

    private final String publicURL;
    private final String manageURL;

    public AppetizeEnvironmentContributingAction(String publicURL, String manageURL) {
        this.publicURL = publicURL;
        this.manageURL = manageURL;
    }

    public void buildEnvVars(AbstractBuild<?, ?> build, EnvVars env) {
        if (publicURL != null) {
            env.put(ENV_VAR_NAME_PUBLIC, publicURL);
        }
        if (manageURL != null) {
            env.put(ENV_VAR_NAME_MANAGE, manageURL);
        }
    }

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return null;
    }

}