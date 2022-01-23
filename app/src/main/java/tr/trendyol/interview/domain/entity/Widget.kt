package tr.trendyol.interview.domain.entity

class ListWidgets(val widgets: List<Widget>)

data class Widget(val bannerContents: BannerContents,
                  val type: Type,
                  val displayType: DisplayType,
                  val id: Long,
                  val displayCount: Int)

data class BannerContents(val title: String,
                          val displayOrder: Int,
                          val imageUrl: String)

enum class Type {
    BANNER, SLIDER, PRODUCT
}

enum class DisplayType {
    SINGLE, CAROUSEL, BANNER, LISTING
}