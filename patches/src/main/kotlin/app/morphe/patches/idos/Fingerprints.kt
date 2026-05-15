package app.morphe.patches.idos

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.literal
import app.morphe.patcher.methodCall

@Suppress("unused")
object DisplayAdFingerprint : Fingerprint(
    definingClass = "Lcz/mafra/ads/presentation/ui/AdView;",
    returnType = "V",
    parameters = listOf(
        "Lcz/mafra/ads/domain/entity/ad/Ad;",
        "I",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        "Z",
        "Ljava/lang/String;",
        "Lcz/mafra/ads/presentation/ui/IAdStateListener;",
        "Z",
        "I"
    ),
    filters = listOf(
        methodCall(name = "showInterscroller", returnType = "V"),
        methodCall(name = "startVisibilityCheck", returnType = "V"),
        methodCall(name = "showWidesquare", returnType = "V"),
        methodCall(name = "startVisibilityCheck", returnType = "V"),
        methodCall(name = "loadAdMob", returnType = "V"),
        methodCall(name = "loadNativeAd", returnType = "V"),
        methodCall(name = "dismissAds", returnType = "V")
    )
)

@Suppress("unused")
object LoadNativeAdInvokeSuspendFingerprint : Fingerprint(
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Ljava/lang/Object;"),
    strings = listOf(
        "ca-app-pub-6065344208545391/5389004340"
    ),
    filters = listOf(
        literal(4),
        methodCall(name = "setMediaAspectRatio"),
        methodCall(name = "forNativeAd"),
        methodCall(name = "withAdListener"),
        methodCall(name = "withNativeAdOptions"),
        methodCall(name = "loadAd")
    )
)