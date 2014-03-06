## Proof of Concept for JBoss Tools Documentation

This repository contains prove of concept (POC) that consists of default help context for JBoss Tools features, JBoss JSF Tools Reference Guide packed in eclipse help system format, standalone info-center application and p2repository to deliver features mentioned above to the end user

The Default Help Context Feature extends eclipse help system with Global Context Provider to intercept missing help contexts with "org.jboss.tools" prefix and provide default context help content for various supported UI elements:
- Views;
- Editors;
- Wizards;
- Dialogs.

JBoss JSF Tools Reference Guide adds topic to eclipse help system and contributes context help contents for:
- New JSF Project Wizard;
- Import JSF  Project Wizard;
- JSF Configuration File Editor;
- New JSF Configuration File Wizard.
This documentation uses artifacts built out of /jbosstools-javaee/jsf/docs/jsf_tools_ref_guide module and installed in local or remote repository. 

Info-center application builds standalone eclipse help system application with pre-installed JBoss JSF Tools Reference Guide. It can be started locally using provided launchers for most platforms supported by JBossTools. Then local web server at http://localhost:8080/help/index.jsp can be used as regular eclipse help system. 
This application is aloso deployed as a war file into Openshift here http://help-eskimooo.rhcloud.com/p2repo/.

Eclipse p2repository contains two features mentioned above:
1. JBoss Tools Foundation Help Feature with default context help provider;
2. JBoss JSF Tools Reference Guide Feature with documentation in eclipse help system format.
This repository is available form Openshift http://help-eskimooo.rhcloud.com/help/index.jsp location and can be added to eclipse as remote info-center in Preferences dialog Help->Content category.


## Scenarios covered 
1. Default behavior - the way it looks right now
2. Default context help provider for org.jboss.tools.* contexts
3. Using remote info-center to fill org.jboss.tools.* contexts
4. Installing JBoss JSF Tools Reference Guide locally

Detailed steps are here ([see details](docs/scenarios.md)) 


## Steps to build this repository
1. build jbosstools-javaee/jsf/docs/jsf_ref_guide 
```
mvn clean install 
```
2. build this repository 
```
mvn clean install
```

3. Start info-center using bat or sh files
4. Start JBossTools 
5. Install JBoss Tools Foundation Help feature form local update site in site/target/repository
6. Look at new JSF Project wizard - there should be default context doc on the right side if you push (?) button 
7. Go to preferencess and add remote info center as http://localhost:8081/help
8. Try dialog again and it should have context help linked to documentation topic

### TODO's:

1. Provide actions to default context to install help locally or add remote info-center
2. Add the API to override default context help for different products
3. Create build war to deploy info-center into any web container
4. Report problems in documentation about deploying info-center as war

##### List of current problems in eclipse:

- missing dependencies in info-center feature;
- missing steps to copy index.jsp, default and advanced folders to war archive;
- wrong target location for org.eclipse.equinox.servletbridge.jar which should be copied to WEB-INF/lib and WEB-INF/plugins;
- no maven plugin to build war to simplify info-center deployment.

