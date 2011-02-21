package com.bluepapa32.gradle.plugins.native2ascii

import org.apache.tools.ant.filters.EscapeUnicode
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin

public class Native2AsciiPlugin implements Plugin<Project> {
    def void apply(Project project) {
        project.getPlugins().apply(JavaBasePlugin.class);

        project.sourceSets.each { s ->
            project.tasks.getByName(s.processResourcesTaskName) { task ->
                task.from(s.resources.srcDirs) {
                    include '**/*.properties'
                    filter(EscapeUnicode)
                }
                task.from(s.resources.srcDirs) {
                    exclude '**/*.properties'
                }
            }
        }
    }
}

