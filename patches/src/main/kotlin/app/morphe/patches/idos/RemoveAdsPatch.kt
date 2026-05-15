package app.morphe.patches.idos

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.Constants.COMPATIBILITY_IDOS

@Suppress("unused")
val disableAdsPatch = bytecodePatch(
    name = "Disable ads",
    description = "Disables ads in Mafra AdView.",
    default = true
) {
    compatibleWith(COMPATIBILITY_IDOS)
    execute {
        DisplayAdFingerprint.method.addInstructions(
            0,
            """
            return-void
            """.trimIndent()
        )
        LoadNativeAdInvokeSuspendFingerprint.method.addInstructions(
            0,
            $$"""
            const/16 v0, 0x8
            invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V
            invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
            move-result-object v0
            const/4 v1, 0x0
            iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I
            return-void
            """
        )
    }
}