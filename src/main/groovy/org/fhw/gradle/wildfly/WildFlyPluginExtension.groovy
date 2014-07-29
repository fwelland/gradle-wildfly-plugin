package org.fhw.gradle.wildfly

class WildFlyPluginExtension {
    def String wildfly_home = '/opt/wildfly'
    def String start_script = 'standalone.sh'    
    def String cli_script = 'jboss-cli.sh'
    def String start_regex = '^.*started in.*- Started.*$'    
}
   