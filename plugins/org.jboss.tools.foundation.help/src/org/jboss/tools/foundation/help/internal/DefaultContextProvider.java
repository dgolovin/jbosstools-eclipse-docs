package org.jboss.tools.foundation.help.internal;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.help.AbstractContextProvider;
import org.eclipse.help.ICommandLink;
import org.eclipse.help.IContext;
import org.eclipse.help.IContext3;
import org.eclipse.help.IHelpResource;
import org.eclipse.help.IUAElement;

public class DefaultContextProvider extends AbstractContextProvider {

	public DefaultContextProvider() {
	}

	@Override
	public IContext getContext(String id, String locale) {
		// Return null if it is not JBossTools context
		IContext result = null;

		// Check if it is JBossTools related context
		if (id.startsWith("org.jboss.tools")) {
			result = getDefaultContext();
		}
		return result;
	}

	/**
	 * This context provider is global and going to be invoked last if
	 * documentation plug-ins are not installed
	 */
	@Override
	public String[] getPlugins() {
		return null;
	}

	public IContext getDefaultContext() {
		// should be delegated to default context provider 
		return new IContext3() {

			@Override
			public String getText() {
				return "This is default context";
			}

			@Override
			public IHelpResource[] getRelatedTopics() {
				return new IHelpResource[] { new IHelpResource() {

					@Override
					public String getHref() {
						return "http://www.jboss.org";
					}

					@Override
					public String getLabel() {
						return "JBoss Tools Documentation";
					}
				} };
			}

			@Override
			public String getTitle() {
				return "Default context title";
			}

			@Override
			public String getStyledText() {
				return "";
			}

			@Override
			public String getCategory(IHelpResource topic) {
				return "";
			}

			@Override
			public ICommandLink[] getRelatedCommands() {
				// TODO: Provide action that would install local documentation
				return new ICommandLink[] { new ICommandLink() {

					@Override
					public boolean isEnabled(IEvaluationContext context) {
						return true;
					}

					@Override
					public IUAElement[] getChildren() {
						return new IUAElement[0];
					}

					@Override
					public String getSerialization() {
						return "org.jboss.tools.foundation.help.InstallDocCommand";
					}

					@Override
					public String getLabel() {
						return "Install JBoss Tools Documentation";
					}
				},  new ICommandLink() {

                                        @Override
                                        public boolean isEnabled(IEvaluationContext context) {
                                                return true;
                                        }

                                        @Override
                                        public IUAElement[] getChildren() {
                                                return new IUAElement[0];
                                        }

                                        @Override
                                        public String getSerialization() {
                                                return "org.jboss.tools.foundation.help.AddRemoteInfoCenterCommand";
                                        }

                                        @Override
                                        public String getLabel() {
                                                return "Use Remote JBoss Tools Documentation";
                                        }
                                }};
			}
		};
	}
}
