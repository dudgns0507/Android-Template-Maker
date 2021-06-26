package com.github.dudgns0507.template.config

import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

class TemplateSettingDialogWrapper : DialogWrapper(true) {

    private val config: Config by lazy {
        Config.createInstance()
    }

    init {
        title = "Android-Template-Maker Settings"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(BorderLayout())

        val pathText = JLabel("Template File Path")
        dialogPanel.add(pathText, BorderLayout.LINE_START)

        val label = JTextField(config.templatePath)
        dialogPanel.add(label, BorderLayout.CENTER)

        return dialogPanel
    }
}