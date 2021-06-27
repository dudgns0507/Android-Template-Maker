package com.github.dudgns0507.template.util

import com.github.dudgns0507.template.ext.replaceAll
import com.github.dudgns0507.template.type.FileExtension
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.util.ResourceUtil

class FileHelper(
        private val replacer: Replacer
) {
    fun isFileExistWithPath(path: String): Boolean {
        val file = VirtualFileManager.getInstance().findFileByUrl("file://$path")
        return file != null
    }

    fun createFileWithTemplate(
            directory: VirtualFile,
            name: String,
            fileExtension: FileExtension,
            templateFileName: String,
            replacements: Replacements
    ) {
        val kotlinFile = directory.createChildData(this, "$name.${fileExtension.extension}")
        val templateContent = getTemplate(templateFileName)
        val replaced = replacer.replace(templateContent, replacements)

        VfsUtil.saveText(kotlinFile, replaced)
    }

    fun getPackageNameByPath(path: String): String {
        val split = when {
            path.contains("java/") -> path.split("java/")
            else -> path.split("kotlin/")
        }

        when {
            split.size < 2 -> throw IllegalArgumentException("path error")
            else -> return split[1].replaceAll("/", ".")
        }
    }

    fun getLayoutDirectory(selectedDirectoryPath: String): VirtualFile? {
        val mainPath = selectedDirectoryPath.split("src/main")[0]
        val layoutPath = "$mainPath/src/main/res/layout"
        return VirtualFileManager.getInstance().findFileByUrl("file://$layoutPath")
    }

//    private fun VirtualFile.findOrCreateFileByRelativePath(relativePath: String): VirtualFile {
//        return relativePath.split("/").fold(this) { virtualFile, s ->
//            val child = virtualFile.findOrCreateChildData(this, s)
//            child
//        }
//    }

    private fun getTemplate(name: String): String {
        val templateFileInputStream = ResourceUtil.getResourceAsStream(
            javaClass.classLoader,
            "templates",
            "$name.txt"
        )
        return templateFileInputStream.bufferedReader()
            .readLines()
            .reduce { acc, s -> "${acc}\n$s" }
    }
}
