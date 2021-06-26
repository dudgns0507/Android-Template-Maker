package com.github.dudgns0507.template.config

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable

class TemplateSettingDialogAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val currentProject: Project? = e.project
        val dlgMsg = StringBuffer(e.presentation.text.toString() + " Selected!")
        val dlgTitle: String = e.presentation.description

        val nav: Navigatable? = e.getData(CommonDataKeys.NAVIGATABLE)
        nav?.let {
            dlgMsg.append(java.lang.String.format("\nSelected Element: %s", nav.toString()))
        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon())
    }
}