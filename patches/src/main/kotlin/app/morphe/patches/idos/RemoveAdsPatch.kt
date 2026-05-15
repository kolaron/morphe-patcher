package app.morphe.patches.idos

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.Constants.COMPATIBILITY_IDOS

// @Suppress("unused")
// val disableAdsPatch = bytecodePatch(
//     name = "Disable ads",
//     description = "Disables ads in Mafra AdView.",
//     default = true
// ) {
//     execute {
//         DisplayAdFingerprint.method.addInstructions(
//             0,
//             """
//             const/4 p6, 0x0
//             invoke-direct {p0, p6, p8}, Lcz/mafra/ads/presentation/ui/AdView;->dismissAds(ZLcz/mafra/ads/presentation/ui/IAdStateListener;)V
//             return-void
//             """.trimIndent()
//         )
//     }
// }

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
    }
}