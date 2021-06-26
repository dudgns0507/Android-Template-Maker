package com.github.dudgns0507.template.config

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import java.awt.event.ActionEvent
import javax.swing.JButton


class TemplateSettingDialogAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = TemplateSettingDialogWrapper()
        dialog.show()

        val testButton = JButton()
        testButton.addActionListener { actionEvent: ActionEvent? ->
            if (dialog.showAndGet()) {
                val currentProject: Project? = e.project
                Messages.showMessageDialog(currentProject, "Test", "Test", Messages.getInformationIcon())
            }
        }
    }
}