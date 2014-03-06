jbosstools-context-help
=======================

Administrative tasks that should be done:
1. Define the rule how to name dynamic help contextx
	pluginId.contextId
                pluginId is match to plugin where UI element is defined
                contextId dynamic help identifier for UI elements inside plugin should start with ui element name like "newwizard_*", "editor_*"
2. Every ui element that supports context help should set specific contextId or default contextId


CntextId definition and recognition:
1. Provide default context which is going to be used:
	when specific contextId us assigned but not defined yet
	when JBDS/JBT specific ui element is not planned to have context help
2. Provide the way to configure default context content for different products
3. Provide remote infocenter with all documentation installed
4. 4ontext provider that recognized jbds/jbt help contexts and if defined transfer processing to that context or return context for default one




