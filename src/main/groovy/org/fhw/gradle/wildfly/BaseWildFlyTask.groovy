package org.fhw.gradle.wildfly

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class BaseWildFlyTask extends DefaultTask {
    

    def getWildFlyBinDir()
    {
        return project.wildfly.wildfly_home + "/bin"
    }
	
}
