package com.github.dudgns0507.template.config

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class TemplateSettingDialogAction : AnAction() {
    private val config: Config by lazy {
        Config.createInstance()
    }

    override fun actionPerformed(e: AnActionEvent) {
        val dialog = TemplateSettingDialogWrapper(config.templatePath)
        dialog.showAndGet()
    }
}
