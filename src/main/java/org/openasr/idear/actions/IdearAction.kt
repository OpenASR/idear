package org.openasr.idear.actions

import com.intellij.openapi.actionSystem.AnAction
import org.openasr.idear.ide.IDEService.invokeAction

abstract class IdearAction : AnAction() {
    operator fun invoke() = invokeAction(this)
}