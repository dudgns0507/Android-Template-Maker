package com.github.dudgns0507.template.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "Config",
    storages = [Storage(value = "Config.xml")]
)
class Config : PersistentStateComponent<Config> {
    @JvmField
    var templatePath: String = ""

    override fun getState(): Config {
        return this
    }

    override fun loadState(state: Config) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun createInstance(): Config = ServiceManager.getService(Config::class.java)
    }
}