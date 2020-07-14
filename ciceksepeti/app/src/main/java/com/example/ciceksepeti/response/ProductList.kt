package com.example.ciceksepeti.response

data class ProductList (
    val result: Result,
    val error: Error
)

data class Data (
    val categoryName: Any? = null,
    val products: List<Product>,
    val filter: Any? = null,
    val banners: Any? = null,
    val mainFilter: MainFilter,
    val branch: Any? = null,
    val message: Any? = null,
    val productCount: Long,
    val title: Any? = null,
    val isAlternate: Boolean,
    val hasOldPrice: Boolean,
    val storeID: Any? = null,
    val backgroundColor: Any? = null,
    val subCategoryModel: SubCategoryModel
)

data class MainFilter (
    val dynamicFilter: List<DynamicFilter>,
    val sort: List<Sort>
)

data class DynamicFilter (
    val detailID: Long,
    val name: String,
    val sequence: Long,
    val clearLink: Any? = null,
    val filterType: Long,
    val urlTag: Any? = null,
    val values: List<Sort>,
    val filterBehaviour: Long,
    val isMainCategory: Boolean,
    val isReload: Boolean,
    val isRemovableDetail: Boolean,
    val id: Long
)

data class Sort (
    val count: Long,
    val id: Long,
    val selected: Boolean,
    val link: String,
    val filterQueryString: Any? = null,
    val name: String,
    val icon: String? = null,
    val group: Long,
    val detailValueID: Long
)

data class Product (
    val adsModel: Any? = null,
    val id: Long,
    val code: String,
    val name: String,
    val image: String,
    val link: String,
    val webLink: String,
    val deliveryBadgeType: Long,
    val deliveryBadgeText: String,
    val deliveryChargeText: String? = null,
    val price: Price,
    val marketplaceBranch: Any? = null,
    val isMarketplace: Boolean,
    val largeImage: String,
    val isDiscountAvailable: Boolean,
    val isOriginal: Boolean,
    val installment: Boolean,
    val installmentText: String? = null,
    val smallImage: String,
    val xlargeImage: String,
    val mediumImage: String,
    val mostSellestProduct: Boolean,
    val isHaveVase: Boolean,
    val isHaveVaseText: String,
    val productDeliveryCity: ProductDeliveryCity,
    val productGroupID: Long,
    val variantCode: String,
    val entryID: Long,
    val reviewRating: Float? = null,
    val deliveryChargeMessage: Any? = null,
    val reviewCount: Int? = null,
    val information: String,
    val isSubscription: Boolean,
    val productType: Long
)

data class Price (
    val current: Double,
    val old: Double,
    val tax: Any? = null,
    val total: Double,
    val currency: Currency,
    val currencyCode: CurrencyCode,
    val oldTotal: Double,
    val discountPercentage: Int,
    val showFirstPrice: Boolean,
    val subscriptionPrice: Double,
    val subscriptionDiscountPercentage: Any? = null,
    val showCurrencyCode: Boolean,
    val showDecimalPart: Boolean
)

enum class Currency {
    Tl
}

enum class CurrencyCode {
    Try
}

data class ProductDeliveryCity (
    val deliveryCityImage: String,
    val isSendToSingleCity: Boolean
)

data class SubCategoryModel (
    val shapeType: Long,
    val subCategoryList: List<Any?>
)
