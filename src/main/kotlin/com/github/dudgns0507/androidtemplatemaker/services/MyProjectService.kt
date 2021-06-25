package com.github.dudgns0507.androidtemplatemaker.services

import com.github.dudgns0507.androidtemplatemaker.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
