package tr.trendyol.interview.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class ListWidgets(val widgets: List<Widget>)

data class Widget(val bannerContents: List<BannerContent>,
                  val type: Type?,
                  val displayType: DisplayType?,
                  val id: Long,
                  val displayCount: Int)

@Parcelize
data class BannerContent(val title: String,
                          val displayOrder: Int,
                          val imageUrl: String): Parcelable

enum class Type {
    BANNER, SLIDER, PRODUCT
}

enum class DisplayType {
    SINGLE, SLIDER
}