package com.github.dudgns0507.template.config

import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class TemplateSettingDialogWrapper(
    defaultPath: String
) : DialogWrapper(true) {
    private val config: Config by lazy {
        Config.createInstance()
    }
    private val dialogPanel = JPanel(BorderLayout())
    private val pathLabel = JLabel("Template File Path")
    private val pathText = JTextField(defaultPath)

    init {
        title = "Android-Template-Maker Settings"
        init()
    }

    override fun createCenterPanel(): JComponent {
        dialogPanel.add(pathLabel, BorderLayout.LINE_START)
        dialogPanel.add(pathText, BorderLayout.CENTER)

        return dialogPanel
    }

    override fun doOKAction() {
        config.templatePath = pathText.text
        super.doOKAction()
    }
}
