package org.openasr.idear.actions

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.diagnostic.Logger
import org.openasr.idear.actions.recognition.TextToActionConverter
import org.openasr.idear.ide.IDEService

object ExecuteVoiceCommandAction : ExecuteActionByCommandText() {
    private val logger = Logger.getInstance(javaClass)
    private val KEY = DataKey.create<String>("Idear.VoiceCommand.Text")

    override fun actionPerformed(e: AnActionEvent) {
        val editor = IDEService.getEditor(e.dataContext)!!

        val provider = TextToActionConverter(e.dataContext)
        val info = provider.extractAction(e.getData(KEY)!!)
        if (info != null) {
            runInEditor(editor, info)
        } else {
            logger.info("Command not recognized")
        }
    }
}
